package strategy.example01.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import decorator.stream.csv.CSVInputStream;
import strategy.example01.model.Car;
import strategy.example01.reader.CSVCarReader;
import strategy.example01.reader.CarReader;
import strategy.example01.stock.CarStock;

public class AppCar {
	private CarStock carStock;

	// -------------------------------------------------------------------------------------
	public AppCar(CarStock carStock) throws IOException {
		this.carStock = carStock;
		carStock.load();
	}

	// -------------------------------------------------------------------------------------
	static private CarReader createCarReader(String pathToCSVCarFile) throws IOException {
		File file = new File(pathToCSVCarFile);
		FileInputStream fileInputStream = new FileInputStream(file);
		CSVInputStream csvInputStream = new CSVInputStream(fileInputStream);
		CarReader carReader = new CSVCarReader(csvInputStream);

		return carReader;
	}
	// -------------------------------------------------------------------------------------

	void printAllCars() {

		List<Car> listCar = carStock.getAll();

		listCar.stream().forEach(System.out::println);
	}
	// -------------------------------------------------------------------------------------
	// private class OrderedByYear implements Comparator<Car> {

	// @Override
	// public int compare(Car carA, Car carB) {
	// return carA.getYear() - carB.getYear();
	// }

	// }

	// private int orderedByYear(Car carA, Car carB){
	// return carA.getYear() - carB.getYear();
	// }

	// -------------------------------------------------------------------------------------
	public void printAllCarsOrderedByYear() {

		// Stream<Car> stream = carStock.stream();
		// stream.sorted(this::orderedByYear).forEach(System.out::println);
		carStock.stream().sorted((carA, carB) -> (carA.getYear() - carB.getYear()))
				.forEach(car -> System.out.println(car));
	}

	// -------------------------------------------------------------------------------------

	public void printAllCarsOrderedByLicense() {

		carStock.stream().sorted((carA, carB) -> carA.getLicence()
				.compareToIgnoreCase(carB.getLicence()))
				.forEach(car -> System.out.println(car));
	}

	// -------------------------------------------------------------------------------------

	public void printAllCarsOrderedByBrand() {

		carStock.stream().sorted((carA, carB) -> carA.getBrand()
				.compareTo(carB.getBrand()))
				.forEach(car -> System.out.println(car));
	}

	// -------------------------------------------------------------------------------------

	private int orderedByBrandAndByYear(Car carA, Car carB){
		
	}

	// -------------------------------------------------------------------------------------

	public void printAllCarsOrderedByBrandAndYear(){
			carStock.stream().sorted((carA, carB) -> carA.getBrand().compareTo(carB.getBrand()) || carA.getYear() - carB.getYear())
			.forEach(car ->System.out.println(car));

	}

	// -------------------------------------------------------------------------------------

	public static void main(String[] args) throws IOException {
		String path = System.getProperty("user.dir");
		path += "/src/main/java/strategy/example01/app/CSVCarStockData.csv";

		CarReader carReader = createCarReader(path);
		CarStock carStock = new CarStock(carReader);

		AppCar app = new AppCar(carStock);
		// app.printAllCars();
		// app.printAllCarsOrderedByYear();
		// app.printAllCarsOrderedByLicense();
		// app.printAllCarsOrderedByBrand();

	}

}
