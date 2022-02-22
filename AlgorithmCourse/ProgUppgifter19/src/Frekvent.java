import java.util.*;

public class Frekvent
{
	/**
	 * 
	 * @param word here is the whole txt file without spaces and then i will count every character and write it out
	 */
	public static void usage(String word)
	{
		int[] counter = new int[127];
		char[] charArray = word.toCharArray();
		int totalCounter = 0;
		int temp = 0;
		int diffrent = 0;
		int[] tempHolder = new int[charArray.length];

		for (int i = 0; i < charArray.length; i++)
		{
			temp = (int) (charArray[i]) - 1;
			if (counter[temp] == 0)
			{
				tempHolder[diffrent] = temp;
				diffrent = diffrent + 1;

			}
			counter[temp] = counter[temp] + 1;
			totalCounter = totalCounter + 1;

		}
		Arrays.sort(tempHolder);
		temp = 0;
		do
		{
			if (tempHolder[temp] == 0)
			{
				temp++;
			}
		}while (tempHolder[temp] == 0);

		for (int j = 0; j < diffrent; j++)
		{
			System.out.println((char) (tempHolder[temp] + 1) + " " + counter[tempHolder[temp]] + " "
					+ ((counter[tempHolder[temp]] / (float) totalCounter) * 100) + "%");
			temp++;
		}

	}
}
