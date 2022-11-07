package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.MemberDAO;
import view.LoginPanel;


public class LoginEvent implements ActionListener{
	private LoginPanel loginPanel;
	private MemberDAO mdao = new MemberDAO();
	public LoginEvent(LoginPanel loginPanel) {
		this.loginPanel=loginPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==loginPanel.getBtn(0)) { //로그인버튼
			String id = loginPanel.getidtf();
			String pwd = loginPanel.getpwtf();
			System.out.println(id);
			System.out.println(pwd);
			if(mdao.MemberCheck(id,pwd)) {
			ChangeView.setView("HomePanel",1000,600); 
			}
		}
		else if(o==loginPanel.getBtn(1)) { //회원가입버튼
			ChangeView.setView("JoinPanel",400,600); 
		}
	}
}
