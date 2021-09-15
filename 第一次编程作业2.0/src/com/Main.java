package com;
import com.github.stuxuhai.jpinyin.ChineseHelper;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        InputFile IOinput = new InputFile();
        String checkfile=IOinput.inputfile();//读待检测文件
        /*String[] aa=checkfile.split("\\n");
        System.out.println(checkfile);//待检测文件*/

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
        System.out.println(wordsmap);

        OutputFile outputfile=new OutputFile();
        CheckSensitiveWords outcome=new CheckSensitiveWords();

        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        CheckSensitiveWords aa=new CheckSensitiveWords();
        aa.getMap(wordsmap);
        List<String> setwords=aa.getSensitiveWord(checkfile,1);
        String txt="Total:"+setwords.size()+'\n';
        for(int k=0;k<setwords.size();k++){
            txt+=setwords.get(k);
            txt+='\n';
        }
        outputfile.rwFile(txt,name);//读出文件到指定位置
        System.out.println(setwords.size());

    }
}
