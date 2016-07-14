import java.util.Scanner;

public class NHelloWorld {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int nLines = in.nextInt();
		while (nLines-- > 0) {
			System.out.println("Hello World");
		}
		in.close();
	}
}
