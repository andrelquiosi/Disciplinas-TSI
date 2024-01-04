package strategy.example01.model;

public class CarBuilder
{
	private Car car = null;
	
	public CarBuilder()
	{
		this.car = new Car();
	}
	
	//--------------------------------------------
	public CarBuilder licence(String licence)
	{
		car.setLicence(licence);
		return this;
	}
	
	//--------------------------------------------
	public CarBuilder name(String name)
	{
		car.setName(name);
		return this;
	}
	
	//--------------------------------------------
	public CarBuilder brand(String brand) 
	{
		car.setBrand(brand);
		return this;
	}
	
	//--------------------------------------------
	public CarBuilder year(int year) 
	{
		car.setYear(year);
		return this;
	}
	
	//--------------------------------------------
	public CarBuilder color(String color) 
	{
		car.setColor(color);
		return this;
	}
	
	//--------------------------------------------
	public Car build()
	{
		Car builtCar = this.car;
		
		this.car = new Car();
		
		return builtCar;
	}
}

