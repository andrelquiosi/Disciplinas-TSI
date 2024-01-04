package strategy.example01.reader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import strategy.example01.model.Car;
import strategy.example01.model.CarBuilder;

abstract public 
class AbstractCarReader implements CarReader
{
	private CarBuilder carBuilder = new CarBuilder();

    //---------------------------------------------------------------
	protected
	Car buildCar(String[] values)
	{
		return carBuilder
				.licence(values[0])
				.name(values[1])
				.brand(values[2])
				.year(Integer.parseInt(values[3]))
				.color(values[4])
				.build();
	}
	
	//---------------------------------------------------------------
	@Override
	public final 
	List<Car> readAllCars() throws IOException
	{
		List<Car> list = new ArrayList<>();
		while( available() )
		{
			list.add(readOneCar());
		}
		
		return list;
	}
		
	//---------------------------------------------------------------
	public abstract Car readOneCar() throws IOException;
	public abstract boolean available();
}
