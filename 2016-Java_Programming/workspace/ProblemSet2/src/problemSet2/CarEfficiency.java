package problemSet2;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class CarEfficiency {

        public static void main(String[] args) throws FileNotFoundException{

                Scanner s = new Scanner(new File("input.txt"));
                int nCars = s.nextInt();
                Car[] fleet = new Car[nCars];
                

                int type;
                double efficiency, fuelOrChargeLeft;
                
                for (int i = 0; i < nCars; ++i) {
                        type = s.nextInt();
                        efficiency = s.nextDouble();
                        fuelOrChargeLeft = s.nextDouble();
                        if (type == 1) {
                                fleet[i] = new DieselCar(efficiency, fuelOrChargeLeft);
                        } else {
                                fleet[i] = new ElectricCar(efficiency, fuelOrChargeLeft);
                        }
                        
                        System.out.println("Car "+ (i+1) + ": range = " + fleet[i].calculateRange());
                        
                }
        }
}

abstract class Car {
        double efficiency;
        abstract double calculateRange();
}

class DieselCar extends Car {
        double fuelLeft;

        public DieselCar(double efficiency, double fuelLeft) {
                this.efficiency = efficiency;
                this.fuelLeft = fuelLeft;
        }

        double calculateRange() {
                return fuelLeft * efficiency;

        }
}

class ElectricCar extends Car {
        double chargeLeft;

        public ElectricCar(double efficiency, double chargeLeft) {
                this.efficiency = efficiency;
                this.chargeLeft = chargeLeft;
        }

        double calculateRange() {
                return chargeLeft*1000 / efficiency;
        }
}
