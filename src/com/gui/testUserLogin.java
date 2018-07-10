package com.gui;

import com.dataOperation.userInfoOperation;
import com.dateSafe.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class testUserLogin implements ActionListener{

	dateSafe safe = new dateSafe();
	userInfoOperation userinfo = new userInfoOperation();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	JButton button,button_1;
	JLabel lblNewLabel_2;
	JFrame frame1;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					testUserLogin window = new testUserLogin();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public testUserLogin() {
		initialize();
		
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame1 = new JFrame();
		frame1.getContentPane().setBackground(new Color(240, 248, 255));
		frame1.getContentPane().setLayout(null);
		Font font1=new Font("宋体",Font.PLAIN,30);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("/Users/mac/Documents/JavaGui/ManageFeeSystem/Image/5.jpg"));
		lblNewLabel.setBounds(0, 0, 461, 254);
		
		lblNewLabel_2 = new JLabel("请输入对应信息");
		lblNewLabel_2.setFont(new Font("幼圆", Font.BOLD, 18));
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setForeground(new Color(255, 215, 0));
		lblNewLabel_2.setBounds(139, 36, 223, 25);
		frame1.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("用户登陆");
		label.setForeground(Color.white);
		label.setBounds(161, 0, 300, 38);
		label.setFont(new Font("宋体", Font.BOLD, 30));
		frame1.getContentPane().add(label);;
		frame1.setBounds(100,100,513,341);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame1.setTitle("兆亿物业管理系统欢迎您！");
		frame1.setFont(font1);
		new Font("宋体",Font.PLAIN,20);
		frame1.setVisible(true);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		frame1.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label_1 = new JLabel("用户名：");
		label_1.setFont(new Font("宋体", Font.BOLD, 20));
		label_1.setForeground(Color.white);
		label_1.setBounds(117, 66, 85, 30);
		frame1.getContentPane().add(label_1);
		
		textField = new JTextField();
		textField.setBounds(214, 71, 171, 25);
		frame1.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("密码：");
		label_2.setFont(new Font("宋体", Font.BOLD, 20));
		label_2.setForeground(Color.white);
		label_2.setBounds(132, 141, 70, 23);
		frame1.getContentPane().add(label_2);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(214, 142, 171, 26);
		frame1.getContentPane().add(passwordField);
		
		JLabel label_3 = new JLabel("请再次确认密码：");
		label_3.setFont(new Font("宋体", Font.BOLD, 20));
		label_3.setForeground(Color.white);
		label_3.setBounds(25, 178, 171, 24);
		frame1.getContentPane().add(label_3);
		
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(214, 180, 171, 26);
		frame1.getContentPane().add(passwordField_1);
		
		button = new JButton("确认");		
		button.setBounds(85, 230, 117, 29);
		button.addActionListener(this);
		frame1.getContentPane().add(button);
		
		button_1 = new JButton("重置");
		button_1.setBounds(268, 230, 117, 29);
		button_1.addActionListener(this);
		frame1.getContentPane().add(button_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(214, 106, 171, 25);
		frame1.getContentPane().add(textField_1);
		
		JLabel label_4 = new JLabel("房间号：");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("宋体", Font.BOLD, 20));
		label_4.setBounds(117, 101, 85, 30);
		frame1.getContentPane().add(label_4);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\21.jpg"));
		lblNewLabel_1.setBounds(0, 0, 500, 302);
		frame1.getContentPane().add(lblNewLabel_1);
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == button) { //对登陆按钮监听
			String name;
			String Password;
			String SurePwd;
			String roomId;
			boolean flag = false;
			name = textField.getText();
			roomId = textField_1.getText();
			Password = passwordField.getText();
			SurePwd = passwordField_1.getText();
			//System.out.println(Password);
			//System.out.println(SurePwd);
			if(Password.equalsIgnoreCase(SurePwd)) { //如果两次输入密码相等
				Password = safe.TransferToAscii(Password);
				name = safe.TransferToAscii(name);
				try {
					flag = userinfo.findUserAndPwd(name, Password, roomId);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					lblNewLabel_2.setText("未知错误！");
				}
				if(flag == true) {
					UserIndex userIndex = new UserIndex(roomId);
					//userIndex.run();
					frame1.setVisible(false);
					lblNewLabel_2.setText("successful to login");
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
			textField_1.setText(null);
			passwordField.setText(null);
			passwordField_1.setText(null);
		}
	}
}
