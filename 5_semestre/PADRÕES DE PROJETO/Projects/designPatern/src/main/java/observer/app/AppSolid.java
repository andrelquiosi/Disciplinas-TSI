package observer.app;

import observer.corcel.motor.Motor1400;
import observer.fusca.motor.Motor1200;
import observer.fusca.motor.Motor1500;
import observer.motor.Motor;
import observer.motor.MotorState;
import observer.solid.MotorEvent;
import observer.solid.MotorEventListener;
import observer.solid.MotorSlowDownListener;
import observer.solid.MotorSpeedUpListener;
import observer.solid.MotorStartListener;
import observer.solid.MotorStopListener;
import observer.solid.ObservableMotor;

public class AppSolid {

    static MotorEventListener motorStartListener = new MotorStartListener() {

        @Override
        public void before(MotorEvent me) {
            System.out.println("BeforeStart" + MotorState.stringfy(me.state));
        }

        @Override
        public void after(MotorEvent me) {
            System.out.println("AfterStart" + MotorState.stringfy(me.state));
        }

    };

    static MotorEventListener motorStoptListener = new MotorStopListener() {

        @Override
        public void before(MotorEvent me) {
            System.out.println("BeforeStop" + MotorState.stringfy(me.state));
        }

        @Override
        public void after(MotorEvent me) {
            System.out.println("AfterStop" + MotorState.stringfy(me.state));
        }

    };

    static MotorEventListener motorSpeedUptListener = new MotorSpeedUpListener() {

        @Override
        public void before(MotorEvent me) {
            System.out.println("BeforeSpeedUp" + MotorState.stringfy(me.state));
        }

        @Override
        public void after(MotorEvent me) {
            System.out.println("AfterSpeedUp" + MotorState.stringfy(me.state));
        }

    };
    static MotorEventListener motorSlowDowntListener = new MotorSlowDownListener() {

        @Override
        public void before(MotorEvent me) {
            System.out.println("BeforeSlowDown" + MotorState.stringfy(me.state));
        }

        @Override
        public void after(MotorEvent me) {
            System.out.println("AfterSlowDown" + MotorState.stringfy(me.state));
        }

    };

    public static void main(String[] args) {
        Motor motor1500 = new Motor1500();
        ObservableMotor motor1 = new ObservableMotor(motor1500);

        motor1.addStartListener(motorSlowDowntListener);
        motor1.addStopListener(motorSlowDowntListener);
        motor1.addSlowDownListener(motorSlowDowntListener);
        motor1.addSpeedUpListener(motorSlowDowntListener);

        motor1.start();
        motor1.speedUp(0.4f);
        motor1.stop();

        Motor motor1200 = new Motor1200();
        ObservableMotor motor2 = new ObservableMotor(motor1200);

        motor2.addStartListener(motorSlowDowntListener);
        motor2.addStopListener(motorSlowDowntListener);
        motor2.addSlowDownListener(motorSlowDowntListener);
        motor2.addSpeedUpListener(motorSlowDowntListener);

        motor2.start();
        motor2.speedUp(0.2f);
        motor2.stop();


        Motor motor1400 = new Motor1400();
        ObservableMotor motor3 = new ObservableMotor(motor1400);

        motor3.addStartListener(motorSlowDowntListener);
        motor3.addStopListener(motorSlowDowntListener);
        motor3.addSlowDownListener(motorSlowDowntListener);
        motor3.addSpeedUpListener(motorSlowDowntListener);

        motor3.start();
        motor3.speedUp(0.6f);
        motor3.stop();
    }
}
