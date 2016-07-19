import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SpellChecker22 {

	public static void main(String[] args) {

		try {
			CorpusAnalyzer c = new CorpusAnalyzer();
			c.createWordDict("big_doc.txt");

			//feed input
			FileReader f = new FileReader("test2.txt");
			BufferedReader inp = new BufferedReader(f);
			String line;
			while ((line = inp.readLine()) != null) {
				String[] input = line.split("\\s+", -1);
				c.generateEdits(input[0]);
				System.out.print(input[0] + ":");
				c.suggestCorrection();
			}
			inp.close();
		} catch (IOException e) {
			System.out.println("Done");
			e.printStackTrace();
		}

	}


}

