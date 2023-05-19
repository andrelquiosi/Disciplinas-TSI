package observer.motor;

public abstract class AbstractMotor implements Motor
{
	protected MotorState state = null;
	
	//----------------------------------------------------
	protected AbstractMotor(MotorState state)
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
		return state.rotationsPerMinute();
	}
	
	//----------------------------------------------------
	@Override
	public void start()
	{
		state.setStatusOn();
		state.setAccelerationFraction(0.1f);
		float rpms = this.determineRotationsPerMinute();
		state.setRotationsPerMinute(rpms); 
	}

	//----------------------------------------------------
	@Override
	public void stop()
	{
		state.setStatusOff();
		state.setAccelerationFraction(0.0f);
		state.setRotationsPerMinute(0.0f);
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
		
		float acceleration = state.accelerationFraction();
		float increment = (1-acceleration) * percent;
		state.setAccelerationFraction(acceleration + increment);
		float rpms = this.determineRotationsPerMinute(); 
		state.setRotationsPerMinute(rpms);
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
		
		float acceleration = state.accelerationFraction();
		float base = (float)Math.pow((Math.exp(-acceleration)/2.72),2);
		float decrement = (acceleration) *(base) * percent;
		state.setAccelerationFraction( acceleration - decrement);
		
		float rpms = this.determineRotationsPerMinute(); 
		state.setRotationsPerMinute(rpms); ;
	}
	
	//----------------------------------------------------
	@Override
	public boolean isOn()
	{
		return state.currentStatus() == MotorState.Status.ON;
	}

	//----------------------------------------------------
	@Override
	public boolean isOff()
	{
		return state.currentStatus() == MotorState.Status.OFF;
	}
	
	//----------------------------------------------------
	public abstract float getPower();
	protected abstract float determineRotationsPerMinute();
}
