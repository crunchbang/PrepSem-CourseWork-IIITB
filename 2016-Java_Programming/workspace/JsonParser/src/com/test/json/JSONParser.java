package com.test.json;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.test.json.Token.Symbol;

/*
 * JSON Grammar
 * ===========
 * 
 * OBJECT 	-> {} | { MEMBERS }
 * MEMBERS 	-> PAIR | PAIR , MEMBERS
 * PAIR 	-> STRING : VALUE
 * ARRAY 	-> [] | [ ELEMENTS ]
 * ELEMENTS -> VALUE | VALUE , ELEMENTS
 * VALUE 	-> STRING | NUMBER | OBJECT | ARRAY
 * STRING 	-> "[a-zA-Z]+"
 * 
 */
public class JSONParser {

	private JSONTokenizer j; 
	private Token t;

	public JSONParser() {
		try {
			j = new JSONTokenizer("json.txt");
			Token t;
			JSONObject x = OBJECT();
				System.out.println("main" +x);
//				
//				  while ((t=j.getNextToken()) != null)
//				  	System.out.println(t);
				 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// TODO: Implement error checking

	public JSONObject OBJECT() {
		JSONObject obj = null; 
		Token t = j.getNextToken();
		System.out.println("O" +t);
		if (!(t.getToken() == Symbol.OPEN_B)) {
			//throw error
		}

		obj = MEMBER();
		t = j.getNextToken();
		System.out.println("Ox" +t);
		if (!(t.getToken() == Symbol.CLOSE_B)) {
			//throw error
		}
		return obj;
	}

	public JSONObject MEMBER() {
		JSONObject obj = new JSONObject();
		HashMap<String, JSONValue> p = PAIR();
		obj.addAll(p);
		if (j.peek() == ',') {
			Token t = j.getNextToken();
				System.out.println("M"+t);
			obj.addAll(MEMBER().getKeyValue());
		}
		return obj;
	}


	public HashMap<String, JSONValue>  PAIR() {
		String s = STR();
		Token t = j.getNextToken();
				System.out.println("P"+t);
		if (!(t.getToken() == Symbol.COLON)) {
			//throw error
		}
		JSONValue v = VAL();
		HashMap<String, JSONValue> h = new HashMap<String, JSONValue>();
		h.put(s, v);
		return h;
	}

	public String STR() {
		Token t = j.getNextToken();
		System.out.println("S"+t);
		if (!(t.getToken() == Symbol.DQUOTE)) {
			//throw error
		}
		String s = j.getNextToken().getLexeme();
		System.out.println("S"+s);
		t = j.getNextToken();
		System.out.println("S"+t);

		return s;
	}

	public JSONValue VAL() {
		char c = j.peek();
				//System.out.println("vv" +t);
		switch(c) {
		case '"':
			return new JSONValue(STR());
		case '{':
			return new JSONValue(OBJECT());
		case '[':
			return new JSONValue(ARR());
		default:
			//throw error;
		}
		return null;
	}

	public JSONValue[] ARR() {
		Token t = j.getNextToken();
		JSONValue[] jArr = null;
		if (!(t.getToken() == Symbol.OPEN_SQ)) {
			//throw error
		}
		jArr = E();
		if (!(t.getToken() == Symbol.CLOSE_SQ)) {
			//throw error
		}
		return jArr;
	}

	public JSONValue[] E() {
		List<JSONValue> jA = new ArrayList<JSONValue>();
		jA.add(VAL());
		if (j.peek() == ',') {
			Token t = j.getNextToken(); 
			jA.addAll(Arrays.asList(E()));
			t = j.getNextToken();
		}
		return jA.toArray(new JSONValue[jA.size()]);
	}


	class Pair {
		String key;
		JSONValue value;

		public Pair(String key, JSONValue value) {
			this.key = key;
			this.value = value;

		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public JSONValue getValue() {
			return value;
		}
		public void setValue(JSONValue value) {
			this.value = value;
		}

	}
}

