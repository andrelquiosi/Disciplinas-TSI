
import java.io.IOException;
import javax.security.auth.login.LoginException;

public abstract class Logger implements ILogger {

    public final void log(String logMessage) throws Exception {
        if (!isValid(logMessage)) {
            throw new LoginException("Invalid Log Message");
        }
        write(logMessage);
    }

    protected abstract void write(String logMessage) throws IOException;

    private boolean isValid(String logMessage) {
        if (logMessage == null) {
            return false;
        }
        if (logMessage.isBlank() || logMessage.isEmpty()) {
            return false;
        }
        //aqui é feita uma implementação que não faremos no momento
        return true;
    }
}
