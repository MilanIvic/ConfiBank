package confidence;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Label;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import accounts.Bank;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Component;
import java.awt.Cursor;

public class ConfidenceMain {
	Bank confidenceBank = new Bank();
	private JFrame frame;
	private JLabel myLabel;

	public ConfidenceMain() {
		ImageIcon photoBackground=new ImageIcon(this.getClass().getResource("/confiBank.jpg"));

		myLabel=new JLabel(photoBackground);
    	myLabel.setSize(850, 600);
    	myLabel.setLayout(null);
   
		
    	    	
		frame = new JFrame("Confidence Bank");
		frame.getContentPane().add(myLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 850, 600);
		frame.setVisible(true);
		frame.getContentPane().setLayout(null);
		
	
		JButton btnATM = new JButton("Use ATM");
		btnATM.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnATM.setForeground(new Color(255, 255, 255));
		btnATM.setBackground(new Color(255, 165, 0));
		btnATM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Atm obj = new Atm(confidenceBank);
				obj.setVisible(true);
			}
		});
		btnATM.setBounds(10, 450, 200, 80);
		myLabel.add(btnATM);
		
		JButton btnEnterBank = new JButton("Enter Bank");
		btnEnterBank.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InsideBankGui inside = new InsideBankGui(confidenceBank);
				inside.setVisible(true);
			}
		});
		btnEnterBank.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnEnterBank.setBackground(new Color(255, 165, 0));
		btnEnterBank.setForeground(new Color(255, 250, 250));
		btnEnterBank.setBounds(620, 450, 200, 80);
		myLabel.add(btnEnterBank);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Good Bye! Confidence Bank is always here for you!");
				frame.dispose();
			}
		});
		btnExit.setForeground(new Color(255, 250, 250));
		btnExit.setBackground(new Color(255, 165, 0));
		btnExit.setBounds(372, 527, 89, 23);
		myLabel.add(btnExit);
		
		JLabel welcome = new JLabel("W E L C O M E ");
		welcome.setFont(new Font("Cambria", Font.PLAIN, 60));
		welcome.setBackground(new Color(255, 165, 0));
		welcome.setForeground(new Color(255, 165, 0));
		welcome.setBounds(240, 250, 450, 100);
		myLabel.add(welcome);
		
		
	}
	public static void main(String[] args) {
		new ConfidenceMain();
	}
}
