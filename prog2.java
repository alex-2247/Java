// Скопировано с репо Тины
// Повторить, внимательно вникнув, и желательно модернизировать
// Этот код просто выводит в консоль содержимое двух уравнений
// Изначальная задача не решена, это задача для меня
//package java_projects;  // подсвечивается красным, но не оказывает влияния
import java.io.*;

/**
 * Даны два файла, в каждом из которых находится запись многочлена. 
 * Сформировать файл содержащий сумму многочленов.
 */
public class prog2 {
    public static void main(String[] args) throws Exception {
        String fileFirst = PutOutFile("first.txt");
        String fileSecond = PutOutFile("second.txt");
    }

    static String PutOutFile(String fileName) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String text = br.readLine();
        System.out.printf("%s\n", text);
        return text;
    }   
}