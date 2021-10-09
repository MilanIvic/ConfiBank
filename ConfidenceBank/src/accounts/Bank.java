package accounts;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;

public class Bank {
	ArrayList<Account> accountsList = new ArrayList<>();
	ArrayList<Person> personList = new ArrayList<>();
	ArrayList<Card> cardsList = new ArrayList<>();

	int accountId = 0;

	public String openAccount() {
		try {
			Account account;
			String continuation = String.valueOf(accountId); // every new account gets different continuation
			String accNumb = "11-111" + continuation; // account number
			String name = JOptionPane.showInputDialog("Enter your full name: ");
			String adress = JOptionPane.showInputDialog("Enter your adress: ");
			String idNumb = JOptionPane.showInputDialog("Enter your ID number: ");
			if (name.equals("") || adress.equals("") || idNumb.equals("")) {
				return "Wrong input!";
			} else {
				Person person = new Person(name, adress, idNumb); // creating new person
				account = new Account(person, accNumb); // new account
				person.addNewAccount(account); // adding account to personal list of accounts
				accountsList.add(account); // adding account to accountsList
				personList.add(person); // adding person to personList
				String pin = "123" + continuation; // every card gets different pin
				Card card = new Card(account, pin); // creating card
				cardsList.add(card); // adding card to card list
				accountId++;
				JOptionPane.showMessageDialog(null,
						"New account has been created for person: " + person.getName() + ", " + person.getAdress()
								+ ", " + person.getIdNumber() + "\n" + "Account number: " + account.getAccount()
								+ ", Amount: " + account.getAmount() + "\n" + "Card has been created for this account: "
								+ card.getAccNumb() + ", PIN: " + card.getPin());// showing message

				return // used for JLabel text
				"New account has been created. Welcome " + person.getName();
				/*
				 * after every new account is created accountId will be incremented, it is used
				 * as continuation, new account numb is 11-111 plus continuation (example:
				 * continuation = 0 -> account number is 11-1110 and after creating that account
				 * continuation is 1 and it is now ready to be used for next account creation,
				 * next account number would be 11-1111)
				 */
			}
		} catch (Exception e) {
			return "Wrong input!";
		}

	}

	public String addMoney(String account, String idNumber, double amount) {
		String answer = "";
		boolean match = false;
		for (Account acnts : accountsList) {
			if (acnts.getAccount().equals(account) && acnts.getId().equals(idNumber)) {
				match = true;
				acnts.addMoney(amount);
				answer = acnts.getName() + ", your new account balance: " + acnts.getAmount();
				break;
			} else {
				match = false;
			}

		}
		if (match == false) {
			return "Wrong input! Try again.";

		} else {
			return answer;
		}

	}

	public String checkAmount(String account, String idNumber) {
		for (Account acnts : accountsList) {
			if (acnts.getAccount().equals(account) && acnts.getId().equals(idNumber)) {

				return acnts.getName() + " your account balance: " + acnts.getAmount();

			}

		}
		return "Please give valid informations";
	}

	public String removeMoney(String account, String idNumber, double amount) {

		for (Account acnts : accountsList) {
			if (acnts.getAccount().equals(account) && acnts.getId().equals(idNumber)) {// finding account in list //
																						// accountsList
				if (acnts.getAmount() >= amount) {
					acnts.removeMoney(amount);
					return acnts.getName() + ", your new account balance: " + acnts.getAmount();
				}
				else {
					return "Not enough money on your account for this transaction";
				}
			}

		}
		return "Please give valid informations";

	}

	public String transferFunds(String account, String idNumber, double amount, String recAccount) {
		for (Account acnts : accountsList) {
			if (acnts.getAccount().equals(account) && acnts.getId().equals(idNumber)) {// finding your account
				for (Account reciever : accountsList) {
					if (reciever.getAccount().equals(recAccount)) {// finding receiver account
						if (acnts.getAmount() >= amount) {
							acnts.removeMoney(amount);
							reciever.addMoney(amount);
							return "Transfer completed! " + acnts.getName() + ", your new account balance: "
									+ acnts.getAmount();
						}
						break;
					}

				}
				break;
			}

		}

		return "Wrong informations! Try again";
	}

	public String removeAccount(String id, String account) {
		boolean check = false;
		Iterator<Account> itr = accountsList.iterator();// removing account from accountsList
		while (itr.hasNext()) {
			Account acnt = itr.next();
			if (acnt.getId().equals(id) && acnt.getAccount().equals(account)) {
				itr.remove();
				check = true;
				break;
			} else {
				check = false;
			}
		}
		for (Person pers : personList) {// removing account from personList
			if (pers.getIdNumber().equals(id)) {
				pers.removeAccount(id, account);
			}

		}

		Iterator<Card> itr2 = cardsList.iterator();// removing card
		while (itr2.hasNext()) {
			Card card = itr2.next();
			if (card.getAccNumb().equals(account)) {
				itr2.remove();
			}
		}

		if (check == true) {
			return "Account removed!";
		} else {
			return "Wrong input!";
		}

	}

	public String useCard(String pinCode, double amount) {
		for (Card ccard : cardsList) {// confirmation of pin validation
			if (ccard.getPin().equals(pinCode)) {
				String account = ccard.getAccNumb();
				for (Account acnt : accountsList) {
					if (acnt.getAccount().equals(account)) {
						if (acnt.getAmount() >= amount) {
							acnt.removeMoney(amount);
							return ccard.getName() + ", your new balance for account: " + ccard.getAccNumb() + ": "
									+ ccard.getBalance(acnt);
						} else {
							return "Not enough money on your account!";
						}

					}
				}

			}
		}
		return "Wrong PIN";
	}

	public String transferFundsCard(String pinCode, double amount, String recAccount) {
		String answer = "";
		boolean match = false;
		boolean match2 = false;
		for (Card cards : cardsList) {// pin confirmation
			if (cards.getPin().equals(pinCode)) {
				String account = cards.getAccNumb();
				match = true;
				for (Account reciever : accountsList) {// finding receiver account in accountsList
					if (reciever.getAccount().equals(recAccount)) {
						match2 = true;
						for (Account acnts : accountsList) {
							if (acnts.getAccount().equals(account)) {// finding your account in accountsList
								if (acnts.getAmount() >= amount) {
									acnts.removeMoney(amount);
									reciever.addMoney(amount);
									answer = "Transfer completed! " + acnts.getName() + ", your new account balance: "
											+ acnts.getAmount();
								} else {
									answer = "There is not enough money on your account!";
								}

							}
						}
						break;// break from receiver account search when found
					} else {
						match2 = false;
					}

				}
				break;// break from card pin search when found
			} else {
				match = false;
			}

		}
		if (match == false || match2 == false) {
			return "Wrong input! Try again.";

		} else {
			return answer;
		}
	}

	public String showBalanceCard(String pinCode) {
		for (Card ccard : cardsList) {// confirmation of pin validation
			if (ccard.getPin().equals(pinCode)) {
				String account = ccard.getAccNumb();
				for (Account acnt : accountsList) {
					if (acnt.getAccount().equals(account)) {
						return ccard.getName() + ", your balance for account: " + ccard.getAccNumb() + ": "
								+ ccard.getBalance(acnt);

					}

				}
			}

		}
		return "Wrong PIN";
	}

}
