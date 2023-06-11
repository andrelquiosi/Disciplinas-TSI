package observer.corcel.motor;

import observer.motor.AbstractMotor;
import observer.motor.MotorState.Status;
import observer.motor.SimpleMotorState;

public class Motor1400 extends AbstractMotor {

    public Motor1400() {
        super(new SimpleMotorState(Status.OFF, 0, 0));

    }

    @Override
    public float getPower() {

        return 75.0f;

    }

    @Override
    protected float determineRotationsPerMinute() {
        if (super.getAccelerationFraction() < 0.0001)
            return 0;

        float base = super.getAccelerationFraction();
        float rpm = (float) Math.exp(base * base) * 1400;

        return rpm;
    }

}
