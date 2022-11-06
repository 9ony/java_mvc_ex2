package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginPanel;


public class LoginEvent implements ActionListener{
	private LoginPanel loginPanel;
	public LoginEvent(LoginPanel loginPanel) {
		this.loginPanel=loginPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==loginPanel.getBtn(0)) { //로그인버튼
			String user = loginPanel.getidtf();
			System.out.println(user);
			ChangeView.setView("HomePanel",1000,600); 
		}
		else if(o==loginPanel.getBtn(1)) { //회원가입버튼
			ChangeView.setView("JoinPanel",400,600); 
		}
	}
}
