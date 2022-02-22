import java.util.*;
import java.io.*;

/**
 * <h1>HuffmanKompremremering.java</h1>
 * <p>
 * #Question</br>
 * It will compromise less if its more character in the text thats way its less
 * compromised in java files. </br>
 * #About</br>
 * This class use Huffman coding to compromise files
 * </p>
 * 
 * @params theForest store my trees in @makeTree
 * @params freqs store the freqs of every character from the file
 * @params codes store the character we get form the file only once
 * @params namFromFile get the name of the file
 * @author fredrik
 * @version 2.5
 * 
 */

class HuffmanKomprimering {

	private static ArrayList<HuffmanTree> theForest;
	private static int[] freqs = new int[256];
	private static String[] codes = new String[256];
	private static String nameFromFile;

	/**
	 * <h3>readFile</h3>
	 * <p>
	 * #About</br>
	 * Read file from to the codes and freqs array with char
	 * </p>
	 * 
	 * @param filename take the file name from input
	 * 
	 */
	private static void readFile(String filename) {
		try {
			nameFromFile = filename; // get the name to the @makeFile
			@SuppressWarnings("resource")
			BufferedReader file = new BufferedReader(new FileReader(filename));
			int ascii = file.read(); // take the ascii code and read it in the file
			while (ascii != -1) { // read the file untill the end=-1

				if (codes[ascii] != null) {
					if (codes[ascii].equals(Integer.toString(ascii))) { // check if its already been seen
						freqs[ascii] += 1;

					}
				} else {
					codes[ascii] = Integer.toString(ascii); // else it set new to the array
					freqs[ascii] = 1;
				}
				ascii = file.read();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * <h3>makeTree</h3>
	 * <p>
	 * #About</br>
	 * Make one big tree of all the character we get from the file
	 * </p>
	 */
	private static void makeTree() {

		HuffmanTree tree = null;
		HuffmanTree tree2 = null;

		for (int i = 0; i < codes.length; i++) { // Add all the Character to a tree for it self
			if (codes[i] == null) {
			} else {
				Integer temp = Integer.valueOf(codes[i]);
				tree = new HuffmanTree(temp, freqs[i]);
				theForest.add(tree);
			}
		}
		do { // Will sort the trees in freqs and take the trees and merge them together
			theForest.sort(null);
			tree2 = (HuffmanTree) theForest.remove(1);
			tree = (HuffmanTree) theForest.remove(0);
			theForest.add(new HuffmanTree(tree, tree2));// merge them together

		} while (theForest.size() != 1);// end when all it one big tree

	}

	/**
	 * <h3>makeCods</h3>
	 * <p>
	 * #About </br>
	 * Make Character to Binary code of the big tree we get from the @makeTree
	 * </p>
	 */
	private static void makeCods() {
		HuffmanTree bigTree = (HuffmanTree) theForest.get(0);
		bigTree.codes(codes);// send it to HufffmanTree,java and it count down the legs of the tree to make
							// binary code of the charactars

	}

	/**
	 * <h3>showResults</h3>
	 * <p>
	 * #About</br>
	 * Show every character in the Array codes with there frequency and binary code.
	 * </p>
	 */
	private static void showResults() {
		for (int i = 0; i < codes.length; i++) {
			if (codes[i] == null) {
			} else {
				char value = (char) i;
				System.out.println(value + " " + freqs[i] + " " + codes[i]);
			}
		}
	}

	/**
	 * <h3>makeFile</h3>
	 * <p>
	 * #About</br>
	 * Make the file with the new compresed character that will be out new file
	 * </p>
	 */
	@SuppressWarnings("resource")
	private static void makeFile() {
		try {
			FileOutputStream compressFile = new FileOutputStream("compressed.txt");
			DataOutputStream compress = new DataOutputStream(compressFile); // make it so we can get in bit correctly
			BufferedReader file = new BufferedReader(new FileReader(nameFromFile));
			int ascii = file.read();
			String holder = "";
			while (ascii != -1) { // will take every binary and merge them together in one String
				holder += codes[ascii];

				ascii = file.read();
			}
			String temp = "";
			int count = 0;// count the compresed bites
			for (int i = 0; i < holder.length(); i++) {// will take the whole string and a for loop around it

				temp += holder.charAt(i);
				if (temp.length() == 8) {// until its 8 
					count++;
					compress.write(stringTobyte(temp)); //make it a byte and write it 
					temp = "";
				}
			}
			
			compressFile.write(Integer.parseInt(temp));
			System.out.print(count);

			compress.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


	public static byte stringTobyte(String s) {
		byte b = 0;
		if (s.length() != 8) {
			throw new RuntimeException("The string representation of the byte in not of proper length!");
		}
		for (int i = 0; i < 8; i++) {
			if (s.charAt(i) == '1')
				b |= (1 << (7 - i));

		}
		return b;
	}

	@SuppressWarnings({ "resource" })
	public static void main(String[] a) {
		theForest = new ArrayList<HuffmanTree>();
		Scanner scan = new Scanner(System.in);
		System.out.println("Ange filens namn");
		String fileName = scan.next();
		readFile(fileName);
		makeTree();
		HuffmanTree ex = (HuffmanTree) theForest.get(0);
		System.out.println(ex.getWeight());
		makeCods();
		showResults();
		makeFile();
	}
}
