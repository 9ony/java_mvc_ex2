package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Member;
import model.MemberDAO;
import view.BaseFrame;
import view.JoinPanel;
import view.LoginPanel;

public class JoinEvent implements ActionListener{
	private LoginPanel loginUi;
	private JoinPanel joinUi;
	private BaseFrame base;
	private Member member;
	private MemberDAO mdao = new MemberDAO();
	public JoinEvent(JoinPanel joinUi) {
		this.joinUi = joinUi;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o=e.getSource();
		if(o==joinUi.getBtn(0)) { //가입신청버튼
			submitbtn();
		}else if(o==joinUi.getBtn(1)) { //취소버튼
			returnbtn();
		}
	}
	public void submitbtn() {
		String id = joinUi.getTf(0);
		String pw = joinUi.getTf(1);
		String name = joinUi.getTf(2);
		String tel = joinUi.getTf(3);
		if(id.isEmpty()||pw.isEmpty()||name.trim().isEmpty()||tel.isEmpty()) {
			System.out.println("빠짐없이 입력해주세요");
		}else {
			if(tels(tel)[0]==null) {
				System.out.println("전화번호양식이 맞지않습니다.");
				return;
			}
			String tel1=tels(tel)[0];
			String tel2=tels(tel)[1];
			String tel3=tels(tel)[2];
			Member member = new Member(name,id,pw,tel1,tel2,tel3);
			int n = mdao.Memberinsert(member);
			if(n>0) {
				System.out.println("가입완료!");
			}else {
				System.out.println("가입실패!");
			}
		}
	}
	public void returnbtn() {
		ChangeView.setView("LoginPanel",400,600);
		
	}
	public String[] tels(String str) {
		String[] result = new String[3];
		if(str.length()==11) {
		result[0] = str.substring(0, 3);
		result[1] = str.substring(3, 7);
		result[2] = str.substring(7, 11);
		}else if(str.length()==12) {
			result[0] = str.substring(0, 3);
			result[1] = str.substring(3, 6);
			result[2] = str.substring(6, 10);
		}else {
			result[0]=null;
		}
		return result; 
	}
}

