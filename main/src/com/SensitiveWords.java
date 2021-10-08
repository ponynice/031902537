package com;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//构建敏感词的hashmap
public class SensitiveWords {
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map WordsHashMap(Set<String> keyWords) {
        Map sensitiveWordMap = new HashMap(keyWords.size());     //初始化敏感词容器，减少扩容操作
        String key;
        Map nowMap;
        //迭代keyWordSet
        for (String keyWord : keyWords) {
            key = keyWord;    //关键字
            nowMap = sensitiveWordMap;
            for (int i = 0; i < key.length(); i++) {
                char keyChar = key.charAt(i);//转换成char型
                if (Character.isLetter(keyChar)) keyChar = Character.toLowerCase(keyChar);
                //验证输出
                Object wordMap = nowMap.get(keyChar);       //获取

                if (wordMap != null) {        //如果存在该key，直接赋值
                    nowMap = (Map) wordMap;
                } else {     //不存在则，则构建一个map，同时将isEnd设置为0，因为他不是最后一个
                    Map newWorMap = new HashMap<String, String>();
                    newWorMap.put("isEnd", "0");     //不是最后一个
                    nowMap.put(keyChar, newWorMap);
                    nowMap = newWorMap;
                }

                if (i == key.length() - 1) {
                    nowMap.put("isEnd", "1");    //最后一个
                }
            }
        }
        return sensitiveWordMap;
    }
}


