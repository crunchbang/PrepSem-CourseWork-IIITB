import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CarFleet {

	public static void main(String[] args) throws FileNotFoundException {
		
		Car fleet[];
		int n = 1; //stub value
		int t;
		float e, fOrC;
		
		Scanner s = new Scanner(new File("CarTestInput.txt"));
		n = s.nextInt();
		fleet = new Car[n];
		for (int i = 0; i < n; ++i) {
			t = s.nextInt();
			e = s.nextFloat();
			fOrC = s.nextFloat();
			fleet[i] = new Car(t, e, fOrC);
		}
		
		float range;
		for (int i = 0; i < n; ++i) {
			range = fleet[i].calculateRange();
			System.out.println("Car " + (i+1) + ": range = " +range);
		}
		
		s.close();
	}
	
}

class Car {
	int type;
	float efficiency;
	float fuelOrChargeLeft;
	
	public Car(int t, float e, float fOrC){
		type = t;
		efficiency = e;
		fuelOrChargeLeft = fOrC;
	}
	
	float calculateRange() {
		float range;
		if (type == 1) { //diesel cars
			range = fuelOrChargeLeft * efficiency;
		} else { //electric cars
			range = fuelOrChargeLeft * 1000 / efficiency;
		}
		
		return range;
		
	}
	
	
}