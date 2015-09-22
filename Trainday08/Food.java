package Trainday08;

import java.awt.Color;

/**
 * 贪吃蛇的食物类
 * 是一个小方格
 */
public class Food {
	/**食物小方格的宽*/
	private int food_width ;
	/**食物小方格的高*/
	private int food_height ;
	/**食物小方格的行号*/
	private int food_rows ;
	/**食物小方格的列号*/
	private int food_cols ;
	/**食物小方格的x坐标*/
	private int food_x ;
	/**食物小方格的y坐标*/
	private int food_y ;
	/**食物小方格的颜色*/
	private Color food_color ;

	public Food(){}
	//构造方法
	public Food(int food_rows,int food_cols ){
		this.food_width = Util.FOOD_WIDTH;
		this.food_height = Util.FOOD_HEIGHT;
		this.food_rows = food_rows ;
		this.food_cols = food_cols ;
		this.food_x = this.food_cols*food_width;
		this.food_y = this.food_rows*food_height;
		this.food_color =Util.FOOD_COLOR;
	}
	//公开的get/set方法
	public Color getFood_color() {
		return food_color;
	}
	public void setFood_color(Color food_color) {
		this.food_color = food_color;
	}
	public int getFood_cols() {
		return food_cols;
	}
	public void setFood_cols(int food_cols) {
		this.food_cols = food_cols;
	}
	public int getFood_height() {
		return food_height;
	}
	public void setFood_height(int food_height) {
		this.food_height = food_height;
	}
	public int getFood_rows() {
		return food_rows;
	}
	public void setFood_rows(int food_rows) {
		this.food_rows = food_rows;
	}
	public int getFood_width() {
		return food_width;
	}
	public void setFood_width(int food_width) {
		this.food_width = food_width;
	}
	public int getFood_x() {
		return food_x;
	}
	public void setFood_x(int food_x) {
		this.food_x = food_x;
	}
	public int getFood_y() {
		return food_y;
	}
	public void setFood_y(int food_y) {
		this.food_y = food_y;
	}
}
