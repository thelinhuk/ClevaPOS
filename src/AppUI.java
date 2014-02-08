import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.EventQueue;
	





import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
	





import java.awt.GridLayout;
	





import javax.swing.JButton;
import javax.swing.ImageIcon;
	





import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
	





import javax.swing.SwingConstants;
	





import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
	





import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.CompoundBorder;
	





import java.awt.Color;
import java.awt.Font;
	





import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JTabbedPane;
	





import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
	





import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
	





import java.sql.Time;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.awt.SystemColor;
	



import org.freixas.jcalendar.DateEvent;
import org.freixas.jcalendar.DateListener;
import org.freixas.jcalendar.JCalendar;
import org.freixas.jcalendar.JCalendarCombo;

import javax.swing.ListSelectionModel;

import java.awt.Choice;
import java.io.File;
import java.io.IOException;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.AbstractListModel;
import javax.swing.JSplitPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
	//import jpos.*;
	
	
	
	
	public class AppUI extends JFrame implements ActionListener, DateListener{
	
		private JPanel contentPane;
		private JTextField txtSearch;
		private JTextField txtPaid;
		private static final int TIMER_DELAY = 1000;
		private int counter;
		private JButton btnFind;
		private JButton btnLogin;
		private JButton btnOne, btnTwo,btnThree, btnFour, btnFive, btnSix, 
				btnSeven, btnEight, btnNine,btnFivePnd,btnZero,btnLogout,
				btnDelete,btnClear,btnTenPnd,btnTwentyPnd,btnFiftyPnd;
		private JButton btnDot;
		private JButton btnListItems;
		private boolean isSwitch;
		private DBQuery dbQuery;
		private String isPaid;
		private JTable table;
		private static DefaultTableModel model;
		private JScrollPane scrollPane;
		private JButton btnEnter;
		private JLabel lblDateTime;
		final DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		private JTextField txtCustomerID;
		private ArrayList item,tableItems;
		private static ArrayList price;
		static JLabel lblTotal;
		static Calculator calculator;
		static float total;
		private JButton btnRemove,btnResetDate;
		
		private TextPrompt tp;
		private static float totAfterDiscount, totAfterDiscountGo ;
		private static int p = 30;
		private JButton btnDiscount;
		private JTextField txtUserID;
		private JLabel lblCashGiven;
		private JLabel lblChange;
		//private Print print;
		
		private float change;
		private Calendar now;
		private JButton btnPay;
		private Print printTransaction;
		private static float discountPercentAmount;
		private static float discountGrouponAmount;
	
		private static ArrayList itemID = new ArrayList();
		private ArrayList itemName;
		private ArrayList column;
		private ArrayList values;
		private String staffID;
		private String shopID;
		private String customerID;
		private DBQuery InsertItem;
		private static double discount;
		private float totalPrice; 
		private String uniqueID;
		private String discountType;
		private JTextField txtDate;
		private JCalendar calendar;
		private JList list;
		private JPanel panel_31;
		private JList list_2;
		private JLabel lblNewLabel_1;
		private JPanel panel_34;
		private JList list_3;
		private JLabel lblNewLabel_2;
		private JPanel panel_35;
		private JPanel panel_36;
		private JTabbedPane tabbedPane_1;
		private JPanel panel_37;
		private JTextField txtCustomerName;
		private JTextField txtPhoneNumber;
		JComboBox cmbNumberofPeople, cmbAppointmentTime;
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						AppUI frame = new AppUI();
						frame.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	
		/**
		 * Create the frame.
		 */
		public AppUI() {
			
			change = 0;
			shopID = "001";
			uniqueID = "";
			
			price = new ArrayList();
			itemID = new ArrayList();
			itemName = new ArrayList();
			calculator = new Calculator();
			price = new ArrayList();
			calculator = new Calculator();
			setUndecorated(true);
			counter = 201;
			isSwitch = false;
			isPaid = "";
			total = 0;
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(0, 0, 1440, 900);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setBackground(new Color(45, 50, 61));
			setContentPane(contentPane);
			contentPane.setLayout(new GridLayout(0, 1, 0, 0));
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 32));
			contentPane.add(tabbedPane);
			
			JPanel panel = new JPanel();
			tabbedPane.addTab("New tab", null, panel, null);
			panel.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(45, 50, 61));
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JPanel panel_22 = new JPanel();
			panel_22.setBackground(new Color(45, 50, 61));
			panel_22.setBounds(0, 0, 665, 55);
			panel_1.add(panel_22);
			panel_22.setLayout(null);
			
			txtCustomerID = new JTextField();
			tp = new TextPrompt("Customer ID", txtCustomerID );
			tp.setFont(new Font("Tahoma", Font.BOLD, 24));
			tp.setHorizontalAlignment(SwingConstants.CENTER);
			tp.setForeground(Color.LIGHT_GRAY);
			txtCustomerID.setToolTipText("Customer ID");
			txtCustomerID.setFont(new Font("Tahoma", Font.BOLD, 24));
			txtCustomerID.setBounds(1, 2, 256, 53);
			txtCustomerID.setHorizontalAlignment(SwingConstants.CENTER);
			panel_22.add(txtCustomerID);
			txtCustomerID.setColumns(10);
			txtCustomerID.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					//TODO Auto-generated method stub
					isPaid = "customerID";	
				}
				@Override
				public void focusLost(FocusEvent e) {
					
				}
			});
			
			btnFind = new JButton("Add");
			btnFind.setBounds(589, -1, 77, 58);
			panel_22.add(btnFind);
			btnFind.setForeground(Color.WHITE);
			btnFind.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnFind.setBackground(new Color(44, 91, 166));
			btnFind.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			
			txtSearch = new JTextField();
			txtSearch.setBounds(330, 2, 260, 52);
			tp = new TextPrompt("Item ID", txtSearch );
			tp.setFont(new Font("Tahoma", Font.BOLD, 24));
			tp.setHorizontalAlignment(SwingConstants.CENTER);
			tp.setForeground(Color.LIGHT_GRAY);
			panel_22.add(txtSearch);
			txtSearch.setHorizontalAlignment(SwingConstants.CENTER);
			txtSearch.setFont(new Font("Tahoma", Font.BOLD, 24));
			txtSearch.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					//TODO Auto-generated method stub
					isPaid = "Search";	
				}
				@Override
				public void focusLost(FocusEvent e) {
					
				}
			});
			txtSearch.setColumns(10);
			btnFind.addActionListener(this);
			
			JPanel panel_23 = new JPanel();
			panel_23.setBounds(0, 60, 665, 451);
			panel_23.setBackground(new Color(45, 50, 61));
			panel_1.add(panel_23);
			GridBagLayout gbl_panel_23 = new GridBagLayout();
			gbl_panel_23.columnWidths = new int[]{667, 0};
			gbl_panel_23.rowHeights = new int[]{397, 67, 0};
			gbl_panel_23.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_23.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_23.setLayout(gbl_panel_23);
			
			JPanel panel_24 = new JPanel();
			GridBagConstraints gbc_panel_24 = new GridBagConstraints();
			gbc_panel_24.insets = new Insets(0, 0, 5, 0);
			gbc_panel_24.fill = GridBagConstraints.BOTH;
			gbc_panel_24.gridx = 0;
			gbc_panel_24.gridy = 0;
			panel_23.add(panel_24, gbc_panel_24);
			
			model = new DefaultTableModel();
			table = new JTable(model);
			table.setSurrendersFocusOnKeystroke(true);
			table.setShowGrid(false);
			table.setShowHorizontalLines(false);
			table.setShowVerticalLines(false);
			table.setFont(new Font("Tahoma", Font.BOLD, 20));
			table.setRowHeight(50);
			scrollPane = new JScrollPane(table);
			DefaultTableCellRenderer centerRender = new DefaultTableCellRenderer();
			centerRender.setHorizontalAlignment(JLabel.RIGHT);
			model.addColumn("Item");
			model.addColumn("Price");
			table.getColumnModel().getColumn(1).setCellRenderer(centerRender);
			table.getColumn("Item").setPreferredWidth(450);
			
			
			panel_24.setLayout(new BorderLayout(0, 0));
			panel_24.add(scrollPane);
			
			lblTotal = new JLabel("Total:");
			GridBagConstraints gbc_lblTotal = new GridBagConstraints();
			gbc_lblTotal.gridx = 0;
			gbc_lblTotal.gridy = 1;
			panel_23.add(lblTotal, gbc_lblTotal);
			lblTotal.setFont(new Font("Tahoma", Font.BOLD, 27));
			lblTotal.setBackground(new Color(45, 50, 61));
			lblTotal.setForeground(Color.WHITE);
			lblTotal.setHorizontalAlignment(SwingConstants.CENTER);
			
			JPanel panel_28 = new JPanel();
			panel_28.setBounds(0, 512, 669, 154);
			panel_28.setBackground(new Color(45, 50, 61));
			panel_28.setLayout(null);
			panel_1.add(panel_28);
			
			btnRemove = new JButton("Remove");
			btnRemove.setBounds(0, 76, 338, 80);
			panel_28.add(btnRemove);
			btnRemove.setForeground(Color.WHITE);
			btnRemove.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnRemove.setBackground(new Color(44, 91, 166));
			btnRemove.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnRemove.addActionListener(this);
			
			btnListItems = new JButton("List Items");
			btnListItems.setBounds(0, 0, 338, 76);
			panel_28.add(btnListItems);
			btnListItems.addActionListener(this);
			btnListItems.setForeground(Color.WHITE);
			btnListItems.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnListItems.setBackground(new Color(44, 91, 166));
			btnListItems.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			
			btnDiscount = new JButton("Discount");
			btnDiscount.setBounds(337, 76, 329, 79);
			panel_28.add(btnDiscount);
			btnDiscount.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnDiscount.setForeground(Color.WHITE);
			btnDiscount.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnDiscount.setBackground(new Color(44, 91, 166));
			btnDiscount.addActionListener(this);
			
			//test
			
			btnPay = new JButton("Pay");
			btnPay.setEnabled(false);
			btnPay.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnPay.setForeground(Color.WHITE);
			btnPay.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnPay.setBackground(new Color(44, 91, 166));
			btnPay.addActionListener(this);
			btnPay.setBounds(337, 0, 329, 76);
			panel_28.add(btnPay);
			
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(45, 50, 61));
			panel.add(panel_2);
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0};
			gbl_panel_2.rowHeights = new int[] {60, 140, 30, 30, 30, 30, 30, 30, 30, 0};
			gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			
			JPanel panel_5 = new JPanel();
			panel_5.setBackground(new Color(45, 50, 61));
			GridBagConstraints gbc_panel_5 = new GridBagConstraints();
			gbc_panel_5.insets = new Insets(0, 0, 5, 0);
			gbc_panel_5.fill = GridBagConstraints.BOTH;
			gbc_panel_5.gridx = 0;
			gbc_panel_5.gridy = 0;
			panel_2.add(panel_5, gbc_panel_5);
			panel_5.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_15 = new JPanel();
			panel_15.setBackground(new Color(45, 50, 61));
			panel_5.add(panel_15);
			panel_15.setLayout(null);
			
			btnLogin = new JButton("Login");
			btnLogin.setBounds(552, 0, 114, 59);
			btnLogin.setForeground(Color.WHITE);
			btnLogin.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnLogin.setBackground(new Color(44, 91, 166));
			btnLogin.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnLogin.addActionListener(this);
			panel_15.add(btnLogin);
			
			btnLogout = new JButton("Logout");
			btnLogout.setBounds(439, 0, 116, 57);
			btnLogout.setForeground(Color.WHITE);
			btnLogout.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnLogout.setBackground(new Color(44, 91, 166));
			btnLogout.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnLogout.addActionListener(this);
			panel_15.add(btnLogout);
			
			lblDateTime = new JLabel("00/00/0000 00:00:00");
			lblDateTime.setOpaque(true);
			lblDateTime.setBackground(new Color(119, 136, 153));
			lblDateTime.setBounds(2, 3, 244, 51);
			panel_15.add(lblDateTime);
			lblDateTime.setForeground(Color.WHITE);
			lblDateTime.setFont(new Font("Tahoma", Font.PLAIN, 24));
			lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);
			
			txtUserID = new JTextField();
			tp = new TextPrompt("User ID", txtUserID );
			tp.setFont(new Font("Tahoma", Font.BOLD, 24));
			tp.setHorizontalAlignment(SwingConstants.CENTER);
			tp.setForeground(Color.LIGHT_GRAY);
			txtUserID.setBounds(247, 3, 193, 51);
			txtUserID.setHorizontalAlignment(SwingConstants.CENTER);
			txtUserID.setFont(new Font("Tahoma", Font.BOLD, 24));
			panel_15.add(txtUserID);
			txtUserID.setColumns(10);
			txtUserID.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					isPaid = "UserID";
				}
				@Override
				public void focusLost(FocusEvent e) {}			
			});
			
			JPanel panel_12 = new JPanel();
			GridBagConstraints gbc_panel_12 = new GridBagConstraints();
			gbc_panel_12.insets = new Insets(0, 0, 5, 0);
			gbc_panel_12.fill = GridBagConstraints.BOTH;
			gbc_panel_12.gridx = 0;
			gbc_panel_12.gridy = 1;
			panel_2.add(panel_12, gbc_panel_12);
			panel_12.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_16 = new JPanel();
			panel_16.setBackground(Color.WHITE);
			panel_16.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			panel_12.add(panel_16);
			panel_16.setLayout(new GridLayout(2, 0, 0, 0));
			
			JPanel panel_18 = new JPanel();
			panel_18.setBackground(new Color(45, 50, 61));
			panel_16.add(panel_18);
			panel_18.setLayout(null);
			
			lblCashGiven = new JLabel("Cash Payed");
			lblCashGiven.setBounds(94, 0, 150, 63);
			lblCashGiven.setForeground(Color.WHITE);
			lblCashGiven.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblCashGiven.setBackground(new Color(44, 91, 166));
			panel_18.add(lblCashGiven);
			
			JLabel lblChangeDue = new JLabel("Change");
			lblChangeDue.setForeground(Color.WHITE);
			lblChangeDue.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblChangeDue.setBackground(new Color(44, 91, 166));
			lblChangeDue.setBounds(460, 0, 103, 63);
			panel_18.add(lblChangeDue);
			
			JPanel panel_17 = new JPanel();
			panel_16.add(panel_17);
			panel_17.setLayout(new GridLayout(0, 2, 0, 0));
			
			JPanel panel_19 = new JPanel();
			panel_17.add(panel_19);
			panel_19.setLayout(null);
			
			txtPaid = new JTextField();
			txtPaid.setText("0.00");
			txtPaid.setHorizontalAlignment(SwingConstants.CENTER);
			txtPaid.setFont(new Font("Tahoma", Font.BOLD, 26));
			txtPaid.setBounds(-1, 0, 355, 66);
			txtPaid.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					// TODO Auto-generated method stub
					isPaid = "Paid";
				}
				@Override
				public void focusLost(FocusEvent e) {}			
			});
			panel_19.add(txtPaid);
			txtPaid.setColumns(10);
			
			JPanel panel_20 = new JPanel();
			panel_20.setBackground(new Color(119, 136, 153));
			//panel_.setBackground(new Color(45, 50, 61));
			panel_17.add(panel_20);
			panel_20.setLayout(null);
			
			lblChange = new JLabel("0.00");
			lblChange.setForeground(Color.WHITE);
			lblChange.setFont(new Font("Tahoma", Font.BOLD, 24));
			lblChange.setBackground(new Color(44, 91, 166));
			lblChange.setBounds(98, 2, 184, 64);
			panel_20.add(lblChange);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBorder(null);
			panel_3.setBackground(new Color(45, 50, 51));
			GridBagConstraints gbc_panel_3 = new GridBagConstraints();
			gbc_panel_3.gridheight = 7;
			gbc_panel_3.fill = GridBagConstraints.BOTH;
			gbc_panel_3.gridx = 0;
			gbc_panel_3.gridy = 2;
			panel_2.add(panel_3, gbc_panel_3);
			panel_3.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_4 = new JPanel();
			panel_3.add(panel_4);
			
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			panel_4.setBackground(new Color(45, 50, 51));
			gbl_panel_4.columnWidths = new int[]{50, 44, 0, 0};
			gbl_panel_4.rowHeights = new int[]{0, 0};
			gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
			panel_4.setLayout(gbl_panel_4);
			
			JPanel panel_6 = new JPanel();
			GridBagConstraints gbc_panel_6 = new GridBagConstraints();
			gbc_panel_6.gridwidth = 3;
			gbc_panel_6.fill = GridBagConstraints.BOTH;
			gbc_panel_6.gridx = 0;
			gbc_panel_6.gridy = 0;
			panel_4.add(panel_6, gbc_panel_6);
			panel_6.setLayout(new GridLayout(0, 1, 0, 0));
			
			JPanel panel_7 = new JPanel();
			panel_7.setBackground(new Color(45, 50, 51));
			panel_6.add(panel_7);
			panel_7.setLayout(new GridLayout(6, 0, 0, 0));
			
			JPanel panel_14 = new JPanel();
			panel_14.setBackground(new Color(45, 50, 61));
			panel_7.add(panel_14);
			panel_14.setLayout(new GridLayout(0, 2, 0, 0));
			
			btnClear = new JButton("Clear");
			btnClear.setSelectedIcon(new ImageIcon("E:\\POS_Button_Icons\\deleteIcon.png"));
			btnClear.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnClear.setForeground(Color.WHITE);
			btnClear.setBackground(new Color(44, 91, 166));
			btnClear.setIcon(new ImageIcon("E:\\POS_Button_Icons\\clearIcon.png"));
			btnClear.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnClear.addActionListener(this);
			panel_14.add(btnClear);
			
			btnDelete = new JButton("Delete");
			btnDelete.setSelectedIcon(new ImageIcon("E:\\POS_Button_Icons\\deleteIcon.png"));
			btnDelete.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnDelete.setForeground(Color.WHITE);
			btnDelete.setBackground(new Color(44, 91, 166));
			btnDelete.setIcon(new ImageIcon("E:\\POS_Button_Icons\\clearIcon.png"));
			btnDelete.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnDelete.addActionListener(this);
			panel_14.add(btnDelete);
			
			JPanel panel_13 = new JPanel();
			panel_13.setBackground(new Color(45, 50, 61));
			panel_7.add(panel_13);
			panel_13.setLayout(new GridLayout(0, 4, 0, 0));
			
			btnOne = new JButton("1");
			btnOne.setForeground(Color.WHITE);
			btnOne.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnOne.setBackground(new Color(27, 188, 155));
			btnOne.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnOne.addActionListener(this);
			panel_13.add(btnOne);
			
			btnTwo = new JButton("2");
			btnTwo.setForeground(Color.WHITE);
			btnTwo.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnTwo.setBackground(new Color(27, 188, 155));
			btnTwo.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnTwo.addActionListener(this);
			panel_13.add(btnTwo);
			
			
			btnThree = new JButton("3");
			btnThree.setForeground(Color.WHITE);
			btnThree.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnThree.setBackground(new Color(27, 188, 155));
			btnThree.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnThree.addActionListener(this);
			panel_13.add(btnThree);
			
			btnFivePnd = new JButton("£ 5");
			btnFivePnd.setForeground(Color.WHITE);
			btnFivePnd.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnFivePnd.setBackground(new Color(44, 91, 166));
			btnFivePnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnFivePnd.addActionListener(this);
			panel_13.add(btnFivePnd);
			
			JPanel panel_9 = new JPanel();
			panel_9.setBackground(new Color(45, 50, 51));
			panel_7.add(panel_9);
			panel_9.setLayout(new GridLayout(0, 4, 0, 0));
			
			btnFour = new JButton("4");
			btnFour.setForeground(Color.WHITE);
			btnFour.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnFour.setBackground(new Color(27, 188, 155));
			btnFour.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnFour.addActionListener(this);
			panel_9.add(btnFour);
			
			btnFive = new JButton("5");
			btnFive.setForeground(Color.WHITE);
			btnFive.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnFive.setBackground(new Color(27, 188, 155));
			btnFive.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnFive.addActionListener(this);
			panel_9.add(btnFive);
			
			btnSix = new JButton("6");
			btnSix.setForeground(Color.WHITE);
			btnSix.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnSix.setBackground(new Color(27, 188, 155));
			btnSix.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnSix.addActionListener(this);
			panel_9.add(btnSix);
			
			btnTenPnd = new JButton("£ 10");
			btnTenPnd.setForeground(Color.WHITE);
			btnTenPnd.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnTenPnd.setBackground(new Color(44, 91, 166));
			btnTenPnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnTenPnd.addActionListener(this);
			panel_9.add(btnTenPnd);
			
			JPanel panel_11 = new JPanel();
			panel_11.setBackground(new Color(45, 50, 51));
			panel_7.add(panel_11);
			panel_11.setLayout(new GridLayout(0, 4, 0, 5));
			
			btnSeven = new JButton("7");
			btnSeven.setForeground(Color.WHITE);
			btnSeven.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnSeven.setBackground(new Color(27, 188, 155));
			btnSeven.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnSeven.addActionListener(this);
			panel_11.add(btnSeven);
			
			btnEight = new JButton("8");
			btnEight.setForeground(Color.WHITE);
			btnEight.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnEight.setBackground(new Color(27, 188, 155));
			btnEight.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnEight.addActionListener(this);
			panel_11.add(btnEight);
			
			btnNine = new JButton("9");
			btnNine.setForeground(Color.WHITE);
			btnNine.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnNine.setBackground(new Color(27, 188, 155));
			btnNine.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnNine.addActionListener(this);
			panel_11.add(btnNine);
			
			btnTwentyPnd = new JButton("£ 20");
			btnTwentyPnd.setForeground(Color.WHITE);
			btnTwentyPnd.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnTwentyPnd.setBackground(new Color(44, 91, 166));
			btnTwentyPnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnTwentyPnd.addActionListener(this);
			panel_11.add(btnTwentyPnd);
			
			JPanel panel_10 = new JPanel();
			panel_10.setBackground(new Color(45, 50, 51));
			panel_7.add(panel_10);
			panel_10.setLayout(null);
			
			btnZero = new JButton("0");
			btnZero.setBounds(0, 0, 177, 85);
			btnZero.setForeground(Color.WHITE);
			btnZero.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnZero.setBackground(new Color(27, 188, 155));
			btnZero.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnZero.addActionListener(this);
			panel_10.add(btnZero);
			
			btnDot = new JButton(".");
			btnDot.setBounds(178, 0, 356, 85);
			btnDot.setForeground(Color.WHITE);
			btnDot.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnDot.setBackground(new Color(27, 188, 155));
			btnDot.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnDot.addActionListener(this);
			panel_10.add(btnDot);
			
			btnFiftyPnd = new JButton("£ 50");
			btnFiftyPnd.setBounds(534, 0, 178, 85);
			btnFiftyPnd.setForeground(Color.WHITE);
			btnFiftyPnd.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnFiftyPnd.setBackground(new Color(44, 91, 166));
			btnFiftyPnd.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnFiftyPnd.addActionListener(this);
			panel_10.add(btnFiftyPnd);
			
			JPanel panel_8 = new JPanel();
			panel_7.add(panel_8);
			panel_8.setLayout(new GridLayout(0, 1, 0, 0));
			
			btnEnter = new JButton("ENTER");
			btnEnter.setForeground(Color.WHITE);
			btnEnter.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnEnter.setBackground(new Color(44, 91, 166));
			btnEnter.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			panel_8.add(btnEnter);
			btnEnter.addActionListener(this);
			
			JPanel panel_21 = new JPanel();
			tabbedPane.addTab("New tab", null, panel_21, null);
			panel_21.setLayout(null);
			
		    calendar = new JCalendar();
		    calendar.setDayOfWeekFont(new Font("Dialog", Font.BOLD, 12));
		    calendar.setBorder(null);
			calendar.setBackground(Color.WHITE);
			calendar.addDateListener(this);
			calendar.setBounds(10, 8, 438, 277);
			panel_21.add(calendar);
			
			btnResetDate = new JButton("Reset Date");
			
			btnResetDate.setBounds(498, 232, 125, 51);
			btnResetDate.addActionListener(this);
			
			panel_21.add(btnResetDate);
			
			String	listData[] =
				{
					"Item 1 sdd dddddd ddddddd dddd ddddddddddd dddddddddddd ddddd dddd ddddfds",
					"Item 2", 
					"Item 3",
					"Item 4"
				};
			
			JButton btnNewButton = new JButton("Submit");
			btnNewButton.setBounds(628, 232, 125, 51);
			panel_21.add(btnNewButton);
			
			panel_36 = new JPanel();
			panel_36.setBounds(0, 0, 10, 10);
			panel_21.add(panel_36);
			
			tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane_1.setBorder(new EmptyBorder(0, 0, 0, 0));
			tabbedPane_1.setBounds(10, 287, 1405, 550);
			panel_21.add(tabbedPane_1);
			
			panel_37 = new JPanel();
			panel_37.setBorder(new EmptyBorder(0, 0, 0, 0));
			tabbedPane_1.addTab("New tab", null, panel_37, null);
			panel_37.setLayout(null);
			
			JPanel panel_25 = new JPanel();
			panel_25.setBounds(0, 0, 282, 532);
			panel_37.add(panel_25);
			panel_25.setLayout(null);
			
			JPanel panel_33 = new JPanel();
			panel_33.setBounds(-1, 1, 250, 133);
			panel_25.add(panel_33);
			panel_33.setLayout(null);
			
			list = new JList(listData);
			list.setBounds(0, 17, 255, 114);
			panel_33.add(list);
			list.setFont(new Font("Tahoma", Font.PLAIN, 14));
			list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list.setBackground(Color.WHITE);
			list.setListData(listData);
			
			JLabel lblNewLabel = new JLabel("9.00");
			lblNewLabel.setBounds(1, 0, 222, 16);
			panel_33.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			panel_31 = new JPanel();
			panel_31.setBounds(0, 134, 250, 132);
			panel_25.add(panel_31);
			panel_31.setLayout(null);
			
			list_2 = new JList(listData);
			list_2.setBounds(-1, 20, 225, 114);
			panel_31.add(list_2);
			
			lblNewLabel_1 = new JLabel("9.15");
			lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_1.setBounds(1, 1, 224, 16);
			panel_31.add(lblNewLabel_1);
			
			panel_34 = new JPanel();
			panel_34.setBounds(-1, 265, 220, 132);
			panel_25.add(panel_34);
			panel_34.setLayout(null);
			list_3 = new JList(listData);
			list_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
			list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list_3.setListData(listData);
			list_3.setBounds(0, 17, 219, 114);
			panel_34.add(list_3);
			
			lblNewLabel_2 = new JLabel("9.30");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 11));
			lblNewLabel_2.setBounds(2, -1, 225, 16);
			panel_34.add(lblNewLabel_2);
			
			panel_35 = new JPanel();
			panel_35.setBounds(0, 397, 220, 131);
			panel_25.add(panel_35);
			panel_35.setLayout(null);
			
			JList list_4 = new JList();
			list_4.setBounds(1, 18, 218, 114);
			list_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			list_4.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			list_4.setListData(listData);
			panel_35.add(list_4);
			
			JLabel lblNewLabel_3 = new JLabel("9.45");
			lblNewLabel_3.setBounds(1, 0, 217, 16);
			panel_35.add(lblNewLabel_3);
			lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 11));
			
			txtCustomerName = new JTextField();
			tp = new TextPrompt("Customer name", txtCustomerName);
			tp.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tp.setHorizontalAlignment(SwingConstants.LEADING);
			tp.setForeground(Color.LIGHT_GRAY);
			txtCustomerName.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtCustomerName.setBounds(498, 42, 224, 34);
			panel_21.add(txtCustomerName);
			txtCustomerName.setColumns(10);
			txtCustomerName.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					keyboardShow();
				}
				@Override
				public void focusLost(FocusEvent e) {
					keyboardHide();
				}
			});
			
			txtDate = new JTextField();
			tp = new TextPrompt("Select a date from calendar", txtDate);
			tp.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tp.setHorizontalAlignment(SwingConstants.LEADING);
			tp.setForeground(Color.LIGHT_GRAY);
			txtDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtDate.setBounds(498, 78, 254, 34);
			panel_21.add(txtDate);
			txtDate.setColumns(10);
			
			txtPhoneNumber = new JTextField();
			tp = new TextPrompt("Cuatomer's phone number", txtPhoneNumber);
			tp.setFont(new Font("Tahoma", Font.PLAIN, 16));
			tp.setHorizontalAlignment(SwingConstants.LEADING);
			tp.setForeground(Color.LIGHT_GRAY);
			txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 16));
			txtPhoneNumber.setColumns(10);
			txtPhoneNumber.setBounds(498, 152, 224, 34);
			panel_21.add(txtPhoneNumber);
			txtPhoneNumber.addFocusListener(new FocusListener(){
				@Override
				public void focusGained(FocusEvent arg0) {
					keyboardShow();
				}
				@Override
				public void focusLost(FocusEvent e) {
					keyboardHide();
				}
			});

			cmbAppointmentTime = new JComboBox();
			cmbAppointmentTime.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cmbAppointmentTime.setModel(new DefaultComboBoxModel(new String[] {"Select a time", "9.00 AM", "9.15 AM", "9.30 AM", "9.45 AM", "10.00 AM"}));
			cmbAppointmentTime.setBounds(498, 114, 134, 35);
			panel_21.add(cmbAppointmentTime);
			
			cmbNumberofPeople = new JComboBox();
			cmbNumberofPeople.setModel(new DefaultComboBoxModel(new String[] {"No. of people", "1 Person", "2 People", "3 People", "4 People", "5 People"}));
			cmbNumberofPeople.setFont(new Font("Tahoma", Font.PLAIN, 16));
			cmbNumberofPeople.setBounds(498, 188, 134, 34);
			panel_21.add(cmbNumberofPeople);
			
			JLabel lblNewLabel_4 = new JLabel("Booking details");
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_4.setBounds(498, 8, 224, 34);
			panel_21.add(lblNewLabel_4);
			Border emptyBorder = BorderFactory.createEmptyBorder();
		    javax.swing.Timer timer = new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
		        public void actionPerformed(ActionEvent arg0) {
		        	counter++;
		        	if(counter > 200){
		        		isSwitch = true;
		        		if(isSwitch){
		        			btnFind.setEnabled(false);
		        			btnDot.setEnabled(false);
		        			btnFivePnd.setEnabled(false);
		        			btnTenPnd.setEnabled(false);
		        			btnTwentyPnd.setEnabled(false);
		        			btnFiftyPnd.setEnabled(false);
		        			btnEnter.setEnabled(false);
		        			btnRemove.setEnabled(false);
		        			btnListItems.setEnabled(false);
		        			btnRemove.setEnabled(false);
		        			btnDiscount.setEnabled(false);
		        			btnLogout.setEnabled(false);
		        			btnPay.setEnabled(false);
		        			btnLogin.setEnabled(true);
		        			counter = 0;	
		        		}	
		        	}
		        }
	
		      });
		    timer.start();
		    
		    javax.swing.Timer timer2 = new javax.swing.Timer(TIMER_DELAY, new ActionListener() {
		    	public void actionPerformed(ActionEvent arg0) {
		    		now = Calendar.getInstance();
		    		lblDateTime.setText(dateFormat.format(now.getTime()));
		    	}
		    });
		    timer2.start();
	
		}
		
		private void keyboardShow() {
			Desktop desktop = null;
			if (Desktop.isDesktopSupported()) 
			{
			   desktop = Desktop.getDesktop();
			}
			String sysroot = System.getenv("SystemRoot");
			try {
				desktop.open(new File(sysroot+"/system32/osk.exe"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		private void keyboardHide() {
			try {
				Runtime.getRuntime().exec("taskkill /IM osk.exe");
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	
		@Override
		public void actionPerformed(ActionEvent e) {
			
			// TODO Auto-generated method stub
			KeyPad keypad;
			Categories cats;
			JButton btnAction = (JButton)e.getSource();
		
			
			float customerPay = 0;
			if(btnAction.getText().equals("List Items")){
				cats = new Categories();
				cats.setVisible(true);
			}
			
			if(btnAction.getText().equals("Discount")){
				Discount dis = new Discount();
				dis.setVisible(true);
			}
			
			if(isPaid.equals("UserID")){
				keypad = new KeyPad();
				String txtVal = keypad.validateSearch(btnAction.getText(),txtUserID.getText());
				txtUserID.setText(txtVal);
				
			}else if(isPaid.equals("Paid")){
				keypad = new KeyPad();
				String txtVal = keypad.operate(btnAction.getText(),txtPaid.getText());
				if(btnAction.getText().equals("ENTER")){
				}else{
					txtPaid.setText(txtVal);
				}
				
	
			}else if(isPaid.equals("Search")){
				keypad = new KeyPad();
				String txtVal = keypad.validateSearch(btnAction.getText(),txtSearch.getText());
				
				txtSearch.setText(txtVal);
				
			}else if(isPaid.equals("customerID")){
				keypad = new KeyPad();
				String txtVal = keypad.validateSearch(btnAction.getText(),txtCustomerID.getText());
			
				txtCustomerID.setText(txtVal);
	
			}
	
			if(isSwitch && btnAction.getText().equals("Login")){
				//String srch = txtUserID.getText();
				staffID = txtUserID.getText();
			
				if(!staffID.equals("")){
					dbQuery = new DBQuery("root","root");
					dbQuery.connectDB();
					if(dbQuery.isLogin(staffID)){
						btnLogin.setEnabled(false);
						txtUserID.setEnabled(false);
						btnFind.setEnabled(true);
		    			btnDelete.setEnabled(true);
		    			btnClear.setEnabled(true);
		    			btnDot.setEnabled(true);
		    			btnFivePnd.setEnabled(true);
		    			btnTenPnd.setEnabled(true);
		    			btnTwentyPnd.setEnabled(true);
		    			btnFiftyPnd.setEnabled(true);
		    			btnEnter.setEnabled(true);
		    			
		    			btnRemove.setEnabled(true);
		    			btnListItems.setEnabled(true);
		    			btnRemove.setEnabled(true);
		    			btnDiscount.setEnabled(true);
		    			btnLogout.setEnabled(true);
						counter = 0;
						isSwitch = false;
					}
	
					
				}
				
				
			}else if(btnAction.getText().equals("Logout")){
					counter = 200;
					btnLogin.setEnabled(true);
					txtUserID.setEnabled(true);
					txtUserID.setText("");
					
			}else if(btnAction.getText().equals( "Add")){
				
				dbQuery = new DBQuery("root","root");
				dbQuery.connectDB();
				item = dbQuery.getItem(txtSearch.getText());
				
				if(item.size() > 0){
					model.addRow(new Object[]{item.get(0),item.get(1)});
					price.add(item.get(1));
					total = calculator.total(price);
					lblTotal.setText("Total: £"+ total);
					itemID.add(txtSearch.getText());
	
			 		//System.out.println("added--- " + item.get(0));
				}
				txtSearch.setText("");
			}else if(btnAction.getText().equals("Remove")){
				int colIndex = table.getSelectedColumn();
				int r = table.getSelectedRow();
				 tableItems = new ArrayList();
				if(table.getRowCount() > 0 && colIndex >= 0){				
					for (int i = 0; i < table.getRowCount(); i++ ){
						String itemsAdded = (String) table.getModel().getValueAt(i, 0);
						tableItems.add(itemsAdded);
					}
					String selectedItem = (String) table.getModel().getValueAt(r, 0);
					if (tableItems.contains("Discount Amount") && !selectedItem.equals("Discount Amount")) {

					return;	
					} else if(!tableItems.contains("Discount Amount") || selectedItem.equals("Discount Amount") ) {
						removeSelectedRow(table);
						total = calculator.total(price);
						for(int i =0;i < itemID.size();i++){
							if(itemID.get(i).toString().equals("discount")){
								itemID.remove(i);	
							}							
						}
					}
			
					lblTotal.setText("Total: £"+ (total));
					
				}
				//test
			}else if(btnAction.getText().equals("Pay")){
				column = new ArrayList();
				values = new ArrayList();
	
				//Clear data on table
				DefaultTableModel dm = (DefaultTableModel)table.getModel();
				dm.getDataVector().removeAllElements();
				dm.fireTableDataChanged();
				lblChange.setText("0.0");
				txtPaid.setText("0.0");
				lblTotal.setText("Total: £ 0.00");
				btnPay.setEnabled(false);
				
				java.util.Date date = new Date();
				Timestamp timestamp = new Timestamp(date.getTime());
				
				column.add("items_id");
				column.add("staff_id");
				column.add("customer_id");
				column.add("shop_id");
				column.add("payment_code");
				column.add("created");
				
				customerID = txtCustomerID.getText();
				uniqueID = UUID.randomUUID().toString();
				values.add("");
				values.add("'" + staffID+"'");
				values.add("'" + customerID+"'");
				values.add("'" +shopID+"'" );
				values.add("'" +uniqueID+"'");
				values.add("'"+timestamp+"'");
				for(int i =0;i < itemID.size();i++){
					if(itemID.get(i).toString().equals("discount")){
						itemID.remove(i);	
					}
				}
				SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>(){
					@Override
					protected Void doInBackground() throws Exception {
										// TODO Auto-generated method stub
							String query ="";
							java.util.Date date = new Date();
							Timestamp tp = new Timestamp(date.getTime());
							
							InsertItem = new DBQuery("posadmin_pos","clevapos123");
							InsertItem.setHost("jdbc:mysql://173.254.28.135:3306/posadmin_pos");
							InsertItem.connectDB();
				 					
							for(int i =0;i < itemID.size();i++){
												
								values.set(0, "'" +itemID.get(i).toString()+"'");
								query = InsertItem.buildInsertQuery("transaction", column, values);
								System.out.println(query);
								InsertItem.insertTransaction(query);
							}
							column.clear();
							values.clear();
							
							column.add("payment_code");
							column.add("discount_val");
							column.add("discount_type");
							column.add("total");
							column.add("created");
							column.add("shop_id");
							
							
							
							values.add("'"+uniqueID+"'");
							values.add("'"+discount+"'");
							values.add("'"+discountType+"'");
							values.add("'"+total+"'");
							values.add("'"+tp+"'");
							values.add("'" +shopID+"'" );

							
							query = InsertItem.buildInsertQuery("payment", column, values);
							InsertItem.insertTransaction(query);
						
							return null;
					}
			
					protected void done(){
						InsertItem.closeConnection();
						//print(table);

					}
						
					};
					
					worker.execute();
			}else if(btnAction.getText().equals("ENTER")){
				
				if (!txtSearch.getText().equals("")){
					
					dbQuery = new DBQuery("root","root");
					dbQuery.connectDB();
					item = dbQuery.getItem(txtSearch.getText());
					
					if(item.size() > 0){
						model.addRow(new Object[]{item.get(0),item.get(1)});
						price.add(item.get(1));
						total = calculator.total(price);
						lblTotal.setText("Total: £"+ total);
						itemID.add(txtSearch.getText());
					}
					txtSearch.setText("");
					
				}
				
				else if(btnAction.getText().equals("Reset Calendar")){
					calendar.setDisplayDate(null);
					
				}else{
						
					if(table.getRowCount() == 0){
						JOptionPane.showMessageDialog(null, "There are no items added, Please add Item");
						
					}else if(txtPaid.getText().equals("") || txtPaid.getText().equals("0.00")|| txtPaid.getText().equals("0")){
						JOptionPane.showMessageDialog(null, "Please enter amount customer has paid");
		
					}else{
						customerPay = Float.valueOf(txtPaid.getText());
						customerPay = calculator.getChange(table, customerPay);
						if (discountPercentAmount > 0){
							discountType = "Percent";
						}
						else if (discountGrouponAmount > 0){
							discountType = "Groupon";
	
						}
					
						lblChange.setText("£"+customerPay+"");
						btnPay.setEnabled(true);
						
					}		
				}
			}
		}
	
		public static String getTotal(){
			String tot = lblTotal.getText();
			return tot;	
		}

		
		public static void setTotalAfterDiscount(float totalAfterDiscount){
			totAfterDiscount = totalAfterDiscount;
			String totalOriginal = lblTotal.getText();
			totalOriginal = totalOriginal.replaceAll("[^0-9.]", "");
			float totalOrig = Float.parseFloat(totalOriginal);
			total = totalOrig - totAfterDiscount;
			discountPercentAmount = total;
			model.addRow(new Object[]{"Discount Amount",(double)Math.round(total * 100) / 100});
			discount = (double)Math.round(total * 100) / 100;
			price.add(total);
			itemID.add("discount");
			total = totalAfterDiscount;
			lblTotal.setText("Total: £" + (double)Math.round(total * 100) / 100);
		}
		
		public static void setTotalAfterDiscountGroupon(float totalAfterDiscountGo){
			totAfterDiscountGo = totalAfterDiscountGo;
			String totalOriginal = lblTotal.getText();
			totalOriginal = totalOriginal.replaceAll("[^0-9.]", "");
			float totalOrig = Float.parseFloat(totalOriginal);
			total = totalOrig - totAfterDiscountGo;
			discountGrouponAmount = total;
			model.addRow(new Object[]{"Discount Amount",(double)Math.round(total * 100) / 100});
			discount = (double)Math.round(total * 100) / 100;

			price.add(total);
			itemID.add("disccount");
			total = totalAfterDiscountGo;
			lblTotal.setText("Total: £" + (double)Math.round(total * 100) / 100);
		}
		
		public void print(JTable table){
			 	ArrayList<String> itemname = new ArrayList<String>();
			 	ArrayList<String> itemprice = new ArrayList<String>();
			 	printTransaction = new Print();	
				String usrID = "";
		 		String itm = "";
			 	String itp = "";
		 		String paid = "";
		 		String time = "";
				String totalStr = "";
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				time = dateFormat.format(now.getTime()).toLowerCase();
				usrID = "CID: " + txtUserID.getText();
				paid = txtPaid.getText();
		   
				String brand = "USA Star Nails";
				String tel = "Tel: 020 7435 6009";
				String address = "3 holly hill, London NW3 6QN";
		
				for (int count = 0; count < model.getRowCount(); count++){
			         	itm = model.getValueAt(count, 0).toString();
			         	itemname.add(itm);
			         	itp = model.getValueAt(count, 1).toString();
				        itemprice.add(itp);
				        if(!itemname.equals("Discount")){
			         		totalPrice += Float.valueOf(itp);
				        }
			   }
				
				change = Integer.parseInt(paid) - total;
			         
				printTransaction.printReceipt(brand, tel, address, change+"", paid, totalPrice+"", itemname, itemprice, dateFormat.format(now.getTime()).toString(),uniqueID);
		}
		public void removeSelectedRow(JTable table){
			DefaultTableModel model = (DefaultTableModel) this.table.getModel();
			int[] rows = table.getSelectedRows();
			for(int i=0;i< rows.length;i++){
				model.removeRow(rows[i]-i);
				price.remove(rows[i]-i);
				if(!model.getValueAt(i, 0).toString().equals("Discounts")){
						itemID.remove(rows[i]-i);		
				}
			}
		}
	
		public static void setLabel(String item, Object prc,String id){
			//lblItems.setText(setValue);
				model.addRow(new Object[]{item,prc});
				price.add(prc);
				itemID.add(id);
				total = calculator.total(price);
				lblTotal.setText("Total: £"+ total);
		}

		@Override
		public void dateChanged(DateEvent arg0) {
			// TODO Auto-generated method stub
			
			
			txtDate.setText(calendar.getDate().toString());
		}
	}
	 