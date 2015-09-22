package airplane;
/**
 * 奖励接口
 * 奖励形式：双倍火力  增命
 */
public interface Award {
	/**
	 * 接口中只能定义常量跟抽象方法
	 * 常量默认public static final 修饰
	 * 方法默认 public abstract 修饰
	 */
	/**双倍火力*/
	public static final int DOUBLE_FIRE =0;
	/**增命*/
	public static final int LIFE = 1 ;
	/**定义奖励的种类*/
	public static final int AWARD_COUNT = 2 ;
	
	/**获取奖励类型的方法*/
	public abstract int getType(); 
	
}
