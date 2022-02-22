public class Country
{
	private String countryName;
	private String capitalName;
	private int population;
	private int area;

	public Country(String country, String capital, int pop, int landMass)
	{
		countryName = country;
		capitalName = capital;
		population = pop;
		area = landMass;
	}

	public String toString()
	{
		String temp = countryName + " " + capitalName + " " + population + " " + area;
		return temp;
	}

	public void change(String type, String value)
	{

		switch (type)
		{
		case "countryName":
			countryName = value;
			break;

		case "capitalName":
			countryName = value;
			break;
		case "population":
			population = Integer.parseInt(value);
			break;
		case "area":
			area = Integer.parseInt(value);
			break;
		}

	}
	public String getCountryName()
	{
		return countryName;
	}
	public String getCapitalName()
	{
		return capitalName;
	}
	public int getPopulation()
	{
		return population;
	}
	public int getArea()
	{
		return area;
	}

	
}
