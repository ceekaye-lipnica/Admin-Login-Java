package AdminLogin;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//Program by: Chelsea Kate M. Lipnica
//BSIT 2 - 1
//Activity 4 - 1

public class LoginSystem {

	public static void main(String[] args) {
		
		LoginForm form = new LoginForm();
	}

}

class LoginForm extends JFrame implements ActionListener {
	
	JLabel username, password, message, message2;
	JTextField tUser, tPass;
	JButton signin, cancel;
	int login = 3;
	
	public LoginForm() {
		super ("Sign-in");
		
		username = new JLabel("Username: ");
		password = new JLabel("Password: ");
		message = new JLabel("");
		message2 = new JLabel("");
		
		tUser = new JTextField(20);
		tPass = new JTextField(20);
		
		signin = new JButton("SIGN IN");
		cancel = new JButton("CANCEL");
		
		setLayout(new FlowLayout());
		setVisible(true);
		setSize(300,300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(username);
		add(tUser);
		add(password);
		add(tPass);
		add(signin);
		add(cancel);
		add(message);
		add(message2);
		
		signin.addActionListener(this);
		cancel.addActionListener(this);
	}
	
	
 	public void actionPerformed(ActionEvent ae) {
		
			String inputUsername = tUser.getText();
			String inputPassword = tPass.getText();
				
				if (ae.getSource() == cancel) {
					tUser.setText("");
					tPass.setText("");
					message.setText("");	
				}
				
				if (ae.getSource() == signin) {
					 
					while (login != 0) {
						
						if (inputUsername.equals("admin") && inputPassword.equals("123")) {
							message.setText("Welcome to your profile!");
						}
						else {
							
							tUser.setText("");
							tPass.setText("");
							message.setText("Invalid Username or Password");
							message2.setText("You have " + login-- + " attempts to login");
						}
						
						return;		
					}
						
				}
						
				if(login == 0){
					tUser.setEnabled(false);
					tPass.setEnabled(false);
					message.setText("Please contact the administrator");
					message2.setText("if you have problems signing-in in your account");
					JOptionPane.showMessageDialog(null, "ACCOUNT IS LOCKED", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
											
	}
	
}