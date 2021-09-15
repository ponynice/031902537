package com;
import java.util.*;
import java.util.Scanner;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        InputFile IOinput = new InputFile();
        String checkfile=IOinput.inputfile();//读待检测文件
        String[] aa=checkfile.split("\\n");
        System.out.println(checkfile);//待检测文件

        InputFile Wordinput=new InputFile();
        String sensitivefile=Wordinput.inputfile();//读敏感词文件
        String[] ss=sensitivefile.split("\\n");
        System.out.println(ss.length);
        Set<String>set = new HashSet<>();
        for(int i=0;i<ss.length;i++){
            set.add(ss[i]);
        }
        SensitiveWords wordskey=new SensitiveWords();
        Map wordsmap=wordskey.WordsHashMap(set);//返回敏感词树
        CheckWords check=new CheckWords();
        System.out.println(wordsmap.get('法'));

    }
}
