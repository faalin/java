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
	JFrame frame = new JFrame("运动的小球");
    //frame.setTitle("运动的小球");
	//设置frame的大小
	frame.setBounds(300, 150, 800, 500);
	//创建自定义面板的对象
	MyPanel01 panel = new MyPanel01();
	//添加背景颜色
	panel.setBackground(Color.blue);
	//将面板添加到窗体对象中
	frame.add(panel);
    //显示窗体
	frame.setVisible(true);
	//设置默认的关闭操作
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	panel.run();
  }
}

class MyPanel01 extends JPanel{
	//定义小球的坐标
    int x =0 ;
    int y =210 ;
    //定义小球运功的方向
    int dir = 1 ; //1往上2往下3往左4往右
    //重写paint方法
    public void paint(Graphics g){
    	//恢复父类中paint功能
	    super.paint(g);
	    //画小球
	    //g.drawOval(30, 30, 30, 30);
	    //填充一个圆
	    g.setColor(Color.white);
	    g.fillOval(x, y, 30, 30);
      }
    //定义一个小球运动的方法
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