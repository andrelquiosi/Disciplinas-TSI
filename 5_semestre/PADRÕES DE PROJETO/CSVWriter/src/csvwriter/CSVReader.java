package csvwriter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;


public class CSVReader extends Reader {

    private BufferedReader bufReader = null;
    private Separator separator = Separator.COMMA;

    public CSVReader(Reader reader) {
        super(reader);

        if (!(reader instanceof BufferedReader)) {
            reader = new BufferedReader(reader);
        }

        bufReader = (BufferedReader) reader;
    }
@Override
public int read(char[] arg0, int arg1, int arg2) throws IOException {
    // TODO Auto-generated method stub
    return 0;
}
@Override
public void close() throws IOException {
    // TODO Auto-generated method stub
    
}

public void setSeparator(Separator newSeparator) {
    separator = newSeparator;
}
public String[] readLine(){

}
}
