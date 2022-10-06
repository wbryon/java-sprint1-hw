import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * В этом классе осуществляется преобразование шагов в километры и калории
 */
public class Converter {

    private int stepLength = 75;
    private final double calories = 50;
    private final double kilometer = 100000;
    private final double kilocaloriie = 1000;

    /** Метод для преобразования количества пройденных шагов в километры */
    void convertStepsToKilometers(int stepCount) {
        System.out.println("Пройденное расстояние: " + new BigDecimal(stepCount * stepLength / kilometer).setScale(2, RoundingMode.DOWN) + " км");
    }
    /** Метод для преобразования количества пройденных шагов в калории */
    void convertStepsToKilocalories(int stepCount) {
        System.out.println("Количество сожжённых килокалорий: " + new BigDecimal(stepCount * calories / kilocaloriie).setScale(0, RoundingMode.DOWN));
    }
}