/**
 * <h1>Uppgift7.java</h1>
 * <p>
 * the program send in index to take out the name on that position in array list then <br/>
 * we can delete the value on one position in arraylist  and then we add a name to the list.
 * </p>
 * 
 * @author Fredrik
 * @version 1.0
 * @since 2019-03-30
 */
import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;

public class Uppgift7
{
	public static void main(String[] args) throws FileNotFoundException
	{
		ArrayList<String> nameList = new ArrayList<String>();
		File nameDoc = new File("klasslista.txt");
		@SuppressWarnings("resource")
		Scanner nameFile = new Scanner(nameDoc);

		while (nameFile.hasNextLine())
		{
			nameList.add(nameFile.nextLine());
			
		}
		System.out.println(ArrayDoc.findName(nameList, 1));
		System.out.println(ArrayDoc.findName(nameList, 50));
		System.out.println(ArrayDoc.deleteName(nameList, "Fredrik kortetjärvi"));
		System.out.println(ArrayDoc.deleteName(nameList, "Jan Frick"));
		System.out.println(nameList.get(9)+" : Jan Frick is not exitsing any more ");
		System.out.println(ArrayDoc.addToList(nameList, "John Aronsson"));
		System.out.println(ArrayDoc.addToList(nameList, "Fredrik kortetjärvi"));
		for(int i = 0;i<nameList.size();i++) {
			System.out.println(nameList.get(i));
		}
		

	}
}
