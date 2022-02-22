/**
 * <h1>Uppgift1.java</h1>
 * <p>
 * This program should generate a password with condition length between 8-12 character and at<br/>
 * least one lower case character and at least one upper case character.
 * </p>
 * 
 * @author Fredrik
 * @version 1.0
 * @since 2019-04-02
 *
 */
public class Uppgift1
{

	public static void main(String[] args)
	{

		int hManyTimes = 1000;
		char[] showValue = new char[12];
		int passNumb;
		String checkWord = "";
		String checkValues = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,12}$"; // regular expression ^ begin $ end
																			// (?=.*[Anytype]) is if its a [Anytype] in
																			// the text so will it be true so in this
																			// expression if the only thing to give out
																			// true is if everyone is true.{8,12} is
																			// length of the word {min,max} length
		int trueCounter = 0;
		int totalCounter = 0;

		for (int i = 0; i < hManyTimes; i++)
		{

			passNumb = (int) (Math.random() * 5) + 8;

			showValue = Password.generatePassword(passNumb);

			for (int j = 0; j < passNumb; j++)
			{
				System.out.print(showValue[j]);
				checkWord = String.valueOf(showValue);
			}
			System.out.print(" " + checkWord.matches(checkValues));
			System.out.println();
			if (checkWord.matches(checkValues))
			{

				trueCounter++;
				totalCounter++;

			}else
			{

				totalCounter++;
			}

		}
		System.out.println("Total true " + trueCounter + " of " + totalCounter);
	}

}
