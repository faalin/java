package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 1.�������ĸ��ѭ���������
 * 2.���̿��ƣ����ȴ�����������ĸ
 * 		      �����ļ���
 * 3.��ĸ�����䣺while(true)
 * 			   �߳�(Thread)
 * 			   ��ʱ��(�߳�)
 * Timer��  ָ��һ���ƻ�(����һ������)
 * �ڼƻ��У�����һ������
 * TimerTask   run����
 *
 */
public class youxi{
	public static void main(String [] args){
		//�����������
		JFrame frame = new JFrame();
		//���ô������ı���
		frame.setTitle("Char Game");
		//���ô���Ĵ�С
		frame.setSize(500,600);
		//���ô��������ʾ
		frame.setLocationRelativeTo(null);
		//����������
		MyPanel08 panel = new MyPanel08();
		//�������ı�����ɫ
		panel.setBackground(new Color(142,215,215));
		//��Ӽ��̼����¼�
		frame.addKeyListener(panel);
		//��װ:��panel������ӵ�frame������
		frame.add(panel);
		//��ʾ����
		frame.setVisible(true); //-->paint()
		//���ô����Ĭ�Ϲرղ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������ĸ�����䷽��
		panel.go();
	}
}

//�Զ��������
class MyPanel08 extends JPanel implements KeyListener{
	//�����������ĸ�ĸ���
	int num = 15 ;
	//���屣����ĸ������
	char [] chars = new char[num];
	//���屣����ĸx���������
	int [] x = new int[num];
	//���屣����ĸy���������
	int [] y = new int[num];
	//���屣����ĸ���������
	//1 ��ֱ���� 2 ���� 3 ����
	int [] dirs = new int[num];
	//���������
	Random random ;
	//�����ʱ��
	Timer timer ; //NullPointerException
	//�����ʼ������
	int score = 1000 ;
	//���ù��췽���ķ�ʽ�������Ԫ�ؽ��г�ʼ��
	public MyPanel08(){
		random = new Random();
		timer = new Timer();
		for(int i= 0 ;i <chars.length;i++){
			//���������ĸ��x��y���꣬����
			chars[i]=(char)(random.nextInt(26)+97); //A ,B ,C
			x[i] = random.nextInt(450)+20;
			y[i] = random.nextInt(300)+20;
			dirs[i]=random.nextInt(3)+1;//[1,2,3]
		}
	}
	//��д�����paint����
	public void paint(Graphics g){
		//�ָ������paint����
		super.paint(g);
		//����ĸ
		//���û��ʵĴ�С
		g.setFont(new Font("����",Font.BOLD,40));
		for(int i= 0 ;i <chars.length;i++){
			//'A'+"" ="A"
			//1+2+"3"="33"	
			//���û��ʵ���ɫ
			g.setColor(new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)));
			//'a'+""="a"-->"A"
			//"a".toUpperCase();Сдת��д
			g.drawString((chars[i]+"").toUpperCase(), x[i], y[i]);
		}
		//������
		//���û��ʵ���ɫ
		g.setColor(Color.BLUE);
		//��Ŀ�����
		//a<b?a:b
		g.drawString("����:"+(score<0?"0":score), 170,40);
//		����Ϸ������ʾ
		if(score <0){
			g.setColor(Color.RED);
			g.drawString("����:"+0, 170,40);
			g.setFont(new Font("����",Font.BOLD,90));
			g.drawString("Game Over", 30, 300);
		}
	}
	//�����ж��Ƿ������Ϸ
	public void check(){
		//������С��0��ʱ����Ϸ������
		if(score <0){
			//ȡ����ʱ������
			timer.cancel();
			repaint();
		}
	}
	
	//����һ����Ϸ���еķ���
	public void go(){
		//�ƶ���ʱ���ƻ�
		//��0����֮��ÿ��20���룬ִ��һ������(MyTimerTask-->run)
		timer.schedule(new MyTimerTask(),0,10);	
	}
	//�����Զ���TimerTask��
	//�����಻����new����
	class MyTimerTask extends TimerTask{
		//ʵ��TimerTask�еĳ��󷽷�
		//TimerTask ������Ҫ��������
		public void run() {
			for(int i = 0 ;i <chars.length;i++){
				if(dirs[i] == 1){
					y[i]++;
				}
				if(dirs[i] ==2){
					x[i]-- ;
					y[i]++ ;
				}
				if(dirs[i] ==3){
					x[i]++;
					y[i]++;
				}
				//����
				if(x[i]<=0){
					dirs[i] =3 ;
				}
				if(x[i]>=460){
					dirs[i]= 2 ;
				}
				//�ж��Ƿ�Խ��
				if(y[i]>580){
					//����
					score -=50;
					check();
					//��������ĸ
					chars[i]=(char)(random.nextInt(26)+97);
					//����ĸ��y����Ϊ0
					y[i] = 0 ;
					//����ĸ��x�����ڷ�Χ���������
					x[i] = random.nextInt(450)+20;
					//����ĸ���˶������������
					dirs[i]=random.nextInt(3)+1;
				}
			}
			repaint();
		}
	}
	//���̰���ִ�еķ���
	public void keyPressed(KeyEvent e) {
		//������С��0�������¼�ʧЧ
		if(score <0){
			
			check();//��ֹ������ִ��
		    return;
		}
		System.out.println("���̰��µ��ַ���"+e.getKeyChar());
		//System.out.println('a'==e.getKeyChar());
		//��ȡ���̼�����ַ�
		char c = e.getKeyChar();
		//�����Ǳ���
		int nowY = -1 ;
		int nowIndex = -1;
		for(int i= 0 ; i <chars.length;i++){
			char current = chars[i];
			if(c == current){
				//���б��
				//�ж�
				if(nowY<y[i]){
					nowY = y[i];
					nowIndex = i ;
				}
			}
		}
		//�жϱ�ǣ��ӷֻ��߼���
		if(nowIndex != -1){
			//�ӷ�
			score+=10 ;
			//���������ĸ��ʧ��������������ĸ
			chars[nowIndex] =(char)(random.nextInt(26)+97);
			y[nowIndex] = 0 ;
			//����ĸ��x�����ڷ�Χ���������
			x[nowIndex] = random.nextInt(450)+20;
			//����ĸ���˶������������
			dirs[nowIndex]=random.nextInt(3)+1;
			
		}else{
			score -=100 ;
			check();
		}
		
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

