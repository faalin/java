package Trainday08;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * ����̰������Ϸ�������õ�����ֵ
 * 
 * �ĵ�ע��
 */
public class Util {
	//ͨ������.��̬����
	/**����Ŀ�*/
	public static final int FRAME_WIDTH = 450;
	/**����ĸ�*/
	public static final int FRAME_HEIGHT = 470;
	/**��̨���Ŀ�*/
	public static final int STAGE_WIDTH = 400;
	/**��̨���ĸ�*/
	public static final int STAGE_HEIGHT =400;
	/**��̨����x����*/
	public static final int STAGE_X =17;
	/**��̨����y����*/
	public static final int STAGE_Y=15;
	/**��̨���ı�����ɫ*/
	public static final Color STAGE_COLOR = new Color(54,207,211);
	
	
	/**ʳ��С����Ŀ�*/
	public static final int FOOD_WIDTH = 20 ;
	/**ʳ��С����ĸ�*/
	public static final int FOOD_HEIGHT =20 ;
	/**ʳ��С�������ɫ*/
	public static final Color FOOD_COLOR = Color.red;
	
	/**�ߵ�Ԫ��Ŀ�*/
	public static final int CELL_WIDTH =20 ;
	/**�ߵ�Ԫ��ĸ�*/
	public static final int CELL_HEIGHT =20 ;
	/**�ߵ�Ԫ�����ɫ*/
	public static final  Color CELL_COLOR =Color.BLUE;
	
	/**��̨����������*/
	public static final int STAGE_ROWS = 20;
	/**��̨����������*/
	public static final int STAGE_COLS = 20;
	
	/**
	 * ��ȡͼƬ
	 */
	/**head.png*/
	public static Image head;
	/**body.jpg*/
	public static Image body;
	/**tail.jpg*/
	public static Image tail;
	/**bg.jpg*/
	public static Image bg;
	/**food*/
	public static Image[] foods;
	
	/**��̬��  ����ص�ʱ��ִ��*/
	static{
		head = new ImageIcon("image/head.png").getImage();
		body = new ImageIcon("image/body.jpg").getImage();
		tail = new ImageIcon("image/tail.jpg").getImage();
		bg = new ImageIcon("image/bg.jpg").getImage();
		foods = new Image[]{
				new ImageIcon("image/2.jpg").getImage(),
				new ImageIcon("image/3.jpg").getImage(),
				new ImageIcon("image/4.jpg").getImage(),
				new ImageIcon("image/5.jpg").getImage(),
				new ImageIcon("image/6.jpg").getImage(),
				new ImageIcon("image/7.jpg").getImage()
		};
	}
}
