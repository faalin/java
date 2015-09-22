package Trainday08;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * ̰������Ϸ��������
 * 
 * javaSE  javaEE  javaME(Android)
 */
public class Main {
	public static void main(String [] args){
		//�����������
		JFrame frame = new JFrame("̰����");
		//���ô���Ĵ�С
		frame.setSize(Util.FRAME_WIDTH,Util.FRAME_HEIGHT);
		//���ô����ͼ��
		//ImageIcon
		ImageIcon icon = new ImageIcon("image/1.jpg");
		frame.setIconImage(icon.getImage());
		//���ô��������ʾ
		frame.setLocationRelativeTo(null);
		
		//�����������
		JPanel backPanel = new JPanel();
		//���ñ������ı�����ɫ 
		backPanel.setBackground(Color.GREEN	);
		//���ñ������Ĳ���Ϊnull
		backPanel.setLayout(null);
		//�����ߵ���̨���
		//JPanel stage = new JPanel();
		SnakeStage stage = new SnakeStage();
		//������̨���Ĵ�С
		stage.setSize(Util.STAGE_WIDTH,Util.STAGE_HEIGHT);
		//������̨����λ��
		stage.setLocation(Util.STAGE_X, Util.STAGE_Y);
		//��װ������̨�����ӵ����������
		backPanel.add(stage);
		//��װ�������������ӵ�������
		frame.add(backPanel);
		//��ʾ����
		frame.setVisible(true);
		//����Ĭ�ϵĹرղ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//��Ӽ����¼�
		stage.requestFocus();
		stage.addKeyListener(stage);
		//������Ϸ������
		stage.go();
	}
}
