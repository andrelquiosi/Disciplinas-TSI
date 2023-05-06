package designPatern.builder.observer.motor;

public class Motor1500 extends AbstractMotor
{
	//-------------------------------------------------
	public Motor1500()
	{
		super(new SimpleMotorState());
	}

	//-------------------------------------------------
	@Override
	public float getPower()
	{
		return 65.0f;
	}

	//-------------------------------------------------
	@Override
	protected float determineRotationsPerMinute()
	{
		if (super.getAccelerationFraction() < 0.0001)
			return 0;
		
		float base = super.getAccelerationFraction();
		float rpm = (float)Math.exp(base * base) * 1100;
		
		return rpm;
	}
}


