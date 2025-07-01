package banking;
import java.util.Scanner;
public class BankingApp {
	Account acc = new Account();

	public void app() {
		Scanner sc = new Scanner(System.in);
		boolean keepRun = true;

		while (keepRun) {
			System.out.println("\n*** Welcome To Banking App ***");
			System.out.println("1. Create New Account");
			System.out.println("2. Customer Login");
			System.out.println("3. Exit");

			int choice = sc.nextInt();
			sc.nextLine(); // Clear buffer

			switch (choice) {
				case 1:
					System.out.print("Enter Your Name: ");
					String custmrName = sc.nextLine();
					System.out.print("Enter Initial Deposit Amount (1000 or Above): ");
					double balance = sc.nextDouble();

					if (balance < 1000) {
						System.out.println("Minimum First Deposit is ₹1000 or above.");
					} else {
						acc.createAccount(custmrName, balance);
					}
					break;

				case 2:
					System.out.print("Enter Account Number: ");
					int acNo = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter Your Name: ");
					String name = sc.nextLine();

					AccInfo currentAcc = acc.getAccount(acNo, name);
					if (currentAcc != null) {
						boolean login = true;
						while (login) {
							System.out.println("\n--- Welcome, " + name + " ---");
							System.out.println("1. Withdraw");
							System.out.println("2. Deposit");
							System.out.println("3. View Account Detail");
							System.out.println("4. View Transaction History");
							System.out.println("5. Logout");

							int choice2 = sc.nextInt();

							switch (choice2) {
								case 1:
									System.out.print("Enter Amount to Withdraw: ");
									double withdrawAmount = sc.nextDouble();
									acc.withdraw(acNo, name, withdrawAmount);
									break;
								case 2:
									System.out.print("Enter Amount to Deposit: ");
									double depositAmount = sc.nextDouble();
									acc.deposit(acNo, name, depositAmount);
									break;
								case 3:
									System.out.println(currentAcc);
									break;
								case 4:
									acc.showTransactionHistory(acNo);
									break;
								case 5:
									login = false;
									break;
								default:
									System.out.println("Invalid Option!");
							}
						}
					} else {
						System.out.println("Invalid Account Number or Name!");
					}
					break;

				case 3:
					System.out.println("Exiting App...");
					keepRun = false;
					break;

				default:
					System.out.println("Invalid Choice!");
			}
		}
		sc.close();
	}

	public static void main(String[] args) {
		new BankingApp().app();
	}
}
