package Trainday08;

import java.awt.Color;

/**
 * 蛇身上的单元
 */
public class Cell {
	private int cell_width;
	private int cell_height;
	private int cell_rows ;
	private int cell_cols ;
	private int cell_x ;
	private int cell_y;
	private Color cell_color ;
	
	public Cell(){}
	public Cell(int cell_rows,int cell_cols){
		this.cell_width = Util.CELL_WIDTH;
		this.cell_height = Util.CELL_HEIGHT;
		this.cell_rows =cell_rows ;
		this.cell_cols = cell_cols;
		this.cell_x =cell_width * cell_cols ;
		this.cell_y =cell_height *cell_rows ;
		this.cell_color = Util.CELL_COLOR;
	}
	public Color getCell_color() {
		return cell_color;
	}
	public void setCell_color(Color cell_color) {
		this.cell_color = cell_color;
	}
	public int getCell_cols() {
		return cell_cols;
	}
	public void setCell_cols(int cell_cols) {
		this.cell_cols = cell_cols;
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
	public int getCell_width() {
		return cell_width;
	}
	public void setCell_width(int cell_width) {
		this.cell_width = cell_width;
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
}
