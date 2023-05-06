package designPatern.builder.observer.motor;

public class SimpleMotorStateImutable implements MotorState {

    Status currentStatus = Status.OFF;
    private float rpm = 0.0f;
    private float accelerationFraction = 0.0f;

    public SimpleMotorStateImutable(
            Status currenStatus,
            float rpm,
            float accelerationFraction) {

        super();
        this.currentStatus = currenStatus;
        this.rpm = rpm;
        this.accelerationFraction = accelerationFraction;

    }

    public SimpleMotorStateImutable() {
    }

    @Override
    public MotorState.Status currentStatus() {
        return currentStatus;
    }

    @Override
    public float rotatiosPerMinute() {
        return rpm;
    }

    @Override
    public float accelerationFraction() {
        return accelerationFraction;
    }

    public MotorState clone() {

        try {
            Object clone = super.clone();
            return (MotorState) clone;

        } catch (CloneNotSupportedException e) {
            // should never be executaded
            e.printStackTrace();
            return null;
        }

    }

    private boolean areEquals(float valueA, float valueB) {
        float dif = valueA - valueB;
        return (Math.abs(dif) < 0.0001);
    }

    @Override
    public boolean equals(Object other) {

        SimpleMotorStateImutable another = (SimpleMotorStateImutable) other;

        return (this.currentStatus() == another.currentStatus() &&
                areEquals(this.accelerationFraction(), another.accelerationFraction()) &&
                areEquals(this.rotatiosPerMinute(), another.rotatiosPerMinute()));
    }

}
