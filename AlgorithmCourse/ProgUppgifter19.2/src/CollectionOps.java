import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionOps<T>
{
	public static <T> void print(Collection<T> l)
	{
		Iterator<T> printmagic = l.iterator();
		System.out.print("[");
		while (printmagic.hasNext())
		{
			System.out.print(printmagic.next());
			if (printmagic.hasNext())
			{
				System.out.print(", ");
			}
			if (!printmagic.hasNext())
			{
				System.out.println("]");
			}
		}

	}

	public static void main(String[] args)
	{
		Collection<String> newElement = new ArrayList<String>();
		
		List<String> newElements = new ArrayList<String>();
		List<Integer> integers = new ArrayList<Integer>();
		List<Double> doubles = new ArrayList<Double>();
		
		newElement.add("A");
		newElement.add("B");// String Array 
		newElement.add("C");
		
		newElements.add("Albin");
		newElements.add("Bengt");// String list to reverse
		newElements.add("Crille");
		
		integers.add(2);
		integers.add(3);//integer list to reverse
		integers.add(5);
		
		doubles.add(2.1);
		doubles.add(3.1);//double list to reverse 
		doubles.add(4.1);
		
		print(newElement);
		
		print(newElements);
		System.out.println("reversed String list: "+reverse(newElements));
		print(integers);
		System.out.println("reversed Integer list: "+reverse(integers));
		print(doubles);
		System.out.println("reversed Double list: "+reverse(doubles));
	}

	public static <T> List<T> reverse(List<T> l)
	{
		List<T> revArray = new ArrayList<T>(l.size());
		for (int i = l.size() - 1; 0 <= i; i--)
		{
			revArray.add(l.get(i));

		}
		return revArray;

	}
}
