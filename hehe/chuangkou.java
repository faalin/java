package hehe;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.beans.FeatureDescriptor;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class chuangkou {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        //���崰�ڽ���
		JFrame frame = new JFrame("����ϵͳ");
		//���崰�ڴ�С
		frame.setSize(500, 500);
		//�̶����ڵ�λ��
		frame.setLocationRelativeTo(null);
		MyPanel03 panel = new MyPanel03();
		//������ӻ�
		frame.addMouseMotionListener(panel);
		frame.addMouseListener(panel);
		frame.addKeyListener(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		//�رճ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
 }
class MyPanel03 extends JPanel implements MouseMotionListener,MouseListener,KeyListener{
	int x=30;
	int y=30;
	public void paint(Graphics g){
		super.paint(g);
		//�����ɫ
		g.setColor(Color.red);
		//С��Ĵ�С��λ��
		g.fillOval(x, y, 30, 30);
		
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("�������һ��");
		x = e.getX()-20;
		y = e.getY()-44;
		repaint();
		System.out.println(e.getX()+","+e.getY());
	}
	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}
	public void mousePressed(MouseEvent e) {

	}
	public void mouseReleased(MouseEvent e) {

	}
	public void mouseDragged(MouseEvent e) {
      }

	public void mouseMoved(MouseEvent e) {
       System.out.println("����ƶ���");
       x = e.getX()-20;
	   y = e.getY()-40;
       repaint();
	}
	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println("���̰�����");
		//��ȡ���µļ�ֵ
		int code = e.getKeyCode();
		//System.out.println(code);
		//System.out.println(KeyEvent.VK_W);
		if(code == KeyEvent.VK_W){
			y--;
		}else if(code ==KeyEvent.VK_S){
			y++ ;
		}else if(code == KeyEvent.VK_A){
			x -- ;
		}else if(code == KeyEvent.VK_D){
			x ++ ;
		}
		repaint();		
	}
	public void keyReleased(KeyEvent e) {	
	}
	public void keyTyped(KeyEvent e) {
	
	}
}
