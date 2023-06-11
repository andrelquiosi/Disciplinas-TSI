package parkingSystem.parking.billing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface Bill
{
    LocalDateTime getParkingEntry();
   
    LocalDateTime getParkingExit();
    
    Float getTotal();
    
    List<Map.Entry<String, Float>> getDescription();
}
