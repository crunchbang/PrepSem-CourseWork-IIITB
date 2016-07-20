package com.test.json;

import java.util.HashMap;

public class Token {

	private HashMap<Symbol, String> symbolString = new HashMap<Symbol, String>();

	public enum Symbol { 
		OPEN_B,
		CLOSE_B,
		OPEN_SQ,
		CLOSE_SQ,
		DQUOTE,
		COMMA,
		COLON,
		ALPANUM 
	};

	String lexeme;
	Symbol token;

	public Token(String lexeme, Symbol token) {
		this.lexeme = lexeme;
		this.token = token;

		symbolString.put(Symbol.OPEN_B, "OPEN_B");
		symbolString.put(Symbol.CLOSE_B, "CLOSE_B");
		symbolString.put(Symbol.OPEN_SQ, "OPEN_SQ");
		symbolString.put(Symbol.CLOSE_SQ, "CLOSE_SQ");
		symbolString.put(Symbol.DQUOTE, "DQUOTE");
		symbolString.put(Symbol.COMMA, "COMMA");
		symbolString.put(Symbol.COLON, "COLON");
		symbolString.put(Symbol.ALPANUM, "ALPHANUM");
	}

	public String getLexeme() {
		return lexeme;
	}
	public void setLexeme(String lexeme) {
		this.lexeme = lexeme;
	}
	public Symbol getToken() {
		return token;
	}
	public void setToken(Symbol token) {
		this.token = token;
	}

	@Override
	public String toString() {
		if (token == Symbol.ALPANUM)
			return lexeme;
		return symbolString.get(token);
	}

}
