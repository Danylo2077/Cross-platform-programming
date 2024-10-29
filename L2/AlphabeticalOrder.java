import java.util.Arrays;
import java.util.Scanner;

public class AlphabeticalOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Введення рядка
        System.out.print("Введіть рядок: ");
        String input = scanner.nextLine();

        // Перевірка, чи містить рядок лише літери
        boolean onlyLetters = input.chars().allMatch(Character::isLetter);

        if (!onlyLetters) {
            System.out.println("Помилка: рядок повинен містити лише літери.");
        } else {
            // Перетворення рядка у масив символів
            char[] chars = input.toCharArray();

            // Сортування символів
            Arrays.sort(chars);

            // Перетворення масиву символів назад у рядок
            String sortedString = new String(chars);

            // Виведення результату
            System.out.println("Рядок в алфавітному порядку: " + sortedString);
        }
    }
}
