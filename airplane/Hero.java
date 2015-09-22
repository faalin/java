package airplane;

import javax.swing.ImageIcon;

/**
 * 英雄机
 * 飞行物
 * 移动方式：跟随鼠标
 */
public class Hero extends FlyingObject{
	/**定义保存英雄机图片的数组*/
	private ImageIcon [] images ;
	/**定义切换图片的计数下标*/
	private int index ;
	/**定义英雄机双倍火力的子弹数*/
	private int doubleFire ;
	/**定义英雄机的生命数*/
	private int life ;
	
	/**初始化英雄机的构造方法*/
	public Hero(){
		//初始化保存英雄机图片的数组
		images = new ImageIcon[]{Util.hero1,Util.hero2};
		//初始化英雄机的图片对象
		imageIcon = Util.hero1;
		//初始化英雄机图片的宽， 高
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//初始化英雄机初始位置的x，y坐标
		x = Util.HERO_X ;
		y = Util.HERO_Y ;
		//初始化英雄机的生命数
		life = Util.INIT_LIFE;
		//初始化英雄机双倍火力子弹数
		doubleFire = 0;
		//初始化计数下标
		index = 0 ;
		
	}
	/**英雄机减命*/
	public void subLife(){
		life -- ;
	}
	/**英雄机与飞行物的碰撞检测*/
	public boolean hit(FlyingObject fo){
		//获取敌机的坐标
		int fo_X = fo.getX();
		int fo_Y = fo.getY();
		int x1 = fo_X -this.width/2;
		int x2 = fo_X +fo.getWidth()+this.getWidth()/2;
		int y1 = fo_Y -this.height/2;
		int y2 = fo_Y +fo.getHeight() +this.getHeight()/2;
		
		int x3 = this.x +width/2;
		int y3 = this.y +height/2;
		
		return x3 >x1 && x3 <x2 && 
			y3>y1 && y3 <y2 ;
		
	}
	/**英雄机发射子弹*/
	public Bullet[] shoot(){
		//将飞机图片x平均分成4份
		int newWidth = width/4;
		//将飞机图片y平均分成3份
		int newHeight = height/3;
		//定义一个数组
		Bullet [] bullets ;
		//判断是否有双倍火力
		if(doubleFire >0){
			bullets = new Bullet[2];
			bullets[0] = new Bullet(x+newWidth-10,y+height/3);
			bullets[1] = new Bullet(x+3*newWidth+5,y+height/3);
			doubleFire -= 2;
			return bullets ;
		}
		bullets = new Bullet[1];
		bullets[0] = new Bullet(x+2*newWidth,y);
		return bullets ;
	}
	/**英雄机加命*/
	public void addLife(){
		life ++ ;
	}
	
	/**英雄机跟随鼠标移动*/
	public void moveTo(int x ,int y){
		this.x = x - this.width/2;
		this.y = y - this.height/2;
	}
	
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * 英雄机根据鼠标的移动来动
	 * 
	 *  没有自己特定的运动轨迹
	 *	此处可将表示走一步的方法当成
	 *  切换图片的方法
	 */
	public void step() {
		imageIcon = images[index++/10%images.length];
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getDoubleFire() {
		return doubleFire;
	}
	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}
	
}
