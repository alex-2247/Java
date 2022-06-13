/* Написать программу вычисления n-ого треугольного числа 
https://ru.wikipedia.org/wiki/Треугольное_число . Найти в патриотичном 
Яндексе, изучить тему, найти там формулу, и написать вокруг этой формулы 
программу. Ввиду того, что на входе у нас только "сторона треугольника", 
а на выходе - одно искомое число, не вижу смысла запариваться с входными и 
выходными файлами. Сделаю через консоль. Ввиду простоты задачи, методов 
здесь минимум. Всё можно было реализовать в одном, но саму формулу всё-же 
вынесу в отдельный метод, а также сделаю отдельные методы для ввода/вывода.
Дополнительные соображения: Можно читать дальше о свойствах этих чисел,
например о соотношениях с полным квадратом, и встраивать дополнительные
проверки по этому поводу. И, более важно, попробовать БОЛЬШИЕ степени. 
Попробовать решение рекурсией, и оценить время исполнения обоими способами. 
Реализовывать проверки введенного числа. ...но пока делаю в упрощённом виде.
*/

import java.util.Scanner;

public class sem2_dz1 {
    public static void main(String[] args) {
        int triangle_side = 0; // сторона треугольника
        int triangle_num = 0; // искомое треугольное число
        triangle_side = cons_input("Введите сторону треугольника: ");
        triangle_num = triangle_calc(triangle_side);
        cons_output(triangle_side, triangle_num);
    }


    static int triangle_calc(int arg) {     // расчёт по общей формуле
        int result = arg*(arg+1)/2;
        return result;
    }


    static int cons_input(String arg_mess) {    // Запрос исходного с консоли
        Scanner iScanner = new Scanner(System.in);
        System.out.printf(arg_mess);
        String input_str = iScanner.nextLine();
        iScanner.close();
        return Integer.parseInt(input_str);
    }


    static void cons_output(int side, int arg) {  // Вывод результата в консоль
        System.out.printf(
            "При основании %d,  треугольное число  = %d", side, arg);
    }
}
