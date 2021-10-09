package confidence;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import accounts.Bank;
import dialogs.AtmPayOut;
import dialogs.CheckDialog;
import dialogs.transferAtmDialog;

public class InsideBankGui extends JFrame {
	Bank refer;
	private JPanel contentPane;
	private JLabel myLabel;
	private JButton btnPayOut;
	private JButton btnCheck;
	private JButton btnTransfer;
	private JButton btnExit;
	private JLabel lblInfo;
	private JButton btnOpenAccount;
	private JButton btnDepose;
	private JButton btnRemoveAccount;

	public InsideBankGui(Bank refer) {
		this();
		this.refer = refer;
	}

	public InsideBankGui() {
		setTitle("Confidence Bank");
		ImageIcon photoBackground = new ImageIcon(this.getClass().getResource("/confiBank.jpg"));
		myLabel = new JLabel(photoBackground);
		myLabel.setLocation(0, 0);
		myLabel.setSize(850, 600);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.add(myLabel);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		// Button payout
		btnPayOut = new JButton("P a y  o u t");
		btnPayOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String account = JOptionPane.showInputDialog("What is your account number?");
					String idNumber = JOptionPane.showInputDialog("What is your ID number?");
					double amount = Double
							.parseDouble(JOptionPane.showInputDialog("Amount of money you want to take out?"));
					lblInfo.setText(refer.removeMoney(account, idNumber, amount));
				} catch (Exception ex) {
					lblInfo.setText("Error");
				}

			}
		});
		btnPayOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnPayOut.setBackground(new Color(255, 165, 0));
		btnPayOut.setForeground(new Color(248, 248, 255));
		btnPayOut.setBounds(10, 300, 250, 35);
		myLabel.add(btnPayOut);

		// Button check balance
		btnCheck = new JButton("Check balance");
		btnCheck.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String account = JOptionPane.showInputDialog("What is your account number?");
					String idNumber = JOptionPane.showInputDialog("What is your ID number?");
					lblInfo.setText(refer.checkAmount(account, idNumber));
				} catch (Exception ex) {
					lblInfo.setText("Error!");
				}

			}
		});
		btnCheck.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheck.setBackground(new Color(255, 165, 0));
		btnCheck.setForeground(new Color(248, 248, 255));
		btnCheck.setBounds(10, 345, 250, 35);
		myLabel.add(btnCheck);

		// Button transfer
		btnTransfer = new JButton("Transfer money");
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String account = JOptionPane.showInputDialog("What is your account number?");
					String idNumber = JOptionPane.showInputDialog("What is your ID number?");
					double amount = Double
							.parseDouble(JOptionPane.showInputDialog("Amount of money you want to transfer?"));
					String recAccount = JOptionPane.showInputDialog("Account that you want to transfer to?");
					lblInfo.setText(refer.transferFunds(account, idNumber, amount, recAccount));
				} catch (Exception ex) {
					lblInfo.setText("Error!");
				}

			}
		});
		btnTransfer.setForeground(new Color(248, 248, 255));
		btnTransfer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTransfer.setBackground(new Color(255, 165, 0));
		btnTransfer.setBounds(10, 390, 250, 35);
		myLabel.add(btnTransfer);

		// button Exit
		btnExit = new JButton("Exit ");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				dispose();
			}
		});
		btnExit.setForeground(new Color(248, 248, 255));
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnExit.setBackground(new Color(255, 165, 0));
		btnExit.setBounds(575, 390, 250, 35);
		myLabel.add(btnExit);

		// Button open account
		btnOpenAccount = new JButton("Open account");
		btnOpenAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					lblInfo.setText(refer.openAccount());
				} catch (Exception ex) {
					lblInfo.setText("Error!");
				}

			}
		});
		btnOpenAccount.setForeground(new Color(248, 248, 255));
		btnOpenAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnOpenAccount.setBackground(new Color(255, 165, 0));
		btnOpenAccount.setBounds(292, 300, 250, 35);
		myLabel.add(btnOpenAccount);

		// Button add money
		btnDepose = new JButton("Depose");
		btnDepose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String account = "";
				String idNumber = "";
				double amount = 0;
				try {
					account = JOptionPane.showInputDialog("What is your account number?");
					idNumber = JOptionPane.showInputDialog("What is your ID number?");
					amount = Double.parseDouble(
							JOptionPane.showInputDialog("Amount of money that you want to add into your account?"));
					lblInfo.setText(refer.addMoney(account, idNumber, amount));
				} catch (Exception ec) {
					lblInfo.setText("Error!");
				}
			}
		});
		btnDepose.setForeground(new Color(248, 248, 255));
		btnDepose.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDepose.setBackground(new Color(255, 165, 0));
		btnDepose.setBounds(575, 300, 250, 35);
		myLabel.add(btnDepose);

		// Button remove account
		btnRemoveAccount = new JButton("Remove account");
		btnRemoveAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String account = JOptionPane.showInputDialog("What is your account number?");
					String id = JOptionPane.showInputDialog("What is your ID number?");
					lblInfo.setText(refer.removeAccount(id, account));
				} catch (Exception ec) {
					lblInfo.setText("Error!");
				}
			}
		});
		btnRemoveAccount.setForeground(new Color(248, 248, 255));
		btnRemoveAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveAccount.setBackground(new Color(255, 165, 0));
		btnRemoveAccount.setBounds(575, 345, 250, 35);
		myLabel.add(btnRemoveAccount);

		// Label Info
		lblInfo = new JLabel("Welcome to Confidence Bank");
		myLabel.add(lblInfo);
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setBackground(new Color(248, 248, 255));
		lblInfo.setForeground(new Color(255, 165, 0));
		lblInfo.setFont(new Font("Cambria", Font.PLAIN, 20));
		lblInfo.setBounds(18, 475, 800, 50);

	}

}
