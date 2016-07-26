package com.test.json;

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

	private JSONTokenizer jTok; 
	private Token t;

	public JSONParser(String file) {
		try {
			jTok = new JSONTokenizer(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public JSONObject parse() throws ParseException {
			JSONObject x = OBJECT();
			return x;
		
	}


	private JSONObject OBJECT() throws ParseException {
		JSONObject obj = null; 
		t = jTok.getNextToken();
		if (!(t.getToken() == Symbol.OPEN_B)) {
			throw new ParseException("Missing {");
		}

		obj = MEMBER();
		t = jTok.getNextToken();
		if (!(t.getToken() == Symbol.CLOSE_B)) {
			throw new ParseException("Missing }");
		}
		return obj;
	}

	private JSONObject MEMBER() throws ParseException {
		JSONObject obj = new JSONObject();
		HashMap<String, JSONValue> p = PAIR();
		obj.addAll(p);
		if (jTok.peek() == ',') {
			t = jTok.getNextToken();
			obj.addAll(MEMBER().getKeyValue());
		}
		return obj;
	}


	private HashMap<String, JSONValue>  PAIR() throws ParseException {
		String s = STR();
		Token t = jTok.getNextToken();
		if (!(t.getToken() == Symbol.COLON)) {
			throw new ParseException("Missing :");
		}
		JSONValue v = VAL();
		HashMap<String, JSONValue> keyValPair = new HashMap<String, JSONValue>();
		keyValPair.put(s, v);
		return keyValPair;
	}

	private String STR() throws ParseException {
		Token t = jTok.getNextToken();
		if (!(t.getToken() == Symbol.DQUOTE)) {
			throw new ParseException("Missing \"");
		}
		String str = jTok.getNextToken().getLexeme();
		if (!(t.getToken() == Symbol.DQUOTE)) {
			throw new ParseException("Missing \"");
		}
		t = jTok.getNextToken();

		return str;
	}

	private JSONValue VAL() throws ParseException {
		char c = jTok.peek();
		switch(c) {
		case '"':
			return new JSONValue(STR());
		case '{':
			return new JSONValue(OBJECT());
		case '[':
			return new JSONValue(ARR());
		default:
			throw new ParseException("Invalid or Malformed value (Read " + c + ")");
		}
	}

	private JSONValue[] ARR() throws ParseException {
		t = jTok.getNextToken();
		if (!(t.getToken() == Symbol.OPEN_SQ)) {
			throw new ParseException("Missing [");
		}
		JSONValue[] jArr = ELEMENT();
		t = jTok.getNextToken();
		if (!(t.getToken() == Symbol.CLOSE_SQ)) {
			throw new ParseException("Missing ]");
		}
		return jArr;
	}

	private JSONValue[] ELEMENT() throws ParseException {
		List<JSONValue> jA = new ArrayList<JSONValue>();
		jA.add(VAL());
		if (jTok.peek() == ',') {
			t = jTok.getNextToken(); 
			jA.addAll(Arrays.asList(ELEMENT()));
		}
		return jA.toArray(new JSONValue[jA.size()]);
	}

}