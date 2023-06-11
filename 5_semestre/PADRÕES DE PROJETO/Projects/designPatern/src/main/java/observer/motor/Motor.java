package  observer.motor;

public interface Motor
{	
	public MotorState getState();
	
	public boolean isOn();
	public boolean isOff();
	
	public void slowDown(float percent);
	public void speedUp(float percent);
	
	public void start();
	public void stop();
}

