package banking;
class AccInfo {
	private int accNum;
	private String custmrName;
	private double balance;

	public AccInfo(int accNum, String custmrName, double balance) {
		this.accNum = accNum;
		this.custmrName = custmrName;
		this.balance = balance;
	}

	public int getAccNum() {
		return accNum;
	}

	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}

	public String getCustmrName() {
		return custmrName;
	}

	public void setCustmrName(String custmrName) {
		this.custmrName = custmrName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account Number: " + accNum + ", Customer Name: " + custmrName + ", Balance: ₹" + balance;
	}
}
