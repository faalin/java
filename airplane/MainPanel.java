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
 * 飞机大战的主面板
 * 英雄机  敌机  子弹  小蜜蜂
 */
public class MainPanel extends JPanel {
	
//	Bee bee ;
//	Bullet bullet ;
//	Airplane airplane ;
	private Hero hero ;
	/**定义计时器对象*/
	private Timer timer ;
	/**定义保存飞行物(敌机,小蜜蜂)的数组*/
	private FlyingObject [] flyings ;
	/**定义保存子弹的数组*/
	private Bullet [] bullets ;
	/**定义生成飞行物的计数变量*/
	private int flyNewIndex;
	/**定义随机数对象*/
	private Random random ;
	/**定义发射子弹的计数变量*/
	private int shootIndex ;
	/**定义分数*/
	private int score ;
	/**定义表示状态的变量*/
	private int state ;
	/**定义游戏运行的4种状态*/
	public static final int START =0 ;
	public static final int RUNNING = 1 ;
	public static final int PAUSE =2 ;
	public static final int GAME_OVER= 3;
	
	/**初始化MainPanel的构造方法*/
	public MainPanel(){
		//初始化计时器对象
		timer = new Timer();
		//初始化飞行物数组
		flyings = new FlyingObject[2];
		//多态  子类的对象 父类的类型
		//Animal dog = new Dog();
		//Dog dog = new Animal();
		flyings[0] = new Airplane();
		flyings[1] = new Bee();
		//初始化子弹的数组
		bullets = new Bullet[1];
		bullets[0] = new Bullet(200,350);
		//初始化英雄机
		hero = new Hero();
		//初始化生成飞行物的计数变量
		flyNewIndex = 0 ;
		// 初始化随机数对象
		random = new Random();
		//初始化发射子弹的计数变量
		shootIndex =0 ;
		//初始化分数
		score =0;
		//初始化最开始的状态
		state = START;
		
//		bee = new Bee();
//		bullet = new Bullet(200,300);
//		airplane = new Airplane();
	}
	
	/**主控制流程*/
	public void action(){
		//创建鼠标的Adapter 调制解调器
		MouseAdapter  ma = new MouseAdapter(){
			/**鼠标点击事件*/
			public void mouseClicked(MouseEvent e) {
				//如果是开始状态，变成运行状态
				if(state == START){
					state = RUNNING;
				}
				if(state == GAME_OVER){
					//重新开始
					//飞行物数组 子弹数组 英雄机 分数 
					flyings = new FlyingObject[0];
					bullets = new Bullet[0];
					hero = new Hero ();
					score =0 ;
					state = START;
				}
			}
			/**鼠标进入的事件*/
			public void mouseEntered(MouseEvent e) {
				if(state == PAUSE){
					state = RUNNING;
				}
			}
			/**鼠标移出的事件*/
			public void mouseExited(MouseEvent e) {
				if(state == RUNNING){
					state = PAUSE;
				}
			}
			/**鼠标移动事件*/
			public void mouseMoved(MouseEvent e) {
				if(state == RUNNING){
					//获取当前鼠标所在的位置
					int x = e.getX();
					int y = e.getY();
					//让英雄机移动到此位置
					hero.moveTo(x, y);
					//重绘
					repaint();
				}
			}
		};
		//给面板加监听
		this.addMouseMotionListener(ma);
		this.addMouseListener(ma);
		//制定计划
		timer.schedule(new TimerTask(){
			public void run(){
				if(state == RUNNING){
					//飞行物入场
					enteredAction();
					//走一步
					stepAction();
					//发射子弹
					shootAction();
					//判断子弹是否击中飞行物
					hitAction();
					//判断飞行物是否越界
					outOfBoundsAction();
					//判断英雄机是否与敌机碰撞
					heroHitFlyingObject();
					//判断英雄机的生命数，是否结束游戏
					isGameOver();
				}
				repaint();
			}
		}, 10,10);
		
	}
	/**飞行物入场*/
	public void enteredAction(){
		//隔一段时间来一个敌机或者小蜜蜂
		flyNewIndex ++ ;
		if(flyNewIndex % 40 ==0 ){
			//生成飞行物 小蜜蜂  敌机
			FlyingObject fo = nextOne();
			//数组的扩容操作
			flyings =Arrays.copyOf(flyings, flyings.length+1);
			flyings[flyings.length-1] =fo ;
		}
	}
	/**生成飞行物的方法*/
	public FlyingObject nextOne(){
		//随机生成 敌机的几率大 蜜蜂的几率小
		int index = random.nextInt(20);
		if(index ==0){
			//小蜜蜂
			return new Bee();
		}else{
			//敌机
			return new Airplane();
		}
	}
	/**飞行物走一步的方法*/
	public void stepAction(){
		//英雄机走一步
		hero.step();
		//飞行物走一步
		for(int i= 0 ;i <flyings.length;i++){
			//运行时，方法是动态的绑定到对象上的。
			//多态现象中，子类的对象被父类的变量引用，
			//但是，调方法的时候，会按照子类的对象调用对
			//应对象的方法
			//编译时，根据类型来检查
			FlyingObject fo = flyings[i];
			fo.step();
		}
		//子弹的走一步
		for(int i= 0 ;i <bullets.length;i++){
			Bullet bullet  = bullets[i];
			bullet.step();
		}
		//重绘
		repaint();
//		//小蜜蜂走一步
//		bee.step();
//		//子弹走一步
//		bullet.step();
//		//敌机走一步
//		airplane.step();
	}
	/**发射子弹*/
	public void shootAction(){
		System.out.println("子弹数组的长度："+bullets.length);
		if(shootIndex ++ %25==0){
			//让英雄机发射子弹
			Bullet [] bs=hero.shoot();
			//扩容数组的长度
			bullets =Arrays.copyOf(bullets, bullets.length+bs.length);
			//将飞机打出去的子弹放到子弹数组中
			System.arraycopy(bs, 0, bullets, bullets.length-bs.length, bs.length);
		}
	}
	/**判断是否击中飞行物*/
	public void hitAction(){
		
		//创建保存未打掉飞行物的子弹
		Bullet  [] bulletLives  = new Bullet[bullets.length];
		//定义数组计数下标
		int index = 0 ;
		//循环子弹数组，拿出每一颗子弹跟所有的飞行物比较
		for(int i= 0 ;i <bullets.length;i++){
			Bullet current = bullets[i];
			//拿这颗子弹去跟所有飞行物比较
			boolean isDead =hit(current);
			if(!isDead){
				//活着的子弹
				bulletLives[index++] =current;
			}
		}
		//		扩容数组，将空元素删掉
		bullets = Arrays.copyOf(bulletLives, index);
	}
	/**子弹是否击中飞行物的判断*/
	public boolean hit(Bullet bullet){
		//循环飞行物
		for(int i= 0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			//飞行物被子弹打掉
			boolean isDead =fo.shootBy(bullet);
			//子弹打掉飞行物
			//bullet.shoot(fo);
			//通过判断结果决定是否删除此飞行物
			if(isDead){
					flyings[i] = flyings[flyings.length-1];
					flyings[flyings.length-1] = fo;
					flyings = Arrays.copyOf(flyings, flyings.length-1);
					//判断飞行物的类型，加分 奖励
					// instanceof
					if(fo instanceof Airplane){
						//将此飞行物强转为敌机
						Airplane  air = (Airplane)fo;
						//获取此敌机的分数
						int score = air.getScore();
						this.score+=score ;
						
					}
					if(fo instanceof Bee){
						//奖励
						//强转
						Bee bee = (Bee)fo ;
						//获取奖励类型  0 1
						int awardType = bee.getType();
						switch(awardType){
						case Award.DOUBLE_FIRE:
							//给英雄机加双倍火力子弹
							hero.setDoubleFire(40);
							break ;
						case Award.LIFE:
							//英雄机的生命数加1
							hero.addLife();
							break ;
						}
					}	
					return isDead;
			}
		}
		return false ;
	}
	/**判断飞行物是否越界  敌机  小蜜蜂  子弹*/
	public void outOfBoundsAction(){
		//循环飞行物的数组 敌机 小蜜蜂
		FlyingObject [] flyLives = new FlyingObject[flyings.length];
		int index = 0 ;
		for(int i= 0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			if(!fo.outOfBounds()){
				flyLives[index ++] = fo ;
			}
		}
		//删除越界的飞行物
		flyings = Arrays.copyOf(flyLives ,index	);
		//循环子弹的数组
		Bullet [] bulletLives = new Bullet[bullets.length];
		index =0 ;
		for(int i= 0 ;i <bullets.length;i++){
			Bullet bullet = bullets[i];
			if(!bullet.outOfBounds()){
				bulletLives[index ++]=bullet ;
			}
		}
		//删除越界的子弹
		bullets= Arrays.copyOf(bulletLives, index);
	}
	/**判断英雄机是否与飞行物碰撞*/
	public void heroHitFlyingObject(){
		for(int i = 0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			//英雄机与敌机的碰撞检测
			boolean isHit =hero.hit(fo);
			if(isHit){
				//英雄机生命减1
				hero.subLife();
				//敌机消失	
				flyings[i] = flyings[flyings.length-1];
				flyings[flyings.length-1] = fo ;
				flyings = Arrays.copyOf(flyings, flyings.length-1);
				return ;
			}
		}
	}
	/**判断是否结束游戏*/
	public void isGameOver(){
		if(hero.getLife()<=0 ){
			//状态改为GAME_OVER
			state = GAME_OVER;
			//timer.cancel();
		}
	}
	
	/**
	 * 重写JPanel中的paint 方法
	 */
	public void paint(Graphics g){
		super.paint(g);
		//画游戏背景图片
		g.drawImage(Util.background.getImage(), 0, 0, this);
		//画飞行物
		paintFlyings(g); 
		//画子弹
		paintBullet(g);
		//画英雄机
		paintHero(g);
		//画分数
		paintScore(g);
		//画状态
		paintState(g);

	}
	/**画飞行物*/
	public void paintFlyings(Graphics g){
//		//敌机
//		g.drawImage(airplane.getImageIcon().getImage(), airplane.getX(), airplane.getY(), this);
//		//小蜜蜂
//		g.drawImage(bee.getImageIcon().getImage(), bee.getX(), bee.getY(), this);
		for(int i=0 ;i <flyings.length;i++){
			FlyingObject fo = flyings[i];
			//System.out.println("fo:"+fo);
			g.drawImage(fo.getImageIcon().getImage(), fo.getX(), fo.getY(), this);	
		}
		
	}
	/**画子弹*/
	public void paintBullet(Graphics g){
		//g.drawImage(bullet.getImageIcon().getImage(), bullet.getX(), bullet.getY(), this);
		for(int i= 0 ;i <bullets.length;i++){
			Bullet bullet = bullets[i];
			g.drawImage(bullet.getImageIcon().getImage(), bullet.getX(), bullet.getY(), this);
		}
	}
	/**画英雄机*/
	public void paintHero(Graphics g){
		g.drawImage(hero.getImageIcon().getImage(),hero.getX(), hero.getY(), this);
	}
	/**画分数*/
	public void paintScore(Graphics g){
		int x = 10 ;
		int y = 25 ;
		//设置画笔的颜色
		g.setColor(new Color(0x3A3B3B));
		//设置画笔的大小
		g.setFont(new Font(Font.SANS_SERIF,Font.BOLD,25));
		//画分数
		g.drawString("SCORE:"+score, x, y);
		//画英雄机的生命数
		g.drawString("LIFE:"+hero.getLife(), x, y+30);
	}
	/**画游戏运行的状态*/
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
