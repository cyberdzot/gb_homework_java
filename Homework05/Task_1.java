package Homework05;

import java.util.*;

// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции:
// 1) Добавление номера
// 2) Вывод всего

// Сделал без заморочек с ФИО, просто по имени с сутью на 1 человека несколько номеров =)

public class Task_1 {
    private static Map<String, LinkedList<Integer>> book = new HashMap<>();
    private static String message = "";
    private static Scanner sc;

    public static void main(String[] args) {
        engineUI();
    }

    private static void engineUI() {
        sc = new Scanner(System.in, "cp866");
        while (true) {
            clearConsole();
            updateUI();
            String args = sc.nextLine();
            String[] text = args.split(" ");
            switch (text[0]) {
                case "1":
                    if (text.length < 3) {
                        message = "(Ошибка) Некорректный ввод аргументов! '1 имя_контакта номер_контакта'";
                        break;
                    }
                    addPhoneNumber(book, text[1], Integer.parseInt(text[2]));
                    message = "Контакт успешно заполнен!";
                    break;
                case "2":
                    clearConsole();
                    showPhoneBook(book);
                    return;
                case "3":
                    clearConsole();
                    System.out.println("Телефонная книга закрыта!");
                    return;
                default: message = "(Ошибка) Выбранное действие отсутствует! Диапазон действий: 1-3";
            }
        }
    }

    // графическая оболочка
    private static void updateUI() {
        System.out.println();
        System.out.println("Введите цифру действия(и аргументы, если требуются):");
        System.out.println();
        System.out.println("[1] Добавить номер, пример:");
        System.out.println("    1 имя_контакта номер_контакта");
        System.out.println("[2] Показать все контакты");
        System.out.println("[3] Завершить работу программы");
        System.out.println(message);
    }

    // добавление контакта или номера телефона к существующему контакту
    private static void addPhoneNumber(Map<String, LinkedList<Integer>> book, String name, Integer number) {
        // если такой контакт есть, то возьмём список с него
        // дополним его и запихнём в этот же ключ
        if (book.get(name) != null) {
            book.get(name).add(number);
        } else {
            LinkedList<Integer> phone_numbers = new LinkedList<>();
            phone_numbers.add(number);
            book.put(name, phone_numbers);
        }
    }

    // просмотр всей книги
    private static void showPhoneBook(Map<String, LinkedList<Integer>> book) {
        for (var item : book.entrySet())
            System.out.println(item.getKey() + " " + item.getValue());
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
