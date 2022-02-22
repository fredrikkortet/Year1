
public class Password
{
/**
 * 
 * @param passNumb is the number of how long the word will be.
 * @return return a character 
 */
	public static char[] generatePassword(int passNumb)
	{

		int counter = 0;
		int randomNumber;
		char[] endArray = new char[passNumb];

		while (counter < passNumb)
		{

			randomNumber = (int) (Math.random() * 3);

			if (randomNumber == 0)
			{
				randomNumber = (int) (Math.random() * 10) + 48; // Is the Number generator

			}else if (randomNumber == 1)
			{
				randomNumber = (int) (Math.random() * 26) + 65; // is the Big Char generator

			}else
			{
				randomNumber = (int) (Math.random() * 26) + 97; // is the small char Generator

			}

			endArray[counter] = (char) randomNumber;

			counter++;
		}

		return endArray;
	}

}
