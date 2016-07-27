package com.iiitb.taxifleet;

public class User {
	
	int userID;
	int balance;
	int nTrip;
	
	User(int userID, int balance) {
		this.userID = userID;
		this.balance = balance;
		this.nTrip = 0;
	}

	public int getUserID() {
		return userID;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getnTrip() {
		return nTrip;
	}

	public void setnTrip(int nTrip) {
		this.nTrip = nTrip;
	}
	

}
