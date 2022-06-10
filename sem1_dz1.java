/* Реализовать функцию возведения числа а в степень b. a, b ∈ Z. 
Сводя количество выполняемых действий к минимуму. 
Пример 1: а=3, b=2,  ответ: 9 
Пример 2: а=2, b=-2, ответ: 0.25
Пример 3: а=3, b=0, ответ: 1
Пример 4: а=0, b=0, ответ: не определено
MyAppend: if second argument = 1, result = first argument
Входные данные находятся в файле input.txt в виде:  b 3\n   a 10
Результат нужно сохранить в файле output.txt, 1000          */

// Это ДЗ - задача №1 из "Джавовского списка" от Сергея Камянецкого
// Поскольку указано о сведении выполняемых действий к минимуму, это наводит 
// на мысль о решении впрямую, не используя библиотеку Math.Pow, ибо её 
// использование сводит значимый код вообще к одной строке. Правда, как 
// "свести число действий к минимуму", непонятно, поскольку все равно надо 
// умножать в цикле. Разве что, разбивать БОЛЬШИЕ степени на отдельные 
// множители-подстепени. Но этот способ пока затрагивать не буду.
// Еще из анализа условий: принимаю, что оба аргумента - целые

// import java.io.*;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;

public class sem1_dz1 {
    public static void main(String[] args) throws Exception {
        Integer basis = null;   // основание степени
        Integer pow = null;     // показатель степени
        String strResult = null;    // результат для выгрузки в файл
        String basis_string = null; // строка основания из файла-источника
        String pow_string = null;   // строка показателя из файла-источника
        String[] arrInput = new String[3];  // прочитанный массив из источника
        String inputFile = "input.txt";
        String outputFile = "output.txt";
        arrInput = fileReading(inputFile);  // чтение из файла в массив
        
        // Надо из сырого массива раскидать по целевым строковым переменным
        for (int i = 0; i < arrInput.length-1; i++) {
            System.out.printf("==>   %s   <==\n", arrInput[i]);
            if (arrInput[i]==null) continue;
            if (arrInput[i].indexOf("a") != -1) 
                basis_string = arrInput[i];
            if (arrInput[i].indexOf("b") != -1) 
                pow_string = arrInput[i];
        }

        basis = take_num(basis_string);
        pow = take_num(pow_string);
        strResult = calk_pow(basis, pow);
        System.out.printf("Результат =   %s , выгружаем его в файл output.txt", strResult);
        PutInFile(strResult, outputFile);
    }


    static String calk_pow(int argBasis, int argPow) {
        // возвращаем в строковом формате, для выгрузки в .txt
        double fl_basis = 0;
        double result;
        if (argBasis==0 && argPow==0) return "Значение результата не определено";
        if (argPow==0) return "1";
        if (argPow<0) fl_basis = 1.0/argBasis;    // надо вещественное число
        if (argBasis>0 && argPow>0) fl_basis = argBasis;
        result = calc_loop(fl_basis, argPow);
        // В зависимости от, целый ли результат, форматнём по-разному
        if (result%1>0) return String.format("%.2f", result);
        else return String.format("%.0f", result);
    }


    static double calc_loop(double arg_basis, int arg_pow) {
        // в цикле возводим основание в степень
        // аргументы предварительно подготовлены, из разных ситуаций
        double retval = 1;
        if (arg_pow<0) arg_pow *= -1;
        for (int i=0; i<arg_pow; i++) retval *= arg_basis;
        return retval;
    }


    static Integer take_num(String arg) { // возвр. int из входящей строки
        // Найдем числовые значения наших исходных данных
        String[] split_arr = arg.split(" ");
        return Integer.decode(split_arr[1]);
    }


    static String[] fileReading(String argFile) throws Exception {
        // +1 элемент, в нём NULL, без него будет ошибка переполнения индекса
        String[] arrResult = new String[3];
        BufferedReader br = new BufferedReader(new FileReader(argFile));
        int tmpIndex = 0;
        while ((arrResult[tmpIndex] = br.readLine()) != null) tmpIndex++;
        br.close();
        return arrResult;
    }


    static void PutInFile(String task1, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(task1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
