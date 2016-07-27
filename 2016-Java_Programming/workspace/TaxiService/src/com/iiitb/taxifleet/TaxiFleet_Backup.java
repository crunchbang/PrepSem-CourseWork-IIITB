package com.iiitb.taxifleet;

import java.util.ArrayList;
import java.util.List;

import com.test.json.JSONObject;
import com.test.json.JSONParser;
import com.test.json.JSONValue;
import com.test.json.ParseException;

public class TaxiFleet_Backup {
	private ArrayList<Taxi_Backup> taxiList = new ArrayList<Taxi_Backup>();

	TaxiFleet_Backup(String fileName) {
		try {
			taxiList = parseJSON(fileName);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Taxi_Backup> getTaxies() {
		return taxiList;
		
	}

	private ArrayList<Taxi_Backup> parseJSON(String inputFile) throws ParseException {

		JSONParser jparse = new JSONParser(inputFile);
		JSONObject jo = jparse.parse();
		JSONValue[] carObjects = jo.get("data").getArray();
		ArrayList<Taxi_Backup> taxiList = new ArrayList<Taxi_Backup>();
		for(JSONValue v : carObjects) {
			JSONObject j = v.getObj();
			String id = j.get("id").toString();
			int x = Integer.parseInt(j.get("x").toString());
			int y = Integer.parseInt(j.get("y").toString());
			boolean status = Boolean.parseBoolean(j.get("boolean").toString());
			taxiList.add(new Taxi_Backup(id, x, y, status));
		}
		return taxiList;
	}
	
	void release(Taxi_Backup t, int x, int y) {
		t.setUserID(0);
		t.setLocX(x);
		t.setLocY(y);
		t.setAvailable(true);
	}
	
	Taxi_Backup request(int userID, int x, int y) {
		Taxi_Backup t = getNearestTaxi(x,y);
		t.setUserID(userID);
		t.setAvailable(false);
		t.setLocX(x);
		t.setLocY(y);
		return t;
	}

	private Taxi_Backup getNearestTaxi(int x, int y) {
		Taxi_Backup m = null;
		double minDist = Integer.MAX_VALUE;
		for (Taxi_Backup n: taxiList) {
			if (n.isAvailable()) {
				double dist = calcDistance(x, y, n.getLocX(), n.getLocY());
				if (dist < minDist) {
					minDist = dist;
					m = n;
				}
			}
		}

		return m;
	}
	
	double calcDistance(int x1, int y1, int x2, int y2) {
		double xdiff = x2 - x1;
		double ydiff = y2 - y1;
		double sqrSum = Math.pow(xdiff, 2) + Math.pow(ydiff, 2);
		return Math.sqrt(sqrSum);
	}

}
