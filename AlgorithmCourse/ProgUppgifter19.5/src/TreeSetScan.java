import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class TreeSetScan {
	

	public static void main(String[] args) {
		File gran = new File("exptext.txt");
		Scanner txt;
		try {
			txt = new Scanner(gran); // it go in ascii code 
		
		TreeSet<String> tall = new TreeSet<String>();
		while (txt.hasNext()) {
			tall.add(txt.next());
		}
		Iterator<String> alm = tall.iterator();
		
		while(alm.hasNext()) {
			System.out.print(alm.next());
		}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
