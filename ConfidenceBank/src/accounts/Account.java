package accounts;

import javax.swing.JOptionPane;

public class Account {
	private String name;
	private String adress;
	private String idNumber;
	private String accNumber;
	private double amount;

	Account(Person person, String accNumber) {
		this.name = person.getName();
		this.adress = person.getAdress();
		this.idNumber = person.getIdNumber();
		this.accNumber = accNumber;

	}

	
	public String getAdress() {
		return adress;
	}

	public String getAccount() {
		return accNumber;
	}

	public double getAmount() {
		return amount;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return idNumber;
	}

	public void addMoney(double amount) {
		setAmount(this.amount + amount);
	}

	public void removeMoney(double amount) {
			setAmount(this.amount - amount);
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
