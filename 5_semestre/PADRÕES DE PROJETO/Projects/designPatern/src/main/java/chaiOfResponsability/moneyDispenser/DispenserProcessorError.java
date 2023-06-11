package chaiOfResponsability.moneyDispenser;

class DispenserProcessorError extends DispenserProcessor {


    public void load(int numberOfNotes){
        throw new RuntimeException("Operation not suported");
    }


    public DispenserResponse process(final DispenserRequest req, final DispenserResponse resp){
        if(req.getData() > 0){
            throw new RuntimeException("insuficient balance");
        }
        return resp;
    }
    
}
