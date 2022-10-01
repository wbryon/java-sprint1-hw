public class StepTracker {
    private int stepCount = 10000;
    MonthData[] monthToData;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setStepCount(int stepCount) {
        this.stepCount = stepCount;
    }

    class MonthData {
        // Заполните класс самостоятельно
    }
}
