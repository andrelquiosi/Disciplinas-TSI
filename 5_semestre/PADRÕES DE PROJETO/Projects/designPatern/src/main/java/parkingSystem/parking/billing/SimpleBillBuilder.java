package parkingSystem.parking.billing;

import java.time.LocalDateTime;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleBillBuilder 
{
	private LocalDateTime parkingEntry;
    private LocalDateTime parkingExit;
    private List<Map.Entry<String, Float>> descriptionList = new ArrayList<>();
    
    //---------------------------------------------------------------------------------
    public SimpleBillBuilder parkingEntry(LocalDateTime parkingEntry)
    {
    	this.parkingEntry = parkingEntry;
    	return this;
    }
    
    //---------------------------------------------------------------------------------
    public SimpleBillBuilder parkingExit(LocalDateTime parkingExit)
    {
    	this.parkingExit = parkingExit;
    	return this;
    }
    
    //---------------------------------------------------------------------------------
    public SimpleBillBuilder appendDescriptionItem(String description, Float value)
    { 
    	descriptionList.add(new SimpleEntry<String, Float>(description, value));
    	return this;
    }
    
    //---------------------------------------------------------------------------------
    public SimpleBill build()
    {
    	SimpleBill bill = new SimpleBill(parkingEntry, parkingExit, descriptionList);
    	
    	this.reset();
    	
    	return bill;
    }
    
    //---------------------------------------------------------------------------------
    private void reset()
    {
    	parkingEntry = null;
    	parkingExit = null;
    	descriptionList = new ArrayList<>();
    }
}
