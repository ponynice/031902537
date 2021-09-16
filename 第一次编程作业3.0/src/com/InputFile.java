package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
//输入文件并转化为字符串
public class InputFile {
    public static String inputfile() throws IOException {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        File f = new File(name);
        BufferedReader reader = new BufferedReader(new FileReader(f));
        String br =null;
        String bt ="";
        while ((br = reader.readLine()) != null) {//按行读取
            bt+=br;//按行读入
            bt+='\n';
        }//将文本转换为字符串
        return bt;
    }

}
