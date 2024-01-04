package observer.motor;

public interface MotorState extends Cloneable
{
	static enum Status { ON , OFF };
	
	Status currentStatus();
	float rotationsPerMinute();
	float accelerationFraction();
	MotorState clone();
	
	void setStatus(Status status);
	void setRotationsPerMinute(float value);
	void setAccelerationFraction(float value);
	
	default void setStatusOn()
	{
		setStatus(Status.ON);
	}
	
	default void setStatusOff()
	{
		setStatus(Status.OFF);
	}
	
	static String stringfy(MotorState motorState)
	{
		return "{ currentStatus: " + motorState.currentStatus()
			+ " rpm: " + motorState.rotationsPerMinute()
			+ " accelerationFraction: " + motorState.accelerationFraction() 
			+ " }";
	}
}


