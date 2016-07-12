package file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchFile {
    public static List<File> list(File dir, String pattern) {
        List<File> list = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isDirectory())
                list.addAll(list(file, pattern));
            if (file.getName().matches(pattern))
                list.add(file);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String pattern = sc.nextLine();
        pattern = pattern.replace(".", "\\.").replace("*", ".*").replace("?", "//w");
        File file = new File(".");
        List<File> list;
        if (file.isDirectory()) {
            list = list(file, pattern);
            list.forEach(System.out::println);
        }
    }
}
