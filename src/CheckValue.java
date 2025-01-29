import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CheckValue {
    static Scanner sca = new Scanner(System.in);
    protected static String readNonEmptyString() {
        while (true) {
            try {
                String value = sca.nextLine();
                if (value.isEmpty()) {
                    throw new IllegalArgumentException();
                }
                return value;
            } catch (IllegalArgumentException e){
                System.out.println("Значение не может быть пустым. Пожалуйста, введите значение: ");
            }
        }
    }

    protected static int readIntegerInRange(int min, int max) {
        int value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                String input = sca.nextLine(); // Считываем ввод как строку

                // Проверяем, является ли ввод числом
                if (isInteger(input)) {
                    value = Integer.parseInt(input); // Преобразуем строку в число
                    if (value >= min && value <= max) {
                        validInput = true; // Ввод корректен
                    } else {
                        throw new AquariumException("Некорректное значение! Пожалуйста, введите значение от " + min + " до " + max + ": ");
                    }
                } else if (input.isEmpty()) {
                    throw new IllegalArgumentException("Значение не может быть пустым. Пожалуйста, введите значение: ");
                } else {
                    throw new AquariumException("Некорректное значение! Пожалуйста, введите значение от " + min + " до " + max + ": ");
                }
            } catch (IllegalArgumentException | AquariumException e){
                System.out.println(e.getMessage());
            }
        }
        return value;
    }

    private static boolean isInteger(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false; // Если встретили нецифровой символ, возвращаем false
            }
        }
        return true; // Если все символы цифры, возвращаем true
    }

    public static String isValidFileName(String message) {
        String fileName = "";
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(message);
                fileName = sca.nextLine();

                if (fileName.isEmpty()) {
                    throw new IllegalArgumentException("Имя файла не может быть пустым. Пожалуйста, введите имя файла: ");
                } else if (fileName.endsWith(".bin")) {
                    validInput = true; // Имя файла валидно
                } else {
                    throw new IllegalArgumentException("Имя файла должно заканчиваться на .bin. Пожалуйста, попробуйте снова.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return fileName;
    }

    protected static String getAge(int age) {
        if (age % 10 == 1 && age % 100 != 11) {
            return age + " год";
        } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
            return age + " года";
        } else {
            return age + " лет";
        }
    }

    public static String normalizeString(String input) {
        if (input == null) {
            return null;
        }
        // Заменяем все "е" на "ё" и приводим результат к строчным буквам
        return input.replaceAll("е", "ё").toLowerCase();
    }

    public static String capitalizeFirstLetter(String input) {
        if (input == null || input.isEmpty()) {
            return input; // Возврат входных данных без изменений, если они пустые
        }
        return Character.toUpperCase(input.charAt(0)) + input.substring(1).toLowerCase();
    }

    protected static String readVariety(String message, List<String> validVarieties) {
        String variety;
        while (true) {
            System.out.println(message + " " + String.join(", ", validVarieties) + ".");
            variety = sca.nextLine().trim().toLowerCase();
            variety = normalizeString(variety);
            if (validVarieties.contains(variety)) {
                return variety;
            } else {
                System.out.println("Недопустимый ввод. Пожалуйста, выберите из предложенных значений\n");
            }
        }
    }

    public static List<String> getGuppyColors() {
        return Arrays.asList("оранжевый", "синий", "зелёный", "жёлтый", "красный", "пурпурный", "чёрный", "голубой");
    }

    public static List<String> getGoldfishColors() {
        return Arrays.asList("золотой", "белый", "чёрный", "оранжевый", "красный", "калико");
    }

    public static List<String> getGouramiTypes() {
        return Arrays.asList("карликовый", "трёхпятнистый", "целующий", "гнездующий", "мраморный");
    }

    public static List<String> getSwordtailTailShapes() {
        return Arrays.asList("заострённый", "округлый", "лирикальный", "раздвоенный", "мечевидный");
    }

    public static List<String> getNeonBrightnessLevels() {
        return Arrays.asList("высокий", "средний", "низкий");
    }
}
