package Trainday08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * 蛇的舞台  是一个面板类
 */
public class SnakeStage extends JPanel implements KeyListener {
	/**定义舞台上的食物*/
	private Food food ;
	/**定义舞台上的蛇*/
	private Snake snake ;
	/**定义计时器*/
	private Timer timer ;
	/**定义随机数对象*/
	Random random  ;
	
	/**通过构造方法的方式初始化蛇跟食物*/
	public SnakeStage(){
		//初始化随机数对象
		random = new Random();
		//初始化计时器
		timer = new Timer();
		//初始化蛇
		snake = new Snake();
		//初始化食物
		food = randomFood();
	}
	/**定义判断是否越界并决定是否走一步或者重新开始*/
	public void check(int dir ){
		//判断是否越界
		if(snake.headBreak(dir)){
			//重新开始
			reStart();
			return ;
		}
		//走一步
		if(snake.stepForEat(dir, food)){
			food = randomFood();
		}
	}
	/**定义重新开始的方法*/
	public void reStart(){
		//重新创建蛇的对象
		snake = new Snake();
		//重新创建食物的对象
		food = randomFood();
		//重绘
		repaint();	
	}
	/**
	 * 定义随机生成食物的方法
	 * 在行号列号范围内，随机生成行号列号
	 * 判断不能出现在蛇的身上
	 */
	public Food randomFood(){
		while(true){
			int rows = random.nextInt(Util.STAGE_ROWS);
			int cols = random.nextInt(Util.STAGE_COLS);
			if(snake.contains(rows, cols)){
				continue ;
			}
			return new Food(rows,cols);
		}
	}
	/**
	 * 定义启动游戏的方法
	 *  class MyTimerTask extends TimerTask{
	 *  	public void run(){}
	 *  }
	 */
	public void go(){
		//Timer TimerTask
		//匿名内部类
		timer.schedule(new TimerTask(){
			public void run(){
				//check(snake.getDir());
				//判断是否越界
				if(snake.headBreak()){
					//重新开始
					reStart();
					return ;
				}
				//走一步
				if(snake.stepForEat(food)){
					//吃掉食物，重新生成食物
					food  = randomFood();
				}
				//重绘
				repaint();
			}
		}, 0,500);
	}
	
	/**paint方法  有图片素材的paint*/
	public void paint(Graphics g){
		super.paint(g);
		//画背景图片
		g.drawImage(Util.bg, 0, 0, this);
		//画食物
		//随机生成食物图片数组的下标
		int index = random.nextInt(6);//[0,5]
		g.drawImage(Util.foods[index], food.getFood_x(), food.getFood_y(), this);
		//画蛇
		for(int i=0;i<snake.getCells().length;i++){
			//每次取出一个节点
			Cell current = snake.getCells()[i];
			if(i==0){
				g.drawImage(Util.head, current.getCell_x(), current.getCell_y(), this);
			}else if(i==snake.getCells().length-1){
				g.drawImage(Util.tail, current.getCell_x(), current.getCell_y(), this);
			}else{
				g.drawImage(Util.body, current.getCell_x(), current.getCell_y(), this);
			}
		}
	}
	
	/**
	 * 键盘按下
	 */
	public void keyPressed(KeyEvent e) {
		//获取键盘按下的键
		int keyCode = e.getKeyCode();
		System.out.println("keyCode:"+keyCode);
		//判断方向
		if(keyCode == KeyEvent.VK_UP){
			System.out.println("按下了上方向");
			check(Snake.UP);
		}else if(keyCode == KeyEvent.VK_DOWN){
			System.out.println("按下了下方向");
			check(Snake.DOWN);
		}else if(keyCode == KeyEvent.VK_LEFT){
			System.out.println("按下了左方向");
			check(Snake.LEFT);
		}else if(keyCode == KeyEvent.VK_RIGHT){
			System.out.println("按下了右方向");
			check(Snake.RIGHT);
		}
		//重绘
		repaint();
	}
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public Snake getSnake() {
		return snake;
	}
	public void setSnake(Snake snake) {
		this.snake = snake;
	}

}
