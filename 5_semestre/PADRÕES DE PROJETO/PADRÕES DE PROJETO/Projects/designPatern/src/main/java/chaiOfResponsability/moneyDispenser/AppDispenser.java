package chaiOfResponsability.moneyDispenser;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppDispenser {

    static private void loadNotes (MoneyDispenser dispenser){

        dispenser.loadNotes(100,15);
        dispenser.loadNotes(50, 20);
        dispenser.loadNotes(20, 50);
        dispenser.loadNotes(10, 50);
        dispenser.loadNotes(5, 100);
        dispenser.loadNotes(2, 100);
        dispenser.loadNotes(1, 50);
    }
    

    public static void main(String[] args) {
        
        Set<Integer> notesSet = new HashSet<>();
        Collections.addAll(notesSet, 100,50,20,10,5,2,1);
        MoneyDispenser dispenser = new MoneyDispenser(notesSet);
        loadNotes(dispenser);

        try {
            List<Pair> notesList = dispenser.dispenseNotes(4751);
            notesList.stream().forEach(pair -> {System.out.printf("\n%d notes of %d", pair.quantity,pair.value);});
        } catch (Exception e) {
            System.out.printf(e.getMessage());
        }
    }
}
