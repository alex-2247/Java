/*6. +Реализовать алгоритм сортировки слиянием
 * для упрощения задачи построю алгоритм для размерности, равной степени 2
*/
import java.util.Random;

public class sem3_dz2 {
    static int size_of_array = 32;     // Длина массива
    static int[] arr_source = new int[size_of_array];  // массив-источник
    static int[] arrA = new int[size_of_array];  // 
    static int[] arrB = new int[size_of_array];  // 
    static int GroupLength; // длина "группы" (подмассива) на текущем шаге
    public static void main(String[] args) {
        fill_array();
        System.out.print("Массив-источник: ");
        print_to_cons(arr_source);
        copy_array(arr_source, arrA);
        pair_sort(arrA);
        System.out.print("Шаг первый, сортируем в парах:   ");
        print_to_cons(arrA);
        // завернуть вызовы с растущим GL в глобальный цикл
        GroupLength = 1;      //2;      //4;
        while ((GroupLength*2)<size_of_array) {
            GroupLength *= 2;
            System.out.printf("Длина подмассива =%d, массив на входе:   ", GroupLength);
            print_to_cons(arrA);
            merge_sort(GroupLength);
            copy_array(arrB, arrA);
        }
        System.out.println("Результат, отсортированный массив:");
        print_to_cons(arrB);
    }


    /**Функция, реализующая основную логику, слияет две предварительно 
     * отсортированные группы. Работает с "глобальными" массивами arrA и arrB
     * @param gl GroupLength - длина группы (подмассива)    */
    static void merge_sort(int gl) {
        int ind1, ind2, end1, end2, big_ind = 0;
        big_ind = 0;
        while (big_ind<size_of_array) { // реализовать внешний цикл
            ind1 = big_ind;
            ind2 = ind1 + gl;
            end1 = ind2 - 1;
            end2 = end1 + gl;
            // System.out.printf("%d   %d %d %d %d;   ",big_ind,ind1,end1,ind2,end2);
            // цикл по результирующей удвоенной группе
            for (int i = big_ind; i < big_ind+gl*2; i++) {
                if (ind1<=end1 && ind2<=end2) {
                    if (arrA[ind2]>arrA[ind1]) {
                        // System.out.print(" второй > первого\n");
                        arrB[i] = arrA[ind1];
                        ind1++; }
                    else { 
                        // System.out.print(" первый >= второго\n");
                        arrB[i] = arrA[ind2];
                        ind2++; }   }
                else {
                    if (ind1<=end1 && ind2>end2) {
                        // System.out.print(" второй кончился, берём первый\n");
                        arrB[i] = arrA[ind1];
                        ind1++; }
                    if (ind1>end1 && ind2<=end2) {
                        // System.out.print(" первый кончился, берём второй\n");
                        arrB[i] = arrA[ind2];
                        ind2++; }   }
                // System.out.printf("%d ",arrB[i]);
                // System.out.printf("%d %d  %d %d   %d\n",ind1,end1,ind2,end2,arrB[i]);
            }
            // System.out.println();
            big_ind += gl*2;
        }
        // System.out.println();
    }


    /**разбивает массив на пары, и сортирует внутри пары, вся работа в
     * пределах одного массива, поэтому аргумент один */
    static void pair_sort(int[] argArr) {
        int i = 0;
        int tmpVal = 0;
        while (i<argArr.length) {
            // System.out.printf("i=%d;   пара была: %d %d", i, argArr[i], argArr[i+1]);
            if (argArr[i]>argArr[i+1]) {
                tmpVal = argArr[i];
                argArr[i] = argArr[i+1];
                argArr[i+1] = tmpVal;
            }
            // System.out.printf(";   пара стала: %d %d\n", argArr[i], argArr[i+1]);
            i = i + 2;
        }
    }


    /**Копирует один целочисленный массив в другой, размерность равная
     * @param arr1 откуда
     * @param arr2 куда */
    static void copy_array(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; i++)arr2[i] = arr1[i];
    }


    /**Заполняет массив-источник случайными числами в диапазоне 1-99*/
    static void fill_array() {
        Random rand = new Random();
        for (int i = 0; i < arr_source.length; i++) 
            arr_source[i] = 1 + rand.nextInt(99);
    }


    /**Выводит массив в консоль, тупо в строку*/
    static void print_to_cons(int[] argArr) {
        System.out.printf("%d", argArr[0]);
        for (int i = 1; i < argArr.length; i++) 
            System.out.printf(", %d", argArr[i]);
            System.out.printf("\n");
        }
}
