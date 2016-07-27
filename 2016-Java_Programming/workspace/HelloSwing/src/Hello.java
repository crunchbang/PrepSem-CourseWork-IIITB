import java.util.ArrayList;

public class Hello {

	public static void main(String[] args) {
		TaxiFleet t = new TaxiFleet();
		t.start(10);
		ArrayList<Taxi> tlist = t.getTaxis();
		for (Taxi m: tlist)
			System.out.println(m);
	}
}
