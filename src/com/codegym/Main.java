package com.codegym;


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // write your code here
        System.out.println("The program shows the file size");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path of the directory: ");

        String path = scanner.nextLine();

        long res = getFolderSize(path);

        System.out.println("Size: " + res);


    }

    public static long getFolderSize(String path) throws IOException {
        File dir = new File(path);
        long size = 0;
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                System.out.println(file.getName() + " " + file.length());
                size += file.length();
            } else
                size += getFolderSize(file.getCanonicalPath());
        }
        return size;
    }
}
