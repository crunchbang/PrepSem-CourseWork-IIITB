import java.util.ArrayList;

public class JSONArrayType extends ValueType {
	ArrayList<ValueType> jsonObjects;

	
	public JSONArrayType() {
		jsonObjects = new ArrayList<ValueType>();
	}
	
	@Override
	public String toString() {
		StringBuilder repr = new StringBuilder();
		for (ValueType o : jsonObjects) {
			repr.append(o.toString());
		}
		return repr.toString();
	}

	//TODO Ugly. Fix later
	@Override
	public void add(String key, ValueType value) {
		jsonObjects.add(value);

		
	}

}
