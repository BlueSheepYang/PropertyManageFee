package com.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;

import com.dataOperation.adminOperation;

import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

public class testAdminLogin implements ActionListener {

	adminOperation admin = new adminOperation();
	JFrame frame,frame1;
	JTextField textField;
	JPasswordField passwordField;
	JPasswordField passwordField_1;
	JButton button,button_1;
	JLabel lblNewLabel_2;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public testAdminLogin() {
		initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(240, 248, 255));
		frame1.getContentPane().setLayout(null);
		Font font1=new Font("瀹嬩綋",Font.PLAIN,30);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/mac/Documents/JavaGui/ManageFeeSystem/Image/5.jpg"));
		lblNewLabel.setBounds(0, 0, 461, 254);
		
		JLabel label = new JLabel("管理员登陆");
		label.setForeground(Color.WHITE);
		label.setBounds(116, 0, 300, 38);
		label.setFont(new Font("Dialog", Font.BOLD, 30));
		frame1.getContentPane().add(label);;
		frame1.setBounds(100,100,467,282);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("兆亿物业欢迎您");
		frame1.setFont(font1);
		Font font2=new Font("瀹嬩綋",Font.PLAIN,20);
		frame1.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame1.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("Dialog", Font.BOLD, 20));
		label_1.setForeground(Color.BLACK);
		label_1.setBounds(33, 63, 85, 30);
		frame1.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("Dialog", Font.BOLD, 20));
		label_2.setForeground(Color.BLACK);
		label_2.setBounds(33, 107, 70, 23);
		frame1.getContentPane().add(label_2);
		
		textField = new JTextField();
		textField.setBounds(191, 68, 163, 26);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(191, 108, 163, 26);
		frame1.getContentPane().add(passwordField);
		
		JLabel label_3 = new JLabel("再次确认密码：");
		label_3.setFont(new Font("Dialog", Font.BOLD, 20));
		label_3.setForeground(Color.BLACK);
		label_3.setBounds(33, 147, 163, 24);
		frame1.getContentPane().add(label_3);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(191, 145, 163, 26);
		frame1.getContentPane().add(passwordField_1);
		
		button = new JButton("确认");		
		button.addActionListener((ActionListener) this);
		button.setBounds(85, 195, 117, 29);
		frame1.getContentPane().add(button);
		
		button_1 = new JButton("重置");
		button_1.setBounds(263, 195, 117, 29);
		button_1.addActionListener(this);
		frame1.getContentPane().add(button_1);
		
		lblNewLabel_2 = new JLabel();
		lblNewLabel_2.setBounds(126, 35, 170, 23);
		frame1.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\51.jpg"));
		lblNewLabel_1.setBounds(0, 0, 451, 243);
		frame1.getContentPane().add(lblNewLabel_1);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) { //对登陆按钮监听
			String name;
			String Password;
			String SurePwd;
			boolean flag = false;
			name = textField.getText();
			Password = passwordField.getText();
			SurePwd = passwordField_1.getText();
			if(Password.equalsIgnoreCase(SurePwd)) { //如果两次输入密码相等
				try {
					flag = admin.findUserAndPwd(name, Password);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(flag == true) {
					AdminIndex admin = new AdminIndex(name);
					//userIndex.run();
					frame1.setVisible(false);
				}
				else{
					lblNewLabel_2.setText("falied to login");
				}
			}
			else {//input different password
				lblNewLabel_2.setText("请确保密码和确认密码相同");
			}
			
		}
		else if(e.getSource() == button_1) { //reset button，initialize information
			textField.setText(null);
			passwordField.setText(null);
			passwordField_1.setText(null);
		}
	}
}
