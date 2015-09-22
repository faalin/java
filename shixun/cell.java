package shixun;

import java.awt.Color;

/**
 * 贪吃蛇的蛇身
 * 方格表示
 */
public class cell {
	/**贪吃蛇的*/
	private int cell_width;
	private int cell_height;
	private int cell_rows;
	private int cell_cols;
	private int cell_x;
	private int cell_y;
	private Color cell_color;
	
	
	public cell(){}
	public cell(int cell_rows,int cell_cols){
		this.cell_width = util.CELL_WIDTH;
		this.cell_height = util.CELL_HEIGHT;
		this.cell_rows = cell_rows;
		this.cell_cols = cell_cols;
		this.cell_x = cell_width * cell_cols ;
		this.cell_y = cell_height * cell_rows ;
		this.cell_color = util.CELL_COLOR ;
		}
	public int getCell_width() {
		return cell_width;
	}
	public void setCell_width(int cell_width) {
		this.cell_width = cell_width;
	}
	public int getCell_height() {
		return cell_height;
	}
	public void setCell_height(int cell_height) {
		this.cell_height = cell_height;
	}
	public int getCell_rows() {
		return cell_rows;
	}
	public void setCell_rows(int cell_rows) {
		this.cell_rows = cell_rows;
	}
	public int getCell_cols() {
		return cell_cols;
	}
	public void setCell_cols(int cell_cols) {
		this.cell_cols = cell_cols;
	}
	public int getCell_x() {
		return cell_x;
	}
	public void setCell_x(int cell_x) {
		this.cell_x = cell_x;
	}
	public int getCell_y() {
		return cell_y;
	}
	public void setCell_y(int cell_y) {
		this.cell_y = cell_y;
	}
	public Color getCell_Color() {
		return cell_color;
	}
	public void setCell_Color(Color cell_Color) {
		this.cell_color = cell_Color;
	}
	

}
