package Homework04;

import java.util.LinkedList;
import java.util.Scanner;

// * Реализуйте очередь с помощью LinkedList со следующими методами:
// enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его,
// first() - возвращает первый элемент из очереди, не удаляя.

public class Task_2 {
    public static void main(String[] args) {
        engineUI();
    }

    private static Scanner sc;
    private static String my_value = "";


    // запуск программы
    private static void engineUI() {
        sc = new Scanner(System.in);
        LinkedList<String> list = new LinkedList<>();
        while (true) {
            clearConsole();
            updateUI(list);
            my_value = sc.nextLine();
            String[] text = my_value.split(" ");
            switch (text[0]) {
                case "enqueue": {
                    if (text.length < 2) {
                        my_value = "(Ошибка) После команды не был введён аргумент!";
                        break;
                    }
                    list.add(text[1]);
                    my_value = "Произошло добавление в конец очереди!";
                    break;
                }
                case "dequeue": {
                    if (list.size() == 0) {
                        my_value = "(Ошибка) Список пустой!";
                        break;
                    }
                    my_value = "Показываю первый элемент [" + list.pop() + "] и удаляю его!";
                    break;
                }
                case "first": {
                    if (list.size() == 0) {
                        my_value = "(Ошибка) Список пустой!";
                        break;
                    }
                    my_value = "Показываю первый элемент [" + list.get(0) + "].";
                    break;
                }
                case "exit", "quit": {
                    my_value = "Программа завершила работу!";
                    clearConsole();
                    updateUI(list);
                    return;
                }
                default:
                    my_value = "(Ошибка) Введена неизвестная команда!";
            }
        }
    }

    // графическая оболочка
    private static void updateUI(LinkedList<String> list) {
        System.out.println("----------------------------------");
        System.out.println(" Работа с Linked List. Demo ver.");
        System.out.println("----------------------------------");
        System.out.println("Введите команду(и аргументы, если требуются) для выбранной операции:");
        System.out.println("");
        System.out.println("[1] Поместить выбранный элемент в конец очереди");
        System.out.println("    enqueue выбранный_элемент");
        System.out.println("[2] Показать первый элемент из очереди и удалить его");
        System.out.println("    dequeue");
        System.out.println("[3] Показать первый элемент из очереди");
        System.out.println("    first");
        System.out.println("[4] Завершить работу программы");
        System.out.println("    exit или quit");

        System.out.print("Текущий список: [ ");
        for (String value : list)
            System.out.print(value + " ");
        System.out.println("]");

        System.out.println("Результат: " + my_value);
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
