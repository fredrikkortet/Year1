
public class CounterPlusName implements Comparable<CounterPlusName> {
	private String name;
	private int counter;

	public CounterPlusName(String word, int count) {
		name = word;
		counter = count;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public int compareTo(CounterPlusName arg0) {

		return name.compareTo(arg0.getName());
	}

}
