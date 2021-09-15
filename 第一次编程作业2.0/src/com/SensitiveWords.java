package com;
import com.github.stuxuhai.jpinyin.ChineseHelper;

import java.io.IOException;
import java.util.*;

//构建敏感词的hashmap
public class SensitiveWords {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map WordsHashMap(Set<String> keyWords) {
        Map sensitiveWordMap = new HashMap(keyWords.size());     //初始化敏感词容器，减少扩容操作
        String key = null;
        Map nowMap = null;
        Map<String, String> newWordMap = null;
        //迭代keyWordSet
        Iterator<String> iterator = keyWords.iterator();
        while(iterator.hasNext()){
            key = iterator.next();    //关键字
            nowMap = sensitiveWordMap;
            for(int i = 0 ; i < key.length() ; i++){
                char keyChar = key.charAt(i);//转换成char型

                System.out.println(keyChar);
                System.out.println('*');
                Object wordMap = nowMap.get(keyChar);       //获取

                if(wordMap != null){        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                }
                else{     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    Map newWorMap = new HashMap<String,String>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if(i == key.length() - 1){
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
        System.out.println("yeah!");
        return sensitiveWordMap;
    }
}


