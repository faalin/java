package hehe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class xiaoqiu {
    /**
     * @author yoxi* 
     */
    public static void main(String[] args) {
	JFrame frame = new JFrame("�˶���С��");
    //frame.setTitle("�˶���С��");
	//����frame�Ĵ�С
	frame.setBounds(300, 150, 800, 500);
	//�����Զ������Ķ���
	MyPanel01 panel = new MyPanel01();
	//��ӱ�����ɫ
	panel.setBackground(Color.blue);
	//�������ӵ����������
	frame.add(panel);
    //��ʾ����
	frame.setVisible(true);
	//����Ĭ�ϵĹرղ���
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.run();
  }
}

class MyPanel01 extends JPanel{
	//����С�������
    int x =0 ;
    int y =210 ;
    //����С���˹��ķ���
    int dir = 1 ; //1����2����3����4����
    //��дpaint����
    public void paint(Graphics g){
    	//�ָ�������paint����
	    super.paint(g);
	    //��С��
	    //g.drawOval(30, 30, 30, 30);
	    //���һ��Բ
	    g.setColor(Color.white);
	    g.fillOval(x, y, 30, 30);
      }
    //����һ��С���˶��ķ���
    public void run(){
	   while(true){
		   if(dir ==1 ){
				y ++ ;x ++ ;
				if(y >440){
					dir = 2;
			    }
				if(x >750){
					dir = 4;
				}
		   }
		   else if(dir == 2){
				y -- ;x ++ ;
				if(x > 750){
					dir = 3;
					}
				if(y < 0){
					dir = 1;
				}
		   }
		   else if(dir == 3){
					y --;x --;
					if(y < 0){
						dir =4;
					}
					if(x < 0){
						dir = 2;
					}
		   }
		   else {
			   y ++ ;x -- ;
			   if (x<0){
				   dir = 1;
			   }
			   if(y>440){
				   dir = 3;
			   }
		   }
		
		repaint();
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}	
  }
}