
public class NumberTriangle2 {

	public static void main(String[] args){
		
		int nSpaces = 10;
		String out = "0";
		for (int i = 0; i < 10; ++i) {
			for (int k = 0; k < nSpaces; k++) {
				System.out.print(" ");
			}
			nSpaces--;
			if (i == 0) {
				System.out.println(out);
			} else {
				System.out.print(out);
				System.out.print(i);
				String outBack = new StringBuffer(out).reverse().toString();
				System.out.println(outBack);
				out = out + Integer.toString(i);
			}

		}
	}
}
