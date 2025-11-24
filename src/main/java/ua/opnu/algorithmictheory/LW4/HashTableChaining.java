package ua.opnu.algorithmictheory.LW4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableChaining {

    // Константа розміру таблиці
    static final int M = 13;

    // Словник позицій
    static final Map<Character, Integer> LETTER_POSITIONS = new HashMap<>();

    // Статичний блок для ініціалізації словника
    static {
        String alphabet = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
        for (int i = 0; i < alphabet.length(); i++) {
            LETTER_POSITIONS.put(alphabet.charAt(i), i + 1);
        }
    }

    /**
     * Хеш-функція: h(k) = (сума позицій букв) mod 13
     */
    public static int simpleHashFromMap(String key) {
        int sumOfPositions = 0;
        String lowerKey = key.toLowerCase(); // Працюємо з маленькими літерами

        for (char c : lowerKey.toCharArray()) {
            // Отримання позиції. getOrDefault повертає 0, якщо символ не знайдено
            int position = LETTER_POSITIONS.getOrDefault(c, 0);
            sumOfPositions += position;
        }

        // Обчислення фінальної хеш-адреси
        return sumOfPositions % M;
    }

    /**
     * Будує хеш-таблицю з ланцюжками.
     */
    public static List<List<String>> buildOpenHashTable(String[] words, int m) {
        // 1. Ініціалізація таблиці: створюємо список, що містить m списків
        List<List<String>> hashTable = new ArrayList<>(m);
        for (int i = 0; i < m; i++) {
            hashTable.add(new ArrayList<>()); // Додаємо порожній список у кожну комірку
        }

        // 2. Обробка кожного слова
        for (String word : words) {
            int address = simpleHashFromMap(word);
            // Додавання слова до відповідного ланцюжка
            hashTable.get(address).add(word);
        }

        return hashTable;
    }

    /**
     * Виводить хеш-таблицю.
     */
    public static void displayHashTable(List<List<String>> table) {
        System.out.println("\n--- Результат хешування (Таблиця M=13) ---");
        for (int i = 0; i < table.size(); i++) {
            List<String> chain = table.get(i);
            // Форматування виводу як у прикладі
            System.out.printf("Індекс %02d: %s\n", i, chain.toString());
        }
    }

    public static void main(String[] args) {
        // Список вхідних слів
        String[] words = {
                "Чужу", "біду", "руками", "розведу", "а",
                "до", "своєї", "розуму", "не", "дійду"
        };

        // Виконання:
        List<List<String>> resultTable = buildOpenHashTable(words, M);
        displayHashTable(resultTable);
    }
}
