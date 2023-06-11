package parkingSystem.parking.billing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class SimpleBill implements Bill
{
    private final LocalDateTime parkingEntry;
    private final LocalDateTime parkingExit;
    private List<Map.Entry<String, Float>> descriptionList = new ArrayList<>();

    //--------------------------------------------------------------------------
    public SimpleBill(LocalDateTime parkingEntry, 
    		          LocalDateTime parkingExit,
    		          List<Map.Entry<String, Float>> descriptionList )
    {
        this.parkingEntry = parkingEntry;
        this.parkingExit = parkingExit;
        this.descriptionList.addAll(descriptionList);
    }

    //--------------------------------------------------------------------------
    @Override
    public LocalDateTime getParkingEntry()
    {
        return parkingEntry;
    }

    //--------------------------------------------------------------------------
    @Override
    public LocalDateTime getParkingExit()
    {
        return parkingExit;
    }

    //--------------------------------------------------------------------------
    @Override
    public Float getTotal()
    {
        float sum = 0;
        
        for(Map.Entry<String, Float> entry : descriptionList)
        	sum += entry.getValue();
        
        return sum;
    }

    //--------------------------------------------------------------------------
    @Override
    public List<Map.Entry<String, Float>> getDescription()
    {
        return Collections.unmodifiableList(descriptionList);
    }
}
