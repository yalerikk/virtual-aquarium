import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Aquarium {
    static String emptyAquariumMessage = "\nВ аквариуме нет рыбок..";
    static private boolean isAquariumCreated = false;
    protected static boolean isErrorDisplayed = false; // Флаг для отслеживания ошибки

    public static void createAquarium(ArrayList<Fish> fishList){
        try {
            if (isAquariumCreated) {
                throw new AquariumException("\nАквариум уже был создан.");
            } else {
                Guppy guppy1 = new Guppy("Гуппи 1", 1, 3, "Красный");
                fishList.add(guppy1);

                Guppy guppy2 = new Guppy("Гуппи 2", 3, 6, "Голубой");
                fishList.add(guppy2);

                Neon neon1 = new Neon("Неон 1", 1, 2, "Средний");
                fishList.add(neon1);

                Neon neon2 = new Neon("Неон 2", 5, 4, "Высокий");
                fishList.add(neon2);

                Swordtail swordtail1 = new Swordtail("Меченосец 1", 4, 10, "Мечевидный");
                fishList.add(swordtail1);

                Swordtail swordtail2 = new Swordtail("Меченосец 2", 5, 8, "Мечевидный");
                fishList.add(swordtail2);

                Goldfish goldfish1 = new Goldfish("Золотая рыбка 1", 10, 15, "Оранжевый");
                fishList.add(goldfish1);

                Goldfish goldfish2 = new Goldfish("Золотая рыбка 2", 30, 30, "Золотой");
                fishList.add(goldfish2);

                Gourami gourami1 = new Gourami("Гурами 1", 4, 10, "Округлый");
                fishList.add(gourami1);

                Gourami gourami2 = new Gourami("Гурами 2", 5, 8, "Мраморный");
                fishList.add(gourami2);

                isAquariumCreated = true;
                System.out.println("\nУспешно создано!");
            }
        } catch (AquariumException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showAquarium(ArrayList<Fish> fishList) {
        if (!fishList.isEmpty()) {
            System.out.println("\nСписок рыбок в аквариуме: \n");
            System.out.println("-----------------------");
            for (Fish fish : fishList) {
                System.out.println(fish.toString());
                System.out.println("-----------------------");
            }
            isErrorDisplayed = false; // Успешный вывод, сброс флага
        } else {
            // Пытаемся вызвать исключение, если аквариум пуст
            if (!isErrorDisplayed) { // Проверяем, было ли сообщение об ошибке выведено
                try {
                    throw new EmptyAquariumException(emptyAquariumMessage);
                } catch (EmptyAquariumException e) {
                    System.out.println(e.getMessage());
                    isErrorDisplayed = true; // Устанавливаем флаг
                }
            }
        }
    }

    public static void text(String text, List<Fish> list ){
        System.out.println(text);
        for (int i = 0; i < list.size(); i++) {
            Fish fish = list.get(i);
            int age = fish.getLengthOfLife();
            String ageString = CheckValue.getAge(age);

            if (i == list.size() - 1) {
                System.out.println("\n" + fish.getName() + " : " + ageString + " - " +
                        fish.getSize() + " (см) - " + fish.getCost() + " р.");
            } else {
                System.out.print("\n" + fish.getName() + " : " + ageString + " - " +
                        fish.getSize() + " (см) - " + fish.getCost() + " р,");
            }
        }
    }

    public static void sortByLengthOfLifeUp(ArrayList<Fish> fishList){
        if (fishList.isEmpty()) {
            try {
                throw new EmptyAquariumException(emptyAquariumMessage);
            } catch (EmptyAquariumException e) {
                System.out.println(e.getMessage());
            }
        } else {
            Collections.sort(fishList);
            text("\nСортировка рыбок в порядке возрастания: ", fishList);
        }
    }

    public static void sortByLengthOfLifeDown(ArrayList<Fish> fishList){
        if (fishList.isEmpty()) {
            try {
                throw new EmptyAquariumException(emptyAquariumMessage);
            } catch (EmptyAquariumException e) {
                System.out.println(e.getMessage());
            }
        } else {
            Comparator<Fish> lengthOfLifeComparator = new ReserveComparator();
            fishList.sort(lengthOfLifeComparator);
            text("\nСортировка рыбок в порядке убывания: ", fishList);
        }
    }

    public static double calculateTotalCost(ArrayList<Fish> fishList) {
        double totalCost = 0.0;

        try {
            if (fishList.isEmpty()) {
                throw new EmptyAquariumException(emptyAquariumMessage);
            } else {
                for (Fish fish : fishList) {
                    totalCost += fish.getCost();
                }
                isErrorDisplayed = false; // Успешно выполнено, сбрасываем флаг
                return totalCost;
            }
        } catch (EmptyAquariumException e) {
            // Обработка исключения
            if (!isErrorDisplayed) { // Проверяем флаг
                System.out.println(e.getMessage());
                isErrorDisplayed = true; // Устанавливаем флаг, что сообщение об ошибке выведено
            }
            return totalCost; // Возврат 0 для пустого аквариума
        }
    }

    public static void searchInRange(ArrayList<Fish> fishList) {
        try {
            if (fishList.isEmpty()) {
                throw new EmptyAquariumException(emptyAquariumMessage);
            } else {
                int minSize, maxSize;
                System.out.println("\nВведите минимальный размер рыбки: ");
                minSize = CheckValue.readIntegerInRange(0, 30);
                System.out.println("Введите максимальный размер рыбки: ");
                maxSize = CheckValue.readIntegerInRange(1, 50);

                while (minSize == maxSize) {
                    System.out.println("\nЗначения не могут быть одинаковыми! Введите разные значения.");
                    System.out.println("Введите минимальный размер рыбки: ");
                    minSize = CheckValue.readIntegerInRange(0, 30);

                    System.out.println("Введите максимальный размер рыбки: ");
                    maxSize = CheckValue.readIntegerInRange(1, 50);
                }

                List<Fish> fishInRange = new ArrayList<>();
                for (Fish fish : fishList) {
                    if (fish.getSize() >= minSize && fish.getSize() <= maxSize) {
                        fishInRange.add(fish);
                    }
                }

                if (fishInRange.isEmpty()) {
                    emptyAquariumMessage.substring(0, 20);
                    throw new EmptyAquariumException(emptyAquariumMessage + " с заданным диапазоном размеров");
                } else {
                    System.out.println("\nРыбки в заданном диапазоне размеров (" + minSize + " - " + maxSize + "):\n");
                    for (Fish fish : fishInRange) {
                        System.out.println(fish.getName() + ": " + fish.getSize() + " (см)");
                    }
                }
            }
        } catch (EmptyAquariumException e) {
            System.out.println(e.getMessage());
        }
    }

    // Метод для сохранения рыбок в файл
    public static void saveToFile(ArrayList<Fish> fishList, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(fishList);
            System.out.println("\nДанные успешно сохранены в файл " + fileName);
        } catch (FileNotFoundException e) {
            System.out.println("\nФайл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nОшибка при записи данных в файл: " + e.getMessage());
        }
    }

    // Метод для считывания рыбок из файла
    public static void loadFromFile(ArrayList<Fish> fishList, String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            //System.out.println("Попытка загрузки данных из файла: " + fileName);
            fishList.clear(); // Очищаем существующий список
            List<Fish> loadedFish = (List<Fish>) ois.readObject(); // Читаем объекты как List<Fish>
            fishList.addAll(loadedFish); // Добавляем загруженные объекты в текущий список
            System.out.println("\nДанные успешно считаны из файла " + fileName + "!");
        } catch (FileNotFoundException e) {
            System.out.println("\nФайл не найден: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("\nОшибка при чтении данных из файла: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("\nКласс не найден: " + e.getMessage());
        }
    }

    public static boolean isUniqueFishName(ArrayList<Fish> fishList, String name) {
        for (Fish fish : fishList) {
            if (fish.getName().equalsIgnoreCase(name)) {
                return false; // Рыбка с таким именем уже существует
            }
        }
        return true; // Имя уникально
    }

    public static Guppy addGuppy(ArrayList<Fish> fishList) {
        Guppy guppy = new Guppy("", 0, 0, "");

        while (true) {
            try {
                System.out.println("\nВведите имя гуппи: ");
                String name = CheckValue.readNonEmptyString();
                if (!isUniqueFishName(fishList, name)) {
                    throw new AquariumException("Рыбка с таким именем уже существует в аквариуме!");
                }
                guppy.setName(name);

                System.out.println("Введите продолжительность жизни гуппи (до 3 лет): ");
                int lengthOfLife = CheckValue.readIntegerInRange(1, 3);
                guppy.setLengthOfLife(lengthOfLife);

                System.out.println("Введите размер гуппи (до 6 см): ");
                int size = CheckValue.readIntegerInRange(1, 6);
                guppy.setSize(size);

                String color = CheckValue.readVariety("Введите цвет гуппи:", CheckValue.getGuppyColors());
                guppy.setColor(color);

                return guppy;
            } catch (AquariumException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Neon addNeon(ArrayList<Fish> fishList) {
        Neon neon = new Neon("", 0, 0, "");

        while (true) {
            try {
                System.out.println("\nВведите имя неона: ");
                String name = CheckValue.readNonEmptyString();
                if (!isUniqueFishName(fishList, name)) {
                    throw new AquariumException("Рыбка с таким именем уже существует в аквариуме.");
                }
                neon.setName(name);

                System.out.println("Введите продолжительность жизни неона (до 5 лет): ");
                int lengthOfLife = CheckValue.readIntegerInRange(1, 5);
                neon.setLengthOfLife(lengthOfLife);

                System.out.println("Введите размер неона (до 4 см): ");
                int size = CheckValue.readIntegerInRange(1, 4);
                neon.setSize(size);

                String brightness = CheckValue.readVariety("Введите уровень яркости неона:", CheckValue.getNeonBrightnessLevels());
                neon.setBrightness(brightness);

                return neon;
            } catch (AquariumException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Swordtail addSwordtail(ArrayList<Fish> fishList) {
        Swordtail swordtail = new Swordtail("", 0, 0, "");

        while (true) {
            try {
                System.out.println("\nВведите имя меченосца: ");
                String name = CheckValue.readNonEmptyString();
                if (!isUniqueFishName(fishList, name)) {
                    throw new AquariumException("Рыбка с таким именем уже существует в аквариуме.");
                }
                swordtail.setName(name);

                System.out.println("Введите продолжительность жизни меченосца (до 5 лет): ");
                int lengthOfLife = CheckValue.readIntegerInRange(1, 5);
                swordtail.setLengthOfLife(lengthOfLife);

                System.out.println("Введите размер меченосца (до 15 см): ");
                int size = CheckValue.readIntegerInRange(1, 15);
                swordtail.setSize(size);

                String tailShape = CheckValue.readVariety("Введите форму хвоста меченосца:", CheckValue.getSwordtailTailShapes());
                swordtail.setTailShape(tailShape);

                return swordtail;
            } catch (AquariumException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Goldfish addGoldfish(ArrayList<Fish> fishList) {
        Goldfish goldfish = new Goldfish("", 0, 0, "");

        while (true) {
            try {
                System.out.println("\nВведите имя золотой рыбки: ");
                String name = CheckValue.readNonEmptyString();
                if (!isUniqueFishName(fishList, name)) {
                    throw new AquariumException("Рыбка с таким именем уже существует в аквариуме.");
                }
                goldfish.setName(name);

                System.out.println("Введите продолжительность жизни золотой рыбки (до 30 лет): ");
                int lengthOfLife = CheckValue.readIntegerInRange(1, 30);
                goldfish.setLengthOfLife(lengthOfLife);

                System.out.println("Введите размер золотой рыбки (до 30 см): ");
                int size = CheckValue.readIntegerInRange(1, 30);
                goldfish.setSize(size);

                String color = CheckValue.readVariety("Выберите цвет золотой рыбки:", CheckValue.getGoldfishColors());
                goldfish.setColor(color);

                return goldfish;
            } catch (AquariumException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static Gourami addGourami(ArrayList<Fish> fishList) {
        Gourami gourami = new Gourami("", 0, 0, "");

        while (true) {
            try {
                System.out.println("\nВведите имя гурами: ");
                String name = CheckValue.readNonEmptyString();
                if (!isUniqueFishName(fishList, name)) {
                    throw new AquariumException("Рыбка с таким именем уже существует в аквариуме.");
                }
                gourami.setName(name);

                System.out.println("Введите продолжительность жизни гурами (до 6 лет): ");
                int lengthOfLife = CheckValue.readIntegerInRange(1, 6);
                gourami.setLengthOfLife(lengthOfLife);

                System.out.println("Введите размер гурами (до 12 см): ");
                int size = CheckValue.readIntegerInRange(1, 12);
                gourami.setSize(size);

                String species = CheckValue.readVariety("Введите вид гурами:", CheckValue.getGouramiTypes());
                gourami.setSpecies(species);

                return gourami;
            } catch (AquariumException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
