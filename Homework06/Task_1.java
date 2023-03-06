package Homework06;

import java.util.*;

// Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
// Создать множество ноутбуков.
// Написать метод, который будет запрашивать у пользователя критерий фильтрации и выведет ноутбуки, отвечающие фильтру.
// Критерии фильтрации можно хранить в Map.(минимум 5)

public class Task_1 {
    public static void main(String[] args) {
        clearConsole();

        ArrayList<Laptop> laptops = createLaptopList();
        HashMap<Integer, String> sortingValues = createSortingMap();
        HashMap<String, ArrayList<String>> allStr = getStringChoices(sortingValues, laptops);
        Scanner sc = new Scanner(System.in);

        int criterion = filterFirst(sortingValues, sc);
        int value = filterSecond(sortingValues, laptops, allStr, sc, criterion);
        filterFinal(criterion, value, allStr, laptops);

        sc.close();
    }

    // метод финального этапа фильтрации и вывод результатов в консоль
    public static void filterFinal(int first, int second,
            HashMap<String, ArrayList<String>> strMap,
            ArrayList<Laptop> al) {

        ArrayList<Laptop> matching = new ArrayList<>();

        if (first == 1) {
            for (Laptop el : al)
                if (el.ramGB >= second)
                    matching.add(el);
        } else if (first == 2) {
            for (Laptop el : al)
                if (el.hddGB >= second)
                    matching.add(el);
        } else if (first == 3) {
            if (strMap.get("Операционная система").size() <= second - 1 || second < 1)
                System.out.println("Такого выбора нет!");
            else
                for (Laptop el : al)
                    if (strMap.get("Операционная система").get(second - 1).equals(el.os))
                        matching.add(el);
        } else if (first == 4) {
            if (strMap.get("Цвет").size() <= second - 1 || second < 1)
                System.out.println("Такого выбора нет!");
            else
                for (Laptop el : al)
                    if (strMap.get("Цвет").get(second - 1).equals(el.color))
                        matching.add(el);
        }

        if (matching.size() < 1)
            System.out.println("Подходящих вариантов - нет!");
        else {
            System.out.println("\n---- Подходящие варианты ----\n");
            for (Laptop el : matching)
                el.getInfo();
            System.out.println("\n---------------------------------\n");
        }
    }

    // проведение второго этапа фильтрации
    public static int filterSecond(HashMap<Integer, String> hm, ArrayList<Laptop> al,
            HashMap<String, ArrayList<String>> strMap, Scanner sc, int firstChoice) {
        int choice = -1;

        if (firstChoice > 0 && firstChoice < 3) {
            System.out.println("Введите минимально подходящее кол-во памяти (" + hm.get(firstChoice) + ").");
            System.out.print("Кол-во памяти (ГБ): ");

            choice = sc.nextInt();
            sc.nextLine();
        }

        else if (firstChoice > 2 && firstChoice < 5) {
            ArrayList<String> strChoices = strMap.get(hm.get(firstChoice));
            System.out.println("Выберите один из подходящих вариантов (" + hm.get(firstChoice) + "):");

            for (int i = 0; i < strChoices.size(); i++)
                System.out.println((i + 1) + ". " + strChoices.get(i));

            System.out.print("\nВаш выбор: ");
            choice = sc.nextInt();
            sc.nextLine();
        }

        else
            System.out.println("Такого выбора нет!");

        return choice;
    }

    // создание словаря с уникальными значениями ОС и цвета
    public static HashMap<String, ArrayList<String>> getStringChoices(HashMap<Integer, String> hm,
            ArrayList<Laptop> al) {
        HashMap<String, ArrayList<String>> strMap = new HashMap<>();

        HashSet<String> oses = new HashSet<>();
        HashSet<String> colors = new HashSet<>();
        ArrayList<String> osList = new ArrayList<>();
        ArrayList<String> colorList = new ArrayList<>();

        for (Laptop el : al) {
            oses.add(el.os);
            colors.add(el.color);
        }

        osList.addAll(oses);
        colorList.addAll(colors);

        strMap.put(hm.get(3), osList);
        strMap.put(hm.get(4), colorList);

        return strMap;
    }

    // проведение первого этапа фильтрации
    public static int filterFirst(HashMap<Integer, String> hm, Scanner sc) {
        System.out.println("Фильтр техники. (ver 0.1)\n");

        for (var el : hm.entrySet())
            System.out.println(el.getKey() + ". " + el.getValue());

        System.out.print("\nВведите цифру, для выбора критерия: ");
        int choice = sc.nextInt();
        sc.nextLine();

        return choice;
    }

    // создание словаря с критериями фильтрации
    public static HashMap<Integer, String> createSortingMap() {
        HashMap<Integer, String> hm = new HashMap<>();

        hm.put(1, "ОЗУ");
        hm.put(2, "Объем ЖД");
        hm.put(3, "Операционная система");
        hm.put(4, "Цвет");

        return hm;
    }

    // создание списка ноутбуков
    public static ArrayList<Laptop> createLaptopList() {
        ArrayList<Laptop> al = new ArrayList<>();
        Laptop testLaptop = new Laptop("HUAWEI MateBook D 15", "Silver", 4, 128, "Windows 10 Home");
        Laptop macbook = new Laptop("MSI Modern 15", "Black", 16, 256, "DOS");
        Laptop irbis = new Laptop("Apple MacBook Air", "Grey", 8, 320, "macOS");
        Laptop hpLaptop = new Laptop("ASUS TUF Gaming", "White", 32, 512, "without OS");
        Laptop acer = new Laptop("MSI Titan GT77", "Gold", 16, 1024, "Windows 11 Pro");

        al.add(acer);
        al.add(hpLaptop);
        al.add(irbis);
        al.add(macbook);
        al.add(testLaptop);

        return al;
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}