package shixun;

import java.awt.Color;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class tanchise {
     /**
	 * 贪吃蛇游戏
	 * @author Administrator
	 */
	public static void main(String[] args) {
		//创建窗体对象
        JFrame frame = new JFrame("贪吃蛇");
        //设置窗体的大小
        frame.setSize(util.FRAME_WIDTH, util.FRAME_HIGH);
//        //设置窗体图标
//        frame.setIconImage(icon.getImage());
        //设置窗体居中显示
        frame.setLocationRelativeTo(null);
        
        //创建背景面板
        JPanel backpanel = new JPanel();
        //设置背景面板的背景颜色
        backpanel.setBackground(Color.green);
        //设置背景面板的背景布局为null
        backpanel.setLayout(null);
        
        //创建蛇的舞台面板
        snakestage stage = new snakestage();
        //设置舞台面板的大小
        stage.setSize(util.STAGE_WIDTH, util.STAGE_HIGH );
        //设置舞台面板坐标
        stage.setLocation(util.STAGE_X ,util.STAGE_Y );
        //设置舞台背景颜色
        stage.setBackground(util.STAGE_COLOR);
        
        //添加背景面板
        backpanel.add(stage);
        //将背景面板添加到窗口上
        frame.add(backpanel);
        //显示窗口
        frame.setVisible(true);
        //监听事件
        stage.requestFocus();
       //监听按键
        frame.addKeyListener(stage);
        //设置窗口默认关闭程序
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //启动游戏的运行
        stage.go();
	}

}
