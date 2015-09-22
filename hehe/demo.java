package hehe;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
/**
 * 键盘控制小球的运动
 * KeyListener
 * 上下左右  WASD
 *
 */
//内部类
public class demo {
	public static void main(String[] args) {
		JFrame  frame = new JFrame();
		frame.setSize(400,500);
		frame.setLocationRelativeTo(null);
		MyPanel05 panel = new MyPanel05();
		
		
		panel.addMouseMotionListener(panel);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
//实现接口以后必须要实现接口中的抽象方法
class MyPanel05 extends JPanel implements MouseMotionListener{
	int x = 30 ; 
	int y = 30 ;
	public void paint(Graphics g){
		super.paint(g);
		g.fillOval(x, y, 30, 30);
	}
	//鼠标移动执行的方法
	public void mouseMoved(MouseEvent e) {
		System.out.println("鼠标移动了");
		x = e.getX()-20;
		y = e.getY()-40;
		repaint();
	}
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub	
	}
	
	
}