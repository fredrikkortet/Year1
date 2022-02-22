

public class ArrayMain
{
	public static void main(String[] args) {
		
	
	MyArrayList<String> listing = new MyArrayList<String>();
	// is empty
	System.out.println(listing.isEmpty());// true
	// add
	System.out.println(listing.add("amster"));// true
	System.out.println(listing.add("adam")); // true
	System.out.println(listing.add("eva")); // true
	// remove
	System.out.println(listing.remove("adam"));//true
	System.out.println(listing.remove("fredrik")); // false
	// contains
	System.out.println(listing.contains("amster")); // true
	System.out.println(listing.contains("adam")); // false
	// is empty
	System.out.println(listing.isEmpty()); // false
	//get
	System.out.println(listing.get(1));// eva
	System.out.println(listing.get(19)); // is to high index
	//indexof 
	System.out.println(listing.indexOf("eva"));// 1
	System.out.println(listing.indexOf("fredrik"));//-1 
	// size 
	System.out.println(listing.size());// 10
	// toarray
    Object[] toSting = listing.toArray();
    System.out.println(toSting[1]); // eva
	
	}
}
