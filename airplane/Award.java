package airplane;
/**
 * �����ӿ�
 * ������ʽ��˫������  ����
 */
public interface Award {
	/**
	 * �ӿ���ֻ�ܶ��峣�������󷽷�
	 * ����Ĭ��public static final ����
	 * ����Ĭ�� public abstract ����
	 */
	/**˫������*/
	public static final int DOUBLE_FIRE =0;
	/**����*/
	public static final int LIFE = 1 ;
	/**���影��������*/
	public static final int AWARD_COUNT = 2 ;
	
	/**��ȡ�������͵ķ���*/
	public abstract int getType(); 
	
}
