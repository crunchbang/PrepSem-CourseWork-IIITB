package com.test.json;

import java.io.FileNotFoundException;

public class TestJSON {

	public static void main(String[] args) throws FileNotFoundException, ParseException {

		System.out.println(new JSONParser("json3.txt").parse());
	}


}
