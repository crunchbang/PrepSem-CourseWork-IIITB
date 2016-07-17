import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SpellChecker22 {

	public static void main(String[] args) {

		try {
			CorpusAnalyzer c = new CorpusAnalyzer();
			c.createWordDict("big_doc.txt");
			System.out.println("Done");

			//feed input
			FileReader f = new FileReader("test1.txt");
			BufferedReader inp = new BufferedReader(f);
			String line;
			while ((line = inp.readLine()) != null) {
				String[] input = line.split("\\s+", -1);
				c.edits(input[0]);
			}
			//c.showPartitions();
			inp.close();
		} catch (IOException e) {
			System.out.println("Done");
			e.printStackTrace();
		}

	}


}

