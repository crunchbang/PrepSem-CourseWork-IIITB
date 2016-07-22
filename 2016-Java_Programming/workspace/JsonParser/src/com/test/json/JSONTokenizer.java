package com.test.json;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import com.test.json.Token.Symbol;

public class JSONTokenizer {

	private	String jsonString; 
	private	int pos;
	private char c;

	public JSONTokenizer(String inputFile) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(inputFile));
		scan.useDelimiter("\\Z");
		jsonString = scan.next();
		scan.close();
		
		//jsonString = jsonString.replaceAll("\\s+", "");
		
		pos = 0;
	}
	
	public char peek() {
		c = jsonString.charAt(pos);
		while (Character.isWhitespace(c)) {
			pos++;
			c = jsonString.charAt(pos);
		}
		return jsonString.charAt(pos);
	}

	public Token getNextToken() {
		StringBuilder lexeme = new StringBuilder();
		Symbol token = null; 
		boolean insideString = false;

		if (pos >= jsonString.length())
			return null;
		c = jsonString.charAt(pos);
		while (Character.isWhitespace(c)) {
			pos++;
			c = jsonString.charAt(pos);
		}
		if (Character.isLetterOrDigit(c)) {
			token = Symbol.ALPANUM;
			insideString = true;
			while (insideString) { 
				lexeme.append(c);
				pos++;
				c = jsonString.charAt(pos);
				if (c == '"')
					insideString = false;
			}
		} else {
			switch (c) {
			case '{':	
				lexeme = new StringBuilder("{");
				token = Symbol.OPEN_B;
				break;
			case '}':	
				lexeme = new StringBuilder("}");
				token = Symbol.CLOSE_B;
				break;
			case '[':	
				lexeme = new StringBuilder("[");
				token = Symbol.OPEN_SQ;
				break;
			case ']':	
				lexeme = new StringBuilder("]");
				token = Symbol.CLOSE_SQ;
				break;
			case '"':	
				lexeme = new StringBuilder("\"");
				token = Symbol.DQUOTE;
				break;
			case ',':	
				lexeme = new StringBuilder(",");
				token = Symbol.COMMA;
				break;
			case ':':	
				lexeme = new StringBuilder(":");
				token = Symbol.COLON;
				break;
			}
			pos++;
		}
		return new Token(lexeme.toString(), token);
	}
}