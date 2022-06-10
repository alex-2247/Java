//  * Задана натуральная степень k. Сформировать случайным образом список
//  * коэффициентов (значения от 0 до 100) многочлена многочлен степени k.
//  * Пример: k=2   =>   2*x² + 4*x + 5 = 0  или  x² + 5 = 0  или  10*x² = 0

//package java_projects;
import java.util.Random;
import java.io.*;


public class lec1_dz1 {
    public static void main(String[] args) {
        Integer power = 4;      // степень будущего многочлена
        String first = CreatePoli(power);
        String second = CreatePoli(power);
        PutInFile(first, "first.txt");
        PutInFile(second, "second.txt");
        System.out.println("first: " + first);
        System.out.println("second: " + second);
    }


    static String CreatePoli(int MaxPow) {
        Random number = new Random();
        String monomial = null;
        String polinom = "";
        int koefficient = 0;
        for (int currPow = MaxPow; currPow > -1; currPow--) {
            koefficient = number.nextInt(101);
            if (koefficient != 0) {
                monomial = CreateMono(currPow, koefficient);
                if (polinom != "")
                    polinom = polinom + " + ";
                polinom = polinom + monomial;   }
        }
        return polinom;
    }


    static String CreateMono(int curPow, int koeff) {
        String mono = null;
        switch (curPow) {
            case 0:     // коэффициент "c"
                mono = String.format("%d", koeff);
                break;
            case 1:     // коэффициент "b"
                if (koeff == 1) mono = "x";
                else mono = String.format("%d*x", koeff);
                break;
            default:    // все остальные старшие степени >1
                if (koeff == 1) mono = String.format("x^%d", curPow);
                else  mono = String.format("%d*x^%d", koeff, curPow);
                break;
        }
        return mono;
    }


    static void PutInFile(String task1, String fileName) {
        try (FileWriter fw = new FileWriter(fileName, false)) {
            fw.write(task1);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
