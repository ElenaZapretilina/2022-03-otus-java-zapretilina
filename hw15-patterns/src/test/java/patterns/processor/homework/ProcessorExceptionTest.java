package patterns.processor.homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import patterns.model.Message;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class ProcessorExceptionTest {

    @Test
    @DisplayName("Тестируем обработку исключения  в четную секунду")
    void handleExceptionTest() {
        var message = new Message.Builder(1L).field2("field2").build();
        System.out.println(message);

        var processor1 = new ProcessorException(() ->
                LocalDateTime.of(2022, 8, 3, 0, 0, 54)
        );
        assertThrows(RuntimeException.class,
                () -> processor1.process(message));
    }

    @Test
    @DisplayName("Тестируем обработку исключения  в нечетную секунду")
    void handleNoExceptionTest() {
        var message = new Message.Builder(1L).field3("field3").build();
        System.out.println(message);

        var processor = new ProcessorException(() ->
                LocalDateTime.of(2022, 8, 3, 0, 0, 53)
        );
        processor.process(message);
    }
}

