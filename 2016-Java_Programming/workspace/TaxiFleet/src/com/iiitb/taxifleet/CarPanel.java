package com.iiitb.taxifleet;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import com.test.json.JSONObject;
import com.test.json.JSONParser;
import com.test.json.JSONValue;
import com.test.json.ParseException;

class CarPanel extends JPanel implements MouseListener{
	List<Car> carFleet;

	CarPanel(String fname) {
		initComponents(fname);
	}

	private void initComponents(String fname) {
		try {
			addMouseListener(this);
			carFleet = parseJSON(fname);
			for (Car c: carFleet) {
				System.out.println(c);
				CarButton cb = new CarButton(c);
				this.add(cb);
				this.setLayout(null);
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	private List<Car> parseJSON(String inputFile) throws ParseException {

		JSONParser jparse = new JSONParser(inputFile);
		JSONObject jo = jparse.parse();
		JSONValue[] carObjects = jo.get("data").getArray();
		List<Car> carFleet = new ArrayList<Car>();
		for(JSONValue v : carObjects) {
			JSONObject j = v.getObj();
			String id = j.get("id").toString();
			int x = Integer.parseInt(j.get("x").toString());
			int y = Integer.parseInt(j.get("y").toString());
			boolean status = Boolean.parseBoolean(j.get("boolean").toString());
			carFleet.add(new Car(id, x, y, status));
		}
		return carFleet;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + " " + y);

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

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