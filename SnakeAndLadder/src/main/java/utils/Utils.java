package utils;

import java.util.Scanner;

public class Utils {
    private  static Scanner scanner;
    public static Scanner getScanner() {
        if (scanner == null) {
            synchronized (Utils.class) {
                if (scanner == null) {
                    scanner = new Scanner(System.in);
                }
            }
        }
        return scanner;
    }
}
