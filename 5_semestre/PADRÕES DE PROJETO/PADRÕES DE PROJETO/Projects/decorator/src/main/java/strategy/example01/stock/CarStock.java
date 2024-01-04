package strategy.example01.stock;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import strategy.example01.model.Car;
import strategy.example01.reader.CarReader;

public class CarStock implements Stock<Car> {
	private CarReader carReader = null;
	private List<Car> listCar = new ArrayList<>();

	// ----------------------------------------------
	public CarStock(CarReader carReader) {
		this.carReader = carReader;
	}

	// ----------------------------------------------
	public void load() throws IOException {
		System.out.println("Strategy: " + this.carReader.getClass().getName());

		this.listCar = this.carReader.readAllCars();
	}

	@Override
	public final List<Car> getAll() {
		return listCar;
	}

	public Stream<Car> stream(){
		return listCar.stream();
	}

}
