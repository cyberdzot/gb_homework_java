package Homework05;

import java.util.*;

public class Task_2 {
    public static void main(String[] args) {
        clearConsole();

        LinkedList<String> list = new LinkedList<>(
                Arrays.asList("Иван Иванов", "Светлана Петрова", "Кристина Белова", "Анна Мусина",
                        "Анна Крутова", "Иван Юрин", "Петр Лыков", "Павел Чернов", "Петр Чернышов",
                        "Мария Федорова", "Марина Светлова", "Мария Савина", "Мария Рыкова", "Марина Лугова",
                        "Анна Владимирова", "Иван Мечников", "Петр Петин", "Иван Ежов"));

        Map<String, Integer> count_name = new HashMap<>();

        nameProcessing(list, count_name);

        System.out.println("Количество: " + count_name);
        System.out.println("Популярность: " + sortHashMap(count_name));
    }


    private static void nameProcessing(LinkedList<String> list, Map<String, Integer> map) {
        for (String o : list) {
            String name = o.split(" ")[0];

            if (!map.containsKey(name))
                // если не обнаружим такое имя
                map.put(name, 1);
            else
                // если такое имя уже используется
                map.put(name, map.get(name) + 1);
        }
    }

    private static Map<String, Integer> sortHashMap(Map<String, Integer> map) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        int max = 1;

        for (int value : map.values())
            if (value > max)
                max = value;

        for (int i = max; i > 0; i--) {
            for (var el : map.entrySet())
                if (map.get(el.getKey()) == i)
                    sortedMap.put(el.getKey(), el.getValue());
        }

        return sortedMap;
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
        System.out.println();
    }
}
