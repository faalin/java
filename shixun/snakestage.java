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
 *�ߵ���̨ ��һ�������
 */
public class snakestage extends JPanel implements KeyListener{
	//������̨�ϵ�ʳ��
	private food food;
	//������̨����
	private snake snake;
	//�����ʱ��
	private Timer timer;
	//�������������
	Random random;
	
	//ͨ�����췽���ķ�ʽ��ʼ��ʳ�����
	public snakestage(){
		//��ʼ�����������
		random = new Random();
		//��ʼ����ʱ��
		timer = new Timer();
		//��ʼ����
		snake = new snake();
		//��ʼ��ʳ��
		food = randomfood();
	}
	//�����ж��Ƿ�Խ�粢�����Ƿ���һ���������¿�ʼ
	public void check(int dir ){
		//�ж��Ƿ�Խ��
		if(snake.headBreak(dir)){
			//���¿�ʼ
			restart();
			return ;
		}
	   //��һ��
		if(snake.stepForEat(dir, food)){
			food = randomfood();
		}
	}
	/**�������¿�ʼ�ķ���*/
	public void restart(){
			//���´����ߵĶ���
			snake = new snake();
			//���´���ʳ��Ķ���
			food = randomfood();
			//�ػ�
			repaint();
			
		}
	/*
	 * �����������ʳ��ķ���
	 * ���к��кŵķ�Χ�ڣ���������кź��к�
	 * �жϲ��ܳ������ߵ�����
	 */
	public food randomfood(){
		while(true){
			int rows = random.nextInt(util.STAGE_ROWS);
			int cols = random.nextInt(util.STAGE_COLS);
			//�ж��Ƿ���������
//			for(int i = 0;i < snake.getCells().length;i++){
//				cell current = snake.getCells()[i];
//				if(rows ==current.getCell_rows()&&cols == current.getCell_cols())
//			//���������кź��к�
//				{continue;}//��������ѭ�����ص�ѭ�����¿�ʼ
			if(snake.contains(rows,cols)){
				continue ;
		    }
			return new food(rows,cols);
		}
	}
	
	/*
	 * ����������Ϸ�ķ���
	 * class MyTimerTask extends TimerTask{
	 *   public void run(){}
	 * }
	 */
	public void go(){
		//timer timertask
		//�����ڲ���
		timer.schedule(new TimerTask(){
			public void run(){
				if(snake.headBreak()){
					//���¿�ʼ
					restart();
					return;
				}
				//��һ��
				if(snake.stepForEat(food))
				{
					//�Ե�ʳ���������ʳ��
					food = randomfood();
		    }
			    //�ػ�
			    repaint();
			}
		},0,500);
	}
	
	//��дJPanel�е�paint����
	public void paint(Graphics g){
		//�ָ������paint����
		super.paint(g);
		//��ʳ��,���û��ʵ���ɫ
		g.setColor(food.getFood_color());
		g.fillRect(food.getFood_x() , food.getFood_y(),food.getFood_width(), food.getFood_height());
		//����
		for(int i= 0 ;i < snake.getCells().length ; i++){
			//ȡ��һ���ڵ�
			cell current = snake.getCells()[i];
			//���û��ʵ���ɫ
			g.setColor(current.getCell_Color());
			//��ͷ�ڵ����ɫ
			if(i==0){
				g.setColor(Color.yellow);
			}
			g.fillRect(current.getCell_x(), current.getCell_y(), current.getCell_width(), current.getCell_height()); 
	}
 }
	/*
	 * ���̰���
	 * 
	 */
	public void keyPressed(KeyEvent e) {
        //��ȡ���̰��µļ�
		int keycode = e.getKeyCode();
		System.out.println("keycode:"+keycode);
		//�жϷ���
		if(keycode == KeyEvent.VK_UP){
			System.out.println("�������Ϸ���");
//			if(snake.stepForEat(snake.UP,food)){
//				//��������ʳ��
//				food = randomfood();
//			}
			check(snake.UP);
		}
		else if(keycode == KeyEvent.VK_DOWN){
				System.out.println("�������·���");
//				if(snake.stepForEat(snake.DOWN,food)){
//					//��������ʳ��
//					food = randomfood();}
				check(snake.DOWN);
		}
		else if (keycode == KeyEvent.VK_LEFT){
					System.out.println("����������");
//					if(snake.stepForEat(snake.LEFT,food)){
//						food = randomfood();
//					}
					check(snake.LEFT);
		}
	    else if (keycode == KeyEvent.VK_RIGHT){
					System.out.println("�������ҷ���");
//					if(snake.stepForEat(snake.RIGHT, food)){
//					food = randomfood();
//						}
					check(snake.RIGHT);
	    }
				//�ػ�
		   repaint();
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void keyTyped(KeyEvent e) {
		
	}
}