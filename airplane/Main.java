package airplane;

import javax.swing.JFrame;

/**�ɻ���ս��������*/
public class Main {
	public static void main(String [] args){
		//1.�����������
		JFrame frame = new JFrame("ShootGame");
		//2.���ô���Ĵ�С
		frame.setSize(Util.FRAME_WIDTH,Util.FRAME_HEIGHT);
		//3.���ô�����Զ����
		frame.setAlwaysOnTop(true);
		//4.���þ�����ʾ
		frame.setLocationRelativeTo(null);
		//5.����Ĭ�ϵĹرղ���
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//������������
		MainPanel panel = new MainPanel();
		//��װ����panel��ӵ�frame ��
		frame.add(panel);
		//6.��ʾ����
		frame.setVisible(true);
		//��������������
		panel.action();
		
		
	}
}
