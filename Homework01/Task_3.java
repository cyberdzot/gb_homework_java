package Homework01;

import java.util.Scanner;

// * Реализовать простой калькулятор (+ - / *)

public class Task_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Введите выражение через пробел: ");
        String expression = sc.nextLine();
        String[] new_expression = expression.split(" ");

        sc.close();

        System.out.print(new_expression[0] + " " + new_expression[1] + " " + new_expression[2] + " = ");

        int number_1 = Integer.parseInt(new_expression[0]);
        int number_2 = Integer.parseInt(new_expression[2]);

        switch (new_expression[1]) {
            case "+":
                System.out.println(number_1 + number_2);
                break;
            case "-":
                System.out.println(number_1 - number_2);
                break;
            case "*":
                System.out.println(number_1 * number_2);
                break;
            case "/":
                System.out.println(number_1 / number_2);
                break;
            default:
                System.out.println("Знак действия некорректен!");
        }
    }
}
