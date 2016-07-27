package com.iiitb.taxifleet;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class TaxiButton extends JButton implements MouseListener{
	private Taxi c;
	private static int length = 50;
	private static int breadth = 50;

	public TaxiButton(Taxi m) {
		super();
		this.c = m;

		this.setText(Integer.toString(m.getTaxiId()));
		this.setBounds(m.getLocation().getX(), m.getLocation().getY(), length, breadth);
		this.setBorder(null);
		if (!m.isBusy())
			this.setBackground(Color.GREEN);
		else
			this.setBackground(Color.RED);
		this.addMouseListener(this);
		String status = m.isBusy() ? "Busy" : "Available";
		this.setToolTipText(m.getTaxiId() + " " + status);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!c.isBusy()) {
			this.setBackground(Color.RED);
			c.setIsBusy(true);
			this.setToolTipText(c.getTaxiId() + " " + "Busy");
		}
		System.out.println(c);


	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}


}
