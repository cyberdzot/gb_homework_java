package Homework04;

import java.util.LinkedList;
import java.util.Stack;

// * Пусть дан LinkedList с несколькими элементами.
// * Реализуйте метод(не void), который вернет “перевернутый” список.

public class Task_1 {
    public static void main(String[] args) {
        clearConsole();

        // поработаем со строками раз не было конкретики здесь =)
        LinkedList<String> my_ll = new LinkedList<>();

        my_ll.add("a1");
        my_ll.add("b2");
        my_ll.add("c3");
        my_ll.add("d4");
        showList(my_ll);

        LinkedList<String> new_ll = flipList(my_ll);
        showList(new_ll);
    }

    // переворачиваем список из строк
    private static LinkedList<String> flipList(LinkedList<String> my_ll) {
        LinkedList<String> new_ll = new LinkedList<>();
        Stack<String> my_stack = new Stack<>();

        my_stack.addAll(my_ll);

        while (!my_stack.empty())
            new_ll.add(my_stack.pop());

        return new_ll;
    }

    // просмотр выбранного списка из строк
    private static void showList(LinkedList<String> list) {
        for (String value : list)
            System.out.print(value + " ");

        System.out.println("");
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
