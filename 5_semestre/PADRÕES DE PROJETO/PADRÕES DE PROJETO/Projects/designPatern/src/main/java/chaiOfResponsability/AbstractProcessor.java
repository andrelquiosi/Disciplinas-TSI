package chaiOfResponsability;

public abstract class AbstractProcessor<TReq extends AbstractRequest<?>, TResp extends AbstractResponse<?>> {

	private AbstractProcessor<TReq, TResp> next = null;

	// -----------------------------------------------------------------------
	public void SetNext(AbstractProcessor<TReq, TResp> processor) {
		this.next = processor;
	}

	// -----------------------------------------------------------------------
	public AbstractProcessor<TReq, TResp> getNext() {
		return this.next;
	}

	// -----------------------------------------------------------------------
	public boolean hasNext() {
		return (next != null);
	}

	// -----------------------------------------------------------------------
	// aqui é o template method, por fazer uso de algo que ainda não foi
	// implementado
	protected TResp next(TReq req, TResp resp) {
		if (!hasNext())
			return resp;

		return next.process(req, resp);
	}

	// -----------------------------------------------------------------------
	protected abstract TResp process(TReq req, TResp resp);
}
