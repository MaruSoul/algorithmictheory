package ua.opnu.algorithmictheory.LW4;

import java.util.HashMap;
import java.util.Map;

public class HashTableOpenAddressing {

    // Константа розміру таблиці
    static final int M = 13;

    // Словник позицій (Український алфавіт)
    static final Map<Character, Integer> LETTER_POSITIONS = new HashMap<>();

    // Статична ініціалізація мапи
    static {
        String alphabet = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
        for (int i = 0; i < alphabet.length(); i++) {
            LETTER_POSITIONS.put(alphabet.charAt(i), i + 1);
        }
    }

    /**
     * Первинна хеш-функція:
     * h(k) = (сума позицій букв key) mod M
     */
    public static int primaryHash(String key) {
        int total = 0;
        String upperKey = key.toUpperCase(); // Приводимо до верхнього регістру для пошуку в мапі

        for (char c : upperKey.toCharArray()) {
            // Отримуємо значення, якщо буква є в алфавіті, інакше 0
            total += LETTER_POSITIONS.getOrDefault(c, 0);
        }
        return total % M;
    }

    /**
     * Побудова хеш-таблиці з відкритою адресацією (лінійне зондування).
     */
    public static String[] buildClosedHashTable(String[] words, int m) {
        String[] table = new String[m];

        for (String word : words) {
            int start = primaryHash(word);
            boolean inserted = false;

            // Лінійне пробування: шукаємо вільне місце
            for (int i = 0; i < m; i++) {
                int address = (start + i) % m; // Циклічний зсув

                if (table[address] == null) {
                    table[address] = word;
                    inserted = true;
                    break; // Вставка успішна, переходимо до наступного слова
                }
                // Якщо table[address] != null, це колізія -> йдемо на наступну ітерацію (i++)
            }

            if (!inserted) {
                System.out.printf("Помилка: таблиця повна, не можна додати '%s'\n", word);
            }
        }
        return table;
    }

    /**
     * Вивести таблицю
     */
    public static void displayHashTable(String[] table) {
        System.out.println("\n--- Хеш-таблиця (Відкрита адресація, M=13) ---");
        System.out.println("Індекс | Слово");
        System.out.println("-------|--------");

        for (int i = 0; i < table.length; i++) {
            String value = (table[i] != null) ? table[i] : "(NULL)";
            System.out.printf("%02d     | %s\n", i, value);
        }
    }

    public static void main(String[] args) {
        String[] words = {
                "Чужу", "біду", "руками", "розведу", "а",
                "до", "своєї", "розуму", "не", "дійду"
        };

        // Виконання
        String[] hashTable = buildClosedHashTable(words, M);
        displayHashTable(hashTable);
    }
}
