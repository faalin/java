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
 * 1.面板中字母的循环随机出现
 * 2.键盘控制：优先打掉最下面的字母
 * 		      分数的计算
 * 3.字母的下落：while(true)
 * 			   线程(Thread)
 * 			   计时器(线程)
 * Timer类  指定一个计划(调用一个方法)
 * 在计划中：给定一个任务
 * TimerTask   run方法
 *
 */
public class youxi{
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
		MyPanel08 panel = new MyPanel08();
		//设置面板的背景颜色
		panel.setBackground(new Color(142,215,215));
		//添加键盘监听事件
		frame.addKeyListener(panel);
		//组装:将panel对象添加到frame对象中
		frame.add(panel);
		//显示窗体
		frame.setVisible(true); //-->paint()
		//设置窗体的默认关闭操作
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//启动字母的下落方法
		panel.go();
	}
}

//自定义面板类
class MyPanel08 extends JPanel implements KeyListener{
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
	//定义计时器
	Timer timer ; //NullPointerException
	//定义初始化分数
	int score = 1000 ;
	//利用构造方法的方式对数组的元素进行初始化
	public MyPanel08(){
		random = new Random();
		timer = new Timer();
		for(int i= 0 ;i <chars.length;i++){
			//随机生成字母，x，y坐标，方向
			chars[i]=(char)(random.nextInt(26)+97); //A ,B ,C
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
		g.setFont(new Font("宋体",Font.BOLD,40));
		for(int i= 0 ;i <chars.length;i++){
			//'A'+"" ="A"
			//1+2+"3"="33"	
			//设置画笔的颜色
			g.setColor(new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)));
			//'a'+""="a"-->"A"
			//"a".toUpperCase();小写转大写
			g.drawString((chars[i]+"").toUpperCase(), x[i], y[i]);
		}
		//画分数
		//设置画笔的颜色
		g.setColor(Color.BLUE);
		//三目运算符
		//a<b?a:b
		g.drawString("分数:"+(score<0?"0":score), 170,40);
//		画游戏结束提示
		if(score <0){
			g.setColor(Color.RED);
			g.drawString("分数:"+0, 170,40);
			g.setFont(new Font("宋体",Font.BOLD,90));
			g.drawString("Game Over", 30, 300);
		}
	}
	//定义判断是否结束游戏
	public void check(){
		//当分数小于0的时候游戏结束、
		if(score <0){
			//取消计时器工作
			timer.cancel();
			repaint();
		}
	}
	
	//定义一个游戏运行的方法
	public void go(){
		//制定定时器计划
		//从0毫秒之后，每隔20毫秒，执行一次任务(MyTimerTask-->run)
		timer.schedule(new MyTimerTask(),0,10);	
	}
	//创建自定义TimerTask类
	//抽象类不可以new对象
	class MyTimerTask extends TimerTask{
		//实现TimerTask中的抽象方法
		//TimerTask 任务所要做的事情
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
				//反弹
				if(x[i]<=0){
					dirs[i] =3 ;
				}
				if(x[i]>=460){
					dirs[i]= 2 ;
				}
				//判断是否越界
				if(y[i]>580){
					//减分
					score -=50;
					check();
					//生成新字母
					chars[i]=(char)(random.nextInt(26)+97);
					//新字母的y坐标为0
					y[i] = 0 ;
					//新字母的x坐标在范围内随机生成
					x[i] = random.nextInt(450)+20;
					//新字母的运动方向随机生成
					dirs[i]=random.nextInt(3)+1;
				}
			}
			repaint();
		}
	}
	//键盘按下执行的方法
	public void keyPressed(KeyEvent e) {
		//当分数小于0，键盘事件失效
		if(score <0){
			
			check();//终止方法的执行
		    return;
		}
		System.out.println("键盘按下的字符："+e.getKeyChar());
		//System.out.println('a'==e.getKeyChar());
		//获取键盘键入的字符
		char c = e.getKeyChar();
		//定义标记变量
		int nowY = -1 ;
		int nowIndex = -1;
		for(int i= 0 ; i <chars.length;i++){
			char current = chars[i];
			if(c == current){
				//进行标记
				//判断
				if(nowY<y[i]){
					nowY = y[i];
					nowIndex = i ;
				}
			}
		}
		//判断标记，加分或者减分
		if(nowIndex != -1){
			//加分
			score+=10 ;
			//被打掉的字母消失，重新生成新字母
			chars[nowIndex] =(char)(random.nextInt(26)+97);
			y[nowIndex] = 0 ;
			//新字母的x坐标在范围内随机生成
			x[nowIndex] = random.nextInt(450)+20;
			//新字母的运动方向随机生成
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

