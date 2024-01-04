package observer.fusca.motor;

import observer.motor.AbstractMotor;
import observer.motor.MotorState.Status;
import observer.motor.SimpleMotorState;

public class Motor1200 extends AbstractMotor {

    public Motor1200() {
        super(new SimpleMotorState(Status.OFF, 0, 0));
    }

    // -------------------------------------------------
    @Override
    public float getPower() {
        return 36.0f;
    }

    // -------------------------------------------------
    @Override
    protected float determineRotationsPerMinute() {
        if (super.getAccelerationFraction() < 0.0001)
            return 0;

        float base = super.getAccelerationFraction();
        float rpm = (float) Math.exp(base * base) * 1000;

        return rpm;
    }

}
