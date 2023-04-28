package strategy.example01.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import decorator.stream.csv.CSVInputStream;
import strategy.example01.reader.CSVCarReader;
import strategy.example01.reader.CarReader;
import strategy.example01.stock.CarStock;

public class AppCar 
{
	private CarStock carStock;
	
	//-------------------------------------------------------------------------------------
	public AppCar (CarStock carStock) throws IOException
	{
		this.carStock = carStock;
		carStock.load();	
	}
	
	
	//-------------------------------------------------------------------------------------
	static private
	CarReader createCarReader(String pathToCSVCarFile) throws IOException
	{
		File file = new File(pathToCSVCarFile);
		FileInputStream fileInputStream =  new FileInputStream(file);
		CSVInputStream csvInputStream   = new CSVInputStream(fileInputStream);
		CarReader carReader = new CSVCarReader(csvInputStream);
		
		return  carReader;		
	}
	
	//-------------------------------------------------------------------------------------
	public static void main(String[] args) throws IOException
	{
		String path = System.getProperty("user.dir");
		path += "/src/main/java/strategy/example01/app/CSVCarStockData.csv";
		
		CarReader carReader = createCarReader(path);
		CarStock carStock = new CarStock(carReader);
		
		AppCar app = new AppCar(carStock);
		
	}
	
}
