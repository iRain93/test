package event;

/**
 * 事件的产生者
 * @author lu
 * @version 1.0
 */
public class EventProducer {

    ListenerRegister register = new ListenerRegister();
    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int newValue) {
        if (value != newValue) {
            value = newValue;
            ValueChangedEvent event = new ValueChangedEvent(this, value);
            fireAEvent(event);
        }
    }

    public void addListener(ValueChangeListener a) {
        register.addListener(a);
    }

    public void removeListener(ValueChangeListener a) {
        register.removeListener(a);
    }

    public void fireAEvent(ValueChangedEvent event) {
        register.fireAEvent(event);
    }


}
