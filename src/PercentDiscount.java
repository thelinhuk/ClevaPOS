import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;

import java.awt.GridLayout;


public class PercentDiscount extends JDialog implements ActionListener {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private TextPrompt tp;
	private JButton btn5percent, btn10percent, btn15percent, btn20percent, btn50percent;

	private static Calculator calculator;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PercentDiscount dialog = new PercentDiscount();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PercentDiscount() {
		
		calculator = new Calculator();
		
		setBounds(683, 140, 683, 221);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			btn5percent = new JButton("5%");
			btn5percent.setBounds(6, 5, 131, 113);
			btn5percent.setForeground(Color.WHITE);
			btn5percent.setFont(new Font("Tahoma", Font.BOLD, 28));
			btn5percent.setBackground(new Color(44, 91, 166));
			btn5percent.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btn5percent.addActionListener(this);
			contentPanel.setLayout(null);
			contentPanel.add(btn5percent);
		}
		{
			btn10percent = new JButton("10%");
			btn10percent.setBounds(137, 5, 131, 113);
			btn10percent.setForeground(Color.WHITE);
			btn10percent.setFont(new Font("Tahoma", Font.BOLD, 28));
			btn10percent.setBackground(new Color(44, 91, 166));
			btn10percent.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btn10percent.addActionListener(this);
			contentPanel.add(btn10percent);
		}
		{
			btn15percent = new JButton("15%");
			btn15percent.setBounds(268, 5, 131, 113);
			btn15percent.setForeground(Color.WHITE);
			btn15percent.setFont(new Font("Tahoma", Font.BOLD, 28));
			btn15percent.setBackground(new Color(44, 91, 166));
			btn15percent.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btn15percent.addActionListener(this);
			contentPanel.add(btn15percent);
		}
		{
			btn20percent = new JButton("20%");
			btn20percent.setBounds(399, 5, 131, 113);
			btn20percent.setForeground(Color.WHITE);
			btn20percent.setFont(new Font("Tahoma", Font.BOLD, 28));
			btn20percent.setBackground(new Color(44, 91, 166));
			btn20percent.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btn20percent.addActionListener(this);
			contentPanel.add(btn20percent);
		}
		{
			btn50percent = new JButton("50%");
			btn50percent.setBounds(530, 5, 131, 113);
			btn50percent.setForeground(Color.WHITE);
			btn50percent.setFont(new Font("Tahoma", Font.BOLD, 28));
			btn50percent.setBackground(new Color(44, 91, 166));
			btn50percent.setBorder(new LineBorder(new Color(45, 50, 61), 2));
			btn50percent.addActionListener(this);
			contentPanel.add(btn50percent);
		}
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(6, 121, 655, 56);
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 28));
		btnCancel.setBackground(new Color(27, 188, 155));
		btnCancel.setBorder(new LineBorder(new Color(45, 50, 61), 2));
		btnCancel.addActionListener(this);
		contentPanel.add(btnCancel);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//TODO Auto-generated method stub
		JButton btnAction = (JButton)e.getSource();
		if (btnAction.getText().equals("Cancel")) {
			this.dispose();
		}
		
		else if (btnAction.getText().equals("5%")) {
			float discountAmount = 5;
			float totalAfterDiscount = calculator.getDiscount(discountAmount);
			AppUI.setTotalAfterDiscount(totalAfterDiscount);
			this.dispose();
		}
		else if (btnAction.getText().equals("10%")) {
			float discountAmount = 10;
			float totalAfterDiscount = calculator.getDiscount(discountAmount);
			AppUI.setTotalAfterDiscount(totalAfterDiscount);
			this.dispose();
		}
		else if (btnAction.getText().equals("15%")) {
			float discountAmount = 15;
			float totalAfterDiscount = calculator.getDiscount(discountAmount);
			AppUI.setTotalAfterDiscount(totalAfterDiscount);
			this.dispose();
		}
		else if (btnAction.getText().equals("20%")) {
			float discountAmount = 20;
			float totalAfterDiscount = calculator.getDiscount(discountAmount);
			AppUI.setTotalAfterDiscount(totalAfterDiscount);
			this.dispose();
		}
		else if (btnAction.getText().equals("50%")) {
			float discountAmount = 50;
			float totalAfterDiscount = calculator.getDiscount(discountAmount);
			AppUI.setTotalAfterDiscount(totalAfterDiscount);
			this.dispose();
		}
		
	}

}
