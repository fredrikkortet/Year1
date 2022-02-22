import java.util.Arrays;

public class ArrayDouble
{
	/**
	 * 
	 * @param a int array the whole array we want to fill in.
	 * @param x	is the value you want to fill in with
	 * @param index is the position you want to fill in with with your value x
	 */
	public static void addAtIndex(int[] a, int x, int index)
	{
		int length = a.length * 2;
		int[] nextArray = new int[length];
		int temp = 0;

		if (a.length <= index)
		{
			System.out.print("ERRROR");
			System.exit(0);
		}

		if (a[index] == 0)
		{
			a[index] = x; // here we go in when we don't have anything in the index position
			System.out.println(Arrays.toString(a));
		}else
		{
			if (a[a.length - 1] == 0) // here we go in if the last position is empty so we only can change the pos to
										// the right
			{
				for (int i = 0; i < a.length; i++)
				{

					if (index > i)
					{
						a[i] = a[i];
					}else if (index == i)
					{
						temp = a[i];
						a[i] = x;
					}else
					{
						a[i] = temp;
					}

				}
				System.out.println(Arrays.toString(a));
			}else
			{
				for (int i = 0; i < a.length; i++)// here we go in when we need to move 2x the array and then change the
													// values to the right
				{

					if (index > i)
					{
						nextArray[i] = a[i];
					}else if (index == i)
					{
						nextArray[i + 1] = a[i];

					}
				}
				nextArray[index] = x;
				System.out.println(Arrays.toString(nextArray));
			}
		}

	}
}
