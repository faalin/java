package airplane;

import javax.swing.ImageIcon;

public class Util {
	/**����Ŀ�*/
	public static final int FRAME_WIDTH =400 ;
	/**����ĸ�*/
	public static final int FRAME_HEIGHT = 654;
	/**С�۷�x������ƶ��ٶ�*/
	public static final int BEE_XSPEED =2;
	/**С�۷�y������ƶ��ٶ�*/
	public static final int BEE_YSPEED =1 ;
	/**�ӵ����ƶ��ٶ�*/
	public static final int BULLET_SPEED =3 ;
	/**�л����ƶ��ٶ�*/
	public static final int AIRPLANE_SPEED =2 ;
	/**Ӣ�ۻ���ʼλ�õ�x����*/
	public static final int HERO_X =150 ;
	/**Ӣ�ۻ���ʼλ�õ�y����*/
	public static final int HERO_Y =400 ;
	/**Ӣ�ۻ��ĳ�ʼ������*/
	public static final int INIT_LIFE = 3 ;
	
	
	/**����ɻ���ս���õ���ͼƬ��Դ*/
	public static ImageIcon start ;
	public static ImageIcon pause ;
	public static ImageIcon gameOver ;
	public static ImageIcon background ;
	public static ImageIcon airplane;
	public static ImageIcon hero1;
	public static ImageIcon hero2 ;
	public static ImageIcon bullet ;
	public static ImageIcon bee ;
	
	/**ͨ����̬��ķ�ʽ��ȡͼƬ��Դ*/
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
