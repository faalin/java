package airplane;
/**
 * �ӵ���
 * ������
 * �˶���ʽ�� ���µ���
 */
public class Bullet extends FlyingObject{
	/**�����ӵ����ٶ�*/
	private int speed ;
	
	/**��ʼ���ӵ��Ĺ��췽��*/
	public Bullet(int x ,int y ){
		//��ʼ��x,y����
		this.x = x ;
		this.y = y ;
		//��ʼ���ӵ���ͼƬ����
		imageIcon = Util.bullet;
		//��ʼ���ӵ�ͼƬ�Ŀ� ��
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//��ʼ���ӵ����ٶ�
		speed = Util.BULLET_SPEED;	
	}
	@Override
	public boolean outOfBounds() {
		return  y < -height ;
	}

	/**�ӵ���һ���ķ���*/
	public void step() {
		y-=speed ;
	}

}
