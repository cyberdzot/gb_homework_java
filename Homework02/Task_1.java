package Homework02;

import java.util.Arrays;
import java.io.IOException;
import java.util.logging.*;

// * Реализуйте алгоритм сортировки пузырьком числового массива (введён вами),
// * результат после каждой итерации запишите в лог-файл.
// пробежка по каждому значению массива
// for (int value : array) System.out.println(value);

public class Task_1 {
    public static void main(String[] args) throws IOException {
        clearConsole();

        int[] my_array = new int[] { 11, 3, 14, 16, 7 };

        Logger logger = addMyLogger();

        bubbleSort(my_array, logger);
    }

    // чистим консоль, раудем глаз :)
    public static void clearConsole() {
        System.out.print("\033[H\033[J");
    }

    // умная сортировка пузырьком с логированием
    public static void bubbleSort(int[] array, Logger logger) throws IOException {
        boolean isSorted = false;
        int temp;

        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    isSorted = false;
                }
            }
            logger.info(Arrays.toString(array));
        }
    }
    
    // добавление логирования
    public static Logger addMyLogger() throws IOException {
        Logger logger = Logger.getLogger(Task_1.class.getName());
        FileHandler fh = new FileHandler("log.txt");
        logger.addHandler(fh);
        
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        return logger;
    }
}
