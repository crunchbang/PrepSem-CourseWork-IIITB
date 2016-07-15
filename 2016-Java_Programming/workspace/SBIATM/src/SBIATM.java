import java.util.Scanner;

public class SBIATM implements ATMInterface{

	@Override
	public void makeTransaction() {
		System.out.println("1. Deposit\n2. Withdrawal\n3.Balance Enquiry\n");
		Scanner s = new Scanner(System.in);
		int choice = s.nextInt();
		Transaction tx = null;
		switch(choice) {
		case 1:	tx = new Deposit();
				break;
		case 2:	tx = new Withdrawal();
				break;
		case 3:	tx = new BalanceEnquiry();
				break;
			
		}
		tx.executeTransaction();
		s.close();
	}

	@Override
	public void otherServices() {
		System.out.println("No other services available");
	}
}
