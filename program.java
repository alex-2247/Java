// public class program {
//     public static void main(String[] args) {
//         System.out.println("Bye, World!!!");
//     }
// }

// public class program {
//     public static void main(String[] args) {
//         String s = "    3";
//         System.out.println(s);
//     }
// }

// public class Program {
//     public static void main(String[] args) {
//         var a = 123;
//         System.out.println(a);  // 123
//         var d = 123.456;
//         System.out.println(d);  // 123.456
//         System.out.println(getType(a));  // Integer
//         System.out.println(getType(d));  // Double
//         d = 1022;
//         System.out.println(d);  // 1022
//         //d = "mistake";
//         //error: incompatible types:
//         //String cannot be converted to double
//     } 
//     static String getType(Object o){
//         return o.getClass().getSimpleName();
//     }
// }

// class Program { // здесь пример на функционал класса-обёртки Integer
//   public static void main(String[] args) {
//       System.out.println(Integer.MAX_VALUE); // 2147483647
//       System.out.println(Integer.MIN_VALUE); // -2147483648
//   }
// }

// public class program { //еще пример на обёрточный класс String
//     public static void main(String[] args) {
//         String MyString = "qwerty";
//         System.out.println(MyString.charAt(2));
//     }
// }

// public class program { //массивы одномерные
//     public static void main(String[] args) {

//         int[] arr = new int[10];
//         System.out.println(arr.length); // 10

//         arr = new int[] { 1, 2, 3, 4, 5 };
//         System.out.println(arr.length); // 5

//     }
// }

// public class program { // массивы многомерные
//     public static void main(String[] args) {
//         int[] arr[] = new int[3][5];
//         for (int[] line : arr) {
//             for (int item : line) {
//                 System.out.printf("%d ", item);
//             }
//             System.out.println();
//         }
//     }
// }

// public class program { // массивы многомерные другой синтаксис
//     public static void main(String[] args) {
//         int[][] arr = new int[3][5];
//         for (int i = 0; i < arr.length; i++) {
//             for (int j = 0; j < arr[i].length; j++) {
//                 System.out.printf("%d ", arr[i][j]);
//             }
//             System.out.println();
//         }
//     }
// }

// public class program { // преобразования
//     public static void main(String[] args) {
//         int i = 123; double d = i;
//         System.out.println(i);  // 123
//         System.out.println(d);  // 123.0
//         d = 3.1415; i = (int)d;
//         System.out.println(d);  // 3.1415
//         System.out.println(i);  // 3
//         d = 3.9415; i = (int)d;
//         System.out.println(d);  // 3.9415
//         System.out.println(i);  // 3
//         byte b = Byte.parseByte("123");
//         System.out.println(b);  // 123
//         b = Byte.parseByte("1234");
//         System.out.println(b);  // NumberFormatException: Value out of range
//     }
//  }

// public class program { // такое преобразование не работает, хотя казалось бы...
//   public static void main(String[] args) {
//    int[] a = new int[10];
//    double[] d = a;   // ИЗУЧАЕМ ковариантность и контравариантность
//   }
// }

// import java.util.Scanner;
// public class program { // Получение данных из терминала: строки
//    public static void main(String[] args) {
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("name: ");
//        String name = iScanner.nextLine();
//        System.out.printf("Привет, %s!", name);
//        iScanner.close();
//    }
// }   // Однако, русский текст принимает криво

// import java.util.Scanner;
// public class program { // Некоторые примитивы (численные)
//     public static void main(String[] args) {
//         Scanner iScanner = new Scanner(System.in);
//         System.out.printf("int a: ");
//         int x = iScanner.nextInt();
//         System.out.printf("double a: ");
//         double y = iScanner.nextDouble();
//         System.out.printf("%d + %f = %f", x, y, x + y);
//         iScanner.close();
// }}  // имеет значение формат десятичной точки

// import java.util.Scanner;
// public class program { // Проверка на соответствие получаемого типа
//    public static void main(String[] args) {
//        Scanner iScanner = new Scanner(System.in);
//        System.out.printf("int a: ");
//        boolean flag = iScanner.hasNextInt();
//        System.out.println(flag);       
//        int i = iScanner.nextInt();
//        System.out.println(i);       
//        iScanner.close();
//    } }

// public class program { // конкатенация строк, работает, но неэффеективна
//     public static void main(String[] args) {
//         int a = 1, b = 2;
//         int c = a + b;
//         String res = a + " + " + b + " = " + c;
//         System.out.println(res);
//     }
// }

// public class program { // форматированный вывод
//     public static void main(String[] args) {
//         int a = 1, b = 2;
//         int c = a + b;
//         String res = String.format("%d + %d = %d \n", a, b, c);
//         System.out.printf("%d + %d = %d \n", a, b, c);
//         System.out.println(res);
//     }}

// У переменных существует понятие «область видимости». 
// Если переменную объявили внутри некоторого блока фигурных скобок { }, 
// то снаружи этого блока переменная будет недоступна.
// public class program {
//     public static void main(String[] args) {
//         {
//             int i = 123;
//             System.out.println(i);
//         }
//         System.out.println(i); // error: cannot find symbol
//     }}


// public class program { // Функции и методы
//     static void sayHi() {
//         System.out.println("hi!");
//     }
//     static int sum(int a, int b) {
//         return a+b;
//     }  
//     static double factor(int n) { // факториал, использует рекурсию
//         if(n==1)return 1;
//         return n * factor(n-1);
//     }
//     public static void main(String[] args) {
//         sayHi(); // hi!
//         System.out.println(sum(1, 3)); // 4
//         System.out.println(factor(5)); // 120.0
//     }}


// // Почему-то это у меня не работает, хотя в лекции прекрасно
// public class program {
//     public static void main(String[] args) {
//         lib.sayHi();
//     }
// }


// public class program { // Условный оператор, полная форма
//     public static void main(String[] args) {
//         int a = 1;
//         int b = 2;
//         int c;
//         if (a > b) {
//             c = a;
//         } else {
//             c = b;
//         }
//         System.out.println(c);
//     }}


// public class program { // Условный оператор, краткая форма
//     public static void main(String[] args) {
//         int a = 1;
//         int b = 2;
//         int c = 0;
//         if (a > b) c = a;
//         if (b > a) c = b;
//         System.out.println(c);
//     }}


// public class program { // Тернарный оператор
//     public static void main(String[] args) {
//         int a = 1;
//         int b = 2;
//         int min = a < b ? a : b;
//         System.out.println(min);
//     }}


// import java.util.Scanner;
// public class program { // Оператор выбора, не работает, просто пример синтаксиса
//     public static void main(String[] args) {
//         int mounth = value;
//         String text = "";
//         switch (mounth) {
//             case 1:
//                 text = "Autumn";
//                 break;
// 		...
//             default:
//                 text = "mistake";
//                 break;
//         }
//         System.out.println(text);
//         iScanner.close();
//     }}


// public class program { // пример цикла "while", найти сколько цифр в числе
//     public static void main(String[] args) {
//         int value = 321;
//         int count = 0;
//         while (value != 0) {
//             value /= 10;
//             count++;
//         }
//         System.out.println(count);
//     }}


// public class program { // пример цикла "do while" (с постусловием)
//     public static void main(String[] args) {
//         int value = 321;
//         int count = 0;
//         do {
//             value /= 10;
//             count++;
//         } while (value != 0);
//         System.out.println(count);
//     }}


// public class program { // пример вложенного цикла "for"
//     public static void main(String[] args) {
//         for (int i = 0; i < 5; i++) {
//             for (int j = 0; j < 5; j++) {
//                 System.out.print("* ");
//             }
//             System.out.println();
//         }
//     }}


// //Работает только для коллекций, цикл "foreach", "for in"
// public class program { 
//         public static void main(String[] args) {
//             int arr[] = new int[10];
//             for (int item : arr) {
//                 System.out.printf("%d ", item);
//             }
//             System.out.println();
//         }}


// // Работа с файлами
// // Создание и запись/дозапись
// import java.io.FileWriter;
// import java.io.IOException;
// public class program { 
//     public static void main(String[] args) {
//         try (FileWriter fw = new FileWriter("file.txt", false)) {
//             fw.write("line 1");
//             fw.append('\n');
//             fw.append('2');
//             fw.append('\n');
//             fw.write("line 3");
//             fw.flush();
//         } catch (IOException ex) {
//             System.out.println(ex.getMessage());
//         }
//     } }


// // Работа с файлами:        Чтение, вариант ПОСИМВОЛЬНО
// import java.io.*;
// public class program { 
//     public static void main(String[] args) throws Exception {
//         FileReader fr = new FileReader("file.txt");
//         int c;
//         while ((c = fr.read()) != -1) {
//             char ch = (char) c;
//             if (ch == '\n') {
//                 // зачем здесь нужен этот блок if/else, непонятно,
//                 // всё работает если оставить эту одну строку
//                 System.out.print(ch);
//             } else {
//                 System.out.print(ch);
//             }
//         }
//         fr.close(); // это ввел в код сам изза предупреждения компилятора
//     } }


// Работа с файлами:        Чтение, вариант ПОСТРОЧНО
import java.io.*;
public class program { 
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        String str;
        while ((str = br.readLine()) != null) {
            System.out.printf("==>   %s   <==\n", str);
        }
        br.close();
    } }
