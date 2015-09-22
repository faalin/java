package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 1.�������ĸ��ѭ���������
 * 2.���̿��ƣ����ȴ�����������ĸ
 * 		      �����ļ���
 * 3.��ĸ�����䣺while(true)
 * 			   �߳�(Thread)
 * 			   ��ʱ��(�߳�)
 *
 */
public class yoxiyoxi {
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
		MyPanel07 panel = new MyPanel07();
		//�������ı�����ɫ
		panel.setBackground(new Color(142,215,215));
		//��װ:��panel������ӵ�frame������
		frame.add(panel);
		//��ʾ����
		frame.setVisible(true);
		//���ô����Ĭ�Ϲرղ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������ĸ�����䷽��
		panel.run();
	}
}

//�Զ��������
class MyPanel07 extends JPanel{
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
	//���ù��췽���ķ�ʽ�������Ԫ�ؽ��г�ʼ��
	public MyPanel07(){
		random = new Random();
		for(int i= 0 ;i <chars.length;i++){
			//���������ĸ��x��y���꣬����
			chars[i]=(char)(random.nextInt(26)+65); //A ,B ,C
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
		g.setFont(new Font("����",Font.BOLD,30));
		for(int i= 0 ;i <chars.length;i++){
			//'A'+"" ="A"
			//1+2+"3"="33"	
			//���û��ʵ���ɫ
			g.setColor(new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)));
			g.drawString(chars[i]+"", x[i], y[i]);
		}
	}
	//������ĸ����ķ���
	public void run(){
		while(true){
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
			}
			repaint();
			//�߳�����
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

