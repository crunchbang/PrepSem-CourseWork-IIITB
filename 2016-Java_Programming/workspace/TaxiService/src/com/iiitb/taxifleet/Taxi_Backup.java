package com.iiitb.taxifleet;

public class Taxi_Backup {
	private String id;
	private int locX, locY;
	private boolean available;
	private int userID;

	public Taxi_Backup(String id, int locX, int locY, boolean available) {
		super();
		this.id = id;
		this.locX = locX;
		this.locY = locY;
		this.available = available;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int id) {
		this.userID = id;
	}

	public int getLocX() {
		return locX;
	}

	public void setLocX(int locX) {
		this.locX = locX;
	}

	public int getLocY() {
		return locY;
	}

	public void setLocY(int locY) {
		this.locY = locY;
	}

	public boolean isAvailable() {
		return available;
	}
	
	public String getStatus() {
		if (isAvailable())
			return "Available";
		else
			return "Booked";
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Car [id=" + id + ", locX=" + locX + ", locY=" + locY + ", available =" + available + "]";
	}
	

	
	

}