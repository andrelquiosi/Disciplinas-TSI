package observer.motor;

public class SimpleMotorState implements MotorState, Cloneable
{
	Status currentStatus;
	float rpm;
	float accelerationFraction;
	
	
	//----------------------------------------------------------
	public SimpleMotorState( 
			Status currentStatus, 
			float rpm, 
			float accelerationFraction )
	{
		super();
		this.currentStatus = currentStatus;
		this.rpm = rpm;
		this.accelerationFraction = accelerationFraction;
	}

	//----------------------------------------------------------
	@Override
	public void setStatus(Status status) 
	{
	   currentStatus = status;	
	}

	//----------------------------------------------------------
	@Override
	public void setRotationsPerMinute(float value) 
	{
		rpm = value;	
	}

	//----------------------------------------------------------
	@Override
	public void setAccelerationFraction(float value) 
	{
		accelerationFraction = value;	
	}
	//----------------------------------------------------------
	@Override
	public MotorState.Status currentStatus()
	{
		return currentStatus;
	}

	
	//----------------------------------------------------------
	@Override
	public float rotationsPerMinute()
	{
		return rpm;
	}

	//----------------------------------------------------------
	@Override
	public float accelerationFraction()
	{
		return accelerationFraction;
	}
	
	//----------------------------------------------------------
	public MotorState clone()
	{
		try 
		{
			Object clone = super.clone();
			return (MotorState)clone;
		} 
		catch (CloneNotSupportedException e) 
		{
			//should never be executed
			e.printStackTrace();
			return null;
		}
	}
	
	//----------------------------------------------------------
	private boolean areEquals(float valueA, float valueB)
	{
		float dif = valueA-valueB;
		return (Math.abs(dif) < 0.000_000_1);
	}
	
	//----------------------------------------------------------
	@Override
	public boolean equals(Object other)
	{
		SimpleMotorState another = (SimpleMotorState) other;
		
		boolean equalsStatus = this.currentStatus() == another.currentStatus(); 
		boolean equalsRpm = areEquals(this.rotationsPerMinute(),another.rotationsPerMinute());
		boolean equalsAcceleration = areEquals(this.accelerationFraction(), another.accelerationFraction());
		
		return ( equalsStatus && equalsRpm && equalsAcceleration );
	}

}
