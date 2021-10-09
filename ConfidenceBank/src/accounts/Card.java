package accounts;

import javax.swing.JOptionPane;

public class Card {
	String pin;
	String name;
	String idNumber;
	String accNumb;
	String adress;

	Card(Account account, String pin) {
		this.name = account.getName();
		this.idNumber = account.getId();
		this.accNumb = account.getAccount();
		this.adress = account.getAdress();
		this.pin = pin;
	}

	public String getAccNumb() {
		return accNumb;
	}

	public String getPin() {
		return pin;
	}

	public String getName() {
		return name;
	}

	public String getIdNumber() {
		return idNumber;
	}
	
	public String getAdress() {
		return adress;
	}

	public double getBalance(Account account) {
		return account.getAmount();
	}

}
