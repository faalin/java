package airplane;

import javax.swing.ImageIcon;

/**
 * 飞行物
 * 英雄机  子弹 敌机 小蜜蜂
 */
public abstract  class FlyingObject {
	/**定义飞行物的x坐标*/
	//private  public  default(什么都不写) protected
	protected int x ;
	/**定义飞行物的y坐标*/
	protected int y ;
	/**定义飞行物图片的款*/
	protected int width ;
	/**定义飞行物图片的高*/
	protected int height ;
	/**定义飞行物的图片*/
	protected ImageIcon imageIcon ;
	
	/**飞行物的行为(方法)*/
	/**飞行物移动的方法*/
	public abstract void step();
	/**飞行物的越界方法*/
	public abstract boolean outOfBounds();
	/**飞行物是否被击中 -->Bullet*/
	public boolean shootBy(Bullet bullet){
		return  bullet.getX()>this.x && bullet.getX()<this.x+this.width
			&& bullet.getY() >this.y && bullet.getY() <this.y+this.height;
	}
	
	/**公开的get/set方法*/
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public ImageIcon getImageIcon() {
		return imageIcon;
	}
	public void setImageIcon(ImageIcon imageIcon) {
		this.imageIcon = imageIcon;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}
