package shixun;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class util {

	/**
	 * 贪吃蛇游戏所用到的数值
	 * 
	 */
	//设置窗口的宽
	public static final int FRAME_WIDTH = 450;
	//设置窗体的高
	public static final int FRAME_HIGH= 470;
	//设置面板的宽
	public static final int STAGE_WIDTH = 400;
	//设置面板的高
	public static final int STAGE_HIGH = 400;
	//设置舞台面板的x坐标
	public static final int STAGE_X = 17 ;
	//设置舞台面板的y坐标
	public static final int STAGE_Y = 15 ;
	//舞台面板背景颜色
	//public static final Color STAGE_COLOR = new Color(54,207,211);
	public static final Color STAGE_COLOR = Color.cyan;
	
	
	//贪吃蛇食物的小方格的宽
	public static final int FOOD_WIDTH = 20 ;
	//贪吃蛇食物的小方格的高
	public static final int FOOD_HEIGHT = 20 ;
	//贪吃蛇食物小方格的颜色
    public static final Color FOOD_COLOR = Color.red ;
    
    //蛇单元格的宽
    public static final int CELL_WIDTH = 20;
    //蛇单元格的高
    public static final int CELL_HEIGHT = 20;
    //设置单元格的颜色
    public static final Color CELL_COLOR = Color.blue;

	//设置舞台的总行数
    public static final int STAGE_ROWS = 20 ;
    //设置舞台的总行数
    public static final int STAGE_COLS = 20 ;
	//定义贪吃蛇的所用图片素材
    public static ImageIcon icon;
    public static ImageIcon head;
    public static ImageIcon body;
    public static ImageIcon tail;
    public static ImageIcon bg;
    public static ImageIcon[] foods ;
    //通过静态块的方式读取图片资源
    static{
    	icon = new ImageIcon ("image/1.jpg");
    	head = new ImageIcon ("image/head.jpg");
    	body = new ImageIcon ("image/body.jpg");
    	tail = new ImageIcon ("image/tail.jpg");
    	bg = new ImageIcon ("image/bg.jpg");
    	foods = new ImageIcon[]{
    			new ImageIcon("image/2.jpg"),
    			new ImageIcon("image/3.jpg"),
    			new ImageIcon("image/4.jpg"),
    			new ImageIcon("image/5.jpg"),
    			new ImageIcon("image/6.jpg"),
    			new ImageIcon("image/7.jpg"),
    			
                   };

             }
}
