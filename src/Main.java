import java.util.Scanner;

/**
 * @author Хабибула Тамирбудаев
 * @version 1.1
 * @since 1.0
 * В этом классе реализован основной цикл приложения — считывание команд
 * и вызов соответствующих методов основного класса приложения — StepTracker
 */
public class Main {
    public static void main(String[] args) {
        /** Создание экземпляра класса StepTracker */
        StepTracker tracker = new StepTracker();
        Scanner scanner = new Scanner(System.in);
        int userInput;
        printMenu();
        userInput = scanner.nextInt();
        /** Основной цикл работы программы */
        while (userInput != 0) {
            switch (userInput) {
                case 1:
                    System.out.print("Введите месяц (от 1 до 12): ");
                    int monthNumber = scanner.nextInt();
                    System.out.print("Введите день (от 1 до 30): ");
                    int dateNumber = scanner.nextInt();
                    if (tracker.monthToData[monthNumber - 1].days[dateNumber - 1] > 0) {
                        System.out.println("Ранее введённое значение будет перезаписано!");
                    }
                    System.out.print("Введите количество пройденных шагов: ");
                    userInput = scanner.nextInt();
                    if (userInput < 0) {
                        System.out.println("Количество шагов не может быть отрицательным!");
                    } else {
                        tracker.monthToData[monthNumber - 1].days[dateNumber - 1] = userInput;
                    }
                    break;
                case 2:
                    System.out.print("За какой месяц вы хотите получить статистику (от 1 до 12): ");
                    userInput = scanner.nextInt();
                    tracker.monthToData[userInput - 1].printStatistics();
                    break;
                case 3:
                    System.out.print("Введите желаемое количество шагов: ");
                    userInput = scanner.nextInt();
                    tracker.setStepCount(userInput);
                    break;
                default:
                    System.out.println("Такой команды в меню нет.");
                    break;
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Программа завершена");
    }

    /** метод, предлагающий пользователю выбрать команду из списка */
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Ввести количество шагов за день");
        System.out.println("2 - Напечатать статистику за месяц");
        System.out.println("3 - Изменить количество шагов в день");
        System.out.println("0 - Выйти из приложения");
    }
}