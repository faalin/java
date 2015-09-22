package airplane;

import java.util.Random;

/**
 * 敌机
 * 飞行物  敌人
 * 移动方式:从上往下
 * @author windows
 *
 */
public class Airplane extends FlyingObject implements Enemy {
	/**定义敌机移动的速度*/
	private int speed ;
	/**定义敌机的分数*/
	private int score ;
	/**定义随机数对象*/
	Random random ;
	
	/**初始化敌机对象的构造方法*/
	public Airplane(){
		//初始化随机数对象
		random = new Random();
		//初始化敌机移动的速度
		speed = Util.AIRPLANE_SPEED ;
		score = random.nextInt(5)+1;
		//初始化敌机的图片对象
		imageIcon = Util.airplane;
		//初始化敌机图片的宽，高
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//初始化敌机入场的x，y坐标
		x = random.nextInt(Util.FRAME_WIDTH-width);
		y = -height ;
		//y = 50;
	}
	@Override
	public boolean outOfBounds() {
		return y >Util.FRAME_HEIGHT;
	}

	/**敌机走一步*/
	public void step() {
		y+=speed ;
	}

	public int getScore() {
		return  score ;
	}
}
