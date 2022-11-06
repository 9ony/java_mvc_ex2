package view;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import controller.LoginEvent;


public class LoginPanel extends JPanel {
	//init
	private JButton[] btn = new JButton[2];
	private JTextField idtf;
	private JPasswordField pwtf;
	private String btnl[] = { "로그인", "회원가입" };
	public LoginPanel(){
		loginLayout();
	}
	public void loginLayout() {
		setBackground(Color.yellow);
		setLayout(null);
		LoginEvent loginhandler = new LoginEvent(this);
		for (int i = 0; i < btn.length; i++) {
			btn[i] = new JButton(btnl[i]);
			add(btn[i]);
			btn[i].setBackground(Color.white);
			btn[i].setBounds(100 * (i + 1), 300, 100, 50);
			btn[i].addActionListener(loginhandler);
		}
		idtf = new JTextField();
		pwtf = new JPasswordField();
		add(idtf);
		add(pwtf);
		idtf.setBackground(Color.white);
		idtf.setBounds(100, 100, 200, 50);
		idtf.setBorder(new TitledBorder("아이디"));
		pwtf.setBackground(Color.white);
		pwtf.setBounds(100, 200, 200, 50);
		pwtf.setBorder(new TitledBorder("비밀번호"));
		
	}
	// getter, setter----------------------------------
	public JButton getBtn(int i) {
		return btn[i];
	}
	public String getidtf() {
		return idtf.getText();
	}
	public String getpwtf() {
		char[] pwd=pwtf.getPassword();
		return String.valueOf(pwd);
	}
}
