import java.util.Arrays;

/**
 * Класс с основной логикой приложения — в нём хранится информация о пройденных шагах,
 * реализована логика по сохранению и изменению количества шагов, а так же рассчитывается статистика.
 */
public class StepTracker {
    Converter converter = new Converter();
    /** Поле целевого количества шагов */
    private int stepsTarget = 10000;
    /** Поле массива месяцев */
    MonthData[] monthToData;

    public StepTracker() {
        /** Инициализация массива */
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    /** Метод для изменения целевого количества шагов */
    void setStepCount(int stepsTarget) {
        if (stepsTarget >= 0) {
            this.stepsTarget = stepsTarget;
            System.out.println("\nЦелевое значение количества шагов теперь равно " + stepsTarget + "\n");
        }
        else {
            System.out.println("\nКоличество шагов не может быть отрицательным!\n");
        }
    }

    /** Внутренний класс, в котором реализована логика обработки статистики дней месяца */
    class MonthData {
        /** Поле массива дней месяца */
        int[] days;
        public MonthData() {
            /** Инициализауия массива */
            days = new int[30];
        }

        /** Метод для подсчёта и вывода статистики за указанный пользователем месяц */
        void printStatistics() {
            for (int i = 0; i < days.length - 1; i++) {
                System.out.print((i + 1) + " день: " + days[i] + ", ");
            }
            System.out.println(days.length + " день: " + days[days.length -1]);
            System.out.println("Общее количество шагов за месяц: " + Arrays.stream(days).sum());
            System.out.println("Максимальное пройденное количество шагов в этом месяце: " + Arrays.stream(days).max().getAsInt());
            System.out.println("Среднее количество шагов: " + (int)Arrays.stream(days).average().getAsDouble());
            converter.convertStepsToKilometers(Arrays.stream(days).sum());
            converter.convertStepsToKilocalories(Arrays.stream(days).sum());
            System.out.println("Лучшая серия: " + findBestSeries());
        }
        /**
         * Метод подсчёта лучшей серии: максимальное количество подряд идущих дней,
         * в течение которых количество шагов за день было равно или выше целевого
         */
        int findBestSeries() {
            int counter = 0;
            int bestCounter = 0;
            for (int day : days) {
                if (day >= stepsTarget) {
                    counter++;
                    if (bestCounter < counter) {
                        bestCounter = counter;
                    }
                } else {
                    counter = 0;
                }
            }
            return bestCounter;
        }

    }
}