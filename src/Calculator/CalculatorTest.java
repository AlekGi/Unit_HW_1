package Calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    public static void main(String[] args) {

        // Проверить этот метод с использованием библиотеки AssertJ.
        // Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать исключение ArithmeticException.

        // Проверка, что метод выбрасывает исключение при недопустимых аргументах
        assertThatThrownBy(() -> Calculator.calculatingDiscount(-1, 50)).isInstanceOf(IllegalArgumentException.class).hasMessage("Некорректная сумма скидки");
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, -1)).isInstanceOf(IllegalArgumentException.class).hasMessage("Некорректная сумма скидки");
        assertThatThrownBy(() -> Calculator.calculatingDiscount(100, 101)).isInstanceOf(IllegalArgumentException.class).hasMessage("Некорректная сумма скидки");

        assertThat(Calculator.calculatingDiscount(100, 20)).isEqualTo(80.0);
        assertThat(Calculator.calculatingDiscount(100, 50)).isEqualTo(50.0);
        assertThat(Calculator.calculatingDiscount(100, 1)).isEqualTo(99.0);
        assertThat(Calculator.calculatingDiscount(100, 99)).isEqualTo(1.0);
    }
}