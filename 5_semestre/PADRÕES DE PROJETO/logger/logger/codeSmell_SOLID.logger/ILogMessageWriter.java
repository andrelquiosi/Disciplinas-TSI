import java.io.IOException;

public interface ILogMessageWriter {

    void write(String logMessage) throws IOException;
}
