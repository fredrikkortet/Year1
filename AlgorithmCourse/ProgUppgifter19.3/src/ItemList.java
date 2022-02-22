
import java.util.*;

/**
 * Klassen ItemList �r en l�nkad lista som inneh�ller noder av Item-objekt.
 * F�rsta noden i listan ( header) inneh�ller inget objekt.
 */

public class ItemList 
{
	private Node header;
	private int size;

	public ItemList()
	{
		header = new Node(null);
		size = 0;
	}

	/**
	 * Skapar ett ny Node-objekt med ett nytt Item objekt och l�gger den i listan.
	 * �kar v�rdet av variabel size;
	 */
	public void add(Item newItem)
	{

		Node nynode = new Node(newItem);

		Node temp = header;
		while (temp.next != null)
		{
			temp = temp.next;
		}
		size++;
		temp.next = nynode;

	}

	/**
	 * Skapar ett ny Node objekt med ett nytt Item-objekt och l�gger den i listan p�
	 * plats index, �kar v�rdet av variabel size;
	 */
	public void add(Item newItem, int index)
	{
		Node newnode = new Node(newItem);

		Node temp = header;
		if (size >= index && index >= 0)
		{
			for (int i = 0; i < index; i++)
			{
				if (temp.next != null)
				{
					temp = temp.next;
				}
			}
			size++;
			newnode.next = temp.next;
			temp.next = newnode;
		}else
		{
			System.out.println("try another index for insert");
		}
	}

	/**
	 * Returnerar true om det finns ett Item-objekt vars RFIDNR �r lika med metodens
	 * parametern id
	 */
	public boolean find(String id)
	{
		Node node = header.next;
		while (node != null)
		{
			if (node.itm.RFIDNR.equals(id))
			{
				return true;
			}
			node = node.next;
		}
		return false;
	}

	/**
	 * Ta bort noden som inneh�ller Item- objektet med viss id
	 */
	public Item remove(String id)
	{
		Node node = header;
		Node temp = null;
		while (node.next != null)
		{
			if (node.next.itm.RFIDNR.equals(id))
			{
				size--;
				temp = node.next;
				node.next = node.next.next;
				break;
			}

			node = node.next;
		}
		return temp.itm;
	}

	/**
	 * R�knar och returnerar antalet Item- objekt med ett vis namn oavsett RFIDNR
	 */

	public int countObjects(String name)
	{
		int count = 0;
		Node node = header.next;
		while (node != null)
		{
			if (node.itm.name.equals(name))
			{
				count++;
			}
			node = node.next;
		}
		return count;
	}

	/**
	 * Skriver ut inneh�llet i listan
	 */
	public void printList()
	{
		Node node = header.next;
		while (node != null)
		{
			System.out.println(node.itm);
			node = node.next;
		}
	}

	/**
	 * Returnera true om listan �r tom annars false
	 */
	public boolean isEmpty()
	{
		return size == 0 ? true : false;
	}

	/**
	 * Returnera antlet element i listan
	 */
	public int size()
	{

		return size;
	}
/**
 *  take a name and return the information about it RFID and Name 
 * @param name take the name 
 * @return
 */
	public String getItemName(String name)
	{
		Node node = header.next;
		while (node != null)
		{
			if (node.itm.name.equals(name))
			{
				return node.itm.name + " " + node.itm.RFIDNR;
			}
			node = node.next;
		}
		return null;
	}
	/**
	 *  take a RFIDNR and return the information about it RFID and Name 
	 * @param name take the name 
	 * @return
	 */
	public String getItemNumber(String number)
	{
		Node node = header.next;
		while (node != null)
		{
			if (node.itm.RFIDNR.equals(number))
			{
				return node.itm.name + " " + node.itm.RFIDNR;
			}
			node = node.next;
		}
		return null;
	}
/**
 * return all the item to a string
 * @return 
 */
	public String getItm()
	{
		String nameAndNumb = "";
		Node node = header.next;
		while (node != null)
		{
			nameAndNumb += node.itm.name + " "+ node.itm.RFIDNR + " ";
			node = node.next;
		}
		return nameAndNumb;
	}
	/**
	 * take the value on that index you want to compare
	 * @param i is index
	 * @return item 
	 */
	public Item itmComp(int i)
	{
		Node temp = header;
				for( int x = 0; x<i;x++)
				{
					temp = temp.next;
				}
		return temp.itm;
	}

}