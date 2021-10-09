package dialogs;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import accounts.Bank;
import confidence.Atm;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class transferAtmDialog extends JDialog {
	
	private final JPanel contentPanel = new JPanel();
	private Bank bank;
	private Atm atm;
	private JTextField txtFld;
	private JButton btnDot;
	private JButton btn3;
	private JButton btn2;
	private JButton btn5;
	private JButton btn4;
	private JButton btn6;
	private JButton btn10;
	private JButton btn8;
	private JButton btn7;
	private JButton btn9;
	private JButton btn0;
	private JButton btn1;
	private JButton btnCfPin;
	private JButton btnCfAmnt;
	private JButton btnCfRecAcc;
	private JButton btnBacks;
	String account = "";
	String pin = "";
	double amount = 0;
	
	
	public transferAtmDialog(Bank reference, Atm atm) {
		this();
		this.bank = reference;
		this.atm = atm;
	}
	
	public transferAtmDialog() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Confirm");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						try {
							atm.setLblInfo(bank.transferFundsCard(pin, amount, account));
							setVisible(false);
							dispose();
						}
						catch(Exception ex) {
							JOptionPane.showMessageDialog(null, "Wrong input!");
						}
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		contentPanel.setLayout(null);
		
		btnCfPin = new JButton("Confirm your PIN");
		btnCfPin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pin = txtFld.getText();
				txtFld.setText("");
			}
		});
		btnCfPin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCfPin.setBounds(219, 11, 188, 23);
		contentPanel.add(btnCfPin);
		
		btnCfAmnt = new JButton("Confirm amount");
		btnCfAmnt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				amount = Double.parseDouble(txtFld.getText());
				txtFld.setText("");
			}
		});
		btnCfAmnt.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCfAmnt.setBounds(219, 80, 188, 23);
		contentPanel.add(btnCfAmnt);
		
		btnCfRecAcc = new JButton("Confirm reciever account");
		btnCfRecAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				account = txtFld.getText();
				txtFld.setText("");
			}
		});
		btnCfRecAcc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCfRecAcc.setBounds(219, 45, 188, 23);
		contentPanel.add(btnCfRecAcc);
		
		btnBacks = new JButton("C");
		btnBacks.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText("");
			}
		});
		btnBacks.setForeground(new Color(248, 248, 255));
		btnBacks.setFont(new Font("Calibri", Font.PLAIN, 10));
		btnBacks.setBackground(new Color(255, 0, 0));
		btnBacks.setBounds(219, 126, 51, 38);
		contentPanel.add(btnBacks);
		
		btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "1");
			}
		});
		btn1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn1.setForeground(new Color(248, 248, 255));
		btn1.setBackground(new Color(255, 165, 0));
		btn1.setBounds(23, 194, 39, 23);
		contentPanel.add(btn1);
		
		txtFld = new JTextField();
		txtFld.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtFld.setColumns(10);
		txtFld.setBounds(23, 79, 186, 22);
		contentPanel.add(txtFld);
		
		btnDot = new JButton(",");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ ".");
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDot.setForeground(new Color(248, 248, 255));
		btnDot.setBackground(new Color(255, 165, 0));
		btnDot.setBounds(170, 194, 39, 23);
		contentPanel.add(btnDot);
		
		btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "3");
			}
		});
		btn3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn3.setForeground(new Color(248, 248, 255));
		btn3.setBackground(new Color(255, 165, 0));
		btn3.setBounds(121, 194, 39, 23);
		contentPanel.add(btn3);
		
		btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "2");
			}
		});
		btn2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn2.setForeground(new Color(248, 248, 255));
		btn2.setBackground(new Color(255, 165, 0));
		btn2.setBounds(72, 194, 39, 23);
		contentPanel.add(btn2);
		
		btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "5");
			}
		});
		btn5.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn5.setForeground(new Color(248, 248, 255));
		btn5.setBackground(new Color(255, 165, 0));
		btn5.setBounds(72, 160, 39, 23);
		contentPanel.add(btn5);
		
		btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "4");
			}
		});
		btn4.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn4.setForeground(new Color(248, 248, 255));
		btn4.setBackground(new Color(255, 165, 0));
		btn4.setBounds(23, 160, 39, 23);
		contentPanel.add(btn4);
		
		btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "6");
			}
		});
		btn6.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn6.setForeground(new Color(248, 248, 255));
		btn6.setBackground(new Color(255, 165, 0));
		btn6.setBounds(121, 160, 39, 23);
		contentPanel.add(btn6);
		
		btn10 = new JButton("-");
		btn10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "-");
			}
		});
		btn10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn10.setForeground(new Color(248, 248, 255));
		btn10.setBackground(new Color(255, 165, 0));
		btn10.setBounds(170, 160, 39, 23);
		contentPanel.add(btn10);
		
		btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "8");
			}
		});
		btn8.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn8.setForeground(new Color(248, 248, 255));
		btn8.setBackground(new Color(255, 165, 0));
		btn8.setBounds(72, 126, 39, 23);
		contentPanel.add(btn8);
		
		btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "7");
			}
		});
		btn7.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn7.setForeground(new Color(248, 248, 255));
		btn7.setBackground(new Color(255, 165, 0));
		btn7.setBounds(23, 126, 39, 23);
		contentPanel.add(btn7);
		
		btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "9");
			}
		});
		btn9.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn9.setForeground(new Color(248, 248, 255));
		btn9.setBackground(new Color(255, 165, 0));
		btn9.setBounds(121, 126, 39, 23);
		contentPanel.add(btn9);
		
		btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFld.setText(txtFld.getText()+ "0");
			}
		});
		btn0.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btn0.setForeground(new Color(248, 248, 255));
		btn0.setBackground(new Color(255, 165, 0));
		btn0.setBounds(170, 126, 39, 23);
		contentPanel.add(btn0);
	}

}
