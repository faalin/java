package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author 樊林
 * 
 * 利用java swing 实现漫天星星效果
 * 
 */

public class hehe {

	public static void main(String[] args) {
	  //如何让创建一个窗口对象
      JFrame frame = new JFrame();
      //设置窗体显示的大小
      frame.setSize(1366,768);
      //创建面板的对象
      //JPanel panel = new JPanel();
      MyPanel panel = new MyPanel();
      //设置面板的背景颜色
      panel.setBackground(Color.BLACK);
      //将面板贴到窗口上面
      frame.add(panel);
      //显示窗体
      frame.setVisible(true);
      //设置默认的关闭操作
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      //调用run方法
      panel.run();
	}

}
//自定义面板类
//继承：mypanel 就是一个jpanel
//重写：父类和子类中有一模一样的方法
//重写达到的效果：运行时，不会调用父类的方法
//而是调用子类的方法
class MyPanel extends JPanel{
	//定义保存x坐标的数组
	int [] x = new int[300];
	//定义保存Y坐标的数组
	int [] y = new int[300];
	//定义一个数组
	int [] size = new int[300];
	//给数组赋值
	//利用构造方法的方式给数组赋值
	public MyPanel(){
		for (int i = 0; i < 300; i++) {
			x[i]=(int)(Math.random()*1366);
			y[i]=(int)(Math.random()*768);
			size[i]=(int)(Math.random()*40)+10;
		}
	}
	//重写JPanel类中的paint 方法
	//Graphics 画笔
	//paint方法不能人为调用，是系统自己调用的方法
	//repaint:-->通过系统去调用paint方法
	public void paint(Graphics g){
		//回复父类的paint方法的功能
		super.paint(g);
		//写画星星的效果
		//设置画笔的颜色
		g.setColor(Color.white);
		//坐标随机生成
		//画300颗星星
		for(int i = 0 ;i < 300 ;i++){
			g.drawString("*",x[i],y[i]);
			//设置画笔的大小
			g.setFont(new Font("宋体",Font.BOLD,size[i]));
		}		
	}
	//定义一个动的方法
	public void run(){
		//
		while(true){
			for (int i = 0; i < 300; i++) {
				y[i]++;
				if(y[i] > 750){
					y[i]=0;
				}
			}
		    //画出最新位置
		    //重绘 重画
			repaint();//通知系统去调用paint方法
			//没下落一次，休息一会
			//线程的休眠
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
}

