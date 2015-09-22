package Trainday08;

import java.awt.Color;

/**
 * ̰���ߵ�ʳ����
 * ��һ��С����
 */
public class Food {
	/**ʳ��С����Ŀ�*/
	private int food_width ;
	/**ʳ��С����ĸ�*/
	private int food_height ;
	/**ʳ��С������к�*/
	private int food_rows ;
	/**ʳ��С������к�*/
	private int food_cols ;
	/**ʳ��С�����x����*/
	private int food_x ;
	/**ʳ��С�����y����*/
	private int food_y ;
	/**ʳ��С�������ɫ*/
	private Color food_color ;

	public Food(){}
	//���췽��
	public Food(int food_rows,int food_cols ){
		this.food_width = Util.FOOD_WIDTH;
		this.food_height = Util.FOOD_HEIGHT;
		this.food_rows = food_rows ;
		this.food_cols = food_cols ;
		this.food_x = this.food_cols*food_width;
		this.food_y = this.food_rows*food_height;
		this.food_color =Util.FOOD_COLOR;
	}
	//������get/set����
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
