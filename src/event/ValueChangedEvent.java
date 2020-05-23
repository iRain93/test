package event;

import java.util.EventObject;

/**
 * 值改变事件
 * @author lu
 * @version 1.0
 */
public class ValueChangedEvent extends EventObject {

    private int value;
    public ValueChangedEvent(Object source) {
        super(source);
    }
    public ValueChangedEvent(Object source, int value) {
        super(source);
        this.value =value;
    }

    public int getValue() {
        return value;
    }
}
