package csvwriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CSVWriterTest
{	
	String[] contentHeader = {"1st_chord","2nd_chord","3rd_chord","4th_chord","progression_quality"};
	String[][] contentLines = {
		{"6","4","1","5","Alternative"},
		{"4","4","1","5","Catchy"},
		{"1","1","1","1","Didgeridoo"},
		{"1","6","4","5","Dreadful"},
		{"1","6","2","5","Dreadful"},
		{"1","6","2","4","Endless"},
		{"1","3","4","6","Energetic"},
		{"1","5","1","4","Folk"},
		{"1","6","1","4","Folk"},
		{"6","5","4","3","Flamenco"},
		{"6","5","6","5","Flamenco"},
		{"1","4","3","6","Grunge"},
		{"2","5","1","6","Jazz"},
		{"1","4","5","4","Love"},
		{"1","4","1","5","Memories"},
		{"1","5","6","4","Pop"},
		{"1","6","3","7","Pop"},
		{"4","1","4","5","Rebellious"},
		{"1","4","5","5","Sad"},
		{"1","5","4","4","Sad"},
		{"1","4","5","4","Sad"},
		{"5","4","1","1","Sweet"},
		{"1","4","1","4","Simple"},
		{"1","5","5","1","Simple"},
		{"1","4","1","4","Wildside"},
		{"1","1","4","6","Wistful"},
		{"2","1","5","7","Moody"},
		{"2","1","7","6","Moody"},
	};
	String path;
	{
		path = System.getProperty("user.dir");
		path += "/csvwriter";
		File file = new File(path);
		if(!file.exists())
			file.mkdir();
	}
	
	//-----------------------------------------------------------------------------
	private 
	void writeLineByLine(CSVWriter csvWriter) throws IOException
	{
		csvWriter.writeLine(contentHeader);
		
		for(String[] line : contentLines)
			csvWriter.writeLine(line);
	}
	
	//-----------------------------------------------------------------------------
	private 
	void writeTokenByToken(CSVWriter csvWriter) throws IOException
	{
		csvWriter.writeTokens(contentHeader);
		csvWriter.newLine();
		
		for(String[] line : contentLines)
		{
			for(int i=0; i<line.length;)
			{
				csvWriter.writeToken(line[i]);
				if(++i < line.length)
					csvWriter.writeSeparator();
			}
			csvWriter.newLine();
		}
	}
	
	//-----------------------------------------------------------------------------
	private 
	void writingLinesToFileWriter(Separator separator) throws IOException
	{
		FileWriter FileWriter = new FileWriter(path+"/CSVWritingLinesToFileWriter.csv");
		
		CSVWriter csvWriter = new CSVWriter(FileWriter);
		csvWriter.setSeparator(separator);
		
		writeLineByLine(csvWriter);
		
		csvWriter.close();
	}
	
	//-----------------------------------------------------------------------------
	private 
	void writingLinesToOutputStreamWriter(Separator separator) throws IOException
	{
		File file = new File(path + "/CSVWritingLinesToOutputStreamWriter.csv");
		FileOutputStream fStream = new FileOutputStream(file);
		OutputStreamWriter osWriter = new OutputStreamWriter(fStream);
		
		CSVWriter csvWriter = new CSVWriter(osWriter);
		csvWriter.setSeparator(separator);
		
		writeLineByLine(csvWriter);
		
		csvWriter.close();
	}
	
	//-----------------------------------------------------------------------------
	private 
	void writingLinesToBufferedWriter(Separator separator) throws IOException
	{
		File file = new File(path + "/CSVWritingLinesToBuffeerdWriter.csv");
		
		CSVWriter csvWriter = new CSVWriter(new BufferedWriter(new FileWriter(file)));
		csvWriter.setSeparator(separator);
		
		writeLineByLine(csvWriter);
		
		csvWriter.close();
	}
	
	
	//-----------------------------------------------------------------------------
	private 
	void writenTokenByTokenToFileWriter(Separator separator) throws IOException
	{
		File file = new File(path + "/CSVWritingTokenByTokenToFile.csv");
		
		CSVWriter csvWriter = new CSVWriter(new FileWriter(file));
		csvWriter.setSeparator(separator);
		
		writeTokenByToken(csvWriter);
		
		csvWriter.close();
	}

	
	//-----------------------------------------------------------------------------
	public static 
	void main(String[] args) throws IOException
	{
		CSVWriterTest test = new CSVWriterTest();
		
		test.writingLinesToFileWriter(Separator.SEMICOLON);
		
		test.writingLinesToOutputStreamWriter(Separator.PIPE);
		
		test.writingLinesToBufferedWriter(Separator.COLON);
		
		test.writenTokenByTokenToFileWriter(Separator.COMMA);		
	}
}