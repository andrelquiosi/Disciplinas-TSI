package chaiOfResponsability.moneyDispenser;

import chaiOfResponsability.AbstractProcessor;

class DispenserProcessor
		extends AbstractProcessor<DispenserRequest, DispenserResponse> {

	private int numberOfNotes = 0;
	private int noteValue = 0;

	// --------------------------------------------------------
	public int getNoteValue() {
		return noteValue;
	}

	// --------------------------------------------------------
	public int getNumberOfNotes() {
		return numberOfNotes;
	}

	// --------------------------------------------------------
	protected DispenserProcessor() {
		// nothing for while
	}

	// --------------------------------------------------------
	public DispenserProcessor(int noteValue, int numberOfNotes) {
		this.noteValue = noteValue;
		this.load(numberOfNotes);
	}

	// --------------------------------------------------------
	public void load(int numberOfNotes) {
		this.numberOfNotes += numberOfNotes;
	}

	// --------------------------------------------------------
	@Override
	public DispenserResponse process(final DispenserRequest req,
			final DispenserResponse resp) {

		int requestValue = req.getData();

		int requiredNotes = requestValue / this.noteValue;

		if (requiredNotes == 0)
			return next(req, resp);

		if (requiredNotes > this.numberOfNotes)
			requiredNotes = this.numberOfNotes;

		this.numberOfNotes -= requiredNotes;
		DispenserRequest newReq = new DispenserRequest(req.getData() - (requiredNotes * noteValue));

		resp.getData().add(new Pair(requiredNotes, noteValue));
		return next(newReq, resp);
	}
}
