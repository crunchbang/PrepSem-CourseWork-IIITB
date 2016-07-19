import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CorpusAnalyzer {

	private static char[] charArray = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	private HashMap<String, Integer> wordDict; 
	private ArrayList<Pair> partitions;
	private Set<String> suggestions;

	public void createWordDict(String fileName) throws IOException {

		wordDict = new HashMap<String, Integer>();
		//read the file
		FileReader f = new FileReader(fileName);
		BufferedReader br = new BufferedReader(f);
		// read a line
		String line;
		String regEx = "\\P{Alpha}+";
		while ((line = br.readLine()) != null) {
			String[] tokens = line.toLowerCase().split(regEx, -1);
			//tokenize the input into word
			//ignore non-alphabet symbols
			for (String word : tokens) {
				//ugly hack
				if (word.equals(""))
					continue;
				//store into a hash map <word, no_of_occurrences>
				int freq = wordDict.containsKey(word) ? wordDict.get(word) : 0;
				wordDict.put(word, ++freq);
			}
		}
		br.close();
	}

	public void generateEdits(String word) {

		partitions = new ArrayList<Pair>();
		String fst, snd;
		for (int i = 1; i < word.length(); ++i) {
			fst = word.substring(0, i);
			snd = word.substring(i, word.length());
			if (fst != null && snd != null) 
				partitions.add(new Pair(fst, snd));
		}
		partitions.add(new Pair(word, ""));
		partitions.add(new Pair("", word));

		suggestions = new HashSet<String>();
		if (!wordDict.containsKey(word)) {
			suggestions.addAll(inserts());
			suggestions.addAll(deletes());
			suggestions.addAll(transpose());
			suggestions.addAll(replace());
		} else {
			suggestions.add(word);
		}
		
//		showSuggestions();

	}
	
	public void suggestCorrection() {
		String probableSuggestion = new String("");
		int maxScore = 0;
		for (String s : suggestions) {
			int score = wordDict.get(s);
			if (score > maxScore) {
				probableSuggestion = s;
				maxScore = score;
			}
		}
		System.out.println(probableSuggestion);
		
	}

	public ArrayList<String> inserts() {

		ArrayList<String> insertSuggestions = new ArrayList<String>();
		for (Pair p : partitions) {
			for (char c : charArray) {
				String s = p.getFirst() + c + p.getSecond();
				if (wordDict.containsKey(s)) {
					insertSuggestions.add(s);
				}
			}
		}
//		System.out.println("in" + insertSuggestions);
		return insertSuggestions;
	}

	public ArrayList<String> deletes() {

		ArrayList<String> deleteSuggestions = new ArrayList<String>();
		for (Pair p : partitions) {
			if (!p.getSecond().equals("")) {
				String s = p.getFirst() + p.getSecond().substring(1);
				if (wordDict.containsKey(s)) {
					deleteSuggestions.add(s);
				}
			}
		}
//		System.out.println("del" + deleteSuggestions);
		return deleteSuggestions;
	}

	public ArrayList<String> replace() {

		ArrayList<String> replaceSuggestions = new ArrayList<String>();
		for (Pair p : partitions) {
			for (char c : charArray) {
				if(!p.getSecond().equals("")) {
					String s = p.getFirst() + c + p.getSecond().substring(1);
					if (wordDict.containsKey(s)) {
						replaceSuggestions.add(s);
					}
				}
			}
		}
//		System.out.println("re" + replaceSuggestions);
		return replaceSuggestions;
	}

	public ArrayList<String> transpose() {

		ArrayList<String> transposeSuggestions = new ArrayList<String>();
		for (Pair p : partitions) {
			String fst = p.getFirst();
			String snd = p.getSecond();
			if (snd.length() > 2) {
				String s = fst + snd.charAt(1) + snd.charAt(0) + snd.substring(2);
				if (wordDict.containsKey(s)) {
					transposeSuggestions.add(s);
				}
			}
		}
//		System.out.println("tr:" + transposeSuggestions);
		return transposeSuggestions;
	}

	/*
	 * helper functions
	 */
	public void showDict() {
		for (String item : wordDict.keySet()) {
			String val = wordDict.get(item.toString()).toString();
			System.out.println(item + " " + val);
		}
	}

	public void showPartitions() {
		Iterator<Pair> itr = partitions.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	public void showSuggestions() {
		for (String item : suggestions) 
			System.out.print(item + ":");
		System.out.print("\n");
	}

}

/*
 * helper class
 */
class Pair {
	String first;
	String second;

	public Pair(String first, String second) {
		this.first = first;
		this.second = second;
	}

	public String getFirst() {
		return first;
	}
	public void setFirst(String first) {
		this.first = first;
	}
	public String getSecond() {
		return second;
	}
	public void setSecond(String second) {
		this.second = second;
	}

	public String toString() {
		return first + " " + second;
	}
}