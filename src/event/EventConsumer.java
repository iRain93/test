package event;

/**
 * 事件的消费者
 * @author lu
 * @version 1.0
 */
public class EventConsumer implements ValueChangeListener {

    @Override
    public void performed(ValueChangedEvent e) {
        System.out.println("value changed, new value = " + e.getValue());
    }
}
