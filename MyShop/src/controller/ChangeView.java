package controller;

import javax.swing.JPanel;

import view.BaseFrame;
import view.HomePanel;
import view.JoinPanel;
import view.LoginPanel;
//인풋 패널명,프레임크기
public class ChangeView {
	private static ChangeView View;
	public static ChangeView setView(String s,int x, int y) {
		BaseFrame bf = BaseFrame.getInstance();
		JPanel p = null;
		bf.getContentPane().removeAll();
		if(s.equals("HomePanel")){
			p= new HomePanel();
		}else if(s.equals("JoinPanel")) {
			p= new JoinPanel();
		}else if(s.equals("LoginPanel")) {
			p= new LoginPanel();
		}else System.out.println("일치하는 패널이 없습니다");;
		bf.setSize(x,y);
		bf.setLocation(400,100);
		bf.setContentPane(p);
		bf.setVisible(true);
		bf.revalidate();
		bf.repaint();
		bf.setDefaultCloseOperation(bf.EXIT_ON_CLOSE);
		if(View == null) {
			synchronized(ChangeView.class) {
				View = new ChangeView();
			}
		}
		return View;
	}
}
