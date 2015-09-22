package hehe;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.CharConversionException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class xiaoyouxi {

	/**
	 * 面板中的字母的循环随机下落
	 * 键盘控制：优先打掉下面的字母
	 *       分数的计算
	 * 字母的下落：while（true）
	 *         线程
	 *         计时器（线程）       
	 * @author Administrator
	 */
	public static void main(String[] args) {
		//创建窗体对象
		JFrame frame = new JFrame();
		//设置窗体对象的标题
		frame.setTitle("字母游戏");
		//设置窗体大小
		frame.setSize(700,500);
		//设置窗体的位置
		frame.setLocationRelativeTo(null);
		//创建面板对象
		MyPanel9 panel = new MyPanel9();
		//设置面板颜色
		panel.setBackground(Color.cyan);
		//将面板对象添加到窗体
		frame.add(panel);
		//监听键盘输入内容
		frame.addKeyListener(panel);
		//显示窗体
		frame.setVisible(true);
		//设置窗体的默认关闭程序
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //调用go方法
		panel.go();
	}

}
//自定义的面板类
class MyPanel9 extends JPanel implements KeyListener{
	//定义字母的个数
	int num = 15;
	//定义保存字母的数组
	char [] chars = new char[num];
	//定义保存字母x坐标的字母
	int [] x = new int[num];
	//定义保存字母y坐标的字母
	int [] y = new int[num];
	//定义保存字母的数组
	//1垂直下落2向左3向右
	int [] dirs = new int[num];
	//定义随机数
	Random random = new Random();
	//定义计时器
	Timer timer = new Timer();
	//定义初始分数
	int score = 1000;
	//利用构造方法的方式对数组的元素进行初始化
    public MyPanel9(){
    	for(int i = 0;i <chars.length;i++){
    		//随机生成字母，x,y坐标
    		chars[i] = (char)(random.nextInt(26)+97);//A,B,C
    		x[i] = random.nextInt(680)+20;
    		y[i] = random.nextInt(200)+20;
    		dirs[i] = random.nextInt(3)+1;//[1,2,3]
    	}
    }
    //重写父类的paint方法
	public void paint(Graphics g){
		//恢复父类的paint功能
		super.paint(g);
		//画字母
		//设子字母的大小
		g.setFont(new Font("宋体",Font.BOLD,30));
		for(int i =0;i <chars.length;i ++){
			//获取新颜色
			g.setColor(new Color(
					random.nextInt(256),
					random.nextInt(256),
					random.nextInt(256)));
			//'A'+""="A"
			//1+2+"3"="33"
			//touppercase（）大小写转换
			g.drawString((chars[i]+"").toUpperCase(), x[i], y[i]);
		}
		//画分数
		//设置画笔颜色
	    g.setColor(Color.red);
	    //三目运算符
	    //a<b?a:b
        g.drawString("分数:"+(score<0?"0":score), 250, 30); 
        //设置游戏结束标志
        if(score<0){
        	g.setColor(Color.red);
        	g.drawString("分数:"+0, 250, 30);
            g.setFont(new Font("宋体",Font.BOLD,100));
        	g.drawString("GAME OVER", 100, 250);
        }
	}
	//判断游戏是否结束
	public void check(){
		if (score<0){
			//取消计时器工作
			timer.cancel();
			repaint();
			}
	}
	//定义游戏运行的方法
	public void go(){
		//制定定时器计划
		//从0毫秒之后，每隔20毫秒，执行一次任务（mytimertask-->）
		timer.schedule(new MyTimerTask(),0,10);
	}
	//创建自定义timertask类
	//抽象类不可以new对象
	class MyTimerTask extends TimerTask{
		//实现TimerTask中的抽象方法
		//TimerTask 任务所要做的事情
		public void run(){
			for (int i = 0; i < chars.length; i++) {
				if(dirs[i]==1){
					y[i]++;
				}
				if(dirs[i]==2){
					x[i]--;
					y[i]++;
				}
				if(dirs[i]==3){
					x[i]++;
					y[i]++;
				}
				if(x[i]<0){
					dirs[i]=3;
				}
				if(x[i]>670){
					dirs[i]=2;
				}
				//判断是否越界
				if (y[i]>480){
					//越界减50
					score -=50;
					check();
					//生成新字母
					chars[i] = (char)(random.nextInt(26)+97);
					//新生成的字母坐标
					x[i] = random.nextInt(680)+10;
					y[i] = 0;
					//新生成的字母的运动方向随机产生
					dirs[i] = random.nextInt(3)+1;
					
				}
			}
			repaint();
		}
	}
    //键盘按下执行方式
	public void keyPressed(KeyEvent e){
		//当分数小于0，键盘事件失效
		if(score <0){
			check(); //终止方法的执行
			return;
		}
		System.out.println("键盘按下的字符"+e.getKeyChar());
		//获取键盘输入的字符
		char c = e.getKeyChar();
		//定义标记变量
		int nowY = -1;
		int nowIndex = -1;
		for (int i = 0; i < chars.length; i++) {
			char current = chars[i];
			if (current==c){
				//进行标记和判断
				if (nowY<y[i]){
					nowY = y[i];
					nowIndex = i;
				}
				
			}
		}
		//判断标记加分或则减分
		if(nowIndex != -1){
			//加分
			score+=10;
			//被打掉的字母小时重新生成新字母
		    chars[nowIndex] = (char)(random.nextInt(26)+97);
		    y[nowIndex] = 0;
		    x[nowIndex] = random.nextInt(680)+20;
			dirs[nowIndex] = random.nextInt(3)+1;
		}else{
			score -=100;
			check();
		}
		
    }
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
	
	
//	public void run(){
//		while(true){
//			for (int i = 0; i < chars.length; i++) {
//				if (dirs[i]==1){
//					y[i]++;
//				}
//				if(dirs[i]==2){
//					y[i]++;
//					x[i]--;
//				}
//				if (dirs[i]==3){
//					y[i]++;
//					x[i]++;
//				}
//				if (x[i]<0){
//					dirs[i]=3;
//				}
//				if (x[i]>730){
//					dirs[i]=2;
//				}
//				
//			}
//			repaint();
//			//线程休眠
//			try {
//				Thread.sleep(20);
//			} catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
//	}
//}
