package strategy.example01.model;

import java.util.Map;
import java.util.TreeMap;

public class CarHelper 
{
	//------------------------------------------------------------------------
	public String[] toStringArray(Car car)
	{
		String[] stringArray = new String[5];
	
		stringArray[0] = car.getLicence();
		stringArray[1] = car.getName();
		stringArray[2] = car.getBrand();
		stringArray[3] = "" + car.getYear();
		stringArray[4] = car.getColor();
		
		return stringArray;
	}
	
	//------------------------------------------------------------------------
	public Map<String,String> toStringMap(Car car)
	{
		Map<String, String> map = new TreeMap<>();
		
		map.put("Licence", car.getLicence());
		map.put("Name", car.getName());
		map.put("Brand", car.getBrand());
		map.put("Year", ""+car.getYear());
		map.put("Color", car.getColor());
		
		return map;
	}
	
	//------------------------------------------------------------------------
}
