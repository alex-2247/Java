// Задача 7. 
// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class sem5_dz1 {
    public static void main(String[] args) {
        int[][] desk = new int[8][8];
        if (!putFerz(desk, 0)) {
            System.out.println("Не получилось решить задачу");
        }
        printDesk(desk);
    }    


    /**основная функция решения задачи, с рекурсивным вызовом */
    public static boolean putFerz(int[][] board, int col) {
        if (col >= board.length) return true;
        for (int i = 0; i < board.length; i++) {
            if (checkPlace(board, i, col)) {
                board[i][col] = 1;
                if (putFerz(board, col + 1)) return true;
                board[i][col] = 0;
            }
        }
        return false;
    }


    /**Проверим, можно ли в эту позицию поставить ферзя */
    public static boolean checkPlace(int[][] board, int row, int column) {
        // проверим, нет ли уже фигуры в этой строке
        for (int i = 0; i < column; i++) {
            if (board[row][i] == 1) return false;
        }
        // нет ли фигур по диагонали влево-вверх
        for (int i = row - 1, j = column - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) return false;
        }
        // нет ли фигур по диагонали влево-вниз
        for (int i = row + 1, j = column - 1; i < board.length && j >= 0; i++, j--) {
            if (board[i][j] == 1) return false;
        }
        return true;
    }


    /**вывод состояния доски в консоль */
    public static void printDesk(int[][] argArr) {
        for (int i = 0; i < argArr.length; i++) {
            for (int j = 0; j < argArr.length; j++) 
                System.out.printf("%s  ", (argArr[i][j]<1) ? "." : "@");
            System.out.println(); }
    }
}
