import java.util.Scanner;


public class HelloWorld {

        public static void main(String[] args) {
                Scanner s = new Scanner(System.in);
                int n = s.nextInt();

                for (int i = 0; i < n; ++i)
                        System.out.println("Hello World");

                s.close();
        }
}

