package designPatern.builder.observer.motor;

public abstract class AbstractMotor implements Motor
{
	protected SimpleMotorState state = null;
	
	//----------------------------------------------------
	protected AbstractMotor(SimpleMotorState state)
	{
		this.state = state;
	}
	
	//----------------------------------------------------
	public MotorState getState()
	{
		return state.clone();
	}
	
	//----------------------------------------------------
	public float getAccelerationFraction()
	{
		return state.accelerationFraction();
	}
	
	//----------------------------------------------------
	public float getRotationsPerMinute()
	{
		return state.rotatiosPerMinute();
	}
	
	//----------------------------------------------------
	@Override
	public void start()
	{
		state.currentStatus = MotorState.Status.ON;
		state.accelerationFraction = 0.1f;
		state.rpm = determineRotationsPerMinute();
	}

	//----------------------------------------------------
	@Override
	public void stop()
	{
		this.state.currentStatus = MotorState.Status.OFF;
		this.state.accelerationFraction = 0.0f;
		state.rpm = 0.0f;
	}
	
	
	//----------------------------------------------------
	@Override
	public void speedUp(final float percent)
	{
		if(this.isOff())
			return;
		
		if(percent < 0)
		{
			slowDown(Math.abs(percent));
			return;
		}
		
		float increment = (1-state.accelerationFraction) * percent;
		state.accelerationFraction += increment;
		
		state.rpm = determineRotationsPerMinute();
	}
	
	//----------------------------------------------------
	@Override
	public void slowDown(float percent)
	{
		if(this.isOff())
			return;
		
		if(percent < 0)
		{
			speedUp(Math.abs(percent));
			return;
		}
		
		float base = (float)Math.pow((Math.exp(-state.accelerationFraction)/2.72),2);
		float decrement = (state.accelerationFraction) *(base) * percent;
		state.accelerationFraction -= decrement;
	
		state.rpm = determineRotationsPerMinute();
	}
	
	//----------------------------------------------------
	@Override
	public boolean isOn()
	{
		return state.currentStatus == MotorState.Status.ON;
	}

	//----------------------------------------------------
	@Override
	public boolean isOff()
	{
		return state.currentStatus == MotorState.Status.OFF;
	}
	
	//----------------------------------------------------
	public abstract float getPower();
	protected abstract float determineRotationsPerMinute();
}
