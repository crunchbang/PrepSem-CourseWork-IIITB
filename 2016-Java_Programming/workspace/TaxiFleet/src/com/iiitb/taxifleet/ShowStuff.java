package com.iiitb.taxifleet;

import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import com.test.json.JSONObject;
import com.test.json.JSONParser;
import com.test.json.JSONValue;
import com.test.json.ParseException;

/*
 * Reference JSON
 * {
  "data": [
    {
      "id":"1",
      "x": "20",
      "y": "30",
      "boolean": "true"
    },
    {
      "id":"2",
      "x": "200",
      "y": "300",
      "boolean": "false"
    }]
}
 */

public class ShowStuff {

	static List<Car> parseJSON(String inputFile) throws ParseException {

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
	public static void main(String[] args) {

		try {
			drawStuff();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	static void drawStuff() throws ParseException {
		JFrame frame = new JFrame("ShowStuff");

		List<Car> carFleet = parseJSON("input.json");
		for (Car c: carFleet) {
			System.out.println(c);
			CarButton cb = new CarButton(c);
			frame.add(cb);
		}
		frame.setLayout(null);
		frame.setSize(1000, 800);
		frame.setVisible(true);

	}


}
