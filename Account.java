package banking;
import java.util.ArrayList;

class Account {
	public ArrayList<AccInfo> custmrDetail = new ArrayList<>();
	private ArrayList<String> trnHistory = new ArrayList<>();
	private int accNo = 1000;

	public void createAccount(String name, double amount) {
		int accNum = ++accNo;
		custmrDetail.add(new AccInfo(accNum, name, amount));
		trnHistory.add("Account " + accNum + " created with ₹" + amount);
		System.out.println("Account Created Successfully!");
		System.out.println("Your Account Number is (Note it): " + accNum);
	}

	public AccInfo getAccount(int id, String name) {
		for (AccInfo ac : custmrDetail) {
			if (ac.getAccNum() == id && ac.getCustmrName().equalsIgnoreCase(name)) {
				return ac;
			}
		}
		return null;
	}

	public void withdraw(int id, String name, double amount) {
		AccInfo ac = getAccount(id, name);
		if (ac != null) {
			if (ac.getBalance() >= amount) {
				ac.setBalance(ac.getBalance() - amount);
				System.out.println("₹" + amount + " Withdrawn Successfully!");
				trnHistory.add("Withdraw ₹" + amount + " from Account " + id);
			} else {
				System.out.println("Insufficient Balance!");
			}
		}
	}

	public void deposit(int id, String name, double amount) {
		AccInfo ac = getAccount(id, name);
		if (ac != null) {
			ac.setBalance(ac.getBalance() + amount);
			System.out.println("₹" + amount + " Deposited Successfully!");
			trnHistory.add("Deposited ₹" + amount + " into Account " + id);
		}
	}

	public void showTransactionHistory(int accNum) {
		System.out.println("\nTransaction History for Account " + accNum + ":");
		for (String t : trnHistory) {
			if (t.contains("Account " + accNum)) {
				System.out.println("- " + t);
			}
		}
	}
}
