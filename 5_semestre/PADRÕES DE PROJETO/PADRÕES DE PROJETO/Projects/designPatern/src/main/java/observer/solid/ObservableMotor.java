package observer.solid;

import observer.motor.Motor;
import observer.motor.MotorState;

public class ObservableMotor implements Motor {

    private Motor motor;

    public ObservableMotor(Motor motor) {
        this.motor = motor;
    }

    private MotorEventListenerManager startListenerManager = new MotorEventListenerManager();
    private MotorEventListenerManager stopListenerManager = new MotorEventListenerManager();
    private MotorEventListenerManager speedUpListenerManager = new MotorEventListenerManager();
    private MotorEventListenerManager slowDownListenerManager = new MotorEventListenerManager();

    public void addStartListener(MotorEventListener listener) {
        startListenerManager.addMotorStartEventListener(listener);
    }

    public void removeMotorStartEventListener(MotorEventListener listener) {
        startListenerManager.removeMotorStartEventListener(listener);
    }

    public void addStopListener(MotorEventListener listener) {
        stopListenerManager.addMotorStartEventListener(listener);
    }

    public void removeMotorStopEventListener(MotorEventListener listener) {
        stopListenerManager.removeMotorStartEventListener(listener);
    }

    public void addSpeedUpListener(MotorEventListener listener) {
        speedUpListenerManager.addMotorStartEventListener(listener);
    }

    public void removeMotorSpeedUpEventListener(MotorEventListener listener) {
        speedUpListenerManager.removeMotorStartEventListener(listener);
    }

    public void addSlowDownListener(MotorEventListener listener) {
        slowDownListenerManager.addMotorStartEventListener(listener);
    }

    public void removeMotorSlowDownEventListener(MotorEventListener listener) {
        slowDownListenerManager.removeMotorStartEventListener(listener);
    }

    @Override
    public MotorState getState() {
        return motor.getState();
    }

    // --------------------------------------------------------------------------------------
    @Override
    public boolean isOn() {
        return motor.isOn();
    }

    // --------------------------------------------------------------------------------------
    @Override
    public boolean isOff() {
        return motor.isOff();
    }

    @Override
    public void slowDown(float percent) {
        MotorEvent event = new MotorEvent(motor, motor.getState());
        slowDownListenerManager.fireBefore(event);
        motor.slowDown(percent);
        event = new MotorEvent(motor, motor.getState());
        slowDownListenerManager.fireAfter(event);
    }

    @Override
    public void speedUp(float percent) {
        MotorEvent event = new MotorEvent(motor, motor.getState());
        speedUpListenerManager.fireBefore(event);
        motor.speedUp(percent);
        event = new MotorEvent(motor, motor.getState());
        speedUpListenerManager.fireAfter(event);
    }

    @Override
    public void start() {
        MotorEvent event = new MotorEvent(motor, motor.getState());
        startListenerManager.fireBefore(event);
        motor.start();
        event = new MotorEvent(motor, motor.getState());
        startListenerManager.fireAfter(event);

    }

    @Override
    public void stop() {
        MotorEvent event = new MotorEvent(motor, motor.getState());
        stopListenerManager.fireBefore(event);
        motor.stop();
        event = new MotorEvent(motor, motor.getState());
        stopListenerManager.fireAfter(event);
    }

}
