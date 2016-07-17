import java.io.IOException;

public class SpellChecker22 {
	
	public static void main(String[] args) {
		
		try {
			CorpusAnalyzer c = new CorpusAnalyzer();
			c.createWordDict("big_doc.txt");
			//System.out.println("Done");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//c.showDict();
		
	}

}
