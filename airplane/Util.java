package airplane;

import javax.swing.ImageIcon;

public class Util {
	/**窗体的宽*/
	public static final int FRAME_WIDTH =400 ;
	/**窗体的高*/
	public static final int FRAME_HEIGHT = 654;
	/**小蜜蜂x坐标的移动速度*/
	public static final int BEE_XSPEED =2;
	/**小蜜蜂y坐标的移动速度*/
	public static final int BEE_YSPEED =1 ;
	/**子弹的移动速度*/
	public static final int BULLET_SPEED =3 ;
	/**敌机的移动速度*/
	public static final int AIRPLANE_SPEED =2 ;
	/**英雄机初始位置的x坐标*/
	public static final int HERO_X =150 ;
	/**英雄机初始位置的y坐标*/
	public static final int HERO_Y =400 ;
	/**英雄机的初始生命数*/
	public static final int INIT_LIFE = 3 ;
	
	
	/**定义飞机大战所用到的图片资源*/
	public static ImageIcon start ;
	public static ImageIcon pause ;
	public static ImageIcon gameOver ;
	public static ImageIcon background ;
	public static ImageIcon airplane;
	public static ImageIcon hero1;
	public static ImageIcon hero2 ;
	public static ImageIcon bullet ;
	public static ImageIcon bee ;
	
	/**通过静态块的方式读取图片资源*/
	static{
		String url = "image/shoot/";
		start = new ImageIcon(url+"start.png");
		pause = new ImageIcon(url+"pause.png");
		gameOver = new ImageIcon(url+"gameover.png");
		background = new ImageIcon(url+"background.png");
		airplane = new ImageIcon(url+"airplane.png");
		hero1 = new ImageIcon(url+"hero0.png");
		hero2 = new ImageIcon(url+"hero1.png");
		bullet = new ImageIcon(url+"bullet.png");
		bee = new ImageIcon(url+"bee.png");
		
	
			
	}
	
}
