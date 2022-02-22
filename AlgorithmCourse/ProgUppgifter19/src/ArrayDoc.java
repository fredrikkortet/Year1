import java.util.*;

public class ArrayDoc
{
/**
 * 
 * @param list ist the arraylist that go in the method 
 * @param index is the position you want to take out the name 	
 * @return return the name you find
 */
	public static String findName(ArrayList<?> list, int index)
	{
		if (list.size() > index)
		{
			String name = (String) list.get(index);
			return name + " was on place " + (index + 1);
		}else
		{
			return "To high index try again";
		}
	}
/**
 * 
 * @param list its the arraylist that go in the method 
 * @param name is the position you want too delete the position 
 * @return return true if its deleted false otherwise.
 */
	public static boolean deleteName(ArrayList<String> list, String name)
	{
		int index = 0;
		String word = "";
		while (index < list.size())
		{
			word = list.get(index);

			if (word.equals(name))
			{
				list.remove(index);
				return true;

			}
			index++;
		}
		return false;
	}
/**
 * 
 * @param list ist the arraylist that go in the method 
 * @param name will look if the name alreaddy in the list 
 * @return return true if added if not false
 */
	public static boolean addToList(ArrayList<String> list, String name)
	{	int index=0;
		for (int i = 0; i < list.size(); i++)
		{
			if (name.compareTo((String) list.get(i)) == 0)
			{
				return false;
			}
		}
		list.add(index,name);
		Collections.sort(list);
		return true;
	}

}
