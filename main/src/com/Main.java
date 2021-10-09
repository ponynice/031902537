package com;

import com.github.stuxuhai.jpinyin.PinyinException;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException,PinyinException{
        /*System.out.println(ChineseHelper.convertToTraditionalChinese("法轮功"));*/
        String checkfile= InputFile.inputfile(args[1]);//读待检测文件

        String sensitivefile= InputFile.inputfile(args[0]);//读敏感词文件
        String[] ss=sensitivefile.split("\\n");//将敏感词字符串按行划分为字符数组
        AddSensitiveWords add=new AddSensitiveWords();
        Set<String>set=add.addSensitiveWords(ss);//增加敏感词汇
        SensitiveWords wordskey=new SensitiveWords();
        Map wordsmap=wordskey.WordsHashMap(set);//返回敏感词树
        /*System.out.println(wordsmap);*/

        //指定答案输出的目标文件
        CheckSensitiveWords aa=new CheckSensitiveWords();
        aa.getMap(wordsmap);
        List<String> setwords=aa.getSensitiveWord(checkfile,1);//检测敏感词并得到文章中的敏感词形式以及总数
        StringBuilder txt= new StringBuilder("Total: " + setwords.size() / 3 + '\n');
        for(int k=0;k<setwords.size();k+=3){
            txt.append(setwords.get(k));
            txt.append(setwords.get(k + 1));
            txt.append(setwords.get(k + 2));
            txt.append('\n');
        }//将答案转化为字符串
        OutputFile.rwFile(txt.toString(),args[2]);//读出文件到指定位置


    }
}
