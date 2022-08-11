package patterns.handler;

import patterns.model.Message;
import patterns.listener.Listener;

public interface Handler {
    Message handle(Message msg);

    void addListener(Listener listener);
    void removeListener(Listener listener);
}
