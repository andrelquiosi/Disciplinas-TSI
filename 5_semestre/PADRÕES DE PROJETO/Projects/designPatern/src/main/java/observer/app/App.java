package observer.app;

import observer.fusca.motor.Motor1500;
import observer.listenerOldStyle.MotorEvent;
import observer.listenerOldStyle.MotorListener;
import observer.listenerOldStyle.ObservableMotor;
import observer.motor.Motor;
import observer.motor.MotorState;

public class App 
{
	static MotorListener motorListener = new MotorListener() 
   {
      @Override
      public void beforeStart(MotorEvent me)
      {
          System.out.println("beforeStart " + MotorState.stringfy(me.state));
      }

      @Override
      public void afterStart(MotorEvent me) 
      {
         System.out.println("afterStart " + MotorState.stringfy(me.state));
      }

      @Override
      public void beforeStop(MotorEvent me)
      {
         System.out.println("beforeStop " + MotorState.stringfy(me.state));
      }

      @Override
      public void afterStop(MotorEvent me)
      {
         System.out.println("afterStop " + MotorState.stringfy(me.state));
      }
      
      @Override
      public void beforeSlowDown(MotorEvent me)
      { /*nothing*/}

      @Override
      public void afterSlowDown(MotorEvent me)
      { /*nothing*/ }

      @Override
      public void beforeSpeedUp(MotorEvent me)
      { /*nothing*/ }

      @Override
      public void afterSpeedUp(MotorEvent me)
      { /*nothing*/ }
   };

   public static void main(String args[])
   {
      Motor motor1500 = new Motor1500();
      ObservableMotor motor = new ObservableMotor(motor1500);

      motor.addMotorListener(motorListener);

      motor.start();
      motor.speedUp(0.5f);
      motor.stop();
   }

}
