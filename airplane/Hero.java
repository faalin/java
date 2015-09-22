package airplane;

import javax.swing.ImageIcon;

/**
 * Ӣ�ۻ�
 * ������
 * �ƶ���ʽ���������
 */
public class Hero extends FlyingObject{
	/**���屣��Ӣ�ۻ�ͼƬ������*/
	private ImageIcon [] images ;
	/**�����л�ͼƬ�ļ����±�*/
	private int index ;
	/**����Ӣ�ۻ�˫���������ӵ���*/
	private int doubleFire ;
	/**����Ӣ�ۻ���������*/
	private int life ;
	
	/**��ʼ��Ӣ�ۻ��Ĺ��췽��*/
	public Hero(){
		//��ʼ������Ӣ�ۻ�ͼƬ������
		images = new ImageIcon[]{Util.hero1,Util.hero2};
		//��ʼ��Ӣ�ۻ���ͼƬ����
		imageIcon = Util.hero1;
		//��ʼ��Ӣ�ۻ�ͼƬ�Ŀ� ��
		width = imageIcon.getIconWidth();
		height = imageIcon.getIconHeight();
		//��ʼ��Ӣ�ۻ���ʼλ�õ�x��y����
		x = Util.HERO_X ;
		y = Util.HERO_Y ;
		//��ʼ��Ӣ�ۻ���������
		life = Util.INIT_LIFE;
		//��ʼ��Ӣ�ۻ�˫�������ӵ���
		doubleFire = 0;
		//��ʼ�������±�
		index = 0 ;
		
	}
	/**Ӣ�ۻ�����*/
	public void subLife(){
		life -- ;
	}
	/**Ӣ�ۻ�����������ײ���*/
	public boolean hit(FlyingObject fo){
		//��ȡ�л�������
		int fo_X = fo.getX();
		int fo_Y = fo.getY();
		int x1 = fo_X -this.width/2;
		int x2 = fo_X +fo.getWidth()+this.getWidth()/2;
		int y1 = fo_Y -this.height/2;
		int y2 = fo_Y +fo.getHeight() +this.getHeight()/2;
		
		int x3 = this.x +width/2;
		int y3 = this.y +height/2;
		
		return x3 >x1 && x3 <x2 && 
			y3>y1 && y3 <y2 ;
		
	}
	/**Ӣ�ۻ������ӵ�*/
	public Bullet[] shoot(){
		//���ɻ�ͼƬxƽ���ֳ�4��
		int newWidth = width/4;
		//���ɻ�ͼƬyƽ���ֳ�3��
		int newHeight = height/3;
		//����һ������
		Bullet [] bullets ;
		//�ж��Ƿ���˫������
		if(doubleFire >0){
			bullets = new Bullet[2];
			bullets[0] = new Bullet(x+newWidth-10,y+height/3);
			bullets[1] = new Bullet(x+3*newWidth+5,y+height/3);
			doubleFire -= 2;
			return bullets ;
		}
		bullets = new Bullet[1];
		bullets[0] = new Bullet(x+2*newWidth,y);
		return bullets ;
	}
	/**Ӣ�ۻ�����*/
	public void addLife(){
		life ++ ;
	}
	
	/**Ӣ�ۻ���������ƶ�*/
	public void moveTo(int x ,int y){
		this.x = x - this.width/2;
		this.y = y - this.height/2;
	}
	
	public boolean outOfBounds() {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Ӣ�ۻ����������ƶ�����
	 * 
	 *  û���Լ��ض����˶��켣
	 *	�˴��ɽ���ʾ��һ���ķ�������
	 *  �л�ͼƬ�ķ���
	 */
	public void step() {
		imageIcon = images[index++/10%images.length];
	}
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	public int getDoubleFire() {
		return doubleFire;
	}
	public void setDoubleFire(int doubleFire) {
		this.doubleFire = doubleFire;
	}
	
}
