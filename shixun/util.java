package shixun;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class util {

	/**
	 * ̰������Ϸ���õ�����ֵ
	 * 
	 */
	//���ô��ڵĿ�
	public static final int FRAME_WIDTH = 450;
	//���ô���ĸ�
	public static final int FRAME_HIGH= 470;
	//�������Ŀ�
	public static final int STAGE_WIDTH = 400;
	//�������ĸ�
	public static final int STAGE_HIGH = 400;
	//������̨����x����
	public static final int STAGE_X = 17 ;
	//������̨����y����
	public static final int STAGE_Y = 15 ;
	//��̨��屳����ɫ
	//public static final Color STAGE_COLOR = new Color(54,207,211);
	public static final Color STAGE_COLOR = Color.cyan;
	
	
	//̰����ʳ���С����Ŀ�
	public static final int FOOD_WIDTH = 20 ;
	//̰����ʳ���С����ĸ�
	public static final int FOOD_HEIGHT = 20 ;
	//̰����ʳ��С�������ɫ
    public static final Color FOOD_COLOR = Color.red ;
    
    //�ߵ�Ԫ��Ŀ�
    public static final int CELL_WIDTH = 20;
    //�ߵ�Ԫ��ĸ�
    public static final int CELL_HEIGHT = 20;
    //���õ�Ԫ�����ɫ
    public static final Color CELL_COLOR = Color.blue;

	//������̨��������
    public static final int STAGE_ROWS = 20 ;
    //������̨��������
    public static final int STAGE_COLS = 20 ;
	//����̰���ߵ�����ͼƬ�ز�
    public static ImageIcon icon;
    public static ImageIcon head;
    public static ImageIcon body;
    public static ImageIcon tail;
    public static ImageIcon bg;
    public static ImageIcon[] foods ;
    //ͨ����̬��ķ�ʽ��ȡͼƬ��Դ
    static{
    	icon = new ImageIcon ("image/1.jpg");
    	head = new ImageIcon ("image/head.jpg");
    	body = new ImageIcon ("image/body.jpg");
    	tail = new ImageIcon ("image/tail.jpg");
    	bg = new ImageIcon ("image/bg.jpg");
    	foods = new ImageIcon[]{
    			new ImageIcon("image/2.jpg"),
    			new ImageIcon("image/3.jpg"),
    			new ImageIcon("image/4.jpg"),
    			new ImageIcon("image/5.jpg"),
    			new ImageIcon("image/6.jpg"),
    			new ImageIcon("image/7.jpg"),
    			
                   };

             }
}
