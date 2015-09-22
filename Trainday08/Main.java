package Trainday08;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * 贪吃蛇游戏的主窗体
 * 
 * javaSE  javaEE  javaME(Android)
 */
public class Main {
	public static void main(String [] args){
		//创建窗体对象
		JFrame frame = new JFrame("贪吃蛇");
		//设置窗体的大小
		frame.setSize(Util.FRAME_WIDTH,Util.FRAME_HEIGHT);
		//设置窗体的图标
		//ImageIcon
		ImageIcon icon = new ImageIcon("image/1.jpg");
		frame.setIconImage(icon.getImage());
		//设置窗体居中显示
		frame.setLocationRelativeTo(null);
		
		//创建背景面板
		JPanel backPanel = new JPanel();
		//设置背景面板的背景颜色 
		backPanel.setBackground(Color.GREEN	);
		//设置背景面板的布局为null
		backPanel.setLayout(null);
		//创建蛇的舞台面板
		//JPanel stage = new JPanel();
		SnakeStage stage = new SnakeStage();
		//设置舞台面板的大小
		stage.setSize(Util.STAGE_WIDTH,Util.STAGE_HEIGHT);
		//设置舞台面板的位置
		stage.setLocation(Util.STAGE_X, Util.STAGE_Y);
		//组装：将舞台面板添加到背景面板中
		backPanel.add(stage);
		//组装：将背景面板添加到窗体中
		frame.add(backPanel);
		//显示窗体
		frame.setVisible(true);
		//设置默认的关闭操作
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//添加监听事件
		stage.requestFocus();
		stage.addKeyListener(stage);
		//启动游戏的运行
		stage.go();
	}
}
