package Homework01;
import java.util.Scanner;

// * Вычислить n-ое треугольного число(сумма чисел от 1 до n), а так же n! (произведение чисел от 1 до n)

// сниппеты
// class - public class "script_name"
// main - public static void main
// sout - System.out.println();

public class Task_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите n-e треугольное число: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.println(triangularNumber(number));

        System.out.print("Введите натуральное число для вычисления факториала: ");
        int number2 = Integer.parseInt(sc.nextLine());
        System.out.println(factorial(number2));

        sc.close();
    }

    public static int triangularNumber(int number) {
        return number * (number + 1) / 2;
    }

    public static int factorial(int number) {
        int result = 1;

        for (int i = 2; i <= number; i++) result *= i;

        return result;
    }
}
