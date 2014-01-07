
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import java.awt.GridLayout;




public class Items extends JDialog implements ActionListener{

	private static final String String = null;
	private DBQuery dbQuery;
	private JButton[] btn;
	private JPanel itemsPanel;
	private ArrayList category,cid, items, price;

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	private String getVal;
	public static void main(String[] args) {
		try {
			Items dialog = new Items(String);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Items(String cn) {
		setBounds(683, 0, 683, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(45, 50, 61));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 11, 647, 648);
		scrollPane.setBackground(new Color(45, 50, 61));
		contentPanel.add(scrollPane);
		
		itemsPanel = new JPanel();
		scrollPane.setViewportView(itemsPanel);
		itemsPanel.setBackground(new Color(45, 50, 61));
		itemsPanel.setLayout(new GridLayout(0, 1, 5, 5));
		
		JButton btnDone = new JButton("Done");
		btnDone.setBounds(10, 663, 647, 62);
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnDone.setBackground(new Color(27, 188, 155));
		btnDone.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnDone.addActionListener(this);
		contentPanel.add(btnDone);
		setModal(true);
		
		getCID(cn);
		btn = new JButton[items.size()];
		for(int j = 0; j < btn.length; j++){
			btn[j] = new JButton(); 
			btn[j].setText((String) items.get(j));
			btn[j].setBounds(0, 0, 160, 175);
			btn[j].setForeground(Color.WHITE);
			btn[j].setFont(new Font("Tahoma", Font.BOLD, 28));
			btn[j].setBackground(new Color(44, 91, 166));
			btn[j].setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btn[j].addActionListener(this);
			itemsPanel.add(btn[j]);
		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO Auto-generated method stub
		JButton btnAction = (JButton)e.getSource();
		if (btnAction.getText().equals("Done")) {
			this.dispose();
		}
		else {
			getVal = btnAction.getText();
			dbQuery = new DBQuery("root","root");
			dbQuery.connectDB();
			price = dbQuery.getPrice(getVal);
			AppUI.setLabel(getVal,price.get(0));
		}
	}
	

	public void getCID(String cn){
		
		dbQuery = new DBQuery("root","root");
		dbQuery.connectDB();
		cid = dbQuery.getID(cn);
		String cc = (String) cid.get(0);		
		items = dbQuery.getItemsByCategory(cc);
	}
}
