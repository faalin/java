package airplane;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

/**
 * �ɻ���ս�������
 * Ӣ�ۻ�  �л�  �ӵ�  С�۷�
 */
public class MainPanel extends JPanel {
	
//	Bee bee ;
//	Bullet bullet ;
//	Airplane airplane ;
	private Hero hero ;
	/**�����ʱ������*/
	private Timer timer ;
	/**���屣�������(�л�,С�۷�)������*/
	private FlyingObject [] flyings ;
	/**���屣���ӵ�������*/
	private Bullet [] bullets ;
	/**�������ɷ�����ļ�������*/
	private int flyNewIndex;
	/**�������������*/
	private Random random ;
	/**���巢���ӵ��ļ�������*/
	private int shootIndex ;
	/**�������*/
	private int score ;
	/**�����ʾ״̬�ı���*/
	private int state ;
	/**������Ϸ���е�4��״̬*/
	public static final int START =0 ;
	public static final int RUNNING = 1 ;
	public static final int PAUSE =2 ;
	public static final int GAME_OVER= 3;
	
	/**��ʼ��MainPanel�Ĺ��췽��*/
	public MainPanel(){
		//��ʼ����ʱ������
		timer = new Timer();
		//��ʼ������������
		flyings = new FlyingObject[2];
		//��̬  ����Ķ��� ���������
		//Animal dog = new Dog();
		//Dog dog = new Animal();
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
		//��ʼ���ӵ�������
		bullets = new Bullet[1];
		bullets[0] = new Bullet(200,350);
		//��ʼ��Ӣ�ۻ�
		hero = new Hero();
		//��ʼ�����ɷ�����ļ�������
		flyNewIndex = 0 ;
		// ��ʼ�����������
		random = new Random();
		//��ʼ�������ӵ��ļ�������
		shootIndex =0 ;
		//��ʼ������
		score =0;
		//��ʼ���ʼ��״̬
		state = START;
		
//		bee = new Bee();
//		bullet = new Bullet(200,300);
//		airplane = new Airplane();
	}
	
	/**����������*/
	public void action(){
		//��������Adapter ���ƽ����
		MouseAdapter  ma = new MouseAdapter(){
			/**������¼�*/
			public void mouseClicked(MouseEvent e) {
				//����ǿ�ʼ״̬���������״̬
				if(state == START){
					state = RUNNING;
				}
				if(state == GAME_OVER){
					//���¿�ʼ
					//���������� �ӵ����� Ӣ�ۻ� ���� 
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					hero = new Hero ();
					score =0 ;
					state = START;
				}
			}
			/**��������¼�*/
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){
					state = RUNNING;
				}
			}
			/**����Ƴ����¼�*/
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){
					state = PAUSE;
				}
			}
			/**����ƶ��¼�*/
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING){
					//��ȡ��ǰ������ڵ�λ��
					int x = e.getX();
					int y = e.getY();
					//��Ӣ�ۻ��ƶ�����λ��
					hero.moveTo(x, y);
					//�ػ�
					repaint();
				}
			}
		};
		//�����Ӽ���
		this.addMouseMotionListener(ma);
		this.addMouseListener(ma);
		//�ƶ��ƻ�
		timer.schedule(new TimerTask(){
			public void run(){
				if(state == RUNNING){
					//�������볡
					enteredAction();
					//��һ��
					stepAction();
					//�����ӵ�
					shootAction();
					//�ж��ӵ��Ƿ���з�����
					hitAction();
					//�жϷ������Ƿ�Խ��
					outOfBoundsAction();
					//�ж�Ӣ�ۻ��Ƿ���л���ײ
					heroHitFlyingObject();
					//�ж�Ӣ�ۻ������������Ƿ������Ϸ
					isGameOver();
				}
				repaint();
			}
		}, 10,10);
		
	}
	/**�������볡*/
	public void enteredAction(){
		//��һ��ʱ����һ���л�����С�۷�
		flyNewIndex ++ ;
		if(flyNewIndex % 40 ==0 ){
			//���ɷ����� С�۷�  �л�
			FlyingObject fo = nextOne();
			//��������ݲ���
			flyings =Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] =fo ;
		}
	}
	/**���ɷ�����ķ���*/
	public FlyingObject nextOne(){
		//������� �л��ļ��ʴ� �۷�ļ���С
		int index = random.nextInt(20);
		if(index ==0){
			//С�۷�
			return new Bee();
		}else{
			//�л�
			return new Airplane();
		}
	}
	/**��������һ���ķ���*/
	public void stepAction(){
		//Ӣ�ۻ���һ��
		hero.step();
		//��������һ��
		for(int i= 0 ;i <flyings.length;i++){
			//����ʱ�������Ƕ�̬�İ󶨵������ϵġ�
			//��̬�����У�����Ķ��󱻸���ı������ã�
			//���ǣ���������ʱ�򣬻ᰴ������Ķ�����ö�
			//Ӧ����ķ���
			//����ʱ���������������
			FlyingObject fo = flyings[i];
			fo.step();
		}
		//�ӵ�����һ��
		for(int i= 0 ;i <bullets.length;i++){
			Bullet bullet  = bullets[i];
			bullet.step();
		}
		//�ػ�
		repaint();
//		//С�۷���һ��
//		bee.step();
//		//�ӵ���һ��
//		bullet.step();
//		//�л���һ��
//		airplane.step();
	}
	/**�����ӵ�*/
	public void shootAction(){
		System.out.println("�ӵ�����ĳ��ȣ�"+bullets.length);
		if(shootIndex ++ %25==0){
			//��Ӣ�ۻ������ӵ�
			Bullet [] bs=hero.shoot();
			//��������ĳ���
			bullets =Arrays.copyOf(bullets, bullets.length+bs.length);
			//���ɻ����ȥ���ӵ��ŵ��ӵ�������
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	/**�ж��Ƿ���з�����*/
	public void hitAction(){
		
		//��������δ�����������ӵ�
		Bullet  [] bulletLives  = new Bullet[bullets.length];
		//������������±�
		int index = 0 ;
		//ѭ���ӵ����飬�ó�ÿһ���ӵ������еķ�����Ƚ�
		for(int i= 0 ;i <bullets.length;i++){
			Bullet current = bullets[i];
			//������ӵ�ȥ�����з�����Ƚ�
			boolean isDead =hit(current);
			if(!isDead){
				//���ŵ��ӵ�
				bulletLives[index++] =current;
			}
		}
		//		�������飬����Ԫ��ɾ��
		bullets = Arrays.copyOf(bulletLives, index);
	}
	/**�ӵ��Ƿ���з�������ж�*/
	public boolean hit(Bullet bullet){
		//ѭ��������
		for(int i= 0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			//�����ﱻ�ӵ����
			boolean isDead =fo.shootBy(bullet);
			//�ӵ����������
			//bullet.shoot(fo);
			//ͨ���жϽ�������Ƿ�ɾ���˷�����
			if(isDead){
					flyings[i] = flyings[flyings.length-1];
					flyings[flyings.length-1] = fo;
					flyings = Arrays.copyOf(flyings, flyings.length-1);
					//�жϷ���������ͣ��ӷ� ����
					// instanceof
					if(fo instanceof Airplane){
						//���˷�����ǿתΪ�л�
						Airplane  air = (Airplane)fo;
						//��ȡ�˵л��ķ���
						int score = air.getScore();
						this.score+=score ;
						
					}
					if(fo instanceof Bee){
						//����
						//ǿת
						Bee bee = (Bee)fo ;
						//��ȡ��������  0 1
						int awardType = bee.getType();
						switch(awardType){
						case Award.DOUBLE_FIRE:
							//��Ӣ�ۻ���˫�������ӵ�
							hero.setDoubleFire(40);
							break ;
						case Award.LIFE:
							//Ӣ�ۻ�����������1
							hero.addLife();
							break ;
						}
					}	
					return isDead;
			}
		}
		return false ;
	}
	/**�жϷ������Ƿ�Խ��  �л�  С�۷�  �ӵ�*/
	public void outOfBoundsAction(){
		//ѭ������������� �л� С�۷�
		FlyingObject [] flyLives = new FlyingObject[flyings.length];
		int index = 0 ;
		for(int i= 0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			if(!fo.outOfBounds()){
				flyLives[index ++] = fo ;
			}
		}
		//ɾ��Խ��ķ�����
		flyings = Arrays.copyOf(flyLives ,index	);
		//ѭ���ӵ�������
		Bullet [] bulletLives = new Bullet[bullets.length];
		index =0 ;
		for(int i= 0 ;i <bullets.length;i++){
			Bullet bullet = bullets[i];
			if(!bullet.outOfBounds()){
				bulletLives[index ++]=bullet ;
			}
		}
		//ɾ��Խ����ӵ�
		bullets= Arrays.copyOf(bulletLives, index);
	}
	/**�ж�Ӣ�ۻ��Ƿ����������ײ*/
	public void heroHitFlyingObject(){
		for(int i = 0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			//Ӣ�ۻ���л�����ײ���
			boolean isHit =hero.hit(fo);
			if(isHit){
				//Ӣ�ۻ�������1
				hero.subLife();
				//�л���ʧ	
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = fo ;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
				return ;
			}
		}
	}
	/**�ж��Ƿ������Ϸ*/
	public void isGameOver(){
		if(hero.getLife()<=0 ){
			//״̬��ΪGAME_OVER
			state = GAME_OVER;
			//timer.cancel();
		}
	}
	
	/**
	 * ��дJPanel�е�paint ����
	 */
	public void paint(Graphics g){
		super.paint(g);
		//����Ϸ����ͼƬ
		g.drawImage(Util.background.getImage(), 0, 0, this);
		//��������
		paintFlyings(g); 
		//���ӵ�
		paintBullet(g);
		//��Ӣ�ۻ�
		paintHero(g);
		//������
		paintScore(g);
		//��״̬
		paintState(g);

	}
	/**��������*/
	public void paintFlyings(Graphics g){
//		//�л�
//		g.drawImage(airplane.getImageIcon().getImage(), airplane.getX(), airplane.getY(), this);
//		//С�۷�
//		g.drawImage(bee.getImageIcon().getImage(), bee.getX(), bee.getY(), this);
		for(int i=0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			//System.out.println("fo:"+fo);
			g.drawImage(fo.getImageIcon().getImage(), fo.getX(), fo.getY(), this);	
		}
		
	}
	/**���ӵ�*/
	public void paintBullet(Graphics g){
		//g.drawImage(bullet.getImageIcon().getImage(), bullet.getX(), bullet.getY(), this);
		for(int i= 0 ;i <bullets.length;i++){
			Bullet bullet = bullets[i];
			g.drawImage(bullet.getImageIcon().getImage(), bullet.getX(), bullet.getY(), this);
		}
	}
	/**��Ӣ�ۻ�*/
	public void paintHero(Graphics g){
		g.drawImage(hero.getImageIcon().getImage(),hero.getX(), hero.getY(), this);
	}
	/**������*/
	public void paintScore(Graphics g){
		int x = 10 ;
		int y = 25 ;
		//���û��ʵ���ɫ
		g.setColor(new Color(0x3A3B3B));
		//���û��ʵĴ�С
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		//������
		g.drawString("SCORE:"+score, x, y);
		//��Ӣ�ۻ���������
		g.drawString("LIFE:"+hero.getLife(), x, y+30);
	}
	/**����Ϸ���е�״̬*/
	public void paintState(Graphics g){
		switch(state){
		case START:
			g.drawImage(Util.start.getImage(), 0, 0, this);
			break ;
		case PAUSE:
			g.drawImage(Util.pause.getImage(), 0, 0, this);
			break ;
		case GAME_OVER:
			g.drawImage(Util.gameOver.getImage(), 0, 0, this);
			break ;
		}
	}
}
