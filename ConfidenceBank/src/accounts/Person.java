package accounts;

import java.util.ArrayList;
import java.util.Iterator;

public class Person {
	private String name;
	private String adress;
	private String idNumber;
	private ArrayList<Account> accounts = new ArrayList<>();

	Person() {
		this.name = "";
		this.adress = "";
		this.idNumber = "";
	}

	Person(String name, String adress, String idNumber) {
		this.name = name;
		this.adress = adress;
		this.idNumber = idNumber;

	}

	public void addNewAccount(Account acc) {
		accounts.add(acc);

	}

	public void removeAccount(String id, String account) {
		Iterator<Account> itr = accounts.iterator();
		while (itr.hasNext()) {
			Account acnt = itr.next();
			if (acnt.getId().equals(id) && acnt.getAccount().equals(account)) {
				itr.remove();
			}
		}
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

	public String getAccounts() {
		StringBuffer str = new StringBuffer();
		for (Account acnts : accounts) {
			str.append(acnts.getAccount() + " ");
		}
		String personAccounts = new String(str);
		return personAccounts;
	}

}
