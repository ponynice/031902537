package com;
import com.github.stuxuhai.jpinyin.ChineseHelper;

import java.util.*;
//检测敏感词
public class CheckSensitiveWords {
    @SuppressWarnings("rawtypes")
    public static int minMatchTYpe = 1;      //最小匹配规则
    public static int maxMatchType = 2;      //最大匹配规则
    Map sensitiveWordMap=null;
    public int line=1;
    public String liner=null;
    public String orginalword="";
    public void getMap(Map sensitiveWordMap){
        this.sensitiveWordMap=sensitiveWordMap;
    }
    public boolean isContaintSensitiveWord(String txt,int matchType){//txt待检测文件，matchType匹配规则
        boolean flag = false;
        for(int i = 0 ; i < txt.length() ; i++){
            int matchFlag = this.CheckSensitiveWord(txt, i, matchType); //判断是否包含敏感字符
            if(matchFlag > 0){    //大于0存在，返回true
                flag = true;
            }
        }
        return flag;
    }//是否包含敏感字符
    public List<String> getSensitiveWord(String txt , int matchType){
        List<String> sensitiveWordList = new ArrayList<String>();
        for(int i = 0 ; i < txt.length() ; i++){
            int length = CheckSensitiveWord(txt, i, matchType);    //判断是否包含敏感字符
            if(length > 0){    //存在,加入list中
                liner="Line"+line+":";
                sensitiveWordList.add(liner);
                liner="<"+orginalword+">";
                sensitiveWordList.add(liner);
                sensitiveWordList.add(txt.substring(i, i+length));//substring截取字符串
                i = i + length - 1;    //减1的原因，是因为for会自增
            }
        }
        return sensitiveWordList;
    }//获取敏感字符

    @SuppressWarnings({ "rawtypes"})
    public int CheckSensitiveWord(String txt,int beginIndex,int matchType){
        boolean  flag = false;    //敏感词结束标识位：用于敏感词只有1位的情况
        int matchFlag = 0;     //匹配标识数默认为0
        char word;
        Map nowMap = sensitiveWordMap;
        for(int i = beginIndex; i < txt.length() ; i++){
            word = txt.charAt(i);
            if(word=='\n')line++;
            if(Character.isLetter(word)) word = Character.toLowerCase(word);//转小写
            if(ChineseHelper.isChinese(word))word=ChineseHelper.convertToSimplifiedChinese(word);
            nowMap=(Map) nowMap.get(word);
            if(nowMap != null){     //存在，则判断是否为最后一个
                orginalword+=word;
                matchFlag++;     //找到相应key，匹配标识+1
                if("1".equals(nowMap.get("isEnd"))){       //如果为最后一个匹配规则,结束循环，返回匹配标识数
                    flag = true;       //结束标志位为true
                    if(CheckSensitiveWords.minMatchTYpe == matchType){    //最小规则，直接返回,最大规则还需继续查找
                        break;
                    }
                }
            }
            else{     //不存在，直接返回
                break;
            }
        }
        if(matchFlag < 2 || !flag){        //长度必须大于等于1，为词
            matchFlag = 0;
            orginalword="";
        }
        return matchFlag;
    }
}
