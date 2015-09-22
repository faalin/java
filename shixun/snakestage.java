package shixun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 *蛇的舞台 是一个面板类
 */
public class snakestage extends JPanel implements KeyListener{
	//定义舞台上的食物
	private food food;
	//定义舞台的蛇
	private snake snake;
	//定义计时器
	private Timer timer;
	//定义随机数对象
	Random random;
	
	//通过构造方法的方式初始化食物跟蛇
	public snakestage(){
		//初始化随机数对象
		random = new Random();
		//初始化计时器
		timer = new Timer();
		//初始化蛇
		snake = new snake();
		//初始化食物
		food = randomfood();
	}
	//定义判断是否越界并决定是否走一步或者重新开始
	public void check(int dir ){
		//判断是否越界
		if(snake.headBreak(dir)){
			//重新开始
			restart();
			return ;
		}
	   //走一步
		if(snake.stepForEat(dir, food)){
			food = randomfood();
		}
	}
	/**定义重新开始的方法*/
	public void restart(){
			//重新创建蛇的对象
			snake = new snake();
			//重新创建食物的对象
			food = randomfood();
			//重绘
			repaint();
			
		}
	/*
	 * 定义随机生成食物的方法
	 * 在行号列号的范围内，随机生成行号和列号
	 * 判断不能出现在蛇的身上
	 */
	public food randomfood(){
		while(true){
			int rows = random.nextInt(util.STAGE_ROWS);
			int cols = random.nextInt(util.STAGE_COLS);
			//判断是否在蛇身上
//			for(int i = 0;i < snake.getCells().length;i++){
//				cell current = snake.getCells()[i];
//				if(rows ==current.getCell_rows()&&cols == current.getCell_cols())
//			//重新生成行号和列号
//				{continue;}//结束本次循环，回到循环重新开始
			if(snake.contains(rows,cols)){
				continue ;
		    }
			return new food(rows,cols);
		}
	}
	
	/*
	 * 定义启动游戏的方法
	 * class MyTimerTask extends TimerTask{
	 *   public void run(){}
	 * }
	 */
	public void go(){
		//timer timertask
		//匿名内部类
		timer.schedule(new TimerTask(){
			public void run(){
				if(snake.headBreak()){
					//重新开始
					restart();
					return;
				}
				//走一步
				if(snake.stepForEat(food))
				{
					//吃掉食物，重新生成食物
					food = randomfood();
		    }
			    //重绘
			    repaint();
			}
		},0,500);
	}
	
	//重写JPanel中的paint方法
	public void paint(Graphics g){
		//恢复父类的paint功能
		super.paint(g);
		//画食物,设置画笔的颜色
		g.setColor(food.getFood_color());
		g.fillRect(food.getFood_x() , food.getFood_y(),food.getFood_width(), food.getFood_height());
		//画蛇
		for(int i= 0 ;i < snake.getCells().length ; i++){
			//取出一个节点
			cell current = snake.getCells()[i];
			//设置画笔的颜色
			g.setColor(current.getCell_Color());
			//蛇头节点的颜色
			if(i==0){
				g.setColor(Color.yellow);
			}
			g.fillRect(current.getCell_x(), current.getCell_y(), current.getCell_width(), current.getCell_height()); 
	}
 }
	/*
	 * 键盘按下
	 * 
	 */
	public void keyPressed(KeyEvent e) {
        //获取键盘按下的键
		int keycode = e.getKeyCode();
		System.out.println("keycode:"+keycode);
		//判断方向
		if(keycode == KeyEvent.VK_UP){
			System.out.println("按下了上方向");
//			if(snake.stepForEat(snake.UP,food)){
//				//重新生成食物
//				food = randomfood();
//			}
			check(snake.UP);
		}
		else if(keycode == KeyEvent.VK_DOWN){
				System.out.println("按下了下方向");
//				if(snake.stepForEat(snake.DOWN,food)){
//					//重新生成食物
//					food = randomfood();}
				check(snake.DOWN);
		}
		else if (keycode == KeyEvent.VK_LEFT){
					System.out.println("按下了左方向");
//					if(snake.stepForEat(snake.LEFT,food)){
//						food = randomfood();
//					}
					check(snake.LEFT);
		}
	    else if (keycode == KeyEvent.VK_RIGHT){
					System.out.println("按下了右方向");
//					if(snake.stepForEat(snake.RIGHT, food)){
//					food = randomfood();
//						}
					check(snake.RIGHT);
	    }
				//重绘
		   repaint();
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
}