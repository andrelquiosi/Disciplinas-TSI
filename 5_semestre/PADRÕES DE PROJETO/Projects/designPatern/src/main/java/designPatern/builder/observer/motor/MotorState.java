package designPatern.builder.observer.motor;

public interface MotorState extends Cloneable {

    public enum Status {
        ON, OFF
    };

    public Status currentStatus();

    public float rotatiosPerMinute();

    public float accelerationFraction();

    public MotorState clone();

    public static String stringfy(MotorState motorState) {

        return "{ currentStatus: " + motorState.currentStatus()
                + " rpm: " + motorState.rotatiosPerMinute()
                + " accelerationFraction: " + motorState.accelerationFraction()
                + "}";
    }


}
