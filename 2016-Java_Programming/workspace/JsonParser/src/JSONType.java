import java.util.HashMap;

public class JSONType extends ValueType {

	HashMap<String, ValueType> keyValuePairs;
	
	public JSONType() {
		keyValuePairs = new HashMap<String, ValueType>();
	}

	@Override
	public String toString() {
		StringBuilder repr = new StringBuilder();
		for (String key : keyValuePairs.keySet())   {
			String item = new String(key + ":" + keyValuePairs.get(key));
			repr.append(item);
		}
		return repr.toString();
	}

	@Override
	public void add(String key, ValueType value) {
		keyValuePairs.put(key, value);
	}

}
