package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 1.面板中字母的循环随机出现
 * 2.键盘控制：优先打掉最下面的字母
 * 		      分数的计算
 * 3.字母的下落：while(true)
 * 			   线程(Thread)
 * 			   计时器(线程)
 *
 */
public class yoxiyoxi {
	public static void main(String [] args){
		//创建窗体对象
		JFrame frame = new JFrame();
		//设置窗体对象的标题
		frame.setTitle("Char Game");
		//设置窗体的大小
		frame.setSize(500,600);
		//设置窗体居中显示
		frame.setLocationRelativeTo(null);
		//创建面板对象
		MyPanel07 panel = new MyPanel07();
		//设置面板的背景颜色
		panel.setBackground(new Color(142,215,215));
		//组装:将panel对象添加到frame对象中
		frame.add(panel);
		//显示窗体
		frame.setVisible(true);
		//设置窗体的默认关闭操作
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//启动字母的下落方法
		panel.run();
	}
}

//自定义面板类
class MyPanel07 extends JPanel{
	//定义面板中字母的个数
	int num = 15 ;
	//定义保存字母的数组
	char [] chars = new char[num];
	//定义保存字母x坐标的数组
	int [] x = new int[num];
	//定义保存字母y坐标的数组
	int [] y = new int[num];
	//定义保存字母方向的数组
	//1 垂直下落 2 左下 3 右下
	int [] dirs = new int[num];
	//定义随机数
	Random random ;
	//利用构造方法的方式对数组的元素进行初始化
	public MyPanel07(){
		random = new Random();
		for(int i= 0 ;i <chars.length;i++){
			//随机生成字母，x，y坐标，方向
			chars[i]=(char)(random.nextInt(26)+65); //A ,B ,C
			x[i] = random.nextInt(450)+20;
			y[i] = random.nextInt(300)+20;
			dirs[i]=random.nextInt(3)+1;//[1,2,3]
		}
	}
	//重写父类的paint方法
	public void paint(Graphics g){
		//恢复父类的paint功能
		super.paint(g);
		//画字母
		//设置画笔的大小
		g.setFont(new Font("宋体",Font.BOLD,30));
		for(int i= 0 ;i <chars.length;i++){
			//'A'+"" ="A"
			//1+2+"3"="33"	
			//设置画笔的颜色
			g.setColor(new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)));
			g.drawString(chars[i]+"", x[i], y[i]);
		}
	}
	//定义字母下落的方法
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
				//反弹
				if(x[i]<=0){
					dirs[i] =3 ;
				}
				if(x[i]>=460){
					dirs[i]= 2 ;
				}
			}
			repaint();
			//线程休眠
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}	
}

