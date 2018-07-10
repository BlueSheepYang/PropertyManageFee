package com.gui;
//import Model.testDate;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Component;
import javax.swing.Box;
import java.awt.TextField;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JSlider;

import com.dataOperation.*;
import com.dateModel.residentInfo;
import com.dateModel.systemInfo;
import com.dateSafe.InputSafe;
import com.system.maintainCredit;
import com.dateModel.creditInfo;
import com.dateModel.paymentListInfo;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class UserIndex implements ActionListener{
	systemOperation system = new systemOperation();
	creditInfoOperation credit = new creditInfoOperation();
	userInfoOperation user = new userInfoOperation();
	private JFrame frame;
	private JTable table;
	userInfoOperation currentUser= new userInfoOperation();
	InputSafe inputStr = new InputSafe();
	String RoomId;
	public UserIndex(String currentRoomId) {
		this.RoomId = currentRoomId;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JLabel lblNewLabel_6;
	JButton button,button_2,button_3,button_4,button_5,button_6,button_7,button_12,previousItems,nextItems;
	JPanel panel_3,panel_6;
	JPanel cardPanelFather; //第一个菜单项卡片布局
	CardLayout Cardpanel;  //card layout , distribute panel
	JScrollPane scrollPane;
	private JTextField nameLabel;
	private JTextField beforePasswordLabel;
	private JTextField newPasswordLabel;
	private JTextField definePasswordLabel;
	private JTextField phoneNumberLabel;
	private JTextField emilLabel;
	private JTextField roomIdLabel;
	private JTextField debtLabel;
	private JTextField creditScoreLabel;
	JButton button_8,button_9,button_10,button_11;
	private JTextField textField_11;
	private JTextField textField_10;
	private JTextField creditScore;
	private JTextField creditStage;
	private JTextField creditStatus;
	private JTextField creditRank;
	private JTextField creditDeclineTime;
	private JTable table_1;
	private JPanel panel_7;
	private JTextField textField;
	private JLabel lblNewLabel_9;
	private JLabel PayWarning = new JLabel("");
	private JLabel maxPay = new JLabel("");
	private JPanel panel_8;
	Vector columnNames = new Vector();
	Vector rowData = new Vector();
	private JLabel lblv;
	private JTextField textField_1;
	private JLabel lblNewLabel_3;
	private void initialize() {
		residentInfo user = new residentInfo();
		try {
			user = currentUser.findRoomId(RoomId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //通过查询房间号返回该user对象
		Font font1=new Font("宋体",Font.PLAIN,30);
		Font font2=new Font("仿宋",Font.PLAIN,15);

		frame = new JFrame();
		frame.setTitle("兆亿物业管理系统欢迎您");
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 6, 794, 80);
		frame.getContentPane().add(panel);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\11.jpg"));
		lblNewLabel.setBounds(6, 16, 73, 52);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("ZHAOYI Property Management Center");
		lblNewLabel_2.setBounds(91, 52, 247, 16);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("兆亿物业管理中心");
		lblNewLabel_1.setBounds(91, 0, 241, 62);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(font1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(192, 192, 192), null, null, null));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 86, 130, 90);
		frame.getContentPane().add(panel_1);
		
		JLabel label = new JLabel("   住户功能");
		label.setBounds(0, 22, 120, 43);
		label.setFont(new Font("仿宋", Font.BOLD, 16));
		panel_1.add(label);
		
		lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\13.jpg"));
		lblNewLabel_3.setBounds(0, 0, 130, 90);
		panel_1.add(lblNewLabel_3);
		
		button_8 = new JButton("基本信息浏览维护");
		button_8.setFont(new Font("宋体", Font.PLAIN, 11));
		button_8.setBounds(0, 197, 130, 41);
		button_8.addActionListener(this);
		frame.getContentPane().add(button_8);
		
		button_9 = new JButton("查询当前欠费情况");
		button_9.setFont(new Font("宋体", Font.PLAIN, 11));
		button_9.addActionListener(this);
		button_9.setBounds(0, 251, 130, 41);
		frame.getContentPane().add(button_9);
		
	   button_10 = new JButton("查看当前信用状态");
		button_10.setFont(new Font("宋体", Font.PLAIN, 11));
		button_10.addActionListener(this);
		button_10.setBounds(0, 306, 130, 41);
		frame.getContentPane().add(button_10);
		
		button_11 = new JButton("缴费");
		button_11.setFont(new Font("宋体", Font.PLAIN, 12));
		button_11.addActionListener(this);
		button_11.setBounds(0, 364, 130, 41);
		frame.getContentPane().add(button_11);
		
		
		Cardpanel = new CardLayout();
		
		cardPanelFather = new JPanel(Cardpanel);
		//cardPanelFather.setLayout(null);   ///这里不能再设置null布局，因为上面已经指定CardLayout 布局
		cardPanelFather.setBounds(130, 86, 654, 453);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		cardPanelFather.add(panel_5, "name_1604038175568987");
		
		lblNewLabel_6 = new JLabel("New label");
		lblNewLabel_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view22.jpg"));
		lblNewLabel_6.setBounds(105, 10, 461, 305);
		panel_5.add(lblNewLabel_6);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(72, 333, 514, 10);
		panel_5.add(horizontalStrut);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		horizontalStrut_1.setBounds(72, 430, 514, 13);
		panel_5.add(horizontalStrut_1);
		
		button_2 = new JButton("New button");
		button_2.addActionListener(this);
		button_2.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view2.jpg"));
		button_2.setBounds(201, 353, 80, 80);
		panel_5.add(button_2);
		
		button_3 = new JButton("New button");
		button_3.addActionListener(this);
		button_3.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view3.jpg"));
		button_3.setBounds(300, 353, 80, 80);
		panel_5.add(button_3);
		
		button_4 = new JButton("New button");
		button_4.addActionListener(this);
		button_4.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view4.jpg"));
		button_4.setBounds(401, 353, 80, 80);
		panel_5.add(button_4);
		
		button_5 = new JButton("New button");
		button_5.addActionListener(this);
		button_5.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view5.jpg"));
		button_5.setBounds(506, 353, 80, 80);
		panel_5.add(button_5);
		
		button_6 = new JButton("New button");
		button_6.addActionListener(this);
		button_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view1.jpg"));
		button_6.setBounds(95, 353, 80, 80);
		panel_5.add(button_6);
		
		//用户基本信息修改
		panel_3 = new JPanel();
		panel_3.setLayout(null);	
		panel_3.setBounds(0, 0, 664, 374);
		cardPanelFather.add(panel_3,"2");
		
		JLabel lblNewLabel_4 = new JLabel("姓名：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 14));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(51, 48, 78, 21);
		panel_3.add(lblNewLabel_4);
		
		nameLabel = new JTextField();
		nameLabel.setBounds(139, 43, 135, 32);
		panel_3.add(nameLabel);
		nameLabel.setColumns(10);
		
		beforePasswordLabel = new JTextField();
		beforePasswordLabel.setEditable(false);
		beforePasswordLabel.setBounds(139, 111, 135, 32);
		panel_3.add(beforePasswordLabel);
		beforePasswordLabel.setColumns(10);
		
		JLabel label_1 = new JLabel("修改密码：");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("宋体", Font.PLAIN, 14));
		label_1.setBounds(51, 179, 78, 21);
		panel_3.add(label_1);
		
		newPasswordLabel = new JTextField();
		newPasswordLabel.setColumns(10);
		newPasswordLabel.setBounds(139, 174, 135, 32);
		panel_3.add(newPasswordLabel);
		
		definePasswordLabel = new JTextField();
		definePasswordLabel.setColumns(10);
		definePasswordLabel.setBounds(139, 241, 135, 32);
		panel_3.add(definePasswordLabel);
		
		JLabel label_2 = new JLabel("当前密码：");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("宋体", Font.PLAIN, 14));
		label_2.setBounds(51, 119, 78, 21);
		panel_3.add(label_2);
		
		JLabel label_3 = new JLabel("确认密码：");
		label_3.setHorizontalAlignment(SwingConstants.RIGHT);
		label_3.setFont(new Font("宋体", Font.PLAIN, 14));
		label_3.setBounds(51, 249, 78, 21);
		panel_3.add(label_3);
		
		phoneNumberLabel = new JTextField();
		phoneNumberLabel.setColumns(10);
		phoneNumberLabel.setBounds(139, 310, 135, 32);
		panel_3.add(phoneNumberLabel);
		
		JLabel label_4 = new JLabel("手机号：");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setFont(new Font("宋体", Font.PLAIN, 14));
		label_4.setBounds(51, 318, 78, 21);
		panel_3.add(label_4);
		
		JLabel label_5 = new JLabel("邮箱：");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setFont(new Font("宋体", Font.PLAIN, 14));
		label_5.setBounds(372, 252, 78, 21);
		panel_3.add(label_5);
		
		emilLabel = new JTextField();
		emilLabel.setColumns(10);
		emilLabel.setBounds(460, 241, 135, 32);
		panel_3.add(emilLabel);
		
		roomIdLabel = new JTextField();
		roomIdLabel.setEditable(false);
		roomIdLabel.setColumns(10);
		roomIdLabel.setBounds(460, 43, 135, 32);
		panel_3.add(roomIdLabel);
		
		JLabel label_6 = new JLabel("房间号：");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setFont(new Font("宋体", Font.PLAIN, 14));
		label_6.setBounds(360, 48, 78, 21);
		panel_3.add(label_6);
		
		debtLabel = new JTextField();
		debtLabel.setEditable(false);
		debtLabel.setColumns(10);
		debtLabel.setBounds(460, 111, 135, 32);
		panel_3.add(debtLabel);
		
		JLabel label_7 = new JLabel("欠费金额：");
		label_7.setHorizontalAlignment(SwingConstants.RIGHT);
		label_7.setFont(new Font("宋体", Font.PLAIN, 14));
		label_7.setBounds(360, 119, 78, 21);
		panel_3.add(label_7);
		
		creditScoreLabel = new JTextField();
		creditScoreLabel.setEditable(false);
		creditScoreLabel.setColumns(10);
		creditScoreLabel.setBounds(460, 179, 135, 32);
		panel_3.add(creditScoreLabel);
		
		JLabel label_8 = new JLabel("信用积分：");
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setFont(new Font("宋体", Font.PLAIN, 14));
		label_8.setBounds(360, 182, 78, 21);
		panel_3.add(label_8);
		
		button = new JButton("确认");
		button.addActionListener(this);
		button.setBounds(181, 386, 93, 23);
		panel_3.add(button);
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(401, 386, 93, 23);
		panel_3.add(button_1);
		frame.getContentPane().add(cardPanelFather);
		frame.getContentPane().add(cardPanelFather);
		frame.getContentPane().add(cardPanelFather);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);	
		cardPanelFather.add(panel_4, "name_489788865146864");
		
		JLabel label_18 = new JLabel("欠费总金额：");
		label_18.setFont(new Font("宋体", Font.BOLD, 20));
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setBackground(Color.ORANGE);
		label_18.setForeground(Color.BLACK);
		label_18.setBounds(164, 89, 130, 38);
		panel_4.add(label_18);
		
		JLabel label_10 = new JLabel("最早欠费时间：");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setForeground(Color.BLACK);
		label_10.setFont(new Font("宋体", Font.BOLD, 20));
		label_10.setBackground(Color.ORANGE);
		label_10.setBounds(138, 223, 156, 38);
		panel_4.add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setBackground(Color.WHITE);
		textField_11.setBounds(337, 89, 161, 38);
		panel_4.add(textField_11);
		textField_11.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBackground(Color.WHITE);
		textField_10.setBounds(337, 226, 161, 38);
		panel_4.add(textField_10);
		
		lblv = new JLabel("当前物业费价格：");
		lblv.setHorizontalAlignment(SwingConstants.RIGHT);
		lblv.setForeground(Color.BLACK);
		lblv.setFont(new Font("宋体", Font.BOLD, 20));
		lblv.setBackground(Color.ORANGE);
		lblv.setBounds(120, 152, 174, 38);
		panel_4.add(lblv);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBackground(Color.WHITE);
		textField_1.setBounds(337, 152, 161, 38);
		panel_4.add(textField_1);
		
		Panel panel_2 = new Panel();
		panel_2.setLayout(null);
		cardPanelFather.add(panel_2, "name_491847480230716");
		
		JLabel lblNewLabel_5 = new JLabel("信用分数：");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("宋体", Font.BOLD, 24));
		lblNewLabel_5.setBounds(117, 71, 139, 39);
		panel_2.add(lblNewLabel_5);
		
		JLabel label_12 = new JLabel("信用等级：");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setFont(new Font("宋体", Font.BOLD, 24));
		label_12.setBounds(117, 137, 139, 39);
		panel_2.add(label_12);
		
		JLabel label_13 = new JLabel("信用状态：");
		label_13.setHorizontalAlignment(SwingConstants.RIGHT);
		label_13.setFont(new Font("宋体", Font.BOLD, 24));
		label_13.setBounds(117, 204, 139, 39);
		panel_2.add(label_13);
		
		JLabel label_14 = new JLabel("信用排名：");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setFont(new Font("宋体", Font.BOLD, 24));
		label_14.setBounds(117, 267, 139, 39);
		panel_2.add(label_14);
		
		JLabel label_15 = new JLabel("信用扣分开始时间：");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setFont(new Font("宋体", Font.BOLD, 24));
		label_15.setBounds(31, 337, 225, 39);
		panel_2.add(label_15);
		
		creditScore = new JTextField();
		creditScore.setFont(new Font("宋体", Font.PLAIN, 16));
		creditScore.setEditable(false);
		creditScore.setBounds(281, 71, 184, 34);
		panel_2.add(creditScore);
		creditScore.setColumns(10);
		
		creditStage = new JTextField();
		creditStage.setFont(new Font("宋体", Font.PLAIN, 16));
		creditStage.setEditable(false);
		creditStage.setColumns(10);
		creditStage.setBounds(281, 137, 184, 34);
		panel_2.add(creditStage);
		
		creditStatus = new JTextField();
		creditStatus.setFont(new Font("宋体", Font.PLAIN, 16));
		creditStatus.setEditable(false);
		creditStatus.setColumns(10);
		creditStatus.setBounds(281, 209, 184, 34);
		panel_2.add(creditStatus);
		
		creditRank = new JTextField();
		creditRank.setFont(new Font("宋体", Font.PLAIN, 16));
		creditRank.setEditable(false);
		creditRank.setColumns(10);
		creditRank.setBounds(281, 272, 184, 34);
		panel_2.add(creditRank);
		
		creditDeclineTime = new JTextField();
		creditDeclineTime.setFont(new Font("宋体", Font.PLAIN, 16));
		creditDeclineTime.setEditable(false);
		creditDeclineTime.setColumns(10);
		creditDeclineTime.setBounds(281, 342, 184, 34);
		panel_2.add(creditDeclineTime);
		
		
		//信用账单
		//测试数据
		panel_6 = new JPanel();
		panel_6.setLayout(null);
		cardPanelFather.add(panel_6, "name_1818970575172740");
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(54, 57, 565, 367);
		//scrollPane.setLayout(null);
		
		
		JLabel lblNewLabel_7 = new JLabel("显示近十次缴费记录：");
		lblNewLabel_7.setFont(new Font("宋体", Font.BOLD, 18));
		lblNewLabel_7.setBounds(54, 10, 190, 37);
		panel_6.add(lblNewLabel_7);
		
		previousItems = new JButton("上一页");
		previousItems.setBounds(157, 380, 93, 23);
		previousItems.addActionListener(this);
		panel_6.add(previousItems);
		
		nextItems = new JButton("下一页");
		nextItems.setBounds(394, 380, 93, 23);
		nextItems.addActionListener(this);
		panel_6.add(nextItems);
		
		panel_7 = new JPanel();
		panel_7.setLayout(null);
		button_12 = new JButton("确认缴费");
		button_12.setFont(new Font("宋体", Font.PLAIN, 14));
		button_12.setBounds(223, 300, 93, 31);
		button_12.addActionListener(this);
		panel_7.add(button_12);
		
		JLabel label_16 = new JLabel("请输入你想缴纳的物业费金额：");
		label_16.setFont(new Font("宋体", Font.PLAIN, 14));
		label_16.setBounds(57, 196, 196, 40);
		panel_7.add(label_16);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(275, 201, 135, 32);
		panel_7.add(textField);
		
		JLabel label_17 = new JLabel("你可以缴纳的费用为：");
		label_17.setFont(new Font("宋体", Font.PLAIN, 14));
		label_17.setBounds(57, 117, 147, 25);
		panel_7.add(label_17);
		
		JLabel minPay = new JLabel("0");
		minPay.setHorizontalAlignment(SwingConstants.RIGHT);
		minPay.setFont(new Font("宋体", Font.BOLD, 16));
		minPay.setBounds(210, 117, 56, 25);
		panel_7.add(minPay);
		
		maxPay.setText(user.getUserDebt()+"");
		maxPay.setHorizontalAlignment(SwingConstants.LEFT);
		maxPay.setFont(new Font("宋体", Font.BOLD, 16));
		maxPay.setBounds(295, 117, 62, 24);
		panel_7.add(maxPay);
		
		JLabel lblNewLabel_8 = new JLabel("~");
		lblNewLabel_8.setBounds(279, 117, 15, 28);
		panel_7.add(lblNewLabel_8);
		
		PayWarning.setText("请正确核实您输入的金额");
		PayWarning.setForeground(Color.RED);
		PayWarning.setFont(new Font("宋体", Font.BOLD, 16));
		PayWarning.setBounds(150, 49, 278, 31);
		panel_7.add(PayWarning);
		cardPanelFather.add(panel_7, "name_2064654351015901");
		
		panel_8 = new JPanel();
		panel_8.setLayout(null);
		lblNewLabel_9 = new JLabel("Congratulation!您当前未欠费!");
		lblNewLabel_9.setFont(new Font("宋体", Font.BOLD, 26));
		lblNewLabel_9.setBounds(65, 165, 440, 65);
		panel_8.add(lblNewLabel_9);
		cardPanelFather.add(panel_8, "name_2137838754274370");
		
		
		
		
		button_7 = new JButton("查询缴费记录");
		button_7.setBounds(0, 422, 130, 41);
		button_7.addActionListener(this);
		frame.getContentPane().add(button_7);
		button_7.setFont(new Font("宋体", Font.PLAIN, 12));
		
	
		frame.setVisible(true);
		frame.setLocation(100,100);
		frame.setSize(800, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	public void actionPerformed(ActionEvent arg0){
				
		if(arg0.getSource()==button_8){    // modify and check out user information panel button
			residentInfo user = new residentInfo();
			try {
				user = currentUser.findRoomId(RoomId);//通过查询房间号返回该user对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //通过查询房间号返回该user对象
			Cardpanel.show(cardPanelFather, "2");
			nameLabel.setText(user.getUserName());
			System.out.println(user.getUserName());
			beforePasswordLabel.setText(user.getUserPwd());
			phoneNumberLabel.setText(user.getUserPhone());
			roomIdLabel.setText(user.getUserRoomId());
			debtLabel.setText(user.getUserDebt()+"");
			emilLabel.setText(user.getUserMail()+"");
			creditScoreLabel.setText(Double.toString(user.getUserEditScore()));
		}
		else if(arg0.getSource()==button) {  // click "确认"按钮
			residentInfo user = new residentInfo();
			try {
				user = currentUser.findRoomId(RoomId);//通过查询房间号返回该user对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //通过查询房间号返回该user对象
			if(definePasswordLabel.getText().equalsIgnoreCase(newPasswordLabel.getText()) ) { //如果修改的密码和确认密码相同则执行修改操作
				currentUser.modifyInfo(roomIdLabel.getText(), nameLabel.getText(), newPasswordLabel.getText(), phoneNumberLabel.getText(), emilLabel.getText());
			}
		}
		else if(arg0.getSource()==button_9) { //缴费选项
			Cardpanel.show(cardPanelFather, "name_489788865146864");
			Double amount; 
		    String datetime;
			Double price;
			systemInfo newsystem = new systemInfo();
			residentInfo newuser = new residentInfo();
			creditInfo newcredit = new creditInfo();
			
			try {
				newuser = user.findRoomId(RoomId);
				newcredit = credit.findCreditInfo(RoomId);
				newsystem = system.findInfo();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			datetime = newcredit.getDebtTime();
			amount = newuser.getUserDebt();
			price = newsystem.getFee();
			textField_11.setText(amount+"");
			textField_1.setText(price+"");
			textField_10.setText(datetime);
			
		}
		else if(arg0.getSource() == button_11) { //缴费选项，判断当前是否欠费
			residentInfo user = new residentInfo();
			try {
				user = currentUser.findRoomId(RoomId);//通过查询房间号返回该user对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //通过查询房间号返回该user对象
			if(user.getUserDebt()!=0) {
				Cardpanel.show(cardPanelFather, "name_2064654351015901");
				maxPay.setText(user.getUserDebt()+"");
			}else {
				Cardpanel.show(cardPanelFather, "name_2137838754274370");
			}
		}
		else if(arg0.getSource() == button_12) { //进行缴费处理
			maintainCredit maintaincredit =new maintainCredit();
			System.out.println(arg0.getSource());
			residentInfo user = new residentInfo();
			boolean flag;
			try {
				user = currentUser.findRoomId(RoomId);//通过查询房间号返回该user对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //通过查询房间号返回该user对象
			flag = inputStr.checkPayMoneyInputSafe(textField.getText()); //首先判断输入金额是否有非法字符
			if(flag == true) { 
				Double b = Double.valueOf(textField.getText()).doubleValue();
				Double a = Double.valueOf(maxPay.getText()).doubleValue();
				if(b > a||b<=0) {//判断值大小
					PayWarning.setText("您输入金额值过大或过小");
				
				}
				else {
					Double c = a - b;
					currentUser.modifyInfoByDebt(RoomId, c);
					PayWarning.setText("缴费成功，请再次点击缴费刷新信息");
					textField.setText("");
					maintaincredit.modifyUserCreditStatus(RoomId); //修改欠费状态
					maintaincredit.creditScoreAdd(RoomId);//是否加分
					maintaincredit.modifyDebtTime(RoomId);
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
					paymentListInfo payment = new paymentListInfo(); //创建缴费记录对象
					payment.setPaymentInfo(user.getUserName(), df.format(new Date()), b, RoomId, c);
					paymentListOperation paymentOperation = new paymentListOperation();
					paymentOperation.insertFunction(payment); //添加缴费信息
					//maxPay.setText(user.getUserDebt()+"");  //这里是否要再更新一下当前对象，直接返回当前欠费金额
				
				}
			}else {
				PayWarning.setText("您输入字符非法");
			}
		}
		else if(arg0.getSource()==button_10) { // check out credit information
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
			paymentListInfo payment = new paymentListInfo(); //创建缴费记录对象
			residentInfo user = new residentInfo();
			try {
				user = currentUser.findRoomId(RoomId);//通过查询房间号返回该user对象
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //通过查询房间号返回该user对象
			maintainCredit maintaincredit =new maintainCredit();
			Cardpanel.show(cardPanelFather, "name_491847480230716");
			creditInfoOperation credit = new creditInfoOperation();
			creditInfo newCredit = new creditInfo();
			String Status;
			String Stage;
			try {
				newCredit = credit.findCreditInfo(RoomId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(newCredit.getStatus()==false) {
				Status = "已缴清没有扣分";
			}
			else {
				if(maintaincredit.calculateDate(newCredit.getDebtTime(), df.format(new Date())) > 5)
				{
					Status = "正在扣分";
				}
				else {
					Status = "即将扣分";
				}
			}
			
			if(newCredit.getCreditStage() == 2) {
				Stage = "良好";
			}
			else if(newCredit.getCreditStage() == 3) {
				Stage = "优秀";
			}
			else if(newCredit.getCreditStage() == 4) {
				Stage = "极佳";
			}
			else{
				Stage = "不佳，有待提高";
			}
			creditScore.setText(newCredit.getCreditScore()+"");
			creditRank.setText(newCredit.getRank()+"");
			creditStatus.setText(Status);
			creditStage.setText(Stage);
	        System.out.println(newCredit.getDebtTime());
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        Date date1 = new Date(); 
	        Date date2 = new Date();
	        try {
				date1 = sdf.parse("2000-01-01 00:00:00");
				date2 = sdf.parse(newCredit.getDebtTime());
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if(date2.equals(date1)) {
	        	System.out.println(newCredit.getDebtTime());
	        	creditDeclineTime.setText("无欠费");
	        }
	        else {
	        	creditDeclineTime.setText(newCredit.getDebtTime()+"");
	        }
			
		}
		else if(arg0.getSource()==button_7) { //find payment records 
			
			paymentListOperation payment = new paymentListOperation();
			residentInfo user = new residentInfo();
			Cardpanel.show(cardPanelFather, "name_1818970575172740");
					
			columnNames.add("缴费人");
			columnNames.add("缴费时间");
			columnNames.add("缴费金额");
			columnNames.add("当前欠费金额");
			columnNames.add("房号");
			try {
				ResultSet rs = payment.findRoomId(RoomId);
				while(rs.next()) {
					Vector hang = new Vector();
					hang.add(rs.getString("userName"));
					hang.add(rs.getString("PayFeeTime"));
					hang.add(rs.getString("amount"));
					hang.add(rs.getString("debtFee"));
					hang.add(rs.getString("roomId"));
					rowData.add(hang);
				}
				table_1 = new JTable(rowData,columnNames);
				scrollPane.setViewportView(table_1);
				panel_6.add(scrollPane);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			scrollPane.setViewportView(table_1);
			panel_6.add(scrollPane);
		}
		else if(arg0.getSource()==button_2) {
			lblNewLabel_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view22.jpg"));
		}
		else if(arg0.getSource()==button_3) {
			lblNewLabel_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view33.jpg"));
		}
		else if(arg0.getSource()==button_4) {
			lblNewLabel_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view44.jpg"));
		}
		else if(arg0.getSource()==button_5) {
			lblNewLabel_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view55.jpg"));
		}
		else if(arg0.getSource()==button_6) {
			lblNewLabel_6.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\view11.jpg"));
		}
		else if(arg0.getSource()==previousItems) {
	
		}
		else if(arg0.getSource()==nextItems) {
			SplitTable table = new SplitTable();
			int size = 3;
			int first = 3;
			int i=2;
			Vector newDate = new Vector();
			if(rowData.size()>size*i) { //判断点击次数和当前的项目个数
				newDate = table.nextMember(first, size, rowData);
				table_1 = new JTable(newDate,columnNames);
				scrollPane.setViewportView(table_1);
				panel_6.add(scrollPane);
				first = first + size;
			}
		}
		else if(arg0.getSource()==button) { //listen to modify user infomation button
			
		}
	}
}


