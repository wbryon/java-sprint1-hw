import java.util.Arrays;

public class StepTracker {
    Converter converter = new Converter();
    private int stepsTarget = 10000;
    MonthData[] monthToData;

    public StepTracker() {

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void setStepCount(int stepsTarget) {
        if (stepsTarget >= 0) {
            this.stepsTarget = stepsTarget;
            System.out.println("\nЦелевое значение количества шагов теперь равно " + stepsTarget + "\n");
        }
        else {
            System.out.println("\nКоличество шагов не может быть отрицательным!\n");
        }
    }
    class MonthData {
        int[] date;
        public MonthData() {
            date = new int[30];
        }
        void printStatistics() {
            for (int i =0; i < date.length - 1; i++) {
                System.out.print((i + 1) + " день: " + date[i] + ", ");
            }
            System.out.println(date.length + " день: " + date[date.length -1]);
            System.out.println("Общее количество шагов за месяц: " + Arrays.stream(date).sum());
            System.out.println("Максимальное пройденное количество шагов в этом месяце: " + Arrays.stream(date).max().getAsInt());
            System.out.println("Среднее количество шагов: " + (int)Arrays.stream(date).average().getAsDouble());
            converter.convertStepsToKilometers(Arrays.stream(date).sum());
            converter.convertStepsToKilocalories(Arrays.stream(date).sum());
            System.out.println("Лучшая серия: " + findBestSeries());
        }
        int findBestSeries() {
            int counter = 0;
            int bestCounter = 0;
            for (int i = 0; i < date.length; i++) {
                if (i >= stepsTarget) {
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