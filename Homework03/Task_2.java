package Homework03;

import java.util.*;

// * Задан целочисленный список ArrayList.
// * Найти минимальное, максимальное и среднее ариф. из этого списка

public class Task_2 {
    public static void main(String[] args) {
        clearConsole();

        ArrayList<Integer> myList = new ArrayList<>();

        createRandomListInt(myList, 10, 10);

        showList(myList);
        System.out.println("Минимальное значение: " + getValueMin(myList));
        System.out.println("Максимальное значение: " + getValueMax(myList));
        System.out.println("Среднее арифметическое: " + getValueAvg(myList));
    }

    // узнаем среднее арифметическое
    private static double getValueAvg(ArrayList<Integer> list) {
        double avg = 0;

        for (Integer value: list)
            avg += value.doubleValue();

        return avg / list.size();
    }

    // узнаем максимальное значение
    private static int getValueMax(ArrayList<Integer> list) {
        int max = list.get(0);

        for (int i = 1; i < list.size(); i++)
            if (list.get(i) > max)
                max = list.get(i);

        return max;
    }

    // узнаем минимальное значение
    private static int getValueMin(ArrayList<Integer> list) {
        int min = list.get(0);

        for (int i = 1; i < list.size(); i++)
            if (list.get(i) < min)
                min = list.get(i);

        return min;
    }

    // просмотр выбранного списка
    private static void showList(ArrayList<Integer> list) {
        for (Integer value : list)
            System.out.print(value + " ");

        System.out.println("");
    }

    // создаём произвольный список целых чисел
    private static void createRandomListInt(ArrayList<Integer> list, int count, int maxValue) {
        Random rand = new Random();
        for (int i = 0; i < count; i++)
            list.add(rand.nextInt(maxValue));
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
