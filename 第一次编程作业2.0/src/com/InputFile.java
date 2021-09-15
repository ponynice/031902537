package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class InputFile {
    public static String inputfile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        File f = new File(name);
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String br =null;
        String bt ="";
        while ((br = reader.readLine()) != null) {
            bt+=br;//按行读入
            bt+='\n';
        }
        return bt;
    }

}
