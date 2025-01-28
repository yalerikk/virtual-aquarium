import java.util.ArrayList;

public class Main {

    /*25. Аквариум.
    + Определить иерархию аквариумных рыбок.
    + Составить список рыбок для аквариума.
    + Подсчитать цену за всех рыбок.
    + Провести сортировку рыбок на основе их продолжительности жизни.
    + Найти рыбок, соответствующих заданному диапазону размеров.*/

    protected static ArrayList<Fish> fishList = new ArrayList<>();
    protected static String saveFileName = "FishData.bin", loadFileName = "FishData.bin";

    public static void main(String[] args) {
        System.out.println("\n\n\nДобро пожаловать в Аквариум!");
        functionMenu();
    }

    public static void functionMenu(){
        int choice;
        System.out.println("\n1)Составить список рыбок для аквариума;\n" +
                "2)Подсчитать цену за всех рыбок;\n" +
                "3)Провести сортировку рыбок на основе их продолжительности жизни;\n" +
                "4)Найти рыбок, соответствующих заданному диапазону размеров;\n" +
                "5)Работа с файлами.\n");
        System.out.println("Выберите действие или нажмите 6 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 6);

        switch (choice) {
            case 1:
                makeList();
            case 2:
                countAquarium();
            case 3:
                sortByLengthOfLife();
            case 4:
                searchFishes();
            case 5:
                workWithFiles();
            case 6:
                System.out.println("\nВыход из программы.");
                break;
        }
    }

    private static void makeList() {
        int choice;
        System.out.println("\nСоставить список рыбок для аквариума:\n" +
                "1)Автоматически;\n2)Добавить рыбок вручную.\n");
        System.out.println("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);

        switch (choice) {
            case 1:
                Aquarium.createAquarium(fishList);
                functionMenu();
            case 2:
                addFishes();
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    public static void addFishes() {
        while (true) {
            System.out.println("\nВыберите тип рыбки:\n" +
                    "1)Гуппи;\n2)Неон;\n3)Меченосец;\n4)Золотая рыбка;\n5)Гурами.\n");
            System.out.println("Выберите действие или нажмите 6 для выхода: ");
            int choice = CheckValue.readIntegerInRange(1, 6);
            Fish newFish = null;

            switch (choice) {
                case 1:
                    newFish = Aquarium.addGuppy(fishList);
                    break;
                case 2:
                    newFish = Aquarium.addNeon(fishList);
                    break;
                case 3:
                    newFish = Aquarium.addSwordtail(fishList);
                    break;
                case 4:
                    newFish = Aquarium.addGoldfish(fishList);
                    break;
                case 5:
                    newFish = Aquarium.addGourami(fishList);
                    break;
                case 6:
                    functionMenu();
            }

            if (newFish != null) {
                fishList.add(newFish);
                System.out.println("\nРыбка добавлена!");
            }
        }
    }

    private static void countAquarium() {
        int choice;
        System.out.println("\nВывести список рыбок в аквариуме перед просмотром суммы?:\n" +
                "1)Да;\n2)Нет.\n");
        System.out.print("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);
        double totalCost = Aquarium.calculateTotalCost(fishList);
        switch (choice) {
            case 1:
                Aquarium.showAquarium(fishList);
                System.out.println("\nОбщая стоимость рыбок: " + totalCost + " р.");
                functionMenu();
            case 2:
                System.out.println("\nОбщая стоимость рыбок: " + totalCost + " р.");
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    private static void sortByLengthOfLife() {
        int choice;
        System.out.println("\nПровести сортировку рыбок на основе их продолжительности жизни:\n" +
                "1)В порядке возрастания;\n2)В порядке убывания.\n");
        System.out.println("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);
        switch (choice) {
            case 1:
                Aquarium.sortByLengthOfLifeUp(fishList);
                functionMenu();
            case 2:
                Aquarium.sortByLengthOfLifeDown(fishList);
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    private static void searchFishes() {
        int choice;
        System.out.println("\nНайти рыбок, соответствующих заданному диапазону размеров:\n" +
                "1)Да;\n2)Нет, выйти.\n");
        System.out.println("Выберите действие: ");
        choice = CheckValue.readIntegerInRange(1, 2);
        switch (choice) {
            case 1:
                Aquarium.searchInRange(fishList);
                functionMenu();
            case 2:
                functionMenu();
        }
    }

    public static void workWithFiles() {
        int choice;
        System.out.println("\n1)Сохранить аквариум в файл;\n" +
                "2)Считывание из файла.\n");
        System.out.println("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);

        switch (choice) {
            case 1:
                saveFileName = inputFileName(); // Получаем имя файла для сохранения
                if (saveFileName != null) { // Проверяем, не нажал ли пользователь "3" для выхода
                    Aquarium.saveToFile(fishList, saveFileName);
                }
                functionMenu();
            case 2:
                loadFileName = inputFileName();
                if (loadFileName != null) {
                    Aquarium.loadFromFile(fishList, loadFileName);
                }
                functionMenu();
            case 3:
                functionMenu();
        }
    }

    public static String inputFileName() {
        int choice;
        System.out.println("\n1)Использовать базовое название файла - \"FishData.bin\";\n" +
                "2)Ввести свое имя файла.\n");
        System.out.println("Выберите действие или нажмите 3 для выхода: ");
        choice = CheckValue.readIntegerInRange(1, 3);

        return switch (choice) {
            case 1 -> "FishData.bin";
            case 2 -> CheckValue.isValidFileName("\nВведите имя файла формата .bin: ");
            default -> null;
        };
    }
}