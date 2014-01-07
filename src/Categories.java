import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JInternalFrame;

import java.awt.CardLayout;


public class Categories extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	private JButton btnCat1;
	private JButton[] btn;
	private DBQuery dbQuery;
	private static DefaultTableModel model;
	private ArrayList category;
	private JPanel categoryPanel;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Categories dialog = new Categories();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Categories() {
		setBounds(0, 0, 683, 768);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setBackground(new Color(45, 50, 61));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(10, 11, 647, 648);
			scrollPane.setBackground(new Color(45, 50, 61));
			contentPanel.add(scrollPane);
			{
				categoryPanel = new JPanel();
				scrollPane.setViewportView(categoryPanel);
				categoryPanel.setLayout(new GridLayout(0, 2, 5, 5));
				categoryPanel.setBackground(new Color(45, 50, 61));
			}
		}
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(10, 663, 647, 62);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnCancel.setBackground(new Color(44, 91, 166));
		btnCancel.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnCancel.addActionListener(this);
		contentPanel.add(btnCancel);
		
		setModal(true);	
		placeCategories();
	}
	
	private void placeCategories(){
		dbQuery = new DBQuery("root","root");
		dbQuery.connectDB();
		category = dbQuery.getCategory();
		btn = new JButton[category.size()];
	
			for(int j = 0; j < btn.length; j++){
				btn[j] = new JButton(); 
				btn[j].setText((String) category.get(j));
				btn[j].setBounds(0, 0, 480, 75);
				btn[j].setForeground(Color.WHITE);
				btn[j].setFont(new Font("Tahoma", Font.BOLD, 28));
				btn[j].setBackground(new Color(27, 188, 155));
				btn[j].setBorder(new LineBorder(new Color(45, 50, 61), 2));
				btn[j].addActionListener(this);
				categoryPanel.add(btn[j]);
			}	
	}


	ArrayList cid;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btnAction = (JButton)e.getSource();
		if (btnAction.getText().equals("Cancel")) {
			this.dispose();
		}
		else {
			this.dispose();
			JButton categorySelected = (JButton)e.getSource();
			String categoryName = categorySelected.getText();
			Items itemScreen = new Items(categoryName);
			itemScreen.setVisible(true);
		}
		
	}
}
