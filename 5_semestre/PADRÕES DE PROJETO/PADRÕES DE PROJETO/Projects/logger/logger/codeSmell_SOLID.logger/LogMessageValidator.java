public class LogMessageValidator implements ILogMessageValidator {

    final String invalidMessage = "Invalid Log Message";

    @Override
    public void validate(String logMessage) throws LogException {
        if (logMessage == null)
            throw new LogException(invalidMessage + " Null");

        if (logMessage.isBlank() || logMessage.isEmpty())
            throw new LogException(invalidMessage + " ( Empty )");

        /*
         * check if message contains sensitive data such as
         * SSN, credit card number, etc.
         */
    }

}
