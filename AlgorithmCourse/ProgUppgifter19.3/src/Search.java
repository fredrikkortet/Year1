import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
public class Search
{
	/**
	 * search with the algorithm linear search 
	 * @param a is the array you want to find in
	 * @param x is the value you want to find
	 * @return
	 */
	public static int linearSearch(int[] a, int x)
	{
		for (int i = 0; i < a.length; i++) // begin form the beginning and search every number in row
		{
			if (a[i] == x)
			{
				return i;
			}
		}
		return -1;
	}
/**
 * search with the algorithm binary search
 * @param a is the array you want to find in
 * @param x is the value you want to find
 * @return
 */
	public static int binarySearch(int[] a, int x)
	{
		int begin = 0;
		int end = a.length - 1;
		while (begin <= end)
		{
			int m = ((begin + end) / 2);	
											//check if the value is lower, higher or same.
			if (a[m] < x)
			{
				begin = m + 1;
			}else if (a[m] > x)
			{
				end = m - 1;
			}else
				return m;
		}
		return -1;
	}
	/**
	 * create a array with random numbers between 2 numbers
	 * @param size array size
	 * @param min minimum value
	 * @param max maximum value
	 * @return
	 */
	static int [] createArray( int size, int min, int max) { 
		int[] random = new int[size];
		for(int i=0;i<random.length;i++) 
		{
			random[i] = (int)Math.random()*(max-min)+min;
		}
		return random;
	}
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		int[] goFor = createArray(100000,1,1000);
		try
		{
			PrintWriter textLin = new PrintWriter("LinearText.txt");
			for(int i=0;i<10;i++) { // 10 time
				long time1 = System.currentTimeMillis();//start time
				linearSearch(goFor,45); //search will not take the same time becasue its take diffrent time to compare values
				long time2 = System.currentTimeMillis(); // end time
				textLin.println("Time: "+(time2-time1)+ " Length: " + goFor.length); //write
				}
			textLin.close(); // close
			Arrays.sort(goFor); // sort array
			
			PrintWriter textBin = new PrintWriter("BinText.txt");
			
			for(int i=0;i<10;i++) { // 10 times 
				long time1 = System.currentTimeMillis();// time start
				binarySearch(goFor,45); //search will not take the same time becasue its take diffrent time to compare values
				long time2 = System.currentTimeMillis();// time end
				textBin.println("Time: "+(time2-time1)+ " Length: " + goFor.length); // write
				}
			textBin.close(); // close 
		}catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
