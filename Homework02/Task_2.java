package Homework02;

import java.nio.file.Paths;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.File;

// * Дана строка (получение через обычный текстовый файл!!!)
// "фамилия":"Иванов","оценка":"5","предмет":"Математика"
// * Написать метод(ы), который распарсит строку и, используя StringBuilder, создаст строки вида:
// Студент Иванов получил 5 по предмету Математика.

public class Task_2 {
    public static void main(String[] args) {
        clearConsole();

        String currentPath = Paths.get("")
                .toAbsolutePath()
                .toString();

        File textFile = new File(currentPath + "\\grades.txt");

        String formattedData = getFormattedData(parseFile(textFile));
        System.out.print(formattedData);
    }

    // Получение форматированных данных из массива массивов строк
    public static String getFormattedData(String[][] data) {
        String[] infoText = new String[] {
                "Студент ",
                " получил ",
                " по предмету ",
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                sb.append(infoText[j]).append(data[i][j]);
            }
            sb.append(".\n");
        }
        return sb.toString();
    }

    // Парсинг файла в массив массивов строк
    public static String[][] parseFile(File file) {
        int linesCount = countLines(file);
        int currentIndex = 0;

        String[][] parsedData = new String[linesCount][3];

        try {
            FileReader fReader = new FileReader(file);
            BufferedReader bufRead = new BufferedReader(fReader);

            String line = null;

            for (int i = 0; i < linesCount; i++) {
                line = bufRead.readLine();

                for (String value : line.split(",")) {
                    parsedData[i][currentIndex] = value.split(":")[1]
                            .replace("\"", "");
                    currentIndex++;
                }
                currentIndex = 0;
            }

            bufRead.close();
        } catch (Exception e) {
            System.out.println("Error");
        }

        return parsedData;
    }

    // Получение количества строк из файла
    public static int countLines(File file) {
        int count = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            while (reader.readLine() != null)
                count++;
            reader.close();
        } catch (Exception e) {
            System.out.println("Ошибка какая то!");
        }

        return count;
    }

    // чистим консоль, раудем глаз :)
    public static void clearConsole() {
        System.out.print("\033[H\033[J");
    }
}
