package patterns.processor.homework;

import patterns.model.Message;
import patterns.processor.Processor;

public class ProcessorException implements Processor {
     private final DateTimeProvider dateTime;

    public ProcessorException(DateTimeProvider dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public Message process(Message message){
        var time = dateTime.getDate();
        System.out.println(time);

        if (time.getSecond() % 2 == 0) {
            throw new RuntimeException("Четная секунда!");
        }
        return message;
    }

}
