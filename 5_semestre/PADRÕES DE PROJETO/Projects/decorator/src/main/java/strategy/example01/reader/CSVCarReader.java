package strategy.example01.reader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import decorator.stream.csv.CSVInputStream;
import strategy.example01.model.Car;

public final class CSVCarReader extends AbstractCarReader
{
	protected CSVInputStream inputStream = null;
	
	//---------------------------------------------------------------
	public
	CSVCarReader(CSVInputStream csvInputStream)
	{
		super();
		this.inputStream = csvInputStream;
	}
	
	//---------------------------------------------------------------
	@Override
	public final
	void close() throws IOException
	{
		inputStream.close();
	}
	
	//----------------------------------------------------------------
	@Override
	public boolean available()
	{
		try
		{
			return inputStream.available() > 0;
		}
		catch(IOException e)
		{
			return false;
		}
	}
	
	//---------------------------------------------------------------
	@Override
	public final
	Car readOneCar() throws IOException
	{
		String[] values = inputStream.readLine();
		
		return buildCar(values);
	}
	
	//---test---------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		String path = System.getProperty("user.dir");
		path += "/src/strategy/example01/test";
		
		File file = new File(path + "/CSVCarStockData.csv");
		FileInputStream fis = new FileInputStream(file);
		CSVInputStream cvsInputStream = new CSVInputStream(fis);
		CSVCarReader carReader = new CSVCarReader(cvsInputStream);
		
		Car car = carReader.readOneCar();
		System.out.println(car);
		
		System.out.println("\n\n");
		
		List<Car> list = carReader.readAllCars();
		for(Car element: list)
			System.out.println(element);
	}
}
