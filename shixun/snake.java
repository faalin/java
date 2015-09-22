package shixun;

import java.util.Arrays;

/**
 * ̰���ߵ�����
 */
public class snake {
	//linkedlist
	/**�ߣ����屣���߽ڵ������*/
	private cell [] cells ;
	//�����ߵ��ĸ�����
	public static final int UP = -10;
	public static final int DOWN = 10;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	//�����ߵĵ�ǰ�ķ���
	private int dir;
	//ͨ�����췽���ķ�ʽ��ʼ������
	public snake(){
		cells = new cell[]{
				new cell(5,6),
				new cell(5,7),
				new cell(5,8),
				new cell(6,8),
				new cell(7,8),
				new cell(7,9),
				new cell(7,10)
		};
		//�ߵ�Ĭ�Ϸ���
		dir = LEFT;
	}
	/**�����ж��½ڵ��Ƿ����ߵ�����*/
	public boolean contains(int newRows,int newCols){
		for(int i = 0 ;i <cells.length;i++){
			//ȡ��һ���ڵ�
			cell current = cells[i];
			if(newRows ==current.getCell_rows() &&
					newCols ==current.getCell_cols()){
				return true ;
			}
		}
		return false ;
	}
	
	/*
	 * Խ�����
	 * 1.�ж��ߵĵ�ǰ��������̿��Ʒ����Ƿ���ͬ
	 * 2.�����½ڵ�
	 * 3.rows��0||rows>0||cols<0||cols>20
	 * 4.���������
	 * 
	 */
     public boolean headBreak(int dir){
    	 //1.
    	 if(this.dir+dir ==0){
    		 return false;
    	 }
    	 //2.
    	 cell head = cells[0];
    	 int newRows = head.getCell_rows()+dir/10;
    	 int newCols = head.getCell_cols()+dir%10;
    	 return contains(newRows,newCols)||newRows<0
    			 ||newRows>=util.STAGE_ROWS||newCols<0||
    			 newCols>=util.STAGE_COLS;
     }
    	 /*
    	  * ���ص�Խ�緽��
    	  */
     public boolean headBreak(){
    		return this.headBreak(this.dir);
    	}		 
    	 
    

	/**
	 * ��һ��
	 * 1.�ж��ߵ�ǰ�ķ�������̿��Ƶķ���ʱ��һ��
	 * 2.��¼�ߵ����·���
	 * 3.�����µĽڵ�
	 *    ��ǰ�ߵķ����뵱ǰ�ߵ�ͷ�ڵ�
	 * 4���ж��Ƿ�Ե�ʳ��
	 * 4.1�Ե�ʳ���������
	 * 4.2û�Ե�ʳ��
	 * 5.ƽ�������Ԫ�أ��ﵽ��һ����Ч��
	 * 6.���µĽڵ�ŵ�����ĵ�һ��λ��
	 * 7.�����Ƿ�Ե�ʳ��
	 */
	public boolean stepForEat(int dir,food food){
		//1.
		if(this.dir +dir ==0){
			return false;
		}
		//2.
		this.dir = dir;
		//3.
		cell head = cells[0];
		//�����µĽڵ��кź��к�
		int newRows = head.getCell_rows() + dir /10;
		int newCols = head.getCell_cols() + dir %10;
		//4.
		boolean isEat = false ;
		if(newRows  == food.getFood_rows()&&
				newCols == food.getFood_cols()){
			//�Ե�ʳ��
			isEat = true ;
			//��������
			cells=Arrays.copyOf(cells,cells.length+1);
		}
		//5.
		for(int i = cells.length-1;i>=1;i--){
			cells[i]=cells[i-1];
		}
		//6.
		cells[0] = new cell(newRows,newCols);
		//7.
		return isEat;
		}
	/**
	 * �������ص���һ������
	 * ����Ϊ��Ĭ�ϵķ���
	 * ����
	 * 
	 */
	public boolean stepForEat(food food){
		return this.stepForEat(dir,food);
	}
	// ����get/set����	
	public cell[] getCells() {
		return cells;
	}
	public void setCells(cell[] cells) {
		this.cells = cells;
	}
	
}


