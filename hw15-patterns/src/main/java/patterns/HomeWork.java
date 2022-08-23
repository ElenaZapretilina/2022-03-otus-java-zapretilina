package patterns;

import patterns.handler.ComplexProcessor;
import patterns.listener.ListenerPrinterConsole;
import patterns.model.Message;
import patterns.model.ObjectForMessage;
import patterns.processor.ProcessorConcatFields;
import patterns.processor.homework.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class HomeWork {

    /*
     Реализовать to do:
       3. Сделать процессор, который будет выбрасывать исключение в четную секунду (сделайте тест с гарантированным результатом)
             Секунда должна определяьться во время выполнения.
             Тест - важная часть задания
             Обязательно посмотрите пример к паттерну Мементо!
     */

    public static void main(String[] args) throws InterruptedException {
        /*
           по аналогии с Demo.class
           из элеменов "to do" создать new ComplexProcessor и обработать сообщение
         */

        var processors = List.of(new ProcessorUpdateField11_12(), new ProcessorException(LocalDateTime::now));

        var complexProcessor = new ComplexProcessor(processors, ex -> {
        });

        var listenerPrinter = new ListenerPrinterConsole();
        complexProcessor.addListener(listenerPrinter);

        List<String> listField13 = new ArrayList<>();
        listField13.add("1");
        listField13.add("2");

        ObjectForMessage objField13 = new ObjectForMessage();
        objField13.setData(listField13);

        var message = new Message.Builder(1L).field1("field1").field2("field2").field3("field3").field6("field6").field10("field10").field11("field11").field12("field12").field13(objField13).build();

        var result = complexProcessor.handle(message);
        System.out.println("result:" + result);

        complexProcessor.removeListener(listenerPrinter);

    }
}
