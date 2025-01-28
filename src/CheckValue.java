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
}
