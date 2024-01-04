
import java.io.IOException;

public class FileLogMessageWriter implements ILogMessageWriter {

	@Override
	public void write(String logMessage) throws IOException {
		// for educational purposes only
		System.out.printf("\n'%s' was logged into fileLog", logMessage);
	}
}
