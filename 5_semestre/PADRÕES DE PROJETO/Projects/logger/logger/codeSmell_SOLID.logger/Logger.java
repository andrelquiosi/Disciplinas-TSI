
public class Logger implements ILogger {

	final private ILogMessageValidator logMessageValidator;
	final private ILogMessageWriter logMessageWriter;

	protected Logger(ILogMessageValidator validator,
			ILogMessageWriter writer) {

		this.logMessageValidator = validator;
		this.logMessageWriter = writer;
	}

	// ------------------------------------------------------------------
	@Override
	public final void log(String logMessage) throws Exception {

		logMessageValidator.validate(logMessage);
		logMessageWriter.write(logMessage);

	}

}
