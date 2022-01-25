import exception.ExceptionArgumentTriangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.*;

// echo ${LEVEL}
// export LEVEL=TRACE
// mvn test -Dtest=TriangleTest

public class TriangleTest {
    Logger logger = LoggerFactory.getLogger(TriangleTest.class);


    @BeforeEach
    void logging() {
        logger.error("Log error");
        logger.trace("Log trace");
    }

    @Test
    @DisplayName("Проверка площади Equals ассертом")
    void checkAreaEquals() throws ExceptionArgumentTriangle {
        assertEquals(6.0, Triangle.areaTriangle(3, 4, 5));
    }

    @Test
    @DisplayName("Проверка площади позитив")
    void checkAreaPositive() {
        assertAll(() -> assertEquals(5.332682, Triangle.areaTriangle(3, 4, 6)),
                () -> assertEquals(0.0, Triangle.areaTriangle(3, 4, 7)),
                () -> assertEquals(10.256096, Triangle.areaTriangle(3, 7, 7)),
                () -> assertEquals(6.495191, Triangle.areaTriangle(3, 5, 7)),
                () -> assertEquals(3.49106, Triangle.areaTriangle(1, 7, 7)));

    }

    @Test
    @DisplayName("(негатив) Проверка на 1 аргумента не превышающего сумму 2 других аргументов")
    void checkIncorrectArgument() {
        assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 3, 7);
                }
        );
        assertAll(() -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 3, 7);
                }, "Одна из сторон аргемента больше сумму 2 других аргументов"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(7, 3, 3);
                }, "Одна из сторон аргемента больше сумму 2 других аргументов"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 7, 3);
                }, "Одна из сторон аргемента больше сумму 2 других аргументов")
        );
        logger.info("Logging message: {}", "(негатив) Проверка на 1 аргумента не превышающего сумму 2 других аргументов");
    }


    @Test
    @DisplayName("(негатив) Проверка корректность аргементов на 0 и отрицательное значение")
    void checkCorrectArgument() {
        assertAll(() -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(4, 0, 4);
                }, "Введите корректные данные"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(0, 5, 5);
                }, "Введите корректные данные"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 5, 0);
                }, "Введите корректные данные"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, -1, 4);
                }, "Введите корректные данные"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(-5, 5, 5);
                }, "Введите корректные данные"),
                () -> assertThrows(ExceptionArgumentTriangle.class, () -> {
                    Triangle.areaTriangle(3, 5, -1);
                }, "Введите корректные данные"));

        logger.info("Logging message: {}", "(негатив) Проверка корректность аргементов на 0 и отрицательное значение");
    }


    @Test
    @DisplayName("(негатив) Проверка корректность ввода цифры")
    void checkNumber() {
        assertThrows(NumberFormatException.class, () -> Triangle.areaTriangle(4, Integer.parseInt("d"), 5));
        assertThrows(NumberFormatException.class, () -> Triangle.areaTriangle(Integer.parseInt("d"), 4, 5));
        assertThrows(NumberFormatException.class, () -> Triangle.areaTriangle(4, 5, Integer.parseInt("d")));
        logger.info("Logging message: {}", "(негатив) Проверка корректность ввода цифры");
    }

}
