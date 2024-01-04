package strategy.example01.reader;

import java.io.IOException;
import java.util.List;

import strategy.example01.model.Car;

public interface CarReader
{
	Car readOneCar() throws IOException;
	List<Car> readAllCars() throws IOException;
	void close() throws IOException;
	
}
