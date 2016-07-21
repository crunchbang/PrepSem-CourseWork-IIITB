package com.test.json;

public class JSONValue {
	private String str;
	private JSONObject jObj;
	private JSONValue[] jArray;
	/* Implement 3 constructors each of which takes one of
String, JSONObject or array of JSONValues as argument, and
assigns it to the appropriate field. Only one of these three
fields should be non-null */
	// ... the constructors
	// we will need 3 different methods for accessing the appropriate fields.
	// Note that this helps with strong-typing

	public JSONValue(JSONObject jObj) {
		str = null;
		this.jObj = jObj;
		jArray = null;

	}
	public JSONValue(JSONValue[] jArray) {
		str = null;
		jObj = null;
		this.jArray = jArray;

	}
	public JSONValue(String str) {
		this.str = str;
		jObj = null;
		jArray = null;

	}
	 


	String getString() {
		return str;
	}

	JSONObject getObj() {
		return jObj;
	}

	JSONValue[] getArray() {
		return jArray;
	}

	@Override
	public String toString() {
		if (str != null)
			return str;
		else if (jObj != null)
			return jObj.toString();
		else  {
			StringBuilder repr = new StringBuilder("[ ");
			for (JSONValue v : jArray) {
				repr.append(v + ",");
			}
			repr.deleteCharAt(repr.length()-1);
			repr.append( " ]");
			return repr.toString();
		}
	}

}
