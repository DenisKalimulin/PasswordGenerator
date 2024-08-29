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
     * В методе создаются два объекта StringBuilder. Первый для добавления выбранных символов в пул, после чего
     * преобразовываются в массив символов. Второй
     * для генерации пароля. Так же создается объект SecureRandom для выбора случайных значений.
     * Следом идет проверка на то, что выбран хотя бы один набор символов. После чего генерируется пароль
     * и метод его возвращает.
     *
     * @param length Длина пароля
     * @param uppercase Использование символов верхнего регистра в генерируемом пароле
     * @param lowercase Использование символов нижнего регистра в генерируемом пароле
     * @param digits Использование цифр в генерируемом пароле
     * @param specialCharacters Использование специальных символов в генерируемом пароле
     * @return Возвращает сгенерированный пароль в фармате строки (String)
     * @throws IllegalArgumentException метод может выбросить исключение, если
     * не выбран ни один набор символов
     */
    public static String generatePassword(int length, boolean uppercase, boolean lowercase, boolean digits, boolean specialCharacters) {
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
