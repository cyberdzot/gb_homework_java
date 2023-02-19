package Homework02;

public class Task_3 {
    public static void main(String[] args) {
        clearConsole();

        String my_str[] =  new String[]{"шалаш", "summus", "шалащ"};

        for (String value : my_str)
            System.out.println(value + " | " + isPalindrom(value));
    }

    // палиндром ли?
    private static boolean isPalindrom(String text) {
        int len = text.length();
        for (int i = 0; i < len / 2; i++)
            if (text.charAt(i) != text.charAt(len - 1 - i))
                return false;

        return true;
    }

    // чистим консоль, радуем глаз :)
    private static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
