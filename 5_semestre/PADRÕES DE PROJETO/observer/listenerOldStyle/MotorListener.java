package observer.listenerOldStyle;

public interface MotorListener 
{
	public void beforeStart(MotorEvent me);
	public void afterStart(MotorEvent me);
	
	public void beforeStop(MotorEvent me);
	public void afterStop(MotorEvent me);
	
	public void beforeSpeedUp(MotorEvent me);
	public void afterSpeedUp(MotorEvent me);
	
	public void beforeSlowDown(MotorEvent me);
	public void afterSlowDown(MotorEvent me);
}
