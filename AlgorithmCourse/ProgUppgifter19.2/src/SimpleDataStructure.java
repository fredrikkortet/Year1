/**
 * 
 * <h1>SimpleDataSructure.java</h1>
 * <p>
 * This class can add friends in to a array and remove friends can also sort the friends in alphabetic order.
 * </p>
 * @author Fredrik
 * @since 2019-04-08
 * @version 2.0
 */
 
import java.util.*;

public class SimpleDataStructure
{
	private String[] friends;
	private int counter;

	public SimpleDataStructure()
	{
		friends = new String[5];
		counter = 0;
	}

	/**
	 * Appends the other friend name to the end of this list.
	 */
	public boolean add(String other)
	{
		if (friends.length <= counter)
		{
			String[] temp = new String[friends.length * 2];
			temp = Arrays.copyOf(friends, friends.length * 2);

			friends = new String[temp.length];
			friends = Arrays.copyOf(temp, temp.length);

		}
		friends[counter] = other;
		counter++;
		return true;

	}

	/** returns the name at the specified index */
	public String get(int index)
	{
		if (friends.length <= index)
		{
			return "Its to high index";
		}

		return friends[index];

	}

	/**
	 * removes the first occurrence of the specified element in this list if the
	 * list contains the name
	 */
	public boolean remove(String name)
	{
		for (int i = 0; i < counter; i++)
		{
			if (friends[i].equals(name))
			{
				friends[i] = null;
				if(friends[i]==null) {
				for (int j = i; j < friends.length - 1; j++)
				{
					String temp = friends[j + 1];
					friends[j] = temp;

				}
				counter--;
				return true;
				}
			}
		}
		return false;
	}

	/** prints all names in the array friends */
	public void printFriends()
	{
		for (int i = 0; i < friends.length; i++)
			if (friends[i] != null)
			{
				System.out.print(friends[i] + " ");
				System.out.println();
			}
	}
	public void addsort(String name) {
		add(name);
		
		for (int d = 0; d < friends.length; d++)		//sort algorithm bubblesort
		{														// run arrays size.

			for(int i = 1; i < counter; i++)
			{													//Look on the two values and sort them after the words.
				if (friends[i].compareTo(friends[i-1])< 0)
				{
					String temp = friends[i];					// hold the value so it doesn't disappear.
					friends[i] = friends[i - 1];
					friends[i - 1] = temp;
				}
			}
		}
		
		
	}

	public static void main(String[] arg)
	{
		String[] names = { "Fredrik", "Andre", "Kristoffer", "Rolle", "Kalle", "Katja" };
		SimpleDataStructure myfriends = new SimpleDataStructure();
		for (int i = 0; i < names.length; i++)
		{
			myfriends.add(names[i]);
		}
		myfriends.printFriends();
		System.out.println(myfriends.get(23));
		System.out.println(myfriends.get(1));
		myfriends.remove(names[0]);
		System.out.println(" ");
		myfriends.printFriends();
		System.out.println(myfriends.remove("Nikolina"));
		System.out.println(" ");
		myfriends.addsort("Fredrik");
		System.out.println("sorted");
		System.out.println(" ");
		myfriends.printFriends();

	}
}
