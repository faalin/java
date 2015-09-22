package airplane;

import java.util.Random;

/**
 * �л�
 * ������  ����
 * �ƶ���ʽ:��������
 * @author windows
 *
 */
public class Airplane extends FlyingObject implements Enemy {
	/**����л��ƶ����ٶ�*/
	private int speed ;
	/**����л��ķ���*/
	private int score ;
	/**�������������*/
	Random random ;
	
	/**��ʼ���л�����Ĺ��췽��*/
	public Airplane(){
		//��ʼ�����������
		random = new Random();
		//��ʼ���л��ƶ����ٶ�
		speed = Util.AIRPLANE_SPEED ;
		score = random.nextInt(5)+1;
		//��ʼ���л���ͼƬ����
		imageIcon = Util.airplane;
		//��ʼ���л�ͼƬ�Ŀ���
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//��ʼ���л��볡��x��y����
		x = random.nextInt(Util.FRAME_WIDTH-width);
		y = -height ;
		//y = 50;
	}
	@Override
	public boolean outOfBounds() {
		return y >Util.FRAME_HEIGHT;
	}

	/**�л���һ��*/
	public void step() {
		y+=speed ;
	}

	public int getScore() {
		return  score ;
	}
}
