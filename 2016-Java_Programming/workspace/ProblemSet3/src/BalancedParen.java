/*
 * Set 3 - Q3
 */
import java.util.Scanner;

public class BalancedParen {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		Stackv1 stack = new Stackv1();
		boolean flag = true;
		for (int i = 0; i < input.length(); ++i) {
			char x = input.charAt(i);
			if (x == '[' || x == '(' || x == '{')
				stack.push(x);
			else {
				if (stack.peep() == null) {
					flag = false;
					break;
				}
				String y = stack.pop().toString();
					
				if (!((y.equals("[") && x == ']') || 
					  (y.equals("{") && x == '}') || 
					  (y.equals("(") && x == ')'))) { 
					flag = false;
					break;
				}
			}
		}
		if (stack.isEmpty() && flag)
			System.out.println("Balanced");
		else 
			System.out.println("Not Balanced");
		s.close();
	}
}
