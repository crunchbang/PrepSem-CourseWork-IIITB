package com.iiitb.taxifleet;

import javax.swing.JFrame;

public class ShowGUI {
	static JFrame frame;

	public static void main(String[] args) {
		frame = new JFrame("ShowStuff");
		TaxiPanel cpanel = new TaxiPanel("input.json");
		frame.add(cpanel);
		frame.setSize(1000, 768);
		frame.setVisible(true);

	}
}

