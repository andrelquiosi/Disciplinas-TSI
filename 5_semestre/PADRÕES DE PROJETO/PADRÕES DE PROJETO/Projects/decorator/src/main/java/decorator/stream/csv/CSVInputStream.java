package decorator.stream.csv;

import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class CSVInputStream extends InputStream
{
	private BufferedInputStream bufferedInputStream = null;
	private Separator separator = Separator.COMMA;
	
	//------------------------------------------------------------------
	public CSVInputStream(InputStream inputStream) 
		throws FileNotFoundException
	{
		if(inputStream instanceof BufferedInputStream)
			bufferedInputStream = (BufferedInputStream)inputStream;
		else
			bufferedInputStream = new BufferedInputStream(inputStream);			
	}
	
	//------------------------------------------------------------------
	public void setSeparator(Separator separator)
	{
		this.separator = separator;
	}
	
	//------------------------------------------------------------------
	@Override
	public int read() throws IOException
	{
		return this.bufferedInputStream.read();
	}
	
	//------------------------------------------------------------------
	@Override
	public void close() throws IOException
	{
		this.bufferedInputStream.close();
	}
	
	//------------------------------------------------------------------
	@Override
	public int available() throws IOException
	{
		return bufferedInputStream.available();
	}
	
	//------------------------------------------------------------------
	private String readTextLine() throws IOException
	{
		int byteValue = 0;
		StringBuffer stringBuffer = new StringBuffer(); 
		while((byteValue = bufferedInputStream.read()) > -1 )
		{
			if('\n' == byteValue)
				break;
			
			stringBuffer.append((char)byteValue);
		}
		return stringBuffer.toString();
	}
	
	//------------------------------------------------------------------
	public String[] readLine() throws IOException 
	{		
		String line = readTextLine();
		String[] tokens = line.split(this.separator.asString());
		
		for(int i = 0; i < tokens.length; i++)
			tokens[i] = tokens[i].trim();
		
		return tokens;
	}
	
	//------------------------------------------------------------------
	public List<String[]> readAllLines() throws IOException
	{
		List<String[]> lines = new ArrayList<>();
		
		while( bufferedInputStream.available() > 0)
		{
			lines.add(readLine());
		}
		
		return lines;
	}
	
	//------------------------------------------------------------------
	public long skip(long numberOfLines) throws IOException
	{
		final String format = "Can't read %s lines.";
		final String errorMessage = String.format(format, numberOfLines);
		
		for(int i=0; i<numberOfLines; i++)
		{
			String[] line = readLine();
			if(line.length == 0)
				throw new IOException(errorMessage);
		}
		
		return numberOfLines;
	}	
}
