package csvwriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CSVReader extends Reader {

    private BufferedReader bufferReader = null;
    private Separator separator = Separator.COMMA;

    public CSVReader(Reader input) {
        super(input);
        
        if (!(input instanceof BufferedReader)){
            input = new BufferedReader(input);
        }

        bufferReader = (BufferedReader) input;
    }
    
    
    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return bufferReader.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        bufferReader.close();
    }
    
    public Stream<String> lines() {
        return bufferReader.lines();
    }

    public boolean ready() throws IOException {
        return bufferReader.ready();
    }

    public void setSeparator(Separator newSeparator) {
        separator = newSeparator;
    }

    public Separator readSeparator() {
        return separator;
    }

    public String[] readLine() throws IOException {
        String line = bufferReader.readLine();
        
        if (line == null) {
            return null;
        }

        String escapedSeparator = "\\" + separator.asString();
        return line.split(escapedSeparator);
    }

    public List<String[]> readAllLines() throws IOException {
        List<String[]> allLines = new ArrayList<>();

        String[] line;

        while ((line = readLine()) != null) {
            allLines.add(line);
        }

        return allLines;
    }
    
}
