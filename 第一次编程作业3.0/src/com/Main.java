package com;
import com.github.stuxuhai.jpinyin.ChineseHelper;
import java.util.*;
import java.io.*;
import com.github.stuxuhai.jpinyin.PinyinException;
public class Main {
    public static void main(String[] args) throws IOException,PinyinException{
        /*System.out.println(ChineseHelper.convertToTraditionalChinese("法轮功"));*/
        InputFile IOinput = new InputFile();
        String checkfile=IOinput.inputfile();//读待检测文件
        /*String[] aa=checkfile.split("\\n");
        System.out.println(checkfile);//待检测文件*/

        InputFile Wordinput=new InputFile();
        String sensitivefile=Wordinput.inputfile();//读敏感词文件
        String[] ss=sensitivefile.split("\\n");//将敏感词字符串按行划分为字符数组
        /*System.out.println(ss.length);

        Set<String>set = new HashSet<>();
        for(int i=0;i<add.addSensitiveWords(ss).length;i++){
            set.add(ss[i]);
        }
        System.out.println(add.addSensitiveWords(ss).toString());*/
        AddSensitiveWords add=new AddSensitiveWords();
        Set<String>set=add.addSensitiveWords(ss);//增加敏感词汇
        /*for (String s : set) {
            System.out.println(s);
        }*/
        SensitiveWords wordskey=new SensitiveWords();
        Map wordsmap=wordskey.WordsHashMap(set);//返回敏感词树
        /*System.out.println(wordsmap);*/

        OutputFile outputfile=new OutputFile();
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();//指定答案输出的目标文件
        CheckSensitiveWords aa=new CheckSensitiveWords();
        aa.getMap(wordsmap);
        List<String> setwords=aa.getSensitiveWord(checkfile,1);//检测敏感词并得到文章中的敏感词形式以及总数
        String txt="Total:"+setwords.size()/3+'\n';
        for(int k=0;k<setwords.size();k+=3){
            txt+=setwords.get(k);
            txt+=setwords.get(k+1);
            txt+=setwords.get(k+2);
            txt+='\n';
        }//将答案转化为字符串
        outputfile.rwFile(txt,name);//读出文件到指定位置


    }
}
