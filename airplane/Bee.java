package airplane;

import java.util.Random;

/**
 * С�۷�
 * ������  ����
 * 
 * 
 *
 */
public class Bee extends FlyingObject implements Award {
	/**����x������ƶ��ٶ�*/
	private int xSpeed ;
	/**����y������ƶ��ٶ�*/
	private int ySpeed ;
	/**���影������*/
	private int awardType ;
	/**�������������*/
	Random random ;
	/**ͨ�����췽���ķ�ʽ��ʼ���۷����*/
	public Bee(){
		//��ʼ��Random����
		random = new Random();
		//��ʼ��xSpeed��ySpeed
		xSpeed = Util.BEE_XSPEED;
		ySpeed = Util.BEE_YSPEED;
		//��ʼ���۷��ͼƬ����
		imageIcon = Util.bee;
		//��ʼ���۷�ͼƬ�Ŀ���
		//Util.bee.getImage().getWidth(null);
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//��ʼ���۷��볡������x��y
		x = random.nextInt(Util.FRAME_WIDTH-width);
		y = -height;
		//y = 100;
		awardType = random.nextInt(Award.AWARD_COUNT);
	}
	@Override
	public boolean outOfBounds() {
		return y >Util.FRAME_HEIGHT;
	}

	/**�۷����һ��*/
	public void step() {
		x+= xSpeed ;
		y+= ySpeed ;
		//ײ���ұ� �����󷴵�
		if(x >=Util.FRAME_WIDTH-width){
			xSpeed =-2 ;
		}
		//ײ����ߣ����ҷ���
		if(x <=0){
			xSpeed = 2 ;
		}
	}

	public int getType() {
		// TODO Auto-generated method stub
		return awardType;
	}
	
}
