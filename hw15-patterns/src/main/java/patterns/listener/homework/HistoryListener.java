package patterns.listener.homework;

import patterns.listener.Listener;
import patterns.model.Message;
import patterns.model.ObjectForMessage;

import java.util.*;

public class HistoryListener implements Listener, HistoryReader {
    private final Map<Long, Message> historyMsgMap = new HashMap<>();

    @Override
    public void onUpdated(Message msg) {
        Message msgNew = copy(msg);
        historyMsgMap.put(msgNew.getId(), msgNew);
    }

    @Override
    public Optional<Message> findMessageById(long id) {
        return Optional.ofNullable(historyMsgMap.get(id));
    }

    private final Message copy(Message msg) {
        List<String> listField13Data = new ArrayList<>();
        ObjectForMessage fieldCopy13 = new ObjectForMessage();

        if (msg.getField13() != null) {
            for (int i = 0; i < msg.getField13().getData().size(); i++) {
                listField13Data.add(msg.getField13().getData().get(i));
            }
        }
        fieldCopy13.setData(listField13Data);

        return new Message.Builder(msg.getId())
                .field1(msg.getField1())
                .field2(msg.getField2())
                .field3(msg.getField3())
                .field4(msg.getField4())
                .field5(msg.getField5())
                .field6(msg.getField6())
                .field7(msg.getField7())
                .field8(msg.getField8())
                .field9(msg.getField9())
                .field10(msg.getField10())
                .field11(msg.getField11())
                .field12(msg.getField12())
                .field13(fieldCopy13)
                .build();

    }

}

