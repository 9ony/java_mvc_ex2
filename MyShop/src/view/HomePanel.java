package view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HomePanel extends JPanel{
	private CardLayout card = new CardLayout();
	private JPanel menuP = new JPanel();
	private JPanel p = new JPanel();
	private JButton[] menubtn = new JButton[4];
	private JTextField[] loginjtf = new JTextField[2];
	private String[] menustr = {"상품목록","장바구니","회원수정","로그아웃"};
	private String user;
	private JLabel u_name;
	public HomePanel() {
		p.setLayout(card=new CardLayout());
		add(p,BorderLayout.CENTER);
		add(menuP, BorderLayout.NORTH);
		menuP.setLayout(new GridLayout(1,0));
		for(int i = 0 ; i < menubtn.length; i++) {
			menuP.add(menubtn[i] = new JButton(menustr[i]));
		}
		p.add(u_name = new JLabel(user));
		p.setBackground(Color.blue);
		menuP.setBackground(Color.cyan);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
