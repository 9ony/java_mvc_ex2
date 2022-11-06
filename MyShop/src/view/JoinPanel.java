package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.JoinEvent;

public class JoinPanel extends JPanel{
	JButton btn[] = new JButton[2];
	String btnl[] = { "가입신청", "취소" };
	JTextField jtf[] = new JTextField[4];
	String tfl[] = { "아이디", "비밀번호", "이름", "전화번호"};
	public JoinPanel() {
		joinLayout();
	}
	public void joinLayout() {
		setLayout(null);
		setBackground(Color.cyan);
		JoinEvent joinhandler = new JoinEvent(this);
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btnl[i]);
			add(btn[i]);
			btn[i].setBackground(Color.white);
			btn[i].setBounds(100 * (i + 1), 500, 100, 50);
			btn[i].addActionListener(joinhandler);
		}
		for (int i = 0; i < jtf.length; i++) {
			if(i==1) {
				jtf[i] = new JPasswordField();
				add(jtf[i]);
				jtf[i].setBackground(Color.white);
				jtf[i].setBounds(100, 80 * (i + 1), 200, 50);
				jtf[i].setBorder(new TitledBorder(tfl[i]));
			}
			else {
			jtf[i] = new JTextField();
			add(jtf[i]);
			jtf[i].setBackground(Color.white);
			jtf[i].setBounds(100, 80 * (i + 1), 200, 50);
			jtf[i].setBorder(new TitledBorder(tfl[i]));
			}
		}
	}
	//-------getter,setter
	public String getTf(int i) {
		return jtf[i].getText();
	}
	public JButton getBtn(int i) {
		return btn[i];
	}
}