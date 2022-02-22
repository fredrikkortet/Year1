import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ItemListTestTestTest
{

	ItemList list_1;
	ItemList list_2;
	ItemList list_3;

	/**
	 * Fixture initialization (common initialization for all tests).
	 **/

	@Before
	public void setUp()
	{
		// new list for every test case
		list_1 = new ItemList();
		list_2 = new ItemList();
		list_3 = new ItemList();
	}

	@Test
	public void addTest()
	{
		Item test1 = new Item("andre1","123456781");
		Item test2 = new Item("andre2","123456782");
		Item test3 = new Item("andre3","123456783");
		Item test4 = new Item("andre4","123456784");
		Item test5 = new Item("andre5","123456785");
		list_1.add(test1);
		list_1.add(test2);
		list_1.add(test3);
		list_1.add(test4);
		list_1.add(test5);
			
		
		assertEquals("Add 1000 obj test with size()", 5, list_1.size());
		
		
	}

	
	@Test
	public void isEmptyTest()
	{
		assertEquals("Test if new list is empty", true, list_1.isEmpty());
		Item test1 = new Item("andre1","123456781");
		Item test2 = new Item("andre2","123456782");
		Item test3 = new Item("andre3","123456783");
		Item test4 = new Item("andre4","123456784");
		Item test5 = new Item("andre5","123456785");
		list_1.add(test1);
			list_1.add(test2);
			list_1.add(test3);
			list_1.add(test4);
			list_1.add(test5);
		assertEquals("Test if list with objects isn't empty", false, list_1.isEmpty());
		
		
			list_1.remove("123456781");
			list_1.remove("123456782");
			list_1.remove("123456783");
			list_1.remove("123456784");
			list_1.remove("123456785");
		
		assertEquals("Remove all objects check that list is empty", true, list_1.isEmpty());
	}

	@Test
	public void removeTest()
	{
		
		Item test1 = new Item("andre1","123456781");
		Item test2 = new Item("andre2","123456782");
		Item test3 = new Item("andre3","123456783");
		Item test4 = new Item("andre4","123456784");
		Item test5 = new Item("andre5","123456785");
		list_1.add(test1);
			list_1.add(test2);
			list_1.add(test3);
			list_1.add(test4);
			list_1.add(test5);
		list_1.remove("123456781");
		assertEquals("Check that first occurence of object is removed", false, list_1.find("123456781"));
		assertEquals("Check that size has decreces", 4, list_1.size());
		
	}

	@Test
	public void countObjectsTest()
	{	Item test = new Item("andre1","12341514");
		list_1.add(test);
		assertEquals("Test contains() with existing object", 1, list_1.countObjects("andre1"));
		assertEquals("Test contains() with non existing object", 0, list_1.countObjects("krille"));
		assertEquals("Test contains() with null object", 0, list_1.countObjects(null)); 
	}

	@Test
	public void sizeTest()
	{
		assertEquals("Check that new list has size 0", 0, list_1.size());
	}
	@Test
	public void FindTest()
	{
		assertEquals("Check that new list has krille", false, list_1.find("krille"));
	}

	
}