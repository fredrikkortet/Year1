/**
 * is the best lager program that you can choose values and make your shop experience more efficient 
 */
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class LgerProgram
{
	static Scanner scan = new Scanner(System.in);
	static ItemList inStore = new ItemList();
	static ItemList outStore = new ItemList();
	static long nr = 1111111111;
	static Calendar calendar = Calendar.getInstance();
	static Date time = calendar.getTime();
	static PrintWriter newIn;
	static PrintWriter newOut;

	public static void main(String[] args)
	{
		try
		{
			Scanner filescan = new Scanner(new File("Verktyg.txt"));
		}

		catch (IOException ex)
		{
			System.out.println("Filen finns inte");
		}
		printMenu();
		int choice = scan.nextInt();
		scan.nextLine();

		while (choice != 0)
		{
			dispatch(choice);
			printMenu();
			choice = scan.nextInt();
			scan.nextLine();
		}
	}

	public static String getRFID()
	{
		return "" + nr++;

	}

	public static void dispatch(int choice)
	{
		int loc;

		switch (choice)
		{
		case 0:
			System.out.println("EXIT");
			System.exit(0);
			break;

		case 1:
		{
			try
			{
				// add everytiong to store from files  in and out stock
				Scanner filescan = new Scanner(new File("Verktyg.txt"));
				while (filescan.hasNext())
				{
					inStore.add(new Item(filescan.next(), filescan.next()));

				}
				Scanner file = new Scanner(new File("VerktygOut.txt"));
				while (file.hasNext())
				{
					outStore.add(new Item(file.next(), file.next()));
				}
			}

			catch (IOException ex)
			{
				System.out.println("Filen finns inte");
			}
			break;
		}
		case 2:
		{		//take a loan on things in stock and give you a time you take the loan
			System.out.println("Enter your RFID number to your product (10 diget):");
			Scanner RFID = new Scanner(System.in);
			String temp = RFID.nextLine();
			if (inStore.find(temp))
			{
				Item temp1 = inStore.remove(temp);
				temp1.setDeliverDate(time);
				System.out.println(temp1);
				outStore.add(temp1);
			}else
			{
				System.out.print("your product is not in the store today.");
			}
			try
			{
				newIn = new PrintWriter("Verktyg.txt");
				newOut = new PrintWriter("VerktygOut.txt");
				newOut.print(outStore.getItm());
				newOut.close();
				newIn.print(inStore.getItm());
				newIn.close();
			}catch (FileNotFoundException e)
			{

				e.printStackTrace();
			}
			break;
		}
		case 3:
		{  	//return the object to the store and sort them in the right order in instock order
			System.out.println("Enter your RFID number to your product (10 diget):");
			Scanner RFID = new Scanner(System.in);
			String temp = RFID.nextLine();
			if (outStore.find(temp))
			{
				Item temp1 = outStore.remove(temp);
				temp1.setDeliverDate(null);
				for (int i = 1; i < inStore.size(); i++)
				{
					if(temp1.compareTo(inStore.itmComp(i))<0 ) {
						inStore.add(temp1, i-1);
						break;
					}
						
				}
				System.out.println("Your product have been returned " + temp1.name + " " + temp1.RFIDNR);
				
				
			}else
			{
				System.out.print("Your product is not returned or your product dose not excist.");
			}
			try
			{
				newIn = new PrintWriter("Verktyg.txt");
				newOut = new PrintWriter("VerktygOut.txt");
				newOut.print(outStore.getItm());
				newOut.close();
				newIn.print(inStore.getItm());
				newIn.close();
			}catch (FileNotFoundException e)
			{

				e.printStackTrace();
			}
			break;
		}

		case 4:
		{	//search in the store if that you searching for is in the store you can search for name or RFID
			System.out.println("search for RFID or name:");
			Scanner value = new Scanner(System.in);

			if (value.hasNextInt())
			{
				String temp = value.next();
				if (inStore.find(temp))
				{
					System.out.println(inStore.getItemNumber(temp));

				}else
				{
					System.out.print("sorry not find anything. Int");
					break;
				}

			}else
			{
				String temp = value.nextLine();
				String holder = inStore.getItemName(temp);

				if (holder == null)
				{

					System.out.print("sorry not find anything. String");
					break;
				}
				System.out.println(holder);

			}
			break;
		}
		case 5:
		{	// print out store 	
			outStore.printList();
			break;
		}

		case 6:
		{//print in Store
			inStore.printList();
			break;
		}

		default:// if you pressed wrong button 
			System.out.println("Sorry, invalid choice");
		}
	}

	// ----------------------------
	// Skriver ut anv�ndar meny
	// ----------------------------
	public static void printMenu()
	{
		System.out.println("\n  Welcome");
		System.out.println("   ====");
		System.out.println("0: Exit");
		System.out.println("1: Setup Store");
		System.out.println("2: Loan");
		System.out.println("3: Return");
		System.out.println("4: Find product");
		System.out.println("5: Out Of Stock");
		System.out.println("6: In Stock");

		System.out.print("\nEnter your choice: ");
	}

}

