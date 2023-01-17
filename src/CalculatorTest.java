
import static org.assertj.core.api.Assertions.*;
// < ---------- Не забудьте добавить библиотеку libs/assertj-core-3.23.1.jar - add as Library...

public class CalculatorTest {
    public static void main(String[] args) {
        // Проверка базового функционала с целыми числами:
        if (8 != Calculator.calculation(2, 6, '+')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (0 != Calculator.calculation(2, 2, '-')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (14 != Calculator.calculation(2, 7, '*')) {
            throw new AssertionError("Ошибка в методе");
        }

        if (2 != Calculator.calculation(100, 50, '/')) {
            throw new AssertionError("Ошибка в методе");
        }

        // Случаи с неправильными аргументами
        // аргумент operator типа char, должен вызывать исключение, если он получает не базовые символы (+-*/)
        // try {
        //     Calculator.calculation(8, 4, '_');
        // } catch (IllegalStateException e) {
        //     if (!e.getMessage().equals("Unexpected value operator: _")) {
        //         throw new AssertionError("Ошибка в методе");
        //     }
        // }

        // Проверка базового функционала с целыми числами, с использованием утверждений:
        assert 8 == Calculator.calculation(2, 6, '+');
        assert 0 == Calculator.calculation(2, 2, '-');
        assert 14 == Calculator.calculation(2, 7, '*');
        assert 2 == Calculator.calculation(100, 50, '/');

        // Проверка базового функционала с целыми числами, с использованием утверждений AssertJ:
        assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(8);
        assertThat(Calculator.calculation(2, 2, '-')).isEqualTo(0);
        assertThat(Calculator.calculation(2, 7, '*')).isEqualTo(14);
        assertThat(Calculator.calculation(100, 50, '/')).isEqualTo(2);


        // Положительные проверки вычисления скидки
        assertThat(Calculator.calculatingDiscount(1000, 1)).isEqualTo(990);
        assertThat(Calculator.calculatingDiscount(100, 10)).isEqualTo(90);
        assertThat(Calculator.calculatingDiscount(100, 99)).isEqualTo(1);
        assertThat(Calculator.calculatingDiscount(2.2, 6)).isEqualTo(2.068);

        // Проверка вычисления отрицательного числа, 0, дробей, процентов >=100%
        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(-2.0, 6)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма покупки не может быть отрицательной");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2.0, -6)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка не может быть отрицательной");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(2.0, 0)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка не может быть 0");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(0.0, 6)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Сумма покупки не может быть 0");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 101)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка больше 100 %");

        assertThatThrownBy(() ->
                Calculator.calculatingDiscount(100, 100)
                ).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("Скидка 100 %");


//        // Проверка ожидаемого исключения, с использованием утверждений AssertJ:
//        assertThatThrownBy(() ->
//                Calculator.calculation(8, 4, '_')
//        ).isInstanceOf(IllegalStateException.class);

//        System.out.println(Calculator.calculation(2_147_483_647, 1, '+')); // integer overflow
//        System.out.println(Calculator.squareRootExtraction(169));

        // Примерные решения домашних заданий из 1 лекции:

        // HW1.1: Придумайте и опишите (можно в псевдокоде) функцию извлечения корня и
        // необходимые проверки для него используя граничные случаи
//         assertThatThrownBy(() ->
//                 Calculator.squareRootExtraction(0)
//         ).isInstanceOf(ArithmeticException.class);

        // HW1.2: Как будет выглядеть проверка для случая деления на ноль? (с использованием AssertJ)
//         assertThatThrownBy(() ->
//                Calculator.calculation(5, 0, '/')
//         ).isInstanceOf(ArithmeticException.class);

        // HW1.3: Сравните одну и ту же проверку с использованием условий, ассертов, AssertJ
        // в каком случае стандартное сообщение об ошибке будет более информативным?
        // if (0 != Calculator.calculation(2, 6, '+')) {
        //     throw new AssertionError("Ошибка в методе");
        // }
        //   assert 0 == Calculator.calculation(2, 6, '+');
        //    assertThat(Calculator.calculation(2, 6, '+')).isEqualTo(0);
    }
}