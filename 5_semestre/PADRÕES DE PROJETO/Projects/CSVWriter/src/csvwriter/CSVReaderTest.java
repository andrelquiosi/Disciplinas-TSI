package csvwriter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.List;

public class CSVReaderTest {

    private String path;
    {
        path = System.getProperty("user.dir");
		path += "/csvwriter";

		File file = new File(path);
        
		if (!file.exists()) {
			file.mkdir();
        }
    }

    private void printAllLines(CSVReader csvReader) throws IOException {
        List<String[]> lines = csvReader.readAllLines();
        Separator separator = csvReader.readSeparator();
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for (String[] tokens : lines) {
            for (int i = 0; i < tokens.length;) {
                stringBuilder.append(tokens[i]);

                if (++i < tokens.length) {
                    stringBuilder.append(separator.asString());
                }
            }
            stringBuilder.append("\n");
        }

        System.out.println(stringBuilder.toString());
    }

    private String readFileAsString(File file) throws IOException {
        FileReader reader = new FileReader(file);
        BufferedReader buffer = new BufferedReader(reader);
        StringBuilder stringBuilder = new StringBuilder();

        String linha;

        while ((linha = buffer.readLine()) != null) {
            stringBuilder.append(linha);
            stringBuilder.append("\n");
        }

        buffer.close();

        return stringBuilder.toString();
    }

    private void readingLinesFromFileReader(Separator separator) throws IOException {
		FileReader fileReader = new FileReader(path + "/CSVWritingLinesToFileWriter.csv");
		
        CSVReader csvReader = new CSVReader(fileReader);
		csvReader.setSeparator(separator);
		
        printAllLines(csvReader);
		
		csvReader.close();
    }

    private void readingLinesFromInputStreamReader(Separator separator) throws IOException {
        File file = new File(path + "/CSVWritingLinesToOutputStreamWriter.csv");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);

        CSVReader csvReader = new CSVReader(inputStreamReader);
        csvReader.setSeparator(separator);

        printAllLines(csvReader);

        csvReader.close();
    }

    private void readingLinesFromBufferedReader(Separator separator) throws IOException {
        File file = new File(path + "/CSVWritingLinesToBuffeerdWriter.csv");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        CSVReader csvReader = new CSVReader(bufferedReader);
        csvReader.setSeparator(separator);

        printAllLines(csvReader);

        csvReader.close();
    }

    private void readingLinesFromStringReader(Separator separator) throws IOException {
		File file = new File(path + "/CSVWritingTokenByTokenToFile.csv");

        String fileContent = readFileAsString(file);
        StringReader stringReader = new StringReader(fileContent);
		
		CSVReader csvReader = new CSVReader(stringReader);
		csvReader.setSeparator(separator);
        
        printAllLines(csvReader);
		
		csvReader.close();
	}

    public static void main(String[] args) throws IOException {
        CSVReaderTest test = new CSVReaderTest();
        
        test.readingLinesFromFileReader(Separator.SEMICOLON);
        test.readingLinesFromInputStreamReader(Separator.PIPE);
        test.readingLinesFromBufferedReader(Separator.COLON);
        test.readingLinesFromStringReader(Separator.COMMA);
    }
}
