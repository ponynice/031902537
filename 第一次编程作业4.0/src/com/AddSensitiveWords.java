package com;

import com.github.stuxuhai.jpinyin.ChineseHelper;
import com.github.stuxuhai.jpinyin.PinyinFormat;
import com.github.stuxuhai.jpinyin.PinyinHelper;
import com.github.stuxuhai.jpinyin.PinyinException;//外部引入的一个库

import java.util.HashSet;
import java.util.Set;

//扩充敏感词库
public class AddSensitiveWords {
    public Set<String> addSensitiveWords(String[] ss)throws PinyinException{
        Set<String>set = new HashSet<>();
        /*System.out.println(sword.toString());*/
        int j= ss.length;
        for(int i=0;i<j;i++){
            set.add(ss[i]);
        }
        for(int i=0;i<j;i++){
            String word=ss[i];
           /* System.out.println(ss[i]);*/
            char key=word.charAt(0);
            if(ChineseHelper.isChinese(key)){
                set.add(PinyinHelper.convertToPinyinString(ss[i],"", PinyinFormat.WITHOUT_TONE));//将中文转化成拼音
                /*System.out.println(PinyinHelper.convertToPinyinString(ss[i],"", PinyinFormat.WITHOUT_TONE));*/
                set.add(PinyinHelper.getShortPinyin(ss[i]));//将中文转换成拼音开头缩写
            }
        }//将转化后的新增词汇加入set当中
        return set;
    }
}
