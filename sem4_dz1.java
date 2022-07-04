// Задача 4. +Написать программу, показывающую последовательность действий 
// для игры “Ханойская башня”
// Реализация: основной алгоритм решения - рекурсивный. На каждом шаге 
// отображается действие "откуда-куда" и визуальное состояние пирамидок.
// Чтобы сделать очередной ход, надо нажать ENTER.
import java.util.Scanner;

public class sem4_dz1 {
    static int n = 4;
    static int[][] rods = new int[3][n];    // массив для визуализации
    static Scanner iScanner = new Scanner(System.in);
    static int iFrom, iTo;
    public static void main(String[] args) {
        if (n<1) n = 3;
        if (n>9) n = 9;
        init_visual();
        System.out.println("стартовое состояние пирамидок:");
        visual(0, ' ', ' ');
        towerOfHanoi(n, 'A', 'C', 'B');
        iScanner.close();
    }


    /** Основной метод, решаюший задачу рекурсивным способом
     * @param n
     * @param from_rod
     * @param to_rod
     * @param buf_rod */
    static void towerOfHanoi(int n, char from_rod, char to_rod, char buf_rod) {
        if (n == 1) {
            System.out.printf("%d FROM %c ==> %c\n", n, from_rod, to_rod);
            visual(n, from_rod, to_rod);
            return;
        }
        towerOfHanoi(n-1, from_rod, buf_rod, to_rod);
        System.out.printf("%d from %c => %c\n", n, from_rod, to_rod);
        visual(n, from_rod, to_rod);
        towerOfHanoi(n-1, buf_rod, to_rod, from_rod);
    }


    /** Метод, визуализирующий шаг решения - штыри и блины на них
     * @param n
     * @param from_rod
     * @param to_rod     */
    static void visual(int n, char from_rod, char to_rod) {
        if (n!=0) {     // если любой шаг, кроме стартового
            // определим индексы строк "откуда" и "куда"
            if (from_rod=='A') iFrom = 0;
            else iFrom = from_rod=='B' ? 1 : 2;
            if (to_rod=='A') iTo = 0;
            else iTo = to_rod=='B' ? 1 : 2;
            // ищем в строке-источнике последний непустой элемент, 
            // копируем его оттуда
            int tmpInd = 0;
            for (int j = 0; j < rods[iFrom].length; j++) {
                if (rods[iFrom][j]==0) break;
                tmpInd = j; }
            // ищем в строке-назначении первый пустой элемент и копируем в него 
            // найденное в строке-источнике, и обнуляем, откуда скопировали
            for (int j = 0; j < rods[iTo].length; j++) {
                if (rods[iTo][j]==0) {
                    rods[iTo][j] = rods[iFrom][tmpInd];
                    rods[iFrom][tmpInd] = 0;
                    break; } }
        }
        // дальше только собственно визуализация
        String strRod;
        for (int i = 0; i < rods.length; i++) {
            if (i==0) strRod = "ШтырьA:  #-";
            else strRod = i==1 ? "ШтырьB:  #-" : "ШтырьC:  #-";
            System.out.print(strRod);
            for (int j = 0; j < rods[i].length; j++) {
                if (rods[i][j]==0) System.out.print("--");
                else System.out.printf("%d-", rods[i][j]); }
            System.out.print("--");
            System.out.println();   
        }
        iScanner.nextLine();  // Enter-пауза
    }


    /**Инициализация массива для визуализации */
    static void init_visual() {
        for (int i = 0; i < rods[0].length; i++) {
            rods[0][i] = rods[0].length - i; }
    }
}
