/**
 * <h1>ComparePopulation.java</h1>
 * <p>This is a comparator that can help collections.sort() with the sort in the sort i want it to be if <br/>
 * it will be in the country name or area or population.
 * </p>
 * @author Fredrik
 * @since 2019-04-08
 * @version 2.0
 */
import java.util.Comparator;

public class ComparePopulation implements Comparator<Country>
{
	public int compare(Country mankind, Country oMankind){
		   
        
	       int humans = mankind.getPopulation();        
	       int otherHumans = oMankind.getPopulation();
	      
	       if(humans < otherHumans)
	           return 1;
	        else if(humans > otherHumans)
	            return -1;
	        else
	            return 0;    
	    }


	
}
