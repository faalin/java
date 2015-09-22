package Trainday08;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * �ߵ���̨  ��һ�������
 */
public class SnakeStage extends JPanel implements KeyListener {
	/**������̨�ϵ�ʳ��*/
	private Food food ;
	/**������̨�ϵ���*/
	private Snake snake ;
	/**�����ʱ��*/
	private Timer timer ;
	/**�������������*/
	Random random  ;
	
	/**ͨ�����췽���ķ�ʽ��ʼ���߸�ʳ��*/
	public SnakeStage(){
		//��ʼ�����������
		random = new Random();
		//��ʼ����ʱ��
		timer = new Timer();
		//��ʼ����
		snake = new Snake();
		//��ʼ��ʳ��
		food = randomFood();
	}
	/**�����ж��Ƿ�Խ�粢�����Ƿ���һ���������¿�ʼ*/
	public void check(int dir ){
		//�ж��Ƿ�Խ��
		if(snake.headBreak(dir)){
			//���¿�ʼ
			reStart();
			return ;
		}
		//��һ��
		if(snake.stepForEat(dir, food)){
			food = randomFood();
		}
	}
	/**�������¿�ʼ�ķ���*/
	public void reStart(){
		//���´����ߵĶ���
		snake = new Snake();
		//���´���ʳ��Ķ���
		food = randomFood();
		//�ػ�
		repaint();	
	}
	/**
	 * �����������ʳ��ķ���
	 * ���к��кŷ�Χ�ڣ���������к��к�
	 * �жϲ��ܳ������ߵ�����
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
	 * ����������Ϸ�ķ���
	 *  class MyTimerTask extends TimerTask{
	 *  	public void run(){}
	 *  }
	 */
	public void go(){
		//Timer TimerTask
		//�����ڲ���
		timer.schedule(new TimerTask(){
			public void run(){
				//check(snake.getDir());
				//�ж��Ƿ�Խ��
				if(snake.headBreak()){
					//���¿�ʼ
					reStart();
					return ;
				}
				//��һ��
				if(snake.stepForEat(food)){
					//�Ե�ʳ���������ʳ��
					food  = randomFood();
				}
				//�ػ�
				repaint();
			}
		}, 0,500);
	}
	
	/**paint����  ��ͼƬ�زĵ�paint*/
	public void paint(Graphics g){
		super.paint(g);
		//������ͼƬ
		g.drawImage(Util.bg, 0, 0, this);
		//��ʳ��
		//�������ʳ��ͼƬ������±�
		int index = random.nextInt(6);//[0,5]
		g.drawImage(Util.foods[index], food.getFood_x(), food.getFood_y(), this);
		//����
		for(int i=0;i<snake.getCells().length;i++){
			//ÿ��ȡ��һ���ڵ�
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
	 * ���̰���
	 */
	public void keyPressed(KeyEvent e) {
		//��ȡ���̰��µļ�
		int keyCode = e.getKeyCode();
		System.out.println("keyCode:"+keyCode);
		//�жϷ���
		if(keyCode == KeyEvent.VK_UP){
			System.out.println("�������Ϸ���");
			check(Snake.UP);
		}else if(keyCode == KeyEvent.VK_DOWN){
			System.out.println("�������·���");
			check(Snake.DOWN);
		}else if(keyCode == KeyEvent.VK_LEFT){
			System.out.println("����������");
			check(Snake.LEFT);
		}else if(keyCode == KeyEvent.VK_RIGHT){
			System.out.println("�������ҷ���");
			check(Snake.RIGHT);
		}
		//�ػ�
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
