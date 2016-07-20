package com.test.json;

import java.io.FileNotFoundException;

public class TestJSON {

	public static void main(String[] args) throws FileNotFoundException {
		JSONTokenizer j = new JSONTokenizer("json.txt");
		Token t;
		//t = j.getNextToken();

		while ((t = j.getNextToken()) != null) {
			System.out.println(t);
		}
	}


}
