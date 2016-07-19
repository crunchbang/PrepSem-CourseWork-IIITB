
public class StringValue extends ValueType {

	String value;

	public StringValue(String value) {
		this.value = value;
	}
	@Override
	public String toString() {
		return value;
	}

	@Override
	public void add(String key, ValueType value) {

	}

}
