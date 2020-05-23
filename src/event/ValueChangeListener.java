package event;

import java.util.EventListener;

/**
 * 监听器
 * @author lu
 * @version 1.0
 */
public interface  ValueChangeListener extends EventListener {

    public abstract void performed(ValueChangedEvent e);
}
