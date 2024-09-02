import java.security.SecureRandom;


public class PasswordGenerator {
    private static final char[] UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private static final char[] LOWERCASE = "abcdefghijklmnopqrstuvwxyz".toCharArray();

    private static final char[] DIGITS = "0123456789".toCharArray();

    private static final char[] SPECIAL_CHARACTERS = "!@#$%^&*()+=-?<>".toCharArray();

    public static void main(String[] args) {
        String password = generatePassword(24, true, true, true, false);
        System.out.println(password);
    }


    /**
     * Метод генерирует пароль заданной длины с использованием выбранных параметров
     *
     * @param length Длина пароля
     * @param uppercase Использование символов верхнего регистра в генерируемом пароле
     * @param lowercase Использование символов нижнего регистра в генерируемом пароле
     * @param digits Использование цифр в генерируемом пароле
     * @param specialCharacters Использование специальных символов в генерируемом пароле
     * @return Возвращает сгенерированный пароль в фармате строки (String)
     * @throws IllegalArgumentException метод может выбросить исключение, если
     * не выбран ни один набор символов, или длина пароля меньше 1
     */
    public static String generatePassword(int length, boolean uppercase, boolean lowercase, boolean digits, boolean specialCharacters) {

        if (length < 1) {
            throw new IllegalArgumentException("Длина пароля должна быть больше 1 символа");
        }

        SecureRandom random = new SecureRandom();
        StringBuilder password = new StringBuilder();
        StringBuilder charPool = new StringBuilder();

        // Добавление выбранных наборов символов в пул
        if (uppercase) {
            charPool.append(UPPERCASE);
        }
        if (lowercase) {
            charPool.append(LOWERCASE);
        }
        if (digits) {
            charPool.append(DIGITS);
        }
        if (specialCharacters) {
            charPool.append(SPECIAL_CHARACTERS);
        }

        // Преобразование StringBuilder в массив символов
        char[] chars = charPool.toString().toCharArray();

        if (chars.length == 0) {
            throw new IllegalArgumentException("Необходимо выбрать хотя бы один набор символов.");
        }

        // Генерация пароля
        for (int i = 0; i < length; i++) {
            password.append(chars[random.nextInt(chars.length)]);
        }

        return password.toString();
    }
}
