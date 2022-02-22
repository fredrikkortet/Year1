/**
 * <h1>Palindrom.java</h1>
 * <p>
 * Palindrom see if you can take a word in reverse and that its the same word in
 * both ways.
 * </p>
 * 
 * @author fredrik
 *
 */
public class Palindrom {
	public static void main(String[] args) {
		String word = "raddar"; // test word
		palin(word, 0);

	}

	public static void palin(String word, int i) {
		if (i == (word.length() / 2)) {// check if the counter i is equals to the half word length to take a end
			System.out.print(true);
		} else if (word.charAt(i) == word.charAt(word.length() - 1 - i)) { // check if the value is equal if that its
																			// time to continue
			palin(word, i + 1);
		} else {
			System.out.print(false); // if we dont match it goes here to end the method
		}
	}
}
