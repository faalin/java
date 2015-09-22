package airplane;
/**
 * 子弹类
 * 飞行物
 * 运动方式： 从下到上
 */
public class Bullet extends FlyingObject{
	/**定义子弹的速度*/
	private int speed ;
	
	/**初始化子弹的构造方法*/
	public Bullet(int x ,int y ){
		//初始化x,y坐标
		this.x = x ;
		this.y = y ;
		//初始化子弹的图片对象
		imageIcon = Util.bullet;
		//初始化子弹图片的宽 高
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//初始化子弹的速度
		speed = Util.BULLET_SPEED;	
	}
	@Override
	public boolean outOfBounds() {
		return  y < -height ;
	}

	/**子弹走一步的方法*/
	public void step() {
		y-=speed ;
	}

}
