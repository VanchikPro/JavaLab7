import java.util.Scanner;

public class Menu {
    private final Scanner scanner;

    public Menu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void displayMenu() {
        System.out.println("\n--- Главное меню ---");
        System.out.println("1. Выполнить расчет");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.print("Выберите опцию: ");
    }

    public int getChoice() {
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 1 && choice <= 4) {
                    return choice;
                } else {
                    throw new IllegalArgumentException("Выберите опцию от 1 до 4."); //выбрасывание исключения
                }
            } catch (NumberFormatException e) {
                System.out.print("Ошибка: введите число. \nПовторите ввод: ");
            }
        }
    }

    public double getValidMass() throws Exclusion {
        System.out.print("Введите массу объекта в килограммах: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Ошибка: введите положительное число. \nПовторите ввод: ");
            scanner.next();
        }
        double mass = scanner.nextDouble();
        scanner.nextLine(); // очистка буфера
        if (mass > 0) {
            return mass;
        } else {
            throw new Exclusion("Масса должна быть положительным числом."); //выбрасывание исключения
        }
    }

    public double getValidSpeed() throws Exclusion {
        System.out.print("Введите скорость объекта в метрах в секунду: ");
        while (!scanner.hasNextDouble()) {
            System.out.print("Ошибка: введите положительное число. \nПовторите ввод: ");
            scanner.next();
        }
        double speed = scanner.nextDouble();
        scanner.nextLine(); // очистка буфера
        return speed;
    }

    public void displayProgramInfo() {
        System.out.println("Эта программа рассчитывает кинетическую энергию объекта по формуле: E = 0.5 * m * v^2.");
    }

    public void displayDeveloperInfo() {
        System.out.println("Разработчик программы: Дорофиенко Иван Сергеевич РИМ-140970.");
    }
}