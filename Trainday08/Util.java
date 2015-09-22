package Trainday08;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

/**
 * 定义贪吃蛇游戏中所有用到的数值
 * 
 * 文档注释
 */
public class Util {
	//通过类名.静态属性
	/**窗体的宽*/
	public static final int FRAME_WIDTH = 450;
	/**窗体的高*/
	public static final int FRAME_HEIGHT = 470;
	/**舞台面板的宽*/
	public static final int STAGE_WIDTH = 400;
	/**舞台面板的高*/
	public static final int STAGE_HEIGHT =400;
	/**舞台面板的x坐标*/
	public static final int STAGE_X =17;
	/**舞台面板的y坐标*/
	public static final int STAGE_Y=15;
	/**舞台面板的背景颜色*/
	public static final Color STAGE_COLOR = new Color(54,207,211);
	
	
	/**食物小方格的宽*/
	public static final int FOOD_WIDTH = 20 ;
	/**食物小方格的高*/
	public static final int FOOD_HEIGHT =20 ;
	/**食物小方格的颜色*/
	public static final Color FOOD_COLOR = Color.red;
	
	/**蛇单元格的宽*/
	public static final int CELL_WIDTH =20 ;
	/**蛇单元格的高*/
	public static final int CELL_HEIGHT =20 ;
	/**蛇单元格的颜色*/
	public static final  Color CELL_COLOR =Color.BLUE;
	
	/**舞台面板的总行数*/
	public static final int STAGE_ROWS = 20;
	/**舞台面板的总列数*/
	public static final int STAGE_COLS = 20;
	
	/**
	 * 读取图片
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
	
	/**静态块  类加载的时候执行*/
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
