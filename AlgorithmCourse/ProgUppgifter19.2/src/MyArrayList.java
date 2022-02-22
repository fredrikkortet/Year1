/**
 * <h1>MyArrayList.java</h1>
 * <p>this is a copy of a ArrayList its almost identical to learn how ArrayList is operating when it is in action.</p>
 * @author fredrik
 * @version 1.1
 * @param <AnyType> is a generic variable
 * @since 2019-04-08
 */
import java.util.*;
public class MyArrayList<AnyType> implements Iterable<AnyType>
{

	private AnyType[] arraylist;
	private int count;

	@SuppressWarnings("unchecked")
	public MyArrayList()
	{
		arraylist = (AnyType[]) new Object[0];
		count = 0;
	}

	@SuppressWarnings("unchecked")
	public MyArrayList(int initialCapacity)
	{
		arraylist = (AnyType[]) new Object[initialCapacity];
	}

	/* Appends the specified element to the end of this list. */

	public boolean add(AnyType o)
	{
		if (o != null)
		{
			if (arraylist.length <= count)
			{
				AnyType[] temp = Arrays.copyOf(arraylist, arraylist.length + 1);
				arraylist = Arrays.copyOf(temp, temp.length);

			}
			arraylist[count] = o;
			count++;
			return true;
		}
		return false;
	}

	/** tests if the specified element is a component of this list */
	public boolean contains(AnyType o)
	{
		int temp = 0;
		for (int i = 0; i < count; i++)
		{
			if (arraylist[i] != null)
			{
				if (arraylist[i].equals(o))
				{
					temp++;
				}
			}
		}
		return temp == 0 ? false : true;// if temp == 0 return false, else return true
	}

	/** returns the component at the specified index */
	@SuppressWarnings("unchecked")
	public AnyType get(int index)
	{
		if (arraylist.length <= index-1)
		{
			return (AnyType) "Its to high index";
		}

		return arraylist[index];
	}

	/**
	 * Search for the first occurrence of the given argument testing for the
	 * equality using equals method
	 */
	public int indexOf(AnyType o)
	{
		int temp = -1;

		for (int i = 0; i < arraylist.length; i++)
		{
			if (o==arraylist[i])
			{
				temp = i;
				return temp;
			}
		}

		return temp;
	}

	/** tests if this list has no components */
	public boolean isEmpty()
	{
		return count == 0 ? true : false;// if count == 0 return true, else return false
	}

	/**
	 * removes the first occurrence of the specified element in this list if the
	 * list contains the
	 */
	public boolean remove(AnyType o)
	{
		for (int i = 0; i < count; i++)
		{
			if (arraylist[i].equals(o))
			{
				arraylist[i] = null;
				if (arraylist[i] == null)
				{
					for (int j = i; j < arraylist.length - 1; j++)
					{
						AnyType temp = arraylist[j + 1];
						arraylist[j] = temp;

					}
					arraylist = Arrays.copyOf(arraylist, arraylist.length-1);
					count--;
					return true;
				}
			}
		}
		return false;
	}

	/** returns the number of components in this list */
	public int size()
	{
		return arraylist.length;
	}

	/**
	 * returns an array containing all elements in this list in the correct order
	 */
	public Object[] toArray()
	{
		@SuppressWarnings("unchecked")
		AnyType[] arrayCopy = (AnyType[]) new Object[count];
		for (int i = 0; i < count; i++)
		{
			
				arrayCopy[i] = arraylist[i];
			
			

		}
		if(arraylist.length == 0 ) {
			return null;
		}
		return arrayCopy;
	}

	public Iterator<AnyType> iterator()
	{
		Iterator<AnyType> ite = new ArrayListIterator<AnyType>(arraylist, count);
		return ite;
	}

	
}