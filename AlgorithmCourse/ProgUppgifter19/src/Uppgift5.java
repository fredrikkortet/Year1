/**
 * <h1>Uppgift5.java</h1>
 * <p>
 * This program should a text and count the character in that txt file. 
 * </p>
 * 
 * @author Fredrik
 * @version 1.0
 * @since 2019-03-30
 */
import java.io.*;
import java.util.*;

public class Uppgift5
{

	public static void main(String[] args)
	{
		String regex = "\\s";
		String regex2 = "\\W";
		String word="";
			File file = new File("TEXT.txt");
		try {
			@SuppressWarnings("resource")
			Scanner sentence = new Scanner(file);
		
		
			while (sentence.hasNext())
			{
				word = word + sentence.nextLine();
				word = word.replaceAll(regex, "");
				word = word.replaceAll(regex2, "");
				
			}
			Frekvent.usage(word);
		}
		catch (FileNotFoundException e) {
            e.printStackTrace();
			
		}

	}
}
