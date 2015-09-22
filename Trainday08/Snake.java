package Trainday08;

import java.util.Arrays;

/**
 * ̰���ߵ�����
 */
public class Snake {
	//LinkedList
	/**�ߣ����屣���߽ڵ������*/
	private Cell [] cells ;
	/**�����ߵ��ĸ�����*/
	public static final int UP =-10;
	public static final int DOWN =10 ;
	public static final int LEFT =-1 ;
	public static final int RIGHT =1 ;
	/**�����ߵ�ǰ�ķ���*/
	private int dir ;
	//ͨ�����췽���ķ�ʽ��ʼ������
	public Snake(){
		cells = new Cell[]{
				new Cell(5,6),
				new Cell(5,7),
				new Cell(5,8),
				new Cell(6,8),
				new Cell(7,8),
				new Cell(7,9),
				new Cell(7,10)
		};
		//��Ĭ�ϵķ���
		dir = LEFT;
	}
	/**�����ж��½ڵ��Ƿ����ߵ�����*/
	public boolean contains(int newRows,int newCols){
		for(int i = 0 ;i <cells.length;i++){
			//ȡ��һ���ڵ�
			Cell current = cells[i];
			if(newRows ==current.getCell_rows() &&
					newCols ==current.getCell_cols()){
				return true ;
			}
		}
		return false ;
	}
	
	/**
	 * Խ��
	 * 1.�ж��ߵ�ǰ�ķ�������̿��Ƶķ����Ƿ��෴
	 * 2.�����½ڵ�
	 * 3.rows<0|| rows>=20 || cols <0 || cols >=20
	 * 4.���������
	 */
	public boolean headBreak(int dir ){ //��ͷ
		//1.
		if(this.dir + dir  ==0 ){
			return false ;
		}
		//2.
		Cell head = cells[0];
		int newRows = head.getCell_rows() +dir/10;
		int newCols = head.getCell_cols() +dir%10;
		return contains(newRows,newCols)||newRows <0 || newRows >=Util.STAGE_ROWS 
				||newCols <0 || newCols >=Util.STAGE_COLS;
	}
	/**
	 * ���ص�Խ�緽�� 
	 */
	public boolean headBreak(){
		return this.headBreak(this.dir);
	}
	/**
	 * ��һ��
	 * 1.�ж��ߵ�ǰ�ķ�������̿��Ƶķ����Ƿ��෴
	 * 2.��¼�����µķ���
	 * 3.�����µĽڵ�
	 * 	   ��ǰ�ߵķ����뵱ǰ�ߵ�ͷ�ڵ�
	 *     newRows = this.rows +dir /10 ;
	 *     newCols = this.cols +dir %10 ;
	 * 4.�ж��Ƿ�Ե�ʳ��
	 *    4.1�Ե�ʳ���������
	 *    4.2û�Ե�ʳ��
	 * 5.ƽ�������Ԫ�أ��ﵽ��һ����Ч��
	 * 6.���½ڵ�ŵ�����ĵ�һ��λ��
	 * 7.�����Ƿ�Ե�ʳ��
	 */
	public boolean stepForEat(int dir,Food food){
		//1.
		if(this.dir +dir ==0){
			return false ;
		}
		//2.
		this.dir = dir;
		//3.
		Cell head = cells[0];
		//�����½ڵ���к��к�
		int newRows = head.getCell_rows() +dir /10;
		int newCols = head.getCell_cols() +dir %10;
		//4.
		boolean isEat = false ;
		if(newRows == food.getFood_rows() &&
				newCols == food.getFood_cols()){
			//�Ե�ʳ��
			isEat = true ;
			//��������
			
			cells=(Cell[]) Arrays.copyOf(cells, cells.length+1);
		}
		//5.
		for(int i = cells.length-1;i>=1;i--){
			cells[i] =cells[i-1];
		}
		//6.
		cells[0] = new Cell(newRows,newCols);
		//7.
		return isEat ;
	}
	/**
	 * �������ص���һ������
	 * ����Ϊ��Ĭ�ϵķ���
	 * ����
	 * @return
	 */
	public boolean stepForEat(Food food){
		return this.stepForEat(dir, food);
	}
	
	
	//	����get/set����
	public Cell[] getCells() {
		return cells;
	}

	public void setCells(Cell[] cells) {
		this.cells = cells;
	}
	public int getDir() {
		return dir;
	}
	public void setDir(int dir) {
		this.dir = dir;
	}
}
