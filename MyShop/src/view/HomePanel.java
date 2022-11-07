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
	private JPanel menuP = new JPanel();
	private JPanel p = new JPanel();
	private JPanel productP = new JPanel();
	private JPanel orderP = new JPanel();	
	private JButton[] menubtn = new JButton[4];
	private JTextField[] loginjtf = new JTextField[2];
	private String[] menustr = {"상품목록","장바구니","회원수정","로그아웃"};
	private String user;
	private JLabel u_name;
	public HomePanel() {
		add(p,BorderLayout.SOUTH);
		add(menuP, BorderLayout.NORTH);
		menuP.setLayout(new GridLayout(1,0));
		for(int i = 0 ; i < menubtn.length; i++) {
			menuP.add(menubtn[i] = new JButton(menustr[i]));
		}
		productP.setBounds(0,0, 600, 600);
		orderP.setBounds(600,0, 400, 600);
		productP.setBackground(Color.yellow);
		orderP.setBackground(Color.red);
		menuP.setBackground(Color.cyan);
		p.add(productP);
		p.add(orderP);
		p.setVisible(true);
		productP.setVisible(true);
		orderP.setVisible(true);
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	
}
