import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
        boolean exit = false;

        // динамический список объектов
        ArrayList<KineticEnergy> objects = new ArrayList<>();
        int calculationCount = 0; // Счетчик расчетов

        while (!exit) {
            try {
                menu.displayMenu();
                int choice = menu.getChoice();

                switch (choice) {
                    case 1:
                        try {
                            double mass = menu.getValidMass();
                            double speed = menu.getValidSpeed();
                            calculationCount++;
                            KineticEnergy object = new KineticEnergy(calculationCount, mass, speed);
                            objects.add(object); // добавление объекта в список
                            System.out.printf("Кинетическая энергия объекта: %.2f Джоулей\n", object.calculate());
                        } catch (Exclusion e) { //перехват исключения
                            System.out.println("Ошибка создания объекта: " + e.getMessage()); //обработка исключения
                        }
                        break;
                    case 2:
                        menu.displayProgramInfo();
                        break;
                    case 3:
                        menu.displayDeveloperInfo();
                        break;
                    case 4:
                        System.out.println("Выход из программы...");
                        exit = true;
                        break;
                }
            } catch (Exception e) { //перехват исключения
                System.out.println("Произошла ошибка: " + e.getMessage()); //обработка исключения
            }
        }
        // создание клона списка объектов
        ArrayList<KineticEnergy> clonedObjects = new ArrayList<>();
        for (KineticEnergy obj : objects) {
            clonedObjects.add(obj.clone());
        }
        // вывод результатов
        System.out.println("\nРезультаты работы программы:");
        for (KineticEnergy obj : clonedObjects) {
            System.out.println("Расчет " + obj.getId());
            System.out.println(obj);
        }
        // сортировка списка объектов по кинетической энергии
        objects.sort(null); // используется метод compareTo

        // обработка списка объектов с использованием полиморфизма
        System.out.println("\nРезультаты работы программы (отсортированы по энергии):");
        for (KineticEnergy obj : objects) {
            System.out.println("Расчет " + obj.getId());
            System.out.println(obj);
        }
        scanner.close();
    }
}