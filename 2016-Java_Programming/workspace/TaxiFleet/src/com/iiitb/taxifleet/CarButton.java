package com.iiitb.taxifleet;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class CarButton extends JButton implements MouseListener{
	private Car c;
	private static int length = 50;
	private static int breadth = 50;

	public CarButton(Car c) {
		super();
		this.c = c;
		
		this.setText(c.getId());
		this.setBounds(c.getLocX(), c.getLocY(), length, breadth);
		this.setBorder(null);
		if (c.isAvailable())
			this.setBackground(Color.GREEN);
		else
			this.setBackground(Color.RED);
		this.addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (c.isAvailable()) {
			this.setBackground(Color.RED);
			c.setAvailable(false);
		}
		System.out.println(c);
		
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		this.setToolTipText(c.getId() + " " + c.getStatus());
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		this.setToolTipText(c.getId()); 
		
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
