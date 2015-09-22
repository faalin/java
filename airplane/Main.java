package airplane;

import javax.swing.JFrame;

/**飞机大战的主程序*/
public class Main {
	public static void main(String [] args){
		//1.创建窗体对象
		JFrame frame = new JFrame("ShootGame");
		//2.设置窗体的大小
		frame.setSize(Util.FRAME_WIDTH,Util.FRAME_HEIGHT);
		//3.设置窗体永远在上
		frame.setAlwaysOnTop(true);
		//4.设置居中显示
		frame.setLocationRelativeTo(null);
		//5.设置默认的关闭操作
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//创建主面板对象
		MainPanel panel = new MainPanel();
		//组装：将panel添加到frame 中
		frame.add(panel);
		//6.显示窗体
		frame.setVisible(true);
		//启动主控制流程
		panel.action();
		
		
	}
}
