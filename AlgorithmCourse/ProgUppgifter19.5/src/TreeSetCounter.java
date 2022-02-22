import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;
/**
 * <h1></h1>
 * <p>
 * #About</br>
 * Count frequency of the character in the text file and write it out.
 * </p>
 * @author fredrik
 * @verison 1.0
 * @params tree is a TreeSet with CounterPlusName as object
 */
public class TreeSetCounter {
	private static TreeSet<CounterPlusName> tree = new TreeSet<CounterPlusName>();

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		try {
			Scanner scan = new Scanner(new File("exptext.txt"));

			while (scan.hasNext()) {
				addWord(scan.next());
			}
			getMaxFrek();
			printList();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static void addWord(String word) {
		Iterator<CounterPlusName> itr = tree.iterator();
		boolean looking = false;
		while (itr.hasNext() && !looking) {
			CounterPlusName temp = itr.next();
			if (temp.getName().equals(word)) {
				temp.setCounter(temp.getCounter() + 1);
				looking = true;
			}
		}
		if (!looking) {
			tree.add(new CounterPlusName(word, 1));
		}
	}

	public static void makeEmpty() {
		tree.clear();
	}

	@SuppressWarnings("unused")
	public static void getMaxFrek() {
		Iterator<CounterPlusName> itr = tree.iterator();
		CounterPlusName max = new CounterPlusName("0", 0);
		while (itr.hasNext()) {
			CounterPlusName temp = itr.next();
			int telus;
			String uranus;
			if (max.getCounter() < temp.getCounter()) {
				telus = max.getCounter();
				uranus = max.getName();
				max.setCounter(temp.getCounter());
				max.setName(temp.getName());
			}
		}
		System.out.println("Most frekvwent is: " + max.getName());
		System.out.println("How many times: " + max.getCounter());

	}
	

	public static void printList() {
		Iterator<CounterPlusName> itr = tree.iterator();
		int count = 0;
		System.out.println("This is the whole list:");
		while (itr.hasNext()) {
			CounterPlusName temp = itr.next();
			System.out.print(temp.getCounter() + " " + temp.getName() + " ");
			count++;
		}
		System.out.println("----------");
		System.out.println(count);
	}

}
