package com.gui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.event.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooesRole {

	private JFrame frame;
	//class UserLoginAction;
	//class AdminLoginAction;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooesRole window = new ChooesRole();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ChooesRole() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setLayout(new BorderLayout());
		frame.setBounds(100, 100, 600, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Font font1=new Font("宋体",Font.PLAIN,30);
		frame.setTitle("兆亿物业管理系统欢迎您！");
		frame.setFont(font1);
		Font font2=new Font("宋体",Font.PLAIN,20);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1,BorderLayout.CENTER);
		panel_1.setLayout(null);
		JLabel label_1 = new JLabel("请选择权限登陆:");
		label_1.setFont(font2);
		label_1.setBounds(99,310,171,60);
		panel_1.add(label_1);
		
		JButton button = new JButton("用户登陆");
		button.setBounds(300,280,150,50);
		button.setFont(font2);
		panel_1.add(button);
		UserLoginAction userAction = new UserLoginAction();
		button.addActionListener((ActionListener) userAction);
		
		JButton button_1 = new JButton("管理员登陆");
		button_1.setBounds(300,360,150,50);
		button_1.setFont(font2);
		panel_1.add(button_1);
		AdminLoginAction adminAction = new AdminLoginAction();
		button_1.addActionListener((ActionListener) adminAction);
		
		JPanel panel = new JPanel();
		panel.setBounds(59, 0, 506, 264);
		panel_1.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\1.jpeg"));
		lblNewLabel.setBounds(70, 54, 353, 210);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("欢迎来到兆亿物业管理系统");
	    label.setFont(font1);
	    label.setBounds(63, 6, 360, 68);
		panel.add(label);
		
		
		frame.setVisible(true);
		
	}
	private class UserLoginAction implements ActionListener{
		public UserLoginAction(){
		}
		public void actionPerformed(ActionEvent event){
			testUserLogin user = new testUserLogin();
			frame.setVisible(false);
		}
	}
	private class AdminLoginAction implements ActionListener{
		public AdminLoginAction(){
			
		}
		public void actionPerformed(ActionEvent event){
			testAdminLogin admin = new testAdminLogin();
			frame.setVisible(false);
		}
	}
}
