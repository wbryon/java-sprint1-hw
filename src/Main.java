import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        int userInput;
        printMenu();
        userInput = scanner.nextInt();
        while (userInput != 0) {
            if (userInput == 1) {
                System.out.print("Введите месяц: ");
                int monthNumber = scanner.nextInt();
                System.out.print("Введите день: ");
                int dateNumber = scanner.nextInt();
                if (tracker.monthToData[monthNumber - 1].date[dateNumber - 1] > 0) {
                    System.out.println("Ранее введённое значение будет перезаписано!");
                }
                System.out.print("Введите количество пройденных шагов: ");
                userInput = scanner.nextInt();
                if (userInput < 0) {
                    System.out.println("Количество шагов не может быть отрицательным!");
                } else {
                    tracker.monthToData[monthNumber - 1].date[dateNumber - 1] = userInput;
                }
            } else if (userInput == 2) {
                System.out.print("За какой месяц вы хотите получить статистику: ");
                userInput = scanner.nextInt();
                tracker.monthToData[userInput - 1].printStatistics();
            } else if (userInput == 3) {
                System.out.print("Введите желаемое количество шагов: ");
                userInput =scanner.nextInt();
                tracker.setStepCount(userInput);
            } else {
                System.out.println("Такой команды в меню нет.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Напечатать статистику за месяц");
        System.out.println("3 - Изменить количество шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}