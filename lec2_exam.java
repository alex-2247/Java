/* Здесь примеры кода из лекции 2 */


// // Что такое API для нас: строки
// // Простой пример
// // Создать строку из 1 млн плюсиков. Как?
// public class lec2_exam {
//     public static void main(String[] args) {
//         String str = "";
//         for (int i = 0; i < 1_000_000; i++) {
//             str += "+";
//         }
//     }
// }       // Результат - дохрена, у меня минуты три.


// // Что такое API для нас: строки
// // Простой пример
// // Создать строку из 1 млн плюсиков. Как?
// public class lec2_exam {
//     public static void main(String[] args) {
//         StringBuilder sb = new StringBuilder();
//         String q;
//         q.t
//         sb.t
//         for (int i = 0; i < 1_000_000; i++) {
//             sb.append("+");
//         }
//     }
// }       // Результат - около двух секунд


// // Что такое API для нас: строки
// // Весь код
// // В смысле и отключеный String-вариант, и стрингбилдер
// public class lec2_exam {
//    public static void main(String[] args) {
//        var s = System.currentTimeMillis();
//        //String str = "";
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < 1_000_000; i++) {
//            //str += "+";
//            sb.append("+");
//        }
//        System.out.println(System.currentTimeMillis() - s);
//        //System.out.println(str);
//        //System.out.println(sb);
//    }
// }


// // Что такое API для нас: строки
// // некоторые преобразования массива символов и строк
// public class lec2_exam {
//     public static void main(String[] args) {
//         String[] name = { "C", "е", "р", "г", "е", "й" };
//         String sk = "СЕРГЕЙ КА.";
//         System.out.println(sk.toLowerCase()); // сергей ка.
//         System.out.println(String.join("", name)); // Cергей
//         System.out.println(String.join("", "C", "е", "р", "г", "е", "й"));
//         // C,е,р,г,е,й
//         System.out.println(String.join(",", "C", "е", "р", "г", "е", "й"));
//     }
// }


// // Работа с файловой системой. Файлы
// // Опыты с относительными и абсолютными путями
// import java.io.File;
// public class lec2_exam {
//    public static void main(String[] args) {
//        String pathProject = System.getProperty("user.dir");
//        String pathFile = pathProject.concat("/file.txt");
//        File f3 = new File(pathFile);
//        System.out.println(f3.getAbsolutePath());
//        // /Users/sk/vscode/java_projects/file.txt
//        // C:/Users/Sk/Documents/xxx/brainexplosion/java/file.txt
//    }
// }


// // Работа с файловой системой. Файлы. Ошибки
// import java.io.File;
// public class lec2_exam {
//    public static void main(String[] args) {
//        try {
//            String pathProject = System.getProperty("user.dir");
//            String pathFile = pathProject.concat("/file.txt");
//            File f3 = new File(pathFile);
//            System.out.println("try");
//        } catch (Exception e) {
//            System.out.println("catch");
//        }
//        finally
//        { System.out.println("finally"); }
//    }
// }


// // Работа с файловой системой. Файлы. Ошибки
// import java.io.File;
// public class lec2_exam {
//     public static void main(String[] args) {
//         try {
//             String pathProject = System.getProperty("user.dir");
//             String pathFile = pathProject.concat("/file.txt");
//             File file = new File(pathFile);
//             if (file.createNewFile()) {
//                 System.out.println("file.created");
//             } else {
//                 System.out.println("file.existed");
//             }
//         } catch (Exception e) {
//             System.out.println("catch");
//         } finally {
//             System.out.println("finally");
//         }
//     }
// }


// // Работа с файловой системой. Файлы. Ошибки
// // Еще один пример из презентахи, но в лекции не затронут
// import java.io.BufferedReader;
// import java.io.File;
// import java.io.FileReader;
// public class lec2_exam {
//     public static void main(String[] args) {
//         String pathProject = System.getProperty("user.dir");
//         String pathFile = pathProject.concat("/file.txt");
//         String line = "empty";
//         try {
//            File file = new File(pathFile);
//            if (file.createNewFile()) {
//                System.out.println("file.created"); }
//            else {
//                BufferedReader bufReader =
//                new BufferedReader(new FileReader(file));
//                System.out.println("file.existed");
//                line = bufReader.readLine();
//                bufReader.close(); }
//         } catch (Exception e) {
//            //e.printStackTrace();
//         } finally {
//            System.out.println(line);
//         }
//     }
// }


// // Работа с файловой системой. Каталоги
// import java.io.File;
// public class lec2_exam {
//    public static void main(String[] args) {
//        String pathProject = System.getProperty("user.dir");
//        String pathDir = pathProject.concat("/files");
//        File dir = new File(pathDir);
//        System.out.println(dir.getAbsolutePath());
//        if (dir.mkdir()) {
//            System.out.println("+");
//        } else {
//            System.out.println("-");
//        }
//        for (String fname : dir.list()) {
//            System.out.println(fname);
//        } } 
// }


// // подробный и разнопалановый пример из лекеции на работу с файлами
// import java.io.*;
// import java.nio.ByteBuffer;
// import java.nio.ByteOrder;
// import java.nio.charset.Charset;
// import java.nio.charset.StandardCharsets;
// import java.util.HashMap;
// import java.util.Map;
// import java.util.Map.Entry;

// public class lec2_exam {

//     static ByteOrder bOrder = ByteOrder.LITTLE_ENDIAN;
//     static Map<String, String> data = new HashMap<>();
//     static Charset charset = StandardCharsets.UTF_8;

//     static void loadFile(String path) throws IOException {
//         try (InputStream stream = 
//         new BufferedInputStream(new FileInputStream(path))) {
//             int n = readInt(stream);
//             int b1;
//             int b2;
//             byte binWord[];
//             byte binText[];
//             for (int i = 0; i < n; i++) {
//                 binWord = new byte[readInt(stream)];
//                 binText = new byte[readInt(stream)];
//                 b1 = stream.read(binWord);
//                 b2 = stream.read(binText);
//                 if (b1 != binWord.length || b2 != binText.length)
//                     throw new IOException("Error read file");
//                 data.put(new String(binWord, charset), 
//                          new String(binText, charset));
//             }
//         }
//     }

//     static void saveFile(String path) throws IOException {
//         if (data.size() == 0)
//             throw new IOException("Nothing to write");
//         try (OutputStream stream = new BufferedOutputStream(new FileOutputStream(path, false))) {
//             writeInt(stream, data.size());
//             byte binWord[];
//             byte binText[];
//             for (Entry<String, String> entry : data.entrySet()) {
//                 binWord = entry.getKey().getBytes(charset);
//                 writeInt(stream, binWord.length);
//                 binText = entry.getValue().getBytes(charset);
//                 writeInt(stream, binText.length);
//                 stream.write(binWord);
//                 stream.write(binText);
//             }
//         }
//     }

//     static void delete(String word) {
//         data.remove(word);
//     }

//     static void add(String word, String text) throws Exception {
//         if (data.get(word) != null)
//             throw new Exception("Word already exist");
//         data.put(word, text);
//     }

//     static String find(String word) {
//         String out = data.get(word);
//         if (out == null)
//             return "не найдено";
//         else
//             return out;
//     }

//     static int readInt(InputStream in) throws IOException {
//         byte out[] = new byte[4];
//         int i = in.read(out);
//         if (i != 4)
//             throw new IOException("Error read file");
//         return ByteBuffer.wrap(out).order(bOrder).getInt();
//     }

//     static void writeInt(OutputStream out, int num) throws IOException {
//         ByteBuffer dbuf = ByteBuffer.allocate(4);
//         dbuf.order(bOrder).putInt(num);
//         out.write(dbuf.array());
//     }

//     public static void main(String[] args) {
//         String file = "test.bin";
//         //create file
        
//         try {
//             add("key1", "значение 1");
//             add("key2", "значение 2");
//             add("key4", "значение 3");
//             saveFile(file);
//         } catch (Exception e) {
//             e.printStackTrace();
//         }
//         //read file
        
//         try {
//             loadFile(file);
//             String key1 = "key1";
//             String key2 = "key2";
//             String key3 = "key3";
//             System.out.printf("%s: %s\n", key1, find(key1));
//             System.out.printf("%s: %s\n", key2, find(key2));
//             System.out.printf("%s: %s\n", key3, find(key3));
//         } catch (IOException e) {
//             e.printStackTrace();
//         }
//     }
// }


// // Логирование. Использование. Основы. Простой текстовый формат
// import java.util.logging.*;
// public class lec2_exam {
//    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(lec2_exam.class.getName());
//        logger.setLevel(Level.INFO);
//        ConsoleHandler ch = new ConsoleHandler();
//        logger.addHandler(ch);
//        SimpleFormatter sFormat = new SimpleFormatter();
//        ch.setFormatter(sFormat);
//        logger.log(Level.WARNING, "Тестовое логирование");
//        logger.info("Тестовое логирование");
//    }
// }


// // Логирование. Использование. Основы. XML-формат
// import java.util.logging.*;
// public class lec2_exam {
//    public static void main(String[] args) {
//        Logger logger = Logger.getLogger(lec2_exam.class.getName());
//        logger.setLevel(Level.INFO);
//        ConsoleHandler ch = new ConsoleHandler();
//        logger.addHandler(ch);
//        //SimpleFormatter sFormat = new SimpleFormatter();
//        XMLFormatter xml = new XMLFormatter();
//        //ch.setFormatter(sFormat);
//        ch.setFormatter(xml);
//        logger.log(Level.WARNING, "Тестовое логирование");
//        logger.info("Тестовое логирование");
//    }
// }


// // Логирование. Использование. Основы. Запись в файл
import java.io.IOException;
import java.util.logging.*;
public class lec2_exam {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger(lec2_exam.class.getName());
        //ConsoleHandler ch = new ConsoleHandler();
        FileHandler fh = new FileHandler("log.txt");
        //logger.addHandler(ch);
        logger.addHandler(fh);
        // SimpleFormatter sFormat = new SimpleFormatter();
        XMLFormatter xml = new XMLFormatter();
        // fh.setFormatter(sFormat);
        fh.setFormatter(xml);
        //logger.setLevel(Level.INFO);
        logger.log(Level.WARNING, "Тестовое логирование 1");
        logger.info("Тестовое логирование 2");
    }
}







