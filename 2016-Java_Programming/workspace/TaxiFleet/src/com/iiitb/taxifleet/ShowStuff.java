package com.iiitb.taxifleet;

import javax.swing.JFrame;

public class ShowStuff {
	static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("ShowStuff");
		CarPanel cpanel = new CarPanel("input.json");
		frame.add(cpanel);
		frame.setSize(1000, 1000);
		frame.setVisible(true);

	}
}

