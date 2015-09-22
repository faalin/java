package airplane;

import java.util.Random;

/**
 * 小蜜蜂
 * 飞行物  奖励
 * 
 * 
 *
 */
public class Bee extends FlyingObject implements Award {
	/**定义x坐标的移动速度*/
	private int xSpeed ;
	/**定义y坐标的移动速度*/
	private int ySpeed ;
	/**定义奖励类型*/
	private int awardType ;
	/**定义随机数对象*/
	Random random ;
	/**通过构造方法的方式初始化蜜蜂对象*/
	public Bee(){
		//初始化Random对象
		random = new Random();
		//初始化xSpeed，ySpeed
		xSpeed = Util.BEE_XSPEED;
		ySpeed = Util.BEE_YSPEED;
		//初始化蜜蜂的图片对象
		imageIcon = Util.bee;
		//初始化蜜蜂图片的宽，高
		//Util.bee.getImage().getWidth(null);
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//初始化蜜蜂入场的坐标x，y
		x = random.nextInt(Util.FRAME_WIDTH-width);
		y = -height;
		//y = 100;
		awardType = random.nextInt(Award.AWARD_COUNT);
	}
	@Override
	public boolean outOfBounds() {
		return y >Util.FRAME_HEIGHT;
	}

	/**蜜蜂的走一步*/
	public void step() {
		x+= xSpeed ;
		y+= ySpeed ;
		//撞到右边 ，向左反弹
		if(x >=Util.FRAME_WIDTH-width){
			xSpeed =-2 ;
		}
		//撞到左边，向右反弹
		if(x <=0){
			xSpeed = 2 ;
		}
	}

	public int getType() {
		// TODO Auto-generated method stub
		return awardType;
	}
	
}
