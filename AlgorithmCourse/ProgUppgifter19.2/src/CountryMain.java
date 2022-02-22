/**
 * 
 * <h1>CountryMain.java</h1>
 * <p>
 * this is the class that is a almost done project to the CountrymainProgram.java
 * </p>
 * @author Fredrik
 * @since 2019-04-08
 * @version 1.0
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class CountryMain
{
	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{

		ArrayList<Country> landObject = new ArrayList<Country>();
		
		Scanner textfile;
		String landName;
		int landpop;
		int landarea;
		String landCap;

		try
		{
			textfile = new Scanner(new File("CountryStat.txt"));

			textfile.nextLine();
			while (textfile.hasNextLine())
			{
				landName = textfile.next();
				landpop = Integer.parseInt(textfile.next());
				landarea = Integer.parseInt(textfile.next());
				landCap = textfile.next();

				landObject.add(new Country(landName, landCap, landpop, landarea));

			}
			
			Collections.sort(landObject, new CompareCountry());
			
			Iterator magicCountry = landObject.iterator();
			System.out.println(" ");
			System.out.println("Here is the sort in country:");
			System.out.println("Country Capital Population Area");
			System.out.println(" ");
			while(magicCountry.hasNext()) {
				System.out.println(magicCountry.next());
			}
			

			Collections.sort(landObject, new ComparePopulation());
			Iterator magicPopulation = landObject.iterator();
			System.out.println(" ");
			System.out.println("Here is the sort in population:");
			System.out.println("Country Capital Population Area");
			System.out.println(" ");
			while(magicPopulation.hasNext()) {
				System.out.println(magicPopulation.next());
			}
				
			

			Collections.sort(landObject, new CompareLandMass());
			Iterator magicLandMass = landObject.iterator();
			System.out.println(" ");
			System.out.println("Here is the sort in area:");
			System.out.println("Country Capital Population Area");
			System.out.println(" ");
			while(magicLandMass.hasNext()){
				System.out.println(magicLandMass.next());
			}
				
			

		}catch (FileNotFoundException e)
		{
			
			e.printStackTrace();
		}
	}

}
