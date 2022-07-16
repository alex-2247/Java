/* 2.	+ На вход некоторому исполнителю подаётся два числа (a, b). 
У исполнителя есть две команды
- команда 1 (к1): увеличить в с раза, а умножается на c 
- команда 2 (к2): увеличить на d ( +2 ), к a прибавляется d 
написать программу, которая выдаёт набор команд, позволяющий число a 
превратить в число b или сообщить, что это невозможно 
Пример 1: а = 1, b = 7, c = 2, d = 1 
ответ: к1, к1, к1, к1, к1, к1 или к1, к2, к1, к1, к1 или к1, к1, к2, к1. 
Пример 2: а = 11, b = 7, c = 2, d = 1
ответ: нет решения */
// Изменю визуальное отображение команд, чтоб сразу их понимать
// k1 ==> *2;   k2 ==> +1
public class sem6_dz1 {
    static int source = 1;
    static int goal = 7;
    static int mult = 2;
    static int append = 1;
public static void main(String[] args) {
        String str = findSolution(source, goal, mult, append);
        System.out.println(str);
    }


    public static String findSolution(int a, int b, int c, int d) {
        if (a >= b) return "(задумчиво) решения нет...";
        String visK1 = String.format("*%d ", c);
        String visK2 = String.format("+%d ", d);
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%d ==>   ", a));
        while ((a * c) <= b) {
            sb.append(visK1);
            a *= c;
        }
        while (a != b) {
            sb.append(visK2);
            a += d;
        }
        sb.append(String.format("   = %d", b));
        return sb.toString().trim();
    }
}
