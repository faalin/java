package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.CharConversionException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class xiaoyouxi {

	/**
	 * ����е���ĸ��ѭ���������
	 * ���̿��ƣ����ȴ���������ĸ
	 *       �����ļ���
	 * ��ĸ�����䣺while��true��
	 *         �߳�
	 *         ��ʱ�����̣߳�       
	 * @author Administrator
	 */
	public static void main(String[] args) {
		//�����������
		JFrame frame = new JFrame();
		//���ô������ı���
		frame.setTitle("��ĸ��Ϸ");
		//���ô����С
		frame.setSize(700,500);
		//���ô����λ��
		frame.setLocationRelativeTo(null);
		//����������
		MyPanel9 panel = new MyPanel9();
		//���������ɫ
		panel.setBackground(Color.cyan);
		//����������ӵ�����
		frame.add(panel);
		//����������������
		frame.addKeyListener(panel);
		//��ʾ����
		frame.setVisible(true);
		//���ô����Ĭ�Ϲرճ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //����go����
		panel.go();
	}

}
//�Զ���������
class MyPanel9 extends JPanel implements KeyListener{
	//������ĸ�ĸ���
	int num = 15;
	//���屣����ĸ������
	char [] chars = new char[num];
	//���屣����ĸx�������ĸ
	int [] x = new int[num];
	//���屣����ĸy�������ĸ
	int [] y = new int[num];
	//���屣����ĸ������
	//1��ֱ����2����3����
	int [] dirs = new int[num];
	//���������
	Random random = new Random();
	//�����ʱ��
	Timer timer = new Timer();
	//�����ʼ����
	int score = 1000;
	//���ù��췽���ķ�ʽ�������Ԫ�ؽ��г�ʼ��
    public MyPanel9(){
    	for(int i = 0;i <chars.length;i++){
    		//���������ĸ��x,y����
    		chars[i] = (char)(random.nextInt(26)+97);//A,B,C
    		x[i] = random.nextInt(680)+20;
    		y[i] = random.nextInt(200)+20;
    		dirs[i] = random.nextInt(3)+1;//[1,2,3]
    	}
    }
    //��д�����paint����
	public void paint(Graphics g){
		//�ָ������paint����
		super.paint(g);
		//����ĸ
		//������ĸ�Ĵ�С
		g.setFont(new Font("����",Font.BOLD,30));
		for(int i =0;i <chars.length;i ++){
			//��ȡ����ɫ
			g.setColor(new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)));
			//'A'+""="A"
			//1+2+"3"="33"
			//touppercase������Сдת��
			g.drawString((chars[i]+"").toUpperCase(), x[i], y[i]);
		}
		//������
		//���û�����ɫ
	    g.setColor(Color.red);
	    //��Ŀ�����
	    //a<b?a:b
        g.drawString("����:"+(score<0?"0":score), 250, 30); 
        //������Ϸ������־
        if(score<0){
        	g.setColor(Color.red);
        	g.drawString("����:"+0, 250, 30);
            g.setFont(new Font("����",Font.BOLD,100));
        	g.drawString("GAME OVER", 100, 250);
        }
	}
	//�ж���Ϸ�Ƿ����
	public void check(){
		if (score<0){
			//ȡ����ʱ������
			timer.cancel();
			repaint();
			}
	}
	//������Ϸ���еķ���
	public void go(){
		//�ƶ���ʱ���ƻ�
		//��0����֮��ÿ��20���룬ִ��һ������mytimertask-->��
		timer.schedule(new MyTimerTask(),0,10);
	}
	//�����Զ���timertask��
	//�����಻����new����
	class MyTimerTask extends TimerTask{
		//ʵ��TimerTask�еĳ��󷽷�
		//TimerTask ������Ҫ��������
		public void run(){
			for (int i = 0; i < chars.length; i++) {
				if(dirs[i]==1){
					y[i]++;
				}
				if(dirs[i]==2){
					x[i]--;
					y[i]++;
				}
				if(dirs[i]==3){
					x[i]++;
					y[i]++;
				}
				if(x[i]<0){
					dirs[i]=3;
				}
				if(x[i]>670){
					dirs[i]=2;
				}
				//�ж��Ƿ�Խ��
				if (y[i]>480){
					//Խ���50
					score -=50;
					check();
					//��������ĸ
					chars[i] = (char)(random.nextInt(26)+97);
					//�����ɵ���ĸ����
					x[i] = random.nextInt(680)+10;
					y[i] = 0;
					//�����ɵ���ĸ���˶������������
					dirs[i] = random.nextInt(3)+1;
					
				}
			}
			repaint();
		}
	}
    //���̰���ִ�з�ʽ
	public void keyPressed(KeyEvent e){
		//������С��0�������¼�ʧЧ
		if(score <0){
			check(); //��ֹ������ִ��
			return;
		}
		System.out.println("���̰��µ��ַ�"+e.getKeyChar());
		//��ȡ����������ַ�
		char c = e.getKeyChar();
		//�����Ǳ���
		int nowY = -1;
		int nowIndex = -1;
		for (int i = 0; i < chars.length; i++) {
			char current = chars[i];
			if (current==c){
				//���б�Ǻ��ж�
				if (nowY<y[i]){
					nowY = y[i];
					nowIndex = i;
				}
				
			}
		}
		//�жϱ�Ǽӷֻ������
		if(nowIndex != -1){
			//�ӷ�
			score+=10;
			//���������ĸСʱ������������ĸ
		    chars[nowIndex] = (char)(random.nextInt(26)+97);
		    y[nowIndex] = 0;
		    x[nowIndex] = random.nextInt(680)+20;
			dirs[nowIndex] = random.nextInt(3)+1;
		}else{
			score -=100;
			check();
		}
		
    }
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
//	public void run(){
//		while(true){
//			for (int i = 0; i < chars.length; i++) {
//				if (dirs[i]==1){
//					y[i]++;
//				}
//				if(dirs[i]==2){
//					y[i]++;
//					x[i]--;
//				}
//				if (dirs[i]==3){
//					y[i]++;
//					x[i]++;
//				}
//				if (x[i]<0){
//					dirs[i]=3;
//				}
//				if (x[i]>730){
//					dirs[i]=2;
//				}
//				
//			}
//			repaint();
//			//�߳�����
//			try {
//				Thread.sleep(20);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}
