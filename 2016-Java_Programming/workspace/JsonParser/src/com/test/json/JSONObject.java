package com.test.json;

import java.util.HashMap;
import java.util.Map;

public class JSONObject {

	private Map<String, JSONValue> keyValue;

	public JSONObject() {
		keyValue = new HashMap<String, JSONValue>();
	}

	// add a name/value pair to the object
	public void add(String name, JSONValue value) {
		keyValue.put(name, value);
	}

	public void addAll(Map<String, JSONValue> kvPair) {
		keyValue.putAll(kvPair);
	}

	public Map<String, JSONValue> getKeyValue() {
		return keyValue;
	}

	// return the value corresponding to a name.
	// return null if the name does not exist
	public JSONValue get(String name) {
		return keyValue.get(name);
	}

	public String toString() {

		StringBuilder str = new StringBuilder("");
		str.append("{\n");
		for (String i : keyValue.keySet()) {
			str.append(i + " : " + keyValue.get(i).toString() +",\n");
		}
		str.append("\n}\n");
		return str.toString();
	}
}