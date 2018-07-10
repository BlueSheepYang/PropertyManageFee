package com.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;

public class indexTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					indexTest window = new indexTest();
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
	public indexTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Font font1=new Font("宋体",Font.PLAIN,30);
		Font font2=new Font("仿宋",Font.PLAIN,15);

		frame = new JFrame();
		frame.getContentPane().setLayout(null);
		
		CardLayout Cardpanel = new CardLayout();
		
		JPanel cardPanelFather = new JPanel(Cardpanel);
		cardPanelFather.setLayout(null);
		cardPanelFather.setBounds(130, 86, 664, 374);
		frame.getContentPane().add(cardPanelFather);
		
		Vector columnNames = new Vector();
		columnNames.add("房号");
		columnNames.add("姓名");
		columnNames.add("信誉分");
		Vector rowData = new Vector();
		Vector hang = new Vector();
		Vector hang1 = new Vector();
		Vector hang2 = new Vector();
		hang1.add("1033");
		hang1.add("胡洋1");
		hang1.add("100");
		rowData.add(hang1);
		hang2.add("3");
		hang2.add("胡洋2");
		hang2.add("22");
		rowData.add(hang2);
		hang.add("1");
		hang.add("胡洋");
		hang.add("20");
		rowData.add(hang);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		
		
		panel_2.setBounds(0, 0, 664, 374);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 670, 374);
		panel_2.add(scrollPane);
		
		JTable table_1 = new JTable(rowData,columnNames);
		table_1.getColumnModel().getColumn(1).setPreferredWidth(100);
		scrollPane.setViewportView(table_1);
		cardPanelFather.add(panel_2);
		
		frame.setLocation(100,100);
		frame.setSize(800, 578);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
