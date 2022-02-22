
/**
 * <h1>Uppgift6.java</h1>
 * <p>
 * This program should take a text file and encrypt the text to a new text file,
 * <br/>
 * then it should decrypt the text to see what was encrypt.
 * </p>
 * 
 * @author Fredrik
 * @version 1.0
 * @since 2019-03-30
 */
import java.io.*;
import java.util.Scanner;

public class Uppgift6
{

	public static void main(String[] args) throws IOException
	{
		String word;
		String encrypt = ""; // values for the console write
		String decrypt = ""; // -||-
		char token;
		int temp = 0;
		int[] keyToken = { 2, 3, 6, 1, 8, 3, 5, 3, 9, 3 };
		File docText = new File("TEXT.txt");
		PrintWriter outDEC = null;
		PrintWriter outENC = null;
		try
		{
			@SuppressWarnings("resource")
			Scanner text = new Scanner(docText);
			outENC = new PrintWriter(new BufferedWriter(new FileWriter("OutENC.txt", true)));
			outDEC = new PrintWriter(new BufferedWriter(new FileWriter("OutDEC.txt", true)));
			while (text.hasNext())
			{
				word = text.next();
				for (int i = 0; i < word.length(); i++)
				{
					token = word.charAt(i);

					if (temp == keyToken.length)
					{
						temp = 0; // set the temp to zero so the keytoken start over.
					}
					if (token == '.')
					{
						// check if its a dot or not so we can add it so the not be crypt
						encrypt = encrypt + '.';
						decrypt = decrypt + '.';
					}else
					{

						token = Crypt.encrypt_character(token, keyToken[temp]);
						encrypt = encrypt + token;

						token = Crypt.decrypt_character(token, keyToken[temp]);
						decrypt = decrypt + token;
					}
					temp++;
				}
				encrypt = encrypt + ' '; // end with a whitespace after the words.
				decrypt = decrypt + ' '; // -||-

				temp = 0;
			}
			outENC.print(encrypt);
			outDEC.print(decrypt);
		}catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}finally
		{
			outENC.close();
			outDEC.close();
		}
	}
}
