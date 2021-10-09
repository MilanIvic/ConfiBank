package confidence;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import accounts.Bank;
import dialogs.AtmPayOut;
import dialogs.CheckDialog;
import dialogs.transferAtmDialog;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Atm extends JFrame {
	Bank refer;
	
	private JPanel contentPane;
	private JLabel myLabel;
	private JButton btnPayOut;
	private JButton btnCheck;
	private JButton btnTransfer;
	private JButton btnExit;
	private JLabel lblInfo;
	
	public JLabel getLblInfo() {
		return lblInfo;
	}

	public void setLblInfo(String string) {
		this.lblInfo.setText(string); 
	}

	Atm(Bank confidence){
		this();
		this.refer = confidence;
		
	}
	
	public Atm() {
		setTitle("ATM Confidence Bank");
		ImageIcon photoBackground=new ImageIcon(this.getClass().getResource("/confiBank.jpg"));
		myLabel=new JLabel(photoBackground);
		myLabel.setLocation(0, 0);
    	myLabel.setSize(850, 600);
    	myLabel.setCursor(new Cursor(Cursor.HAND_CURSOR));
    	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.add(myLabel);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		//Button Pay out
		btnPayOut = new JButton("P a y  o u t");
		btnPayOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtmPayOut payOut = new AtmPayOut(refer, Atm.this);
				payOut.setVisible(true);
			}
		});
		btnPayOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPayOut.setBackground(new Color(255, 165, 0));
		btnPayOut.setForeground(new Color(248, 248, 255));
		btnPayOut.setBounds(300, 270, 250, 35);
		myLabel.add(btnPayOut);
		
		//Button check balance
		btnCheck = new JButton("Check balance");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckDialog chDial = new CheckDialog (refer, Atm.this);
				chDial.setVisible(true);
			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheck.setBackground(new Color(255, 165, 0));
		btnCheck.setForeground(new Color(248, 248, 255));
		btnCheck.setBounds(300, 315, 250, 35);
		myLabel.add(btnCheck);
		
		//Button transfer
		btnTransfer = new JButton("Transfer money");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					transferAtmDialog td = new transferAtmDialog(refer, Atm.this);
					td.setVisible(true);
				}
				catch(Exception ex) {
					lblInfo.setText("Wrong input! Try again.");
				}
				
			}
		});
		btnTransfer.setForeground(new Color(248, 248, 255));
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTransfer.setBackground(new Color(255, 165, 0));
		btnTransfer.setBounds(300, 360, 250, 35);
		myLabel.add(btnTransfer);
		
		//button Exit
		btnExit = new JButton("Exit ATM");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnExit.setForeground(new Color(248, 248, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBackground(new Color(255, 165, 0));
		btnExit.setBounds(300, 405, 250, 35);
		myLabel.add(btnExit);
		
		//Label Info
		lblInfo = new JLabel("Welcome to Confidence Bank ATM");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBackground(new Color(248, 248, 255));
		lblInfo.setForeground(new Color(255, 165, 0));
		lblInfo.setFont(new Font("Cambria", Font.PLAIN, 17));
		lblInfo.setBounds(18, 475, 800, 50);
		myLabel.add(lblInfo);
		
		
		
    	
	}
}
