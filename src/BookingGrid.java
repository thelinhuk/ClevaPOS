import javax.swing.JPanel;
import javax.swing.JList;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;

import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Font;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;


public class BookingGrid extends JPanel {

	/**
	 * Create the panel.
	 */
	JLabel lbl_time[];
	public BookingGrid() {
		setLayout(null);
		
		lbl_time = new JLabel[4];
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 280, 16);
		add(panel);
		panel.setLayout(null);
		
		lbl_time[0] = new JLabel();
		lbl_time[0].setBounds(0, 0, 46, 14);
		panel.add(lbl_time[0] );
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 16, 280, 114);
		add(panel_1);
		panel_1.setLayout(null);
		
		JList list_1 = new JList();
		list_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_1.setBounds(0, 0, 279, 114);
		panel_1.add(list_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 130, 280, 16);
		add(panel_2);
		panel_2.setLayout(null);
		
		lbl_time[1] = new JLabel();
		lbl_time[1].setBounds(3, 0, 46, 14);
		panel_2.add(lbl_time[1]);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 146, 280, 114);
		add(panel_3);
		panel_3.setLayout(null);
		
		JList list_2 = new JList();
		list_2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_2.setBounds(0, 0, 280, 114);
		panel_3.add(list_2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 260, 280, 16);
		add(panel_4);
		panel_4.setLayout(null);
		
		lbl_time[2] = new JLabel();
		lbl_time[2].setBounds(0, 0, 279, 16);
		panel_4.add(lbl_time[2]);
		lbl_time[2].setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 276, 280, 114);
		add(panel_5);
		panel_5.setLayout(null);
		
		JList list_3 = new JList();
		list_3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_3.setBounds(0, 0, 280, 114);
		panel_5.add(list_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 390, 280, 16);
		add(panel_6);
		panel_6.setLayout(null);
		
		lbl_time[3] = new JLabel();
		lbl_time[3].setBounds(3, 1, 46, 14);
		panel_6.add(lbl_time[3]);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 406, 280, 115);
		add(panel_7);
		panel_7.setLayout(null);
		
		JList list_4 = new JList();
		list_4.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		list_4.setBounds(0, 0, 280, 114);
		panel_7.add(list_4);
	
	}
	
	public void initLabel(String hour){
		String min[] = {"00","15","30","45"};
		for(int i = 0;i < lbl_time.length;i++){
			lbl_time[i].setText(hour + min[i]);
		}
	}
	
	
}
