package com;

import java.io.*;
import java.util.Scanner;
//输入文件并转化为字符串
public class InputFile {
    public static String inputfile(String name) throws IOException {
        /*Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();*/
        File f = new File(name);
        FileInputStream word=new FileInputStream(f);
        InputStreamReader wordreader=new InputStreamReader(word,"UTF-8");
        BufferedReader reader = new BufferedReader(wordreader);//将文件通过绝对路径读出文件
        String br =null;
        String bt ="";
        while ((br = reader.readLine()) != null) {//按行读取
            bt+=br;//按行读入
            bt+='\n';
        }//将文本转换为字符串
        return bt;
    }

}
