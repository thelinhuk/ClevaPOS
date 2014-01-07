import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Font;


public class Discount extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Discount dialog = new Discount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Discount() {
		setBounds(683, 140, 683, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JButton btnPercent = new JButton("%");
			btnPercent.setBounds(5, 5, 328, 113);
			btnPercent.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnPercent.setForeground(Color.WHITE);;
			btnPercent.setBackground(new Color(27, 188, 155));
			btnPercent.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btnPercent.addActionListener(this);
			contentPanel.setLayout(null);
			contentPanel.add(btnPercent);
		}
		{
			JButton btnGroupon = new JButton("Groupon");
			btnGroupon.setBounds(333, 5, 328, 113);
			btnGroupon.setFont(new Font("Tahoma", Font.BOLD, 28));
			btnGroupon.setForeground(Color.WHITE);
			btnGroupon.setBackground(new Color(27, 188, 155));
			btnGroupon.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			contentPanel.add(btnGroupon);
		}
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(5, 121, 656, 56);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnCancel.setBackground(new Color(44, 91, 166));
		btnCancel.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnCancel.addActionListener(this);
		contentPanel.add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton btnAction = (JButton)e.getSource();
		if (btnAction.getText().equals("Cancel")) {
			this.dispose();
		}
		else {
			if (btnAction.getText().equals("%")){
				//this.setVisible(false);
				this.dispose();
				PercentDiscount pc = new PercentDiscount();
				pc.setVisible(true);
			}
		}
	}
}
