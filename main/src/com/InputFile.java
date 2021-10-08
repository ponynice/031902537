package com;

import java.io.*;
import java.nio.charset.StandardCharsets;

//输入文件并转化为字符串
public class InputFile {
    public static String inputfile(String name) throws IOException {
        File f = new File(name);
        FileInputStream word=new FileInputStream(f);
        InputStreamReader wordreader=new InputStreamReader(word, StandardCharsets.UTF_8);
        BufferedReader reader = new BufferedReader(wordreader);//将文件通过绝对路径读出文件
        String br;
        StringBuilder bt = new StringBuilder();
        while ((br = reader.readLine()) != null) {//按行读取
            bt.append(br);//按行读入
            bt.append('\n');
        }//将文本转换为字符串
        return bt.toString();
    }

}
