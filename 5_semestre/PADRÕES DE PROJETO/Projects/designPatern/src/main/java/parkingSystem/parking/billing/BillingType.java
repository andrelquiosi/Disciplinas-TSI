package parkingSystem.parking.billing;

import java.util.Arrays;
import java.util.stream.Stream;

public enum BillingType
{
    HOUR_BILLING(),
    DAY_BILLING(),
    MONTH_BILLING();
	
	//---------------------------------------------
    BillingType(){};

    //---------------------------------------------
    static String[] names = null;

    //---------------------------------------------
    static public
    String[] getNames()
    {
        if(names == null)
        {
            names = new String[values().length];
            BillingType[] enuns = values();
            for(int i=0; i<enuns.length; i++)
                names[i] = enuns[i].name();
        }

        return names;
    }
    
    //---------------------------------------------
    static public
    Stream<String> namesStream()
    {
    	 return Arrays.stream(getNames());
    }
}
