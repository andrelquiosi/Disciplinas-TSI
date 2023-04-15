package csvwriter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.Writer;

public class CSVWriter extends Writer {

    private BufferedWriter bufeWriter = null;
    private Separator separator = Separator.COMMA;

    public CSVWriter(Writer out) {
        super(out);

        if (!(out instanceof BufferedWriter)) {
            out = new BufferedWriter(out);
        }

        bufeWriter = (BufferedWriter) out;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        this.bufeWriter.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        this.bufeWriter.flush();
    }

    @Override
    public void close() throws IOException {
        this.bufeWriter.close();
    }

    public void newLine() throws IOException {
        this.bufeWriter.newLine();
    }

    public void setSeparator(Separator newSeparator) {
        separator = newSeparator;
    }

    public void writeSeparator() throws IOException {
        bufeWriter.append(separator.asChar());
    }

    public void writeToken(String token) throws IOException {
        bufeWriter.append(token);
    }

    public void writeTokenSeparator(String token) throws IOException {
        bufeWriter.append(token);
        bufeWriter.append(separator.asChar());
    }
    
    public void writeTokens(String[] tokens) throws IOException{
            for (int i = 0; i < tokens.length;) {
                bufeWriter.append(tokens[i]);
                
                if(++i < tokens.length)
                    bufeWriter.append(separator.asChar());
                
            }
    }
    
    public void writeLine(String[] tokens) throws IOException{
        writeTokens(tokens);
        bufeWriter.newLine();
    }

}
