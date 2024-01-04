package chaiOfResponsability.moneyDispenser;

import java.util.ArrayList;
import java.util.List;

import chaiOfResponsability.AbstractResponse;

public class DispenserResponse extends AbstractResponse<List<Pair>> {

    public DispenserResponse(){
        super(new ArrayList<>());
    }

    public DispenserResponse(List<Pair>data){
        super(data);
        
    }
}
