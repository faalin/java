package shixun;

import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tanchise {
     /**
	 * ̰������Ϸ
	 * @author Administrator
	 */
	public static void main(String[] args) {
		//�����������
        JFrame frame = new JFrame("̰����");
        //���ô���Ĵ�С
        frame.setSize(util.FRAME_WIDTH, util.FRAME_HIGH);
//        //���ô���ͼ��
//        frame.setIconImage(icon.getImage());
        //���ô��������ʾ
        frame.setLocationRelativeTo(null);
        
        //�����������
        JPanel backpanel = new JPanel();
        //���ñ������ı�����ɫ
        backpanel.setBackground(Color.green);
        //���ñ������ı�������Ϊnull
        backpanel.setLayout(null);
        
        //�����ߵ���̨���
        snakestage stage = new snakestage();
        //������̨���Ĵ�С
        stage.setSize(util.STAGE_WIDTH, util.STAGE_HIGH );
        //������̨�������
        stage.setLocation(util.STAGE_X ,util.STAGE_Y );
        //������̨������ɫ
        stage.setBackground(util.STAGE_COLOR);
        
        //��ӱ������
        backpanel.add(stage);
        //�����������ӵ�������
        frame.add(backpanel);
        //��ʾ����
        frame.setVisible(true);
        //�����¼�
        stage.requestFocus();
       //��������
        frame.addKeyListener(stage);
        //���ô���Ĭ�Ϲرճ���
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //������Ϸ������
        stage.go();
	}

}
