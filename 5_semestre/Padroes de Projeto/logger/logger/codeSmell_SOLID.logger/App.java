
public class App {
	public static void main(String[] args) throws Exception {
		ILogMessageValidator validator = new LogMessageValidator();
		ILogMessageWriter fileLogMessageWriter = new FileLogMessageWriter();
		ILogMessageWriter databaseLogMessageWriter = new DatabaseLogMessageWriter();

		ILogger databasLogger = new Logger(validator, databaseLogMessageWriter);
		ILogger fileLogger = new Logger(validator, fileLogMessageWriter);

		String logMessage = "Login a first message";

		fileLogger.log(logMessage);
		databasLogger.log(logMessage);
	}
}
