package decorator.stream.csv;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class CSVOutputStream extends OutputStream
{
	//------------------------------------------------------------------
	private BufferedOutputStream bufferedOutputStream = null;
	private Separator separator = Separator.COMMA;
	
	//------------------------------------------------------------------
	public CSVOutputStream(OutputStream outputStream)
	{
		if(!(outputStream instanceof BufferedOutputStream))
			bufferedOutputStream = new BufferedOutputStream(outputStream);
		else
			bufferedOutputStream = (BufferedOutputStream)outputStream;
	}

	//------------------------------------------------------------------
	@Override
	public void write(int byteValue) throws IOException
	{
		bufferedOutputStream.write(byteValue);
	}
	
	//------------------------------------------------------------------
	@Override
	public void close() throws IOException
	{
		bufferedOutputStream.close();
	}

	//------------------------------------------------------------------
	@Override
	public void flush() throws IOException
	{
		bufferedOutputStream.flush();
	}

	//------------------------------------------------------------------
	public void 
	setSeparator(Separator separator)
	{
		this.separator = separator;
	}
	
	//------------------------------------------------------------------
	public void newLine() throws IOException
	{
		bufferedOutputStream.write("\n".getBytes());
	}
	
	//------------------------------------------------------------------
	public void writeSeparator() throws IOException
	{
		bufferedOutputStream.write(this.separator.asString().getBytes());
	}
	
	//------------------------------------------------------------------
	public void writeToken(String token) throws IOException
	{
		bufferedOutputStream.write(token.getBytes());
	}
	
	//------------------------------------------------------------------
	public void writeTokenAndSeparator(String token) throws IOException
	{
		writeToken(token);
		writeSeparator();
	}
	
	//------------------------------------------------------------------
	public void writeTokens(String[] tokens) throws IOException
	{
		for(int i=0; i<tokens.length;)
		{
			writeToken(tokens[i]);
			
			if(++i < tokens.length)
				writeSeparator();
		}
	}
	
	//------------------------------------------------------------------
	public void writeLine(String[] tokens) throws IOException
	{
		writeTokens(tokens);
		newLine();
	}
}
