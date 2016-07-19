import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class JSONTokenizer {
	
	//read the data from the file into a string
	// split the string into tokens at ','
	// split the resulting tokens further using split at ':'
	// save them as key value pairs
	// TODO : identify their type and perform further tokenziation (assuming they may be 
	// json objects or arrays

	FileReader f;
	BufferedReader br;
	String jsonString = "{ \"name\":\"Ramesh\", \"age\":\"21\", \"grade\":\"A\"}".replaceAll("\\s+", "");

	public JSONTokenizer() {
	}

	public JSONTokenizer(String inputFile) {
		/*
		Scanner scan = new Scanner("json.txt");
		scan.useDelimiter("\\z");
		String jsonString = scan.next();
		scan.close();
		*/
		
	}
	
	public ValueType parseJSON(String input) {
		String keyValuePairs[] = jsonString.split("\\{|,|\\}|\\s+", -1);
		ValueType parsedValue =  new JSONType();

		for (String s : keyValuePairs) {
			if (!s.equals("")) {
				String keyValue[] = s.split(":", -1);
				String key = keyValue[0];
				String value = keyValue[1];
				
				char c = value.charAt(1);
				if (c == '{') 
					parsedValue.add(key, parseJSON(value));
				else if (c == '[') 
					parsedValue.add(key, parseJSONArray(value));
				else 
					parsedValue.add(key, new StringValue(value));
			}
		}
		return parsedValue;
	}
	
	private ValueType parseJSONArray(String value) {
		ValueType parsedValue = new JSONArrayType();
		//assuming first char is [ and last char is ]
		String jsonList[] = value.split("\\[|,|\\]|\\s+", -1);
	}

}