/**
 * <h1>CountrymainProgram.java</h1>
 * <p>This is a comparator that can help collections.sort() with the sort in the sort i want it to be if <br/>
 * it will be in the country name or area or population.
 * </p>
 * @author Fredrik
 * @since 2019-04-08
 * @version 2.0
 */
import java.util.Comparator;

public class CompareCountry implements Comparator<Object>
{
	public int compare(Object land, Object oLand){    
		 
        //parameter are of type Object, so we have to downcast it to country objects
       
        String landName = ((Country)land).getCountryName();        
        String oLandName = ((Country)oLand).getCountryName();
       
        //uses compareTo method of String class to compare names of the employee
        return landName.compareTo(oLandName);
    
    }
	
}
