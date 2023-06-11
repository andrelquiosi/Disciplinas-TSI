package observer.solid;

import java.util.ArrayList;
import java.util.List;

public class MotorEventListenerManager {

    private List<MotorEventListener> listeners = new ArrayList<>();

    public void addMotorStartEventListener(MotorEventListener listener) {

        this.listeners.add( listener);
    }

    public void removeMotorStartEventListener(MotorEventListener listener) {
        this.listeners.remove(listener);
    }


    public void fireBefore(MotorEvent me) {
        for (MotorEventListener listener : this.listeners)
            listener.before(me);
    }

    public void fireAfter(MotorEvent me) {
        for (MotorEventListener listener : this.listeners)
            listener.after(me);
    }


}