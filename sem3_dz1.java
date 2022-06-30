// До конца не удалось реализовать, ходы упираются в тупик, и при попытке 
// обратных ходов они идут повторно по неверным путям. Отложил задачу,
// для домашки взял другую, попроще. Время.

/* На странице ПЗ задача не указана, значит любая, возьму "про коня" 
* Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой
клетке была строго один раз. */
import java.util.Scanner;

public class sem3_dz1 {
    static int board_size = 5;     // сторона квадратной доски
    static int[][] board_arr = new int[board_size][board_size]; // массив доски
    static int start_line = 2;   //1;     // индекс начинается с нуля
    static int start_pos = 2;      // индекс начинается с нуля
    static int step_numb = 1;
    static int curr_line = start_line;
    static int curr_pos = start_pos;
    static int[] np_arr = {999, 999};  // передаточный массив новой позиции
    static int[][] no_step = new int[2][board_size*board_size+1];
    static Scanner iScanner = new Scanner(System.in);
    public static void main(String[] args) {
        // board_arr[start_line][start_pos] = 1;   // начало со стартовой позиции

        // start_line = 1;
        // board_arr[3][3] = 99;
        // board_arr[2][4] = 99;
        // board_arr[0][4] = 99;
        // board_arr[0][0] = 99;
        // board_arr[2][0] = 99;
        // board_arr[3][1] = 99;

        // главный цикл задачи - по номеру шага, начало с единицы
        for (step_numb=1; step_numb<=(board_size*board_size); step_numb++) {
            if (!Do_Step()) {
                Do_Back_Step();
                // break;
            }
        }
        iScanner.close();    
    }


    // делаем ход
    static boolean Do_Step() {
        // System.out.printf("Do_Step %d\n", step_number);
        board_arr[curr_line][curr_pos] = step_numb;

        np_arr = find_new_pos(board_arr, curr_line, curr_pos);
        
        board_display(board_arr, curr_line, curr_pos, np_arr[0], np_arr[1]);
        if (np_arr[0]<0 || np_arr[1]<0) return false;

        System.out.printf("Step %d,   Next (Enter): ", step_numb);
        // String name = 
        iScanner.nextLine();
        // System.out.printf("Привет, %s!", name);

        curr_line = np_arr[0];
        curr_pos = np_arr[1];
        clear_negative(board_arr, -1*step_numb);
        return true;
    }


    static void Do_Back_Step() {
        // System.out.printf("Step %d,   из текущей позиции нет хода, отходим взад", step_numb);
        System.out.printf("Start Do_Back_Step(), Step=%d, curr_line=%d, curr_pos=%d", step_numb, curr_line, curr_pos);
        // надо вернуться на предыдущий шаг, уменьшив на 1 step_numb, найти в 
        // массиве клетку с этим номером, переприсвоить curr_line и curr_pos
        // индексами найденной предыдущей клетки. Но при этом текущую 
        // тупиковую клетку переприсвоить -1.

        step_numb--;    // перейдем на ПРОШЛЫЙ шаг
        clear_negative(board_arr, -1*step_numb);

        // где перед этим стояли, присвоим заглушку, чтоб туда не ходил 
        // ...заглушка = минус номер пред.шага, который сейчас step_numb
        // заглушки прочих шагов сейчас затёрты функцией clear_negative()
        board_arr[curr_line][curr_pos] = -1*step_numb;
        // ...а также, запишем в [no_step] ЭТУ заглушку, если её там еще нет

        // write_no_step


        // вызовем заполнение из no_step сохранённых заглушек

        // read_no_step




        // найдем ПРОШЛЫЙ шаг
    np_arr = find_old_pos(board_arr, step_numb);

        System.out.println();
        // System.out.printf("Пред.шаг: %d,   ", step_numb);

        curr_line = np_arr[0];
        curr_pos = np_arr[1];

        System.out.printf("Пред.индексы: %d, %d", curr_line, curr_pos);
        System.out.println();
        board_display(board_arr, curr_line, curr_pos, -1, -1);
        step_numb--;    // еще уменьшим, ибо счётчик цикла дальше увеличит

        iScanner.nextLine();
    }


    // найти в массиве элемент по значению, вернуть массив с его индексами
    /**Какое
     * то
     * пояснение
     * к
     * функции
     * @param argArr qwerty ljkdkj ldjckljd lkdjlj
     * @param bad_step djhc kjdnkj dkjcvnkn
     * @return qqwweerrttyy
     */
    static int[] find_old_pos(int[][] argArr, int bad_step) {
        int[] resArr = {-1, -1}; // возвратный массив, [0]линия, [1]позиция
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++) {
                if (argArr[i][j]==bad_step) {
                    resArr[0] = i;
                    resArr[1] = j;
                }
            }
        }
        return resArr;
    }


    // зачистить последствия работы возвратных шагов, если они есть
    static void clear_negative(int[][] argArr, int ignor) {
        for (int i = 0; i < board_size; i++) {
            for (int j = 0; j < board_size; j++)
                if (argArr[i][j]<0 && argArr[i][j]!=ignor) argArr[i][j] = 0;
        }
    }


    // метод поиска следующей позиции
    static int[] find_new_pos(int[][] argArr, int cur_line, int cur_pos) {
        int[] resArr = {4, 4}; // возвратный массив, [0]линия, [1]позиция
        // int new_line, new_pos = -1;

        resArr[0] = cur_line + 2;   // CASE 1
        resArr[1] = cur_pos + 1;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line + 1;   // CASE 2
        resArr[1] = cur_pos + 2;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line - 1;   // CASE 3
        resArr[1] = cur_pos + 2;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line - 2;   // CASE 4
        resArr[1] = cur_pos + 1;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line - 2;   // CASE 5
        resArr[1] = cur_pos - 1;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line - 1;   // CASE 6
        resArr[1] = cur_pos - 2;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line + 1;   // CASE 7
        resArr[1] = cur_pos - 2;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = cur_line + 2;   // CASE 8
        resArr[1] = cur_pos - 1;
        if (stepable(argArr, resArr[0], resArr[1])) return resArr;

        resArr[0] = -1;
        resArr[1] = -1;
        return resArr;
    }
    

    static boolean stepable(int[][] Arr, int line, int pos) {
        if (0<=line && line<Arr.length 
        && 0<=pos && pos<Arr.length && Arr[line][pos]==0) return true;
        return false;
    }


    // отображение доски в терминале
    static void board_display(int[][] arr_arg, 
    int c_l, int c_p, int n_l, int n_p) {
        System.out.println("=======================================");
        String disp, pref, postf = "";
        for (int i = arr_arg.length-1; i>=0 ; i--) {
            System.out.println();
            for (int j = 0; j < arr_arg[i].length; j++) {
                disp = String.valueOf(arr_arg[i][j]);
                // обозначим текущую позицию <>, и следующую []
                pref = (i==c_l && j==c_p) ? "<" : " ";    // тернарный выбор
                postf = (i==c_l && j==c_p) ? ">" : " ";    // тернарный выбор
                pref = (i==n_l && j==n_p) ? "[" : pref;    // тернарный выбор
                postf = (i==n_l && j==n_p) ? "]" : postf;    // тернарный выбор
                if (arr_arg[i][j]<10) disp = "0" + disp;
                if (arr_arg[i][j]<0) disp = "^^";
                if (arr_arg[i][j]==0) disp = "..";
                System.out.printf("%s%s%s ", pref, disp, postf);
            }
            System.out.println();
        }
    }


}
