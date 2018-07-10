package com.gui;
//import Model.testDate;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.ParseException;
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

import com.dataOperation.adminOperation;
import com.dataOperation.creditInfoOperation;
import com.dataOperation.houseInfoOperation;
import com.dataOperation.systemOperation;
import com.dataOperation.userInfoOperation;
import com.dateModel.adminInfo;
import com.dateModel.creditInfo;
import com.dateModel.houseInfo;
import com.dateModel.residentInfo;
import com.dateModel.systemInfo;
import com.system.calculateFee;

import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JPasswordField;

public class AdminIndex implements ActionListener{
	private JFrame frame;
	private JTable table,table_2;
	String name;
	adminOperation adminoperation = new adminOperation();
	houseInfoOperation houseoperation = new houseInfoOperation();
	userInfoOperation residentoperation = new userInfoOperation();
	creditInfoOperation creditoperation = new creditInfoOperation();
	systemOperation systemoperation = new systemOperation();
	//public testDate date;
    
	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public AdminIndex(String name) {
		this.name = name;
		initialize();
	}
	JScrollPane scrollPane;
	JScrollPane scrollPane_1;
	JPanel cardPanelFather,modifyAdminPanel,findByDebtConditionPanel; //第一个菜单项卡片布局
	CardLayout Cardpanel;  //card layout , distribute panel
	JButton modifyFeeBtn,modifyAdminInfoBtn,findRoomBtn,buildingFundBtn,debtFindBtn,creditFindBtn,oneHouseList,twoHouseList;
	JLabel status0101,status0102,status0103,status0104,status0201,status0202,status0203,status0204,status0301,status0302,status0303,status0304,status0401,status0402,status0403,status0404;
	JLabel id0101,id0102,id0103,id0104,id0201,id0202,id0203,id0204,id0301,id0302,id0303,id0304,id0401,id0402,id0403,id0404;
	private JButton delUserBtn;
	private JButton addUserBtn;
	private JPanel addUserPanel;
	private JLabel username;
	private JLabel password;
	private JLabel phoneNumber;
	private JLabel sex;
	private JLabel email;
	private JLabel roomid;
	private JTextField Username;
	private JTextField Userpassword;
	private JTextField Usersex;
	private JTextField Userphone;
	private JTextField Usermail;
	private JTextField Userid;
	private JTextField adminName;
	private JTextField BeforePassword;
	private JTextField NewPassword;
	private JTextField SurePassword;
	private JTextField adminmail;
	private JLabel label_5;
	private JLabel label_6;
	private JTextField adminPhone;
	private JLabel label_7;
	private JLabel label_8;
	private JButton sureToModifyAdminInfo,button;
	private JPanel findByRoomPanel;
	private JTextField textField;
	private JButton findUserRoomBtn;
	private JButton button_2,button_1;
	private JButton button_3;
	private JPanel rankByCreditScorePanel;
	private JPanel delUserPanel;
	private JPanel modifyManagePricePanel;
	private JTextField textField_1;
	private JButton button_4;
	private JPanel panel_2;
	private JLabel label_9;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel label_10;
	private JLabel label_11;
	private JTextField textField_4;
	private JButton button_5;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JLabel label_12;
	private JLabel label_13;
	private JLabel label_14;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel label_17;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JLabel label_18;
	private JLabel label_19;
	private JLabel label_20;
	private JLabel label_21;
	private JLabel label_22;
	private JLabel label_23;
	private JTextField textField_17;
	private JLabel lblNewLabel_10;
	private JLabel label_24;
	private JTextField textField_18;
	private JLabel label_25;
	private JLabel lblNewLabel_11;
	private JLabel lblm;
	private JLabel lblm_1;
	private JLabel lblm_2;
	private JButton button_6;
	JTable table_1;
	private JPanel panel_3;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JButton button_7;
	private void initialize() {
		Vector columnNames = new Vector();
		Vector rowData = new Vector();
		Font font1=new Font("宋体",Font.PLAIN,30);
		Font font2=new Font("仿宋",Font.PLAIN,15);

		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 6, 884, 80);
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
		
		JLabel label = new JLabel("管理员功能");
		label.setBounds(18, 35, 96, 19);
		label.setFont(font2);
		panel_1.add(label);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\13.jpg"));
		lblNewLabel_3.setBounds(0, 0, 160, 90);
		panel_1.add(lblNewLabel_3);
		
		modifyAdminInfoBtn = new JButton("维护管理员信息");
		modifyAdminInfoBtn.setFont(new Font("宋体", Font.PLAIN, 12));
		modifyAdminInfoBtn.addActionListener(this);
		modifyAdminInfoBtn.setBounds(20, 280, 120, 36);
		frame.getContentPane().add(modifyAdminInfoBtn);
		
		modifyFeeBtn = new JButton("维护物业费信息");
		modifyFeeBtn.setBounds(20, 510, 120, 36);
		modifyFeeBtn.addActionListener(this);
		frame.getContentPane().add(modifyFeeBtn);
		
		findRoomBtn = new JButton("查询住户信息");
		findRoomBtn.addActionListener(this);
		findRoomBtn.setFont(new Font("宋体", Font.PLAIN, 12));
		findRoomBtn.setBounds(20, 326, 120, 36);
		frame.getContentPane().add(findRoomBtn);
		
		buildingFundBtn = new JButton("根据楼号查询");
		buildingFundBtn.addActionListener(this);
		buildingFundBtn.setFont(new Font("宋体", Font.PLAIN, 12));
		buildingFundBtn.setBounds(20, 372, 120, 36);
		frame.getContentPane().add(buildingFundBtn);
		
		debtFindBtn = new JButton("欠费情况查询");
		debtFindBtn.addActionListener(this);
		debtFindBtn.setFont(new Font("宋体", Font.PLAIN, 12));
		debtFindBtn.setBounds(20, 418, 120, 36);
		frame.getContentPane().add(debtFindBtn);
		
		creditFindBtn = new JButton("信用分数排名");
		creditFindBtn.addActionListener(this);
		creditFindBtn.setFont(new Font("宋体", Font.PLAIN, 12));
		creditFindBtn.setBounds(20, 464, 120, 36);
		frame.getContentPane().add(creditFindBtn);
		
		Cardpanel = new CardLayout();
		
		cardPanelFather = new JPanel(Cardpanel);
		//cardPanelFather.setLayout(null);   ///这里不能再设置null布局，因为上面已经指定CardLayout 布局
		cardPanelFather.setBounds(159, 86, 725, 509);
		//测试数据
		columnNames.add("编号");
		columnNames.add("姓名");
		columnNames.add("年龄");
		columnNames.add("欠费金额");
		columnNames.add("居住位置");
		Vector hang = new Vector();
		Vector hang1 = new Vector();
		Vector hang2 = new Vector();
		hang1.add("2");
		hang1.add("胡洋1");
		hang1.add("21");
		hang1.add("1500");
		hang1.add("1032");
		rowData.add(hang1);
		hang2.add("3");
		hang2.add("胡洋2");
		hang2.add("22");
		hang2.add("1700");
		hang2.add("1035");
		rowData.add(hang2);
		hang.add("1");
		hang.add("胡洋");
		hang.add("20");
		hang.add("1000");
		hang.add("1033");
		rowData.add(hang);
		
		delUserBtn = new JButton("删除用户");
		delUserBtn.setFont(new Font("宋体", Font.PLAIN, 13));
		delUserBtn.addActionListener(this);
		delUserBtn.setBounds(20, 234, 120, 36);
		frame.getContentPane().add(delUserBtn);
		
		addUserBtn = new JButton("添加用户");
		addUserBtn.setFont(new Font("宋体", Font.PLAIN, 13));
		addUserBtn.addActionListener(this);
		addUserBtn.setBounds(20, 188, 120, 36);
		frame.getContentPane().add(addUserBtn);
		frame.getContentPane().add(cardPanelFather);
		frame.getContentPane().add(cardPanelFather);
		frame.getContentPane().add(cardPanelFather);
		
		panel_3 = new JPanel();
		panel_3.setLayout(null);
		cardPanelFather.add(panel_3, "name_742328607410088");
		
		lblNewLabel_13 = new JLabel("欢迎来到管理员模块");
		lblNewLabel_13.setFont(new Font("宋体", Font.ITALIC, 24));
		lblNewLabel_13.setBounds(219, 209, 248, 48);
		panel_3.add(lblNewLabel_13);
		
		lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setIcon(new ImageIcon("D:\\JavaWork\\ManageFeeSystem\\Image\\timg.jpg"));
		lblNewLabel_12.setBounds(55, 34, 606, 465);
		panel_3.add(lblNewLabel_12);
		
		JPanel buildingPanel = new JPanel();
		buildingPanel.setLayout(null);
		cardPanelFather.add(buildingPanel, "buildingPanel");
		
		oneHouseList = new JButton("一号楼情况");
		oneHouseList.addActionListener(this);
		oneHouseList.setBounds(155, 29, 121, 33);
		buildingPanel.add(oneHouseList);
		
		twoHouseList = new JButton("二号楼情况");
		twoHouseList.addActionListener(this);
		twoHouseList.setBounds(355, 29, 121, 33);
		buildingPanel.add(twoHouseList);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBackground(new Color(0, 255, 0));
		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setBounds(516, 22, 20, 15);
		buildingPanel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setOpaque(true);
		lblNewLabel_6.setBackground(new Color(192, 192, 192));
		lblNewLabel_6.setBounds(516, 47, 20, 15);
		buildingPanel.add(lblNewLabel_6);
		
		JLabel label_1 = new JLabel();
		label_1.setOpaque(true);
		label_1.setBackground(new Color(255, 0, 0));
		label_1.setBounds(516, 68, 20, 15);
		buildingPanel.add(label_1);
		
		JLabel label_2 = new JLabel("不欠费");
		label_2.setBounds(546, 22, 71, 15);
		buildingPanel.add(label_2);
		
		JLabel lblv = new JLabel("没有住户");
		lblv.setBounds(546, 47, 71, 15);
		buildingPanel.add(lblv);
		
		JLabel label_4 = new JLabel("正欠费");
		label_4.setBounds(546, 68, 71, 15);
		buildingPanel.add(label_4);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBounds(75, 93, 593, 370);
		buildingPanel.add(panel_6);
		
		status0401 = new JLabel("");
		status0401.setOpaque(true);
		status0401.setBounds(69, 50, 54, 20);
		panel_6.add(status0401);
		
		status0402 = new JLabel("");
		status0402.setOpaque(true);
		status0402.setBounds(183, 50, 54, 20);
		panel_6.add(status0402);
		
		status0403 = new JLabel("");
		status0403.setOpaque(true);
		status0403.setBounds(296, 50, 54, 20);
		panel_6.add(status0403);
		
		status0404 = new JLabel("");
		status0404.setOpaque(true);
		status0404.setBounds(405, 50, 54, 20);
		panel_6.add(status0404);
		
		status0304 = new JLabel("");
		status0304.setOpaque(true);
		status0304.setBounds(405, 123, 54, 20);
		panel_6.add(status0304);
		
		status0301 = new JLabel("");
		status0301.setOpaque(true);
		status0301.setBounds(69, 123, 54, 20);
		panel_6.add(status0301);
		
		status0302 = new JLabel("");
		status0302.setOpaque(true);
		status0302.setBounds(183, 123, 54, 20);
		panel_6.add(status0302);
		
		status0303 = new JLabel("");
		status0303.setOpaque(true);
		status0303.setBounds(296, 123, 54, 20);
		panel_6.add(status0303);
		
		status0204 = new JLabel("");
		status0204.setOpaque(true);
		status0204.setBounds(405, 196, 54, 20);
		panel_6.add(status0204);
		
		status0201 = new JLabel("");
		status0201.setOpaque(true);
		status0201.setBounds(69, 196, 54, 20);
		panel_6.add(status0201);
		
		status0202 = new JLabel("");
		status0202.setOpaque(true);
		status0202.setBounds(183, 196, 54, 20);
		panel_6.add(status0202);
		
		status0203 = new JLabel("");
		status0203.setOpaque(true);
		status0203.setBounds(296, 196, 54, 20);
		panel_6.add(status0203);
		
		status0104 = new JLabel("");
		status0104.setOpaque(true);
		status0104.setBounds(405, 267, 54, 20);
		panel_6.add(status0104);
		
		status0101 = new JLabel("");
		status0101.setOpaque(true);
		status0101.setBounds(69, 267, 54, 20);
		panel_6.add(status0101);
		
		status0102 = new JLabel("");
		status0102.setOpaque(true);
		status0102.setBounds(183, 267, 54, 20);
		panel_6.add(status0102);
		
		status0103 = new JLabel("");
		status0103.setOpaque(true);
		status0103.setBounds(296, 267, 54, 20);
		panel_6.add(status0103);
		
		id0401 = new JLabel("010201");
		id0401.setBounds(69, 80, 42, 15);
		panel_6.add(id0401);
		
		id0402 = new JLabel("010201");
		id0402.setBounds(183, 80, 42, 15);
		panel_6.add(id0402);
		
		id0403 = new JLabel("010201");
		id0403.setBounds(296, 80, 42, 15);
		panel_6.add(id0403);
		
		id0404 = new JLabel("010201");
		id0404.setBounds(405, 80, 42, 15);
		panel_6.add(id0404);
		
		id0303 = new JLabel("010201");
		id0303.setBounds(296, 153, 42, 15);
		panel_6.add(id0303);
		
		id0304 = new JLabel("010201");
		id0304.setBounds(405, 153, 42, 15);
		panel_6.add(id0304);
		
		id0302 = new JLabel("010201");
		id0302.setBounds(183, 153, 42, 15);
		panel_6.add(id0302);
		
		id0301 = new JLabel("010201");
		id0301.setBounds(69, 153, 42, 15);
		panel_6.add(id0301);
		
		id0203 = new JLabel("010201");
		id0203.setBounds(296, 226, 42, 15);
		panel_6.add(id0203);
		
		id0204 = new JLabel("010201");
		id0204.setBounds(405, 226, 42, 15);
		panel_6.add(id0204);
		
		id0202 = new JLabel("010201");
		id0202.setBounds(183, 226, 42, 15);
		panel_6.add(id0202);
		
		id0201 = new JLabel("010201");
		id0201.setBounds(69, 226, 42, 15);
		panel_6.add(id0201);
		
		id0103 = new JLabel("010201");
		id0103.setBounds(296, 298, 42, 15);
		panel_6.add(id0103);
		
		id0104 = new JLabel("010201");
		id0104.setBounds(405, 298, 42, 15);
		panel_6.add(id0104);
		
		id0102 = new JLabel("010201");
		id0102.setBounds(183, 298, 42, 15);
		panel_6.add(id0102);
		
		id0101 = new JLabel("010201");
		id0101.setBounds(69, 298, 42, 15);
		panel_6.add(id0101);
		
		addUserPanel = new JPanel();
		addUserPanel.setLayout(null);
		cardPanelFather.add(addUserPanel, "addUserPanel");
		
		username = new JLabel("用户名：");
		username.setFont(new Font("宋体", Font.BOLD, 16));
		username.setBounds(177, 64, 75, 32);
		addUserPanel.add(username);
		
		password = new JLabel("初始密码：");
		password.setFont(new Font("宋体", Font.BOLD, 16));
		password.setBounds(167, 124, 85, 32);
		addUserPanel.add(password);
		
		phoneNumber = new JLabel("电话：");
		phoneNumber.setFont(new Font("宋体", Font.BOLD, 16));
		phoneNumber.setBounds(177, 252, 75, 32);
		addUserPanel.add(phoneNumber);
		
		sex = new JLabel("性别：");
		sex.setFont(new Font("宋体", Font.BOLD, 16));
		sex.setBounds(177, 187, 75, 32);
		addUserPanel.add(sex);
		
		email = new JLabel("邮箱：");
		email.setFont(new Font("宋体", Font.BOLD, 16));
		email.setBounds(177, 309, 75, 32);
		addUserPanel.add(email);
		
		roomid = new JLabel("房间号：");
		roomid.setFont(new Font("宋体", Font.BOLD, 16));
		roomid.setBounds(177, 375, 75, 32);
		addUserPanel.add(roomid);
		
		Username = new JTextField();
		Username.setBounds(304, 64, 155, 37);
		addUserPanel.add(Username);
		Username.setColumns(10);
		
		Userpassword = new JTextField();
		Userpassword.setColumns(10);
		Userpassword.setBounds(304, 125, 155, 37);
		addUserPanel.add(Userpassword);
		
		Usersex = new JTextField();
		Usersex.setColumns(10);
		Usersex.setBounds(304, 187, 155, 37);
		addUserPanel.add(Usersex);
		
		Userphone = new JTextField();
		Userphone.setColumns(10);
		Userphone.setBounds(304, 256, 155, 37);
		addUserPanel.add(Userphone);
		
		Usermail = new JTextField();
		Usermail.setColumns(10);
		Usermail.setBounds(304, 313, 155, 37);
		addUserPanel.add(Usermail);
		
		Userid = new JTextField();
		Userid.setColumns(10);
		Userid.setBounds(304, 379, 155, 37);
		addUserPanel.add(Userid);
		
		button = new JButton("确定添加");
		button.addActionListener(this);
		button.setFont(new Font("宋体", Font.PLAIN, 14));
		button.setBounds(129, 435, 107, 32);
		addUserPanel.add(button);
		
		button_1 = new JButton("重置");
		button_1.setFont(new Font("宋体", Font.PLAIN, 14));
		button_1.addActionListener(this);
		button_1.setBounds(464, 435, 107, 32);
		addUserPanel.add(button_1);
		
		modifyAdminPanel = new JPanel();
		modifyAdminPanel.setLayout(null);
		cardPanelFather.add(modifyAdminPanel, "modifyAdminPanel");
		
		adminName = new JTextField();
		adminName.setEditable(false);
		adminName.setBounds(320, 45, 150, 36);
		modifyAdminPanel.add(adminName);
		adminName.setColumns(10);
		
		BeforePassword = new JTextField();
		BeforePassword.setEditable(false);
		BeforePassword.setColumns(10);
		BeforePassword.setBounds(320, 106, 150, 36);
		modifyAdminPanel.add(BeforePassword);
		
		NewPassword = new JTextField();
		NewPassword.setColumns(10);
		NewPassword.setBounds(320, 174, 150, 36);
		modifyAdminPanel.add(NewPassword);
		
		SurePassword = new JTextField();
		SurePassword.setColumns(10);
		SurePassword.setBounds(320, 242, 150, 36);
		modifyAdminPanel.add(SurePassword);
		
		adminmail = new JTextField();
		adminmail.setColumns(10);
		adminmail.setBounds(320, 309, 150, 36);
		modifyAdminPanel.add(adminmail);
		
		JLabel lblNewLabel_4 = new JLabel("姓名：");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(201, 49, 80, 26);
		modifyAdminPanel.add(lblNewLabel_4);
		
		JLabel label_3 = new JLabel("原密码：");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(201, 110, 80, 26);
		modifyAdminPanel.add(label_3);
		
		label_5 = new JLabel("新密码：");
		label_5.setFont(new Font("宋体", Font.PLAIN, 16));
		label_5.setBounds(201, 178, 80, 26);
		modifyAdminPanel.add(label_5);
		
		label_6 = new JLabel("确认密码：");
		label_6.setFont(new Font("宋体", Font.PLAIN, 16));
		label_6.setBounds(201, 246, 80, 26);
		modifyAdminPanel.add(label_6);
		
		adminPhone = new JTextField();
		adminPhone.setColumns(10);
		adminPhone.setBounds(320, 375, 150, 36);
		modifyAdminPanel.add(adminPhone);
		
		label_7 = new JLabel("邮箱：");
		label_7.setFont(new Font("宋体", Font.PLAIN, 16));
		label_7.setBounds(201, 309, 80, 26);
		modifyAdminPanel.add(label_7);
		
		label_8 = new JLabel("手机号：");
		label_8.setFont(new Font("宋体", Font.PLAIN, 16));
		label_8.setBounds(201, 373, 80, 26);
		modifyAdminPanel.add(label_8);
		
		sureToModifyAdminInfo = new JButton("确定修改");
		sureToModifyAdminInfo.setBounds(265, 450, 93, 23);
		sureToModifyAdminInfo.addActionListener(this);
		modifyAdminPanel.add(sureToModifyAdminInfo);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("宋体", Font.BOLD, 14));
		lblNewLabel_8.setForeground(Color.RED);
		lblNewLabel_8.setBounds(219, 10, 280, 25);
		modifyAdminPanel.add(lblNewLabel_8);
		
		findByRoomPanel = new JPanel();
		findByRoomPanel.setLayout(null);
		cardPanelFather.add(findByRoomPanel, "findByRoomPanel");
		
		textField = new JTextField();
		textField.setFont(new Font("宋体", Font.PLAIN, 14));
		textField.setForeground(Color.LIGHT_GRAY);
		textField.setText("请输入您要查找的用户房间号");
		textField.setBounds(131, 26, 335, 45);
		findByRoomPanel.add(textField);
		textField.setColumns(10);
		
		findUserRoomBtn = new JButton("查找");
		findUserRoomBtn.setBounds(510, 31, 114, 34);
		findUserRoomBtn.addActionListener(this);
		findByRoomPanel.add(findUserRoomBtn);
		
		JPanel findRoomUserInfoPanel = new JPanel();
		findRoomUserInfoPanel.setLayout(null);
		findRoomUserInfoPanel.setBounds(41, 102, 647, 397);
		findByRoomPanel.add(findRoomUserInfoPanel);
		
		label_12 = new JLabel("姓名：");
		label_12.setFont(new Font("宋体", Font.PLAIN, 14));
		label_12.setBounds(59, 26, 85, 34);
		findRoomUserInfoPanel.add(label_12);
		
		label_13 = new JLabel("姓别：");
		label_13.setFont(new Font("宋体", Font.PLAIN, 14));
		label_13.setBounds(59, 86, 85, 36);
		findRoomUserInfoPanel.add(label_13);
		
		label_14 = new JLabel("密码：");
		label_14.setFont(new Font("宋体", Font.PLAIN, 14));
		label_14.setBounds(59, 148, 85, 34);
		findRoomUserInfoPanel.add(label_14);
		
		label_15 = new JLabel("手机号：");
		label_15.setFont(new Font("宋体", Font.PLAIN, 14));
		label_15.setBounds(59, 208, 85, 38);
		findRoomUserInfoPanel.add(label_15);
		
		label_16 = new JLabel("邮箱：");
		label_16.setFont(new Font("宋体", Font.PLAIN, 14));
		label_16.setBounds(59, 272, 85, 34);
		findRoomUserInfoPanel.add(label_16);
		
		label_17 = new JLabel("欠费金额：");
		label_17.setFont(new Font("宋体", Font.PLAIN, 14));
		label_17.setBounds(59, 332, 85, 36);
		findRoomUserInfoPanel.add(label_17);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setBounds(180, 27, 125, 34);
		findRoomUserInfoPanel.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(180, 88, 125, 34);
		findRoomUserInfoPanel.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(180, 149, 125, 34);
		findRoomUserInfoPanel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(180, 210, 125, 34);
		findRoomUserInfoPanel.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(180, 273, 125, 34);
		findRoomUserInfoPanel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(180, 332, 125, 34);
		findRoomUserInfoPanel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(467, 27, 125, 34);
		findRoomUserInfoPanel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(467, 88, 125, 34);
		findRoomUserInfoPanel.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(467, 149, 125, 34);
		findRoomUserInfoPanel.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setEditable(false);
		textField_14.setColumns(10);
		textField_14.setBounds(467, 210, 125, 34);
		findRoomUserInfoPanel.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setEditable(false);
		textField_15.setColumns(10);
		textField_15.setBounds(467, 271, 125, 34);
		findRoomUserInfoPanel.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setEditable(false);
		textField_16.setColumns(10);
		textField_16.setBounds(467, 332, 125, 34);
		findRoomUserInfoPanel.add(textField_16);
		
		label_18 = new JLabel("欠费时间：");
		label_18.setFont(new Font("宋体", Font.PLAIN, 14));
		label_18.setBounds(346, 332, 85, 36);
		findRoomUserInfoPanel.add(label_18);
		
		label_19 = new JLabel("是否欠费：");
		label_19.setFont(new Font("宋体", Font.PLAIN, 14));
		label_19.setBounds(346, 272, 85, 34);
		findRoomUserInfoPanel.add(label_19);
		
		label_20 = new JLabel("信用等级：");
		label_20.setFont(new Font("宋体", Font.PLAIN, 14));
		label_20.setBounds(346, 208, 85, 38);
		findRoomUserInfoPanel.add(label_20);
		
		label_21 = new JLabel("信用排名：");
		label_21.setFont(new Font("宋体", Font.PLAIN, 14));
		label_21.setBounds(346, 148, 85, 34);
		findRoomUserInfoPanel.add(label_21);
		
		label_22 = new JLabel("房间号：");
		label_22.setFont(new Font("宋体", Font.PLAIN, 14));
		label_22.setBounds(346, 86, 85, 36);
		findRoomUserInfoPanel.add(label_22);
		
		label_23 = new JLabel("信用分数：");
		label_23.setFont(new Font("宋体", Font.PLAIN, 14));
		label_23.setBounds(346, 26, 85, 34);
		findRoomUserInfoPanel.add(label_23);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setForeground(Color.RED);
		lblNewLabel_9.setBounds(156, 81, 196, 15);
		findByRoomPanel.add(lblNewLabel_9);
		
		findByDebtConditionPanel = new JPanel();
		findByDebtConditionPanel.setLayout(null);
		cardPanelFather.add(findByDebtConditionPanel, "findByDebtConditionPanel");
		
		button_2 = new JButton("按欠费日期长短查询");
		button_2.addActionListener(this);
		button_2.setBounds(116, 32, 169, 38);
		findByDebtConditionPanel.add(button_2);
		
		button_3 = new JButton("按欠费金额量查询");
		button_3.setBounds(401, 32, 169, 38);
		button_3.addActionListener(this);
		findByDebtConditionPanel.add(button_3);
		
		rankByCreditScorePanel = new JPanel();
		rankByCreditScorePanel.setLayout(null);
		cardPanelFather.add(rankByCreditScorePanel, "rankByCreditScorePanel");
		
		delUserPanel = new JPanel();
		delUserPanel.setLayout(null);
		cardPanelFather.add(delUserPanel, "delUserPanel");
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("宋体", Font.BOLD, 16));
		textField_1.setForeground(Color.LIGHT_GRAY);
		textField_1.setBounds(154, 75, 295, 52);
		delUserPanel.add(textField_1);
		textField_1.setColumns(10);
		panel_2 = new JPanel();
		panel_2.setBounds(38, 151, 629, 272);
		panel_2.setLayout(null);
		delUserPanel.add(panel_2);
		
		label_9 = new JLabel("姓名：");
		label_9.setFont(new Font("宋体", Font.BOLD, 18));
		label_9.setBounds(136, 67, 119, 42);
		panel_2.add(label_9);

		textField_2 = new JTextField();
		textField_2.setBounds(280, 67, 150, 34);
		panel_2.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(280, 140, 150, 34);
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(280, 218, 150, 34);
		panel_2.add(textField_4);
		panel_2.add(textField_3);
		
		label_10 = new JLabel("房间号：");
		label_10.setFont(new Font("宋体", Font.BOLD, 18));
		label_10.setBounds(136, 140, 119, 42);
		panel_2.add(label_10);
		
		label_11 = new JLabel("欠费状态：");
		label_11.setFont(new Font("宋体", Font.BOLD, 18));
		label_11.setBounds(136, 218, 119, 42);
		panel_2.add(label_11);
		button_4 = new JButton("查询");
		button_4.addActionListener(this);
		button_4.setBounds(486, 87, 90, 28);
		delUserPanel.add(button_4);
		
		
		button_5 = new JButton("确认删除");
		button_5.addActionListener(this);
		button_5.setBounds(269, 433, 144, 44);
		delUserPanel.add(button_5);
		
		lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setFont(new Font("宋体", Font.PLAIN, 15));
		lblNewLabel_7.setForeground(Color.RED);
		lblNewLabel_7.setBounds(220, 20, 229, 36);
		delUserPanel.add(lblNewLabel_7);
		
		modifyManagePricePanel = new JPanel();
		modifyManagePricePanel.setLayout(null);
		cardPanelFather.add(modifyManagePricePanel, "modifyManagePricePanel");
		
		textField_17 = new JTextField();
		textField_17.setEditable(false);
		textField_17.setBounds(366, 149, 147, 44);
		modifyManagePricePanel.add(textField_17);
		textField_17.setColumns(10);
		
		lblNewLabel_10 = new JLabel("当前物业费价格(/m2)");
		lblNewLabel_10.setFont(new Font("宋体", Font.PLAIN, 24));
		lblNewLabel_10.setBounds(85, 134, 257, 65);
		modifyManagePricePanel.add(lblNewLabel_10);
		
		label_24 = new JLabel("当前物业费价格(/m2)");
		label_24.setFont(new Font("宋体", Font.PLAIN, 24));
		label_24.setBounds(85, 235, 257, 65);
		modifyManagePricePanel.add(label_24);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(366, 250, 147, 44);
		modifyManagePricePanel.add(textField_18);
		
		label_25 = new JLabel("请根据当前市场价格谨慎修改物业费用：");
		label_25.setForeground(Color.RED);
		label_25.setFont(new Font("宋体", Font.BOLD, 15));
		label_25.setBounds(175, 34, 312, 36);
		modifyManagePricePanel.add(label_25);
		
		lblNewLabel_11 = new JLabel("如下参考：");
		lblNewLabel_11.setBounds(546, 34, 147, 27);
		modifyManagePricePanel.add(lblNewLabel_11);
		
		lblm = new JLabel("一级物业：1块/m2");
		lblm.setBounds(546, 69, 147, 27);
		modifyManagePricePanel.add(lblm);
		
		lblm_1 = new JLabel("二级物业：0.75m/2");
		lblm_1.setBounds(546, 106, 147, 27);
		modifyManagePricePanel.add(lblm_1);
		
		lblm_2 = new JLabel("三级物业：0.45/m2");
		lblm_2.setBounds(546, 142, 147, 27);
		modifyManagePricePanel.add(lblm_2);
		
		button_6 = new JButton("确定修改");
		button_6.addActionListener(this);
		button_6.setFont(new Font("宋体", Font.PLAIN, 16));
		button_6.setBounds(285, 374, 139, 44);
		modifyManagePricePanel.add(button_6);
		
		button_7 = new JButton("生成物业费");
		button_7.setBounds(20, 556, 120, 36);
		button_7.addActionListener(this);
		frame.getContentPane().add(button_7);
		
		
	
		
		frame.setLocation(100,100);
		frame.setSize(910, 658);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent arg0){
		if(arg0.getSource()==addUserBtn){
			Cardpanel.show(cardPanelFather, "addUserPanel");
		}
		else if(arg0.getSource()==delUserBtn) {
			Cardpanel.show(cardPanelFather, "delUserPanel");
		}
		else if(arg0.getSource()==modifyAdminInfoBtn) { //显示出当前管理员信息
			Cardpanel.show(cardPanelFather, "modifyAdminPanel");
			adminInfo admin = new adminInfo();
			try {
				admin = adminoperation.findAdminInfo(name);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			adminName.setText(admin.getAdminName());
			BeforePassword.setText(admin.getAdminPWD());
			adminPhone.setText(admin.getAdminPhone());
			adminmail.setText(admin.getAdminMail());
		}
		else if(arg0.getSource()==findRoomBtn) {
			Cardpanel.show(cardPanelFather, "findByRoomPanel");
		}
		else if(arg0.getSource()==findRoomBtn) {
			Cardpanel.show(cardPanelFather, "findByRoomPanel");
		}
		else if(arg0.getSource()==buildingFundBtn) {
			Cardpanel.show(cardPanelFather, "buildingPanel");
		}
		else if(arg0.getSource()==debtFindBtn) {
			Cardpanel.show(cardPanelFather,"findByDebtConditionPanel");
		}
		else if(arg0.getSource()==creditFindBtn) { //按照信用分数排序
			scrollPane = new JScrollPane();
			scrollPane.setBounds(54, 57, 565, 367);
			Vector<creditInfo> credit =new Vector();
			Vector Alldate = new Vector();
			Vector columnNames = new Vector();
			columnNames.add("姓名");
			columnNames.add("房号");
			columnNames.add("信用分数");
			columnNames.add("名次");
			columnNames.add("等级");
			columnNames.add("欠费状态");
			columnNames.add("欠费时间");
			credit = adminoperation.rankCreditScore();
			Cardpanel.show(cardPanelFather,"rankByCreditScorePanel");
			for(int i=0;i<credit.size();i++) {
				Vector date = new Vector();
				date.add(credit.get(i).getName());
				date.add(credit.get(i).getRoomId());
				date.add(credit.get(i).getCreditScore());
				date.add(credit.get(i).getRank());
				date.add(credit.get(i).getCreditStage());
				date.add(credit.get(i).getStatus());
				date.add(credit.get(i).getDebtTime());
				System.out.println(date);
				Alldate.add(date);
			}
			System.out.println(Alldate);
			table_1 = new JTable(Alldate,columnNames);
			scrollPane.setViewportView(table_1);
			System.out.println("succc");
			rankByCreditScorePanel.add(scrollPane);
		}
		
		else if(arg0.getSource()==modifyFeeBtn) {
			Cardpanel.show(cardPanelFather,"modifyManagePricePanel");
			systemInfo price = new systemInfo();
			try {
				price = systemoperation.findInfo();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			textField_17.setText(price.getFee()+"");
			
		}
			
		else if(arg0.getSource()==oneHouseList) { //一号楼情况
			
			Vector <houseInfo>houseStatusList = new Vector();
			try {
				houseStatusList = houseoperation.findRoomStatus();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setHouseColor(status0101,houseStatusList.get(0));
			setHouseColor(status0102,houseStatusList.get(1));
			setHouseColor(status0103,houseStatusList.get(2));
			setHouseColor(status0104,houseStatusList.get(3));
			setHouseColor(status0201,houseStatusList.get(4));
			setHouseColor(status0202,houseStatusList.get(5));
			setHouseColor(status0203,houseStatusList.get(6));
			setHouseColor(status0204,houseStatusList.get(7));
			setHouseColor(status0301,houseStatusList.get(8));
			setHouseColor(status0302,houseStatusList.get(9));
			setHouseColor(status0303,houseStatusList.get(10));
			setHouseColor(status0304,houseStatusList.get(11));
			setHouseColor(status0401,houseStatusList.get(12));
			setHouseColor(status0402,houseStatusList.get(13));
			setHouseColor(status0403,houseStatusList.get(14));
			setHouseColor(status0404,houseStatusList.get(15));
			id0101.setText("010101");
			id0102.setText("010102");
			id0103.setText("010103");
			id0104.setText("010104");
			id0201.setText("010201");
			id0202.setText("010202");
			id0203.setText("010203");
			id0204.setText("010204");
			id0301.setText("010301");
			id0302.setText("010302");
			id0303.setText("010303");
			id0304.setText("010304");
			id0401.setText("010401");
			id0402.setText("010402");
			id0403.setText("010403");
			id0404.setText("010404");
		}
		else if(arg0.getSource()==twoHouseList) { //二号楼情况
			Vector <houseInfo>houseStatusList = new Vector();
			try {
				houseStatusList = houseoperation.findRoomStatus();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setHouseColor(status0101,houseStatusList.get(16));
			id0101.setText("020101");
			setHouseColor(status0102,houseStatusList.get(17));
			id0102.setText("020102");
			setHouseColor(status0103,houseStatusList.get(18));
			id0103.setText("020103");
			setHouseColor(status0104,houseStatusList.get(19));
			id0104.setText("020104");
			setHouseColor(status0201,houseStatusList.get(20));
			id0201.setText("020201");
			setHouseColor(status0202,houseStatusList.get(21));
			id0202.setText("020202");
			setHouseColor(status0203,houseStatusList.get(22));
			id0203.setText("020203");
			setHouseColor(status0204,houseStatusList.get(23));
			id0204.setText("020204");
			setHouseColor(status0301,houseStatusList.get(24));
			id0301.setText("020301");
			setHouseColor(status0302,houseStatusList.get(25));
			id0302.setText("020302");
			setHouseColor(status0303,houseStatusList.get(26));
			id0303.setText("020303");
			setHouseColor(status0304,houseStatusList.get(27));
			id0304.setText("020304");
			setHouseColor(status0401,houseStatusList.get(28));
			id0401.setText("020401");
			setHouseColor(status0402,houseStatusList.get(29));
			id0402.setText("020402");
			setHouseColor(status0403,houseStatusList.get(30));
			id0403.setText("020403");
			setHouseColor(status0404,houseStatusList.get(31));
			id0404.setText("020404");
		}
		else if(arg0.getSource() == button) { //添加用户
			String name = Username.getText();
			String pwd = Userpassword.getText();
			String sex = Usersex.getText();
			String phone = Userphone.getText();
			String mail = Usermail.getText();
			String roomId = Userid.getText();
			adminoperation.addUser(name, sex , pwd, phone, mail, roomId);
		}
		else if(arg0.getSource() == button_1) { //添加用户时重置按钮
			Username.setText("");
			Userpassword.setText("");
			Usersex.setText("");
			Userphone.setText("");
			Usermail.setText("");
			Userid.setText("");
		}
		else if(arg0.getSource() == button_5) { //删除用户键
			String roomId = textField_1.getText();
			adminoperation.delUser(roomId);
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			lblNewLabel_7.setText("成功删除");
		}
		else if(arg0.getSource() == sureToModifyAdminInfo) {
			if(NewPassword.getText().equals(SurePassword.getText())) {
				adminoperation.modifyAdminInfo(adminName.getText(), NewPassword.getText(), adminPhone.getText(), adminmail.getText());
				lblNewLabel_8.setText("修改成功");
			}
			else {
				lblNewLabel_8.setText("两次密码不一致");
			}
		}
		else if(arg0.getSource() ==button_6) {//确认修改物业费
			Double newPrice;
			newPrice = Double.valueOf(textField_18.getText()).doubleValue();
			systemoperation.modifyPrice(1,newPrice);
			label_25.setText("您修改的物业价格下月开始生效");
			textField_18.setText("");
		}
		else if(arg0.getSource() == button_7) {
			String id;
			Vector<residentInfo> allUser = new Vector();
			allUser = adminoperation.rankDebt();//得到全部用户对象
			calculateFee calculate = new calculateFee();
			for(int i=0;i<allUser.size();i++) {
				id = allUser.get(i).getUserRoomId();
				calculate.addFeeAndModifyInfo(id);
			}
		}
		else if(arg0.getSource() == button_4) { //删除住户，首先显示相关信息
			String roomId = textField_1.getText();
			residentInfo resident = new residentInfo();
			creditInfo credit = new creditInfo();
			try {
				credit = creditoperation.findCreditInfo(roomId);
				resident = residentoperation.findRoomId(roomId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resident.getUserName()!=null) {
			
				textField_2.setText(resident.getUserName());
				textField_3.setText(resident.getUserRoomId());
				if(credit.getStatus()==true) {
					textField_4.setText("欠费");
				}
				else {
					textField_4.setText("无欠费");
				}
				panel_2.add(textField_4);
				
			}
			else {
				lblNewLabel_7.setText("输入有误");
			}
			
		}
		else if(arg0.getSource()==button_3) { //显示按欠费金额排序
			//sasasa
			scrollPane = new JScrollPane();
			scrollPane.setBounds(100,129, 528, 329);
			Vector<residentInfo> resident =new Vector();
			Vector Alldate = new Vector();
			Vector columnNames = new Vector();
			columnNames.add("姓名");
			columnNames.add("房号");
			columnNames.add("欠费金额");
			resident = adminoperation.rankDebt();
			for(int i=0;i<resident.size();i++) {
				Vector date = new Vector();
				date.add(resident.get(i).getUserName());
				date.add(resident.get(i).getUserRoomId());
				date.add(resident.get(i).getUserDebt());
				System.out.println(date);
				Alldate.add(date);
			}
			System.out.println(Alldate);
			table_1 = new JTable(Alldate,columnNames);
			scrollPane.setViewportView(table_1);
			findByDebtConditionPanel.add(scrollPane);
		}
		else if(arg0.getSource()==button_2) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(100,129, 528, 329);
			Vector<creditInfo> resident =new Vector();
			Vector Alldate = new Vector();
			Vector columnNames = new Vector();
			columnNames.add("姓名");
			columnNames.add("房号");
			columnNames.add("欠费日期");
			try {
				resident = adminoperation.rankDebtTime();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(int i=0;i<resident.size();i++) {
				Vector date = new Vector();
				date.add(resident.get(i).getName());
				date.add(resident.get(i).getRoomId());
				date.add(resident.get(i).getDebtTime());
				System.out.println(date);
				Alldate.add(date);
			}
			System.out.println(Alldate);
			table_1 = new JTable(Alldate,columnNames);
			scrollPane.setViewportView(table_1);
			findByDebtConditionPanel.add(scrollPane);
		}
		else if(arg0.getSource()==findUserRoomBtn) { //按房间号查找住户信息
			String roomId = textField.getText();
			residentInfo resident = new residentInfo();
			creditInfo credit = new creditInfo();
			String Stage;
			try {
				credit = creditoperation.findCreditInfo(roomId);
				resident = residentoperation.findRoomId(roomId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(resident.getUserName()!=null) {
				textField_5.setText(resident.getUserName());
				textField_6.setText(resident.getUserSex());
				textField_7.setText(resident.getUserPwd());
				textField_8.setText(resident.getUserPhone());
				textField_9.setText(resident.getUserMail());
				textField_10.setText(resident.getUserDebt()+"");
				textField_11.setText(resident.getUserEditScore()+"");
				textField_12.setText(resident.getUserRoomId());
				textField_13.setText(credit.getRank()+"");
				if(credit.getCreditStage() == 2) {
					Stage = "良好";
				}
				else if(credit.getCreditStage() == 3) {
					Stage = "优秀";
				}
				else if(credit.getCreditStage() == 4) {
					Stage = "极佳";
				}
				else{
					Stage = "不佳，有待提高";
				}
				textField_14.setText(Stage);
				if(credit.getStatus()==true)
				{
					textField_15.setText("欠费");
				}else {
					textField_15.setText("无欠费");
				}
				textField_16.setText(credit.getDebtTime());
			}else {
				lblNewLabel_9.setText("输入房间号错误，或者该房间号没有人居住");
			}
		}
	}
	public void setHouseColor(JLabel label, houseInfo house) { //设置不同楼号对应label信息
		creditInfo credit = new creditInfo();
		creditInfoOperation creditoperation = new creditInfoOperation();
		if(house.getHouseEmptyOrNot()==1) {
			System.out.println(house.getHouseId());
			System.out.println(house.getHouseEmptyOrNot());
			label.setBackground(new Color(192, 192, 192)); //灰色没有住人
		}
		else {
			try {
				credit = creditoperation.findCreditInfo(house.getHouseId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			if(credit.getStatus()==true) {
				label.setBackground(new Color(255, 0, 0));
			}else {
				label.setBackground(new Color(0, 255, 0));
			}
		}
		
	}
}

