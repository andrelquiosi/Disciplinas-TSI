package observer.listenerOldStyle;

import java.util.ArrayList;
import java.util.List;

public class MotorListenerManager
{
	private List<MotorListener> listeners = new ArrayList<>();
	
	public void addMotorListener(MotorListener listener)
	{
		listeners.add(listener);
	}
	
	public void removeMotorListener(MotorListener listener)
	{
		listeners.remove(listener);
	}
	
	public void fireBeforeStart(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.beforeStart(me);
	}
	
	public void fireAfterStart(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.afterStart(me);
	}
	
	public void fireBeforeStop(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.beforeStop(me);
	}
	
	public void fireAfterStop(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.afterStop(me);
	}
	
	public void fireBeforeSpeedUp(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.beforeSpeedUp(me);
	}
	
	public void fireAfterSpeedUp(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.afterSpeedUp(me);
	}
	
	public void fireBeforeSlowDown(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.beforeSlowDown(me);
	}
	
	public void fireAfterSlowDown(MotorEvent me)
	{
		for(MotorListener listener : listeners)
			listener.afterSlowDown(me);
	}
}
