
import java.util.*;

/**
 * Klassen SimpleLinkedList är en länkad lista som innehåller noder av objekt.
 * Första noden i listan innehåller inget objekt.
 */

public class SimpleLinkedList
{
	private ListNode header;
	private int counter = 0;

	public SimpleLinkedList()
	{
		header = new ListNode(null);
	}

	/**
	 * Skapar en ny ListNode med ett nytt objekt och lägger den i listan
	 */
	public void insert(String theobj)
	{
		ListNode nynode = new ListNode(theobj);

		ListNode temp = header;
		while (temp.next != null)
		{
			temp = temp.next;
		}
		counter++;
		temp.next = nynode;
	}

	/*
	 * Ta bort noden som innehåller respektive objekt
	 */
	public void remove(String theobj)
	{
		ListNode node = header;

		while (node.next != null)
		{
			if (node.next.element.equals(theobj))
			{
				counter--;
				node.next = node.next.next;
				break;
			}

			node = node.next;
		}
	}

	/**
	 * Skriver ut innehållet i listan
	 */
	public void print()
	{
		ListNode node = header.next;
		while (node != null)
		{
			System.out.println(node.element);
			node = node.next;
		}
	}

	public void insert2(String theobj)
	{
		ListNode newnode = new ListNode(theobj, header.next);
		counter++;
		header.next = newnode;
	}

	// Detta skall du göra
	// läger objekt på på plats index. Index får inte vara negativ eller större än
	// listans storlek
	public void insert(String obj, int index)
	{
		ListNode newnode = new ListNode(obj);

		ListNode temp = header;
		if (counter >= index && index >= 0)
		{
			for (int i = 0; i < index; i++)
			{
				if (temp.next != null)
				{
					temp = temp.next;
				}
			}
			counter++;
			newnode.next = temp.next;
			temp.next = newnode;
		}else
		{
			System.out.println("try another index for insert");
		}
	}

	// Returnerar och tar bort ett objkt från lista
	public String remove(int index)
	{
		if (index < counter && index > 0)
		{
			ListNode temp = header;

			for (int i = 0; i <= index; i++)
			{
				if (i == index)
				{
					counter--;
					temp.next = temp.next.next;
					break;
				}
				temp = temp.next;

			}
			return temp.element;
		}else
		{
			return "try another index for remove";
		}
	}

//returnerar storleken på listan. Lägg till i klasssen  en variabel för detta
	// uppdatera variabeln när det är fallet

	public int size()
	{
		return counter;
	}

	public String toString()
	{	
		String description = "";
		ListNode node = header.next;
		while (node != null)
		{
			description += node.element + " ";
			node = node.next;
		}
		return description;
	}

	public static void main(String[] arg)
	{
		// testa metoderna från klassen SimpleLinkedList
		SimpleLinkedList klassLista = new SimpleLinkedList();
		klassLista.insert("Olle");
		klassLista.insert("andre");
		klassLista.insert2("Nina");
		klassLista.insert("Fredrik", 3);
		klassLista.print();
		System.out.println("");
		System.out.println(klassLista.remove(2));
		System.out.println("");
		klassLista.print();
		System.out.println(klassLista.size());
		System.out.println(klassLista.toString());
	}
}
