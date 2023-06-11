package chaiOfResponsability.moneyDispenser;

import java.util.List;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class MoneyDispenser
{
	DispenserProcessor root = new DispenserProcessorError();
	
	//-------------------------------------------------------------------------------
	public MoneyDispenser(Set<Integer> notesValuesSet)
	{
		
		SortedSet<Integer> sortedSet = new TreeSet<>(notesValuesSet);
		sortedSet.forEach(noteValue ->
		{
			DispenserProcessor newlyProcessor = new DispenserProcessor(noteValue, 0);
					
			newlyProcessor.SetNext(root);
			root = newlyProcessor;
		});		
	}
	
	//-------------------------------------------------------------------------------
	public 
	List<Pair> dispenseNotes(int value)
	{
		if(root == null)
			throw new RuntimeException("Dispenser is empty");
			
		DispenserResponse response = root.process(new DispenserRequest(value), 
				            					  new DispenserResponse());
		return response.getData();
	}
	
	//-------------------------------------------------------------------------------
	private 
	DispenserProcessor getProcessorFor(int noteValue)
	{
		DispenserProcessor aux = root;
		while(aux != null && aux.getNoteValue() != noteValue)
			aux = (DispenserProcessor) aux.getNext();
		
		if(aux != null)
			return aux;
		
		throw new RuntimeException("Unknown processor for notes of'" + noteValue + "'.");
	}
	
	//-------------------------------------------------------------------------------
	public 
	void loadNotes(int noteValue, int numberOfNotes)
	{
		DispenserProcessor processor = getProcessorFor(noteValue); 
		processor.load(numberOfNotes);
	}
}
