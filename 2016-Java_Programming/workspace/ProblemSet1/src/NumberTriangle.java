
public class NumberTriangle {

	public static void main(String[] args){
		
		String out = "0";
		System.out.println(out);
		for (int i = 0; i < 9; ++i) {
			System.out.print(out);
			System.out.print(i+1);
			String outBack = new StringBuffer(out).reverse().toString();
			System.out.println(outBack);
			out = out + Integer.toString(i+1);

		}
	}
}
