package observer.listenerOldStyle;

import observer.motor.Motor;
import observer.motor.MotorState;

public class ObservableMotor implements Motor
{
	private final Motor motor;
	private final MotorListenerManager listenerManager = new MotorListenerManager();
	
	//-------------------------------------------------------------------------------
	public ObservableMotor(Motor motor)
	{
		this.motor = motor;
	}
	
	//--Observable-------------------------------------------------------------------	
	//-------------------------------------------------------------------------------
	public void addMotorListener(MotorListener listener)
	{
		this.listenerManager.addMotorListener(listener);
	}
	
	//-------------------------------------------------------------------------------
	public void removeMotorListener(MotorListener listener)
	{
		this.listenerManager.removeMotorListener(listener);
	}

	//--interface Motor---------------------------------------------------------------------
	//--------------------------------------------------------------------------------------
	@Override
	public MotorState getState()
	{
		return motor.getState();
	}

	//--------------------------------------------------------------------------------------
	@Override
	public boolean isOn()
	{
		return motor.isOn();
	}

	//--------------------------------------------------------------------------------------
	@Override
	public boolean isOff()
	{
		return motor.isOff();
	}

	//--------------------------------------------------------------------------------------
	@Override
	public void slowDown(float percent)
	{
		this.listenerManager.fireBeforeSlowDown(new MotorEvent(motor, motor.getState()));
		
		motor.slowDown(percent);
		
		this.listenerManager.fireAfterSlowDown(new MotorEvent(motor, motor.getState()));
	}

	//--------------------------------------------------------------------------------------
	@Override
	public void speedUp(float percent)
	{
		this.listenerManager.fireBeforeSpeedUp(new MotorEvent(motor, motor.getState()));
		
		motor.speedUp(percent);
		
		this.listenerManager.fireAfterSpeedUp(new MotorEvent(motor, motor.getState()));
	}

	//--------------------------------------------------------------------------------------
	@Override
	public void start()
	{
		this.listenerManager.fireBeforeStart(new MotorEvent(motor, motor.getState()));
		
		motor.start();
		
		this.listenerManager.fireAfterStart(new MotorEvent(motor, motor.getState()));
	}

	//--------------------------------------------------------------------------------------
	@Override
	public void stop()
	{
		this.listenerManager.fireBeforeStop(new MotorEvent(motor, motor.getState()));
		
		motor.stop();
		
		this.listenerManager.fireAfterStop(new MotorEvent(motor, motor.getState()));
	}
}
