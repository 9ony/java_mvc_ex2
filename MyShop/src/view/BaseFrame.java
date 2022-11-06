package view;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class BaseFrame extends JFrame{
	private static BaseFrame instance;
//	public BaseFrame() {
//		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
//	}
	public static BaseFrame getInstance() {
		if(instance == null) {
			synchronized(BaseFrame.class) {
				instance = new BaseFrame();
			}
		}
		return instance;
	}
}