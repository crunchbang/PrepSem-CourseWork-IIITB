package com.iiitb.taxifleet;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

class TaxiPanel extends JPanel implements MouseListener{
	ArrayList<Taxi> taxis;
	TaxiFleet tf;
	int tStatus;
	User user;
	short secondClick = 0;
	int x = 0;
	Timer timer;

//	MyRunnable r;

	TaxiPanel(String fname) {
		initComponents(fname);
	}

	private void initComponents(String fname) {
		addMouseListener(this);

//		r=new MyRunnable();
//		Thread t=new Thread(r);

		user = new User(30, 100);
		//tf = new TaxiFleet_Backup("input.json");
		tf = new TaxiFleet();
		tf.start(3);
		taxis = tf.getTaxis();
		for (Taxi m: taxis) {
			System.out.println(x + ":" + m);
			TaxiButton tb = new TaxiButton(m);
			add(tb);
		}
		this.setLayout(null);
//		t.start();

		timer = new Timer(1000, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				//tf = new TaxiFleet_Backup("input.json");
				taxis = tf.getTaxis();
				for (Taxi m: taxis) {
					System.out.println(x + ":" + m);
					TaxiButton tb = new TaxiButton(m);
					add(tb);
				}
				validate();
				repaint();
				setLayout(null);
				System.out.println("Refreshed");
			}
		});
		timer.start();
	}



	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + " " + y);
		secondClick++;
		if (secondClick == 1) {
			tStatus = tf.request(user.getUserID(), new Location(x, y));
			if (tStatus == -1)
				System.out.println("Taxi not available");
			//taxi not available - update balance
			//redraw
			
		}
		else if (secondClick == 2) {
			secondClick = 0;
			tf.release(user.getUserID(), new Location(x, y));
			int trip = user.getnTrip();
			user.setnTrip(trip+1);
			//update balance
			//redraw
			
		}


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}
}