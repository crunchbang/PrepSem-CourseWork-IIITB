import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

public class CorpusAnalyzer {
	
	private static HashMap<String, Integer> wordDict = new HashMap<String, Integer>();
	private PrintWriter out; 


	public void createWordDict(String fileName) throws IOException {

		//read the file
		FileReader f = new FileReader(fileName);
		BufferedReader br = new BufferedReader(f);
		out = new PrintWriter(new BufferedOutputStream(System.out));
		// read a line
		String line;
		String regEx = "\\P{Alpha}+";
		while ((line = br.readLine()) != null) {
			//out.println(line); // DEBUG
			String[] tokens = line.toLowerCase().split(regEx, -1);
			//tokenize the input into word
			//ignore non-alphabet symbols
			for (String word : tokens) {
				//out.println(word + "|"); //DEBUG
				//ugly hack
				if (word.equals(""))
					continue;
				int freq = wordDict.containsKey(word) ? wordDict.get(word) : 0;
				wordDict.put(word, ++freq);
			}
		}
		showDict(); //DEBUG
		//store into a hash map <word, no_of_occurrences>
		out.close();
	}

	public void showDict() {
		for (String item : wordDict.keySet()) {
			String val = wordDict.get(item.toString()).toString();
			System.out.println(item + " " + val);
		}
	}
	
	public void edits()
	{
		
	}
	
	void transpose() {
		
	}
	void inserts() {
		
	}
	void deletes() {
		
	}
	void replace() {
		
	}
	

}
