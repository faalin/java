package airplane;

import javax.swing.ImageIcon;

/**
 * ������
 * Ӣ�ۻ�  �ӵ� �л� С�۷�
 */
public abstract  class FlyingObject {
	/**����������x����*/
	//private  public  default(ʲô����д) protected
	protected int x ;
	/**����������y����*/
	protected int y ;
	/**���������ͼƬ�Ŀ�*/
	protected int width ;
	/**���������ͼƬ�ĸ�*/
	protected int height ;
	/**����������ͼƬ*/
	protected ImageIcon imageIcon ;
	
	/**���������Ϊ(����)*/
	/**�������ƶ��ķ���*/
	public abstract void step();
	/**�������Խ�緽��*/
	public abstract boolean outOfBounds();
	/**�������Ƿ񱻻��� -->Bullet*/
	public boolean shootBy(Bullet bullet){
		return  bullet.getX()>this.x && bullet.getX()<this.x+this.width
			&& bullet.getY() >this.y && bullet.getY() <this.y+this.height;
	}
	
	/**������get/set����*/
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
