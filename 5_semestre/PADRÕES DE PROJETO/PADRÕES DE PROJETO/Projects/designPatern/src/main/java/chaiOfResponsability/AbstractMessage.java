package chaiOfResponsability;

public class AbstractMessage<T> implements Message<T> {
    protected T data;

    // ----------------------------------
    public AbstractMessage(T data)
	{
		this.data = data;
	}

    // ----------------------------------
    @Override
    public T getData() {
        return data;
    }
}