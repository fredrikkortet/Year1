   import java.text.DateFormat;
   import java.text.SimpleDateFormat;
   import java.util.Date;
   import java.util.*;


   public class Item implements Comparable <Item>{
      public Date delivered;   // utl�nd datum, null n�r Item inte �r utl�nad 
      public final String RFIDNR; 
      public String name;
   
      
      public String getRFIDNR()
	{
		return RFIDNR;
	}

	public String getName()
	{
		return name;
	}

	public Item(String thename, String number) {
         name = thename;
         RFIDNR = number;
         delivered=null;
      }
     	
      public void setDeliverDate(Date d) {
         delivered = d;
      }
   
      public Date getDeliverDate() {
         return delivered;
      }
   
      public String getItemNumber() {
         return RFIDNR;
      }
    
	  public String getItemName() {
         return name;
      }
    

      public int compareTo( Item other)
      {
    	  if (name.compareTo(other.name)==0)
  		{
  			return 0;
  		}else if(name.compareTo(other.name) < 0)
  		{
  			return -1;
  		}
  		return 1;
      }
     
	  public boolean equals( Object other)
      {
      // Detta g�r du f�rdig. Vi s�ger att tv� objekt �r lika om de har samma RFIDNR  
         return false;
      }
 	
		
      public String toString() {
         DateFormat df = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      if( delivered==null)
		  return RFIDNR + " "+ name+ " "+ "p� lager";
		else
         return RFIDNR + " "+ name+ " "+ df.format(delivered);
      }
       	 
   // See a simple program example to understand how Date class works; 
      public static void main (String [] arg)
      {
       
         Calendar calendar = Calendar.getInstance();
      
         Date newDate = calendar.getTime();
      
      // Skapa item- object
         Item itm= new Item ( "Termometer", "1111111111");
      
      // G�r item-obj utl�nad
         itm.setDeliverDate(newDate);
      
         System.out.println( itm); 
      	
      
      }
   
   }


