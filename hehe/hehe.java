package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author ����
 * 
 * ����java swing ʵ����������Ч��
 * 
 */

public class hehe {

	public static void main(String[] args) {
	  //����ô���һ�����ڶ���
      JFrame frame = new JFrame();
      //���ô�����ʾ�Ĵ�С
      frame.setSize(1366,768);
      //�������Ķ���
      //JPanel panel = new JPanel();
      MyPanel panel = new MyPanel();
      //�������ı�����ɫ
      panel.setBackground(Color.BLACK);
      //�����������������
      frame.add(panel);
      //��ʾ����
      frame.setVisible(true);
      //����Ĭ�ϵĹرղ���
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //����run����
      panel.run();
	}

}
//�Զ��������
//�̳У�mypanel ����һ��jpanel
//��д���������������һģһ���ķ���
//��д�ﵽ��Ч��������ʱ��������ø���ķ���
//���ǵ�������ķ���
class MyPanel extends JPanel{
	//���屣��x���������
	int [] x = new int[300];
	//���屣��Y���������
	int [] y = new int[300];
	//����һ������
	int [] size = new int[300];
	//�����鸳ֵ
	//���ù��췽���ķ�ʽ�����鸳ֵ
	public MyPanel(){
		for (int i = 0; i < 300; i++) {
			x[i]=(int)(Math.random()*1366);
			y[i]=(int)(Math.random()*768);
			size[i]=(int)(Math.random()*40)+10;
		}
	}
	//��дJPanel���е�paint ����
	//Graphics ����
	//paint����������Ϊ���ã���ϵͳ�Լ����õķ���
	//repaint:-->ͨ��ϵͳȥ����paint����
	public void paint(Graphics g){
		//�ظ������paint�����Ĺ���
		super.paint(g);
		//д�����ǵ�Ч��
		//���û��ʵ���ɫ
		g.setColor(Color.white);
		//�����������
		//��300������
		for(int i = 0 ;i < 300 ;i++){
			g.drawString("*",x[i],y[i]);
			//���û��ʵĴ�С
			g.setFont(new Font("����",Font.BOLD,size[i]));
		}		
	}
	//����һ�����ķ���
	public void run(){
		//
		while(true){
			for (int i = 0; i < 300; i++) {
				y[i]++;
				if(y[i] > 750){
					y[i]=0;
				}
			}
		    //��������λ��
		    //�ػ� �ػ�
			repaint();//֪ͨϵͳȥ����paint����
			//û����һ�Σ���Ϣһ��
			//�̵߳�����
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

