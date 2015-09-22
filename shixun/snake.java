package shixun;

import java.util.Arrays;

/**
 * 贪吃蛇的蛇类
 */
public class snake {
	//linkedlist
	/**蛇：定义保存蛇节点的数组*/
	private cell [] cells ;
	//定义蛇的四个方向
	public static final int UP = -10;
	public static final int DOWN = 10;
	public static final int LEFT = -1;
	public static final int RIGHT = 1;
	//定义蛇的当前的方向
	private int dir;
	//通过构造方法的方式初始化数组
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
		//蛇的默认方向
		dir = LEFT;
	}
	/**定义判断新节点是否在蛇的身上*/
	public boolean contains(int newRows,int newCols){
		for(int i = 0 ;i <cells.length;i++){
			//取出一个节点
			cell current = cells[i];
			if(newRows ==current.getCell_rows() &&
					newCols ==current.getCell_cols()){
				return true ;
			}
		}
		return false ;
	}
	
	/*
	 * 越界操作
	 * 1.判断蛇的当前方向与键盘控制方向是否相同
	 * 2.计算新节点
	 * 3.rows《0||rows>0||cols<0||cols>20
	 * 4.将结果返回
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
    	  * 重载的越界方法
    	  */
     public boolean headBreak(){
    		return this.headBreak(this.dir);
    	}		 
    	 
    

	/**
	 * 走一步
	 * 1.判断蛇当前的方向与键盘控制的方向时候一致
	 * 2.记录蛇的最新方向
	 * 3.计算新的节点
	 *    当前蛇的方向与当前蛇的头节点
	 * 4，判断是否吃掉食物
	 * 4.1吃掉食物：扩容数组
	 * 4.2没吃掉食物
	 * 5.平移数组的元素，达到走一步的效果
	 * 6.把新的节点放到数组的第一个位置
	 * 7.返回是否吃掉食物
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
		//设置新的节点行号和列号
		int newRows = head.getCell_rows() + dir /10;
		int newCols = head.getCell_cols() + dir %10;
		//4.
		boolean isEat = false ;
		if(newRows  == food.getFood_rows()&&
				newCols == food.getFood_cols()){
			//吃掉食物
			isEat = true ;
			//扩容数组
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
	 * 定义重载的走一步方法
	 * 方向为蛇默认的方向
	 * 冗余
	 * 
	 */
	public boolean stepForEat(food food){
		return this.stepForEat(dir,food);
	}
	// 公开get/set方法	
	public cell[] getCells() {
		return cells;
	}
	public void setCells(cell[] cells) {
		this.cells = cells;
	}
	
}


