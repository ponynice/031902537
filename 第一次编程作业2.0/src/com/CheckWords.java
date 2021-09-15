package com;
import java.util.*;
public class CheckWords {
    public static Map sensitiveWordMap = null;
    public static int minMatchTYpe = 1;
    public static int maxMatchType = 2;
        public static int getWordSize()
        {
            if (sensitiveWordMap == null)
            {
                return 0;
            }
            return sensitiveWordMap.size();
        }//返回敏感词数量

        /**
         * 是否包含敏感词
         *
         * @param txt
         * @param matchType
         * @return
         */
        public static boolean isContaintSensitiveWord(String txt, int matchType)
        {
            boolean flag = false;
            for (int i = 0; i < txt.length(); i++)
            {
                int matchFlag = checkSensitiveWord(txt, i, matchType);
                if (matchFlag > 0)
                {
                    flag = true;
                }
            }
            return flag;
        }

        /**
         * 获取敏感词内容
         *
         * @param txt
         * @param matchType
         * @return 敏感词内容
         */
        public static Set<String> getSensitiveWord(String txt, int matchType)
        {
            Set<String> sensitiveWordList = new HashSet<String>();

            for (int i = 0; i < txt.length(); i++)
            {
                int length = checkSensitiveWord(txt, i, matchType);
                if (length > 0)
                {
                    // 将检测出的敏感词保存到集合中
                    sensitiveWordList.add(txt.substring(i, i + length));
                    i = i + length - 1;
                }
            }

            return sensitiveWordList;
        }


        /**
         * 检查敏感词数量
         *
         * @param txt
         * @param beginIndex
         * @param matchType
         * @return
         */
        public static int checkSensitiveWord(String txt, int beginIndex, int matchType)
        {
            boolean flag = false;
            // 记录敏感词数量
            int matchFlag = 0;
            char word = 0;
            Map nowMap = sensitiveWordMap;
            for (int i = beginIndex; i < txt.length(); i++)
            {
                word = txt.charAt(i);
                // 判断该字是否存在于敏感词库中
                nowMap = (Map) nowMap.get(word);
                if (nowMap != null)
                {
                    matchFlag++;
                    // 判断是否是敏感词的结尾字，如果是结尾字则判断是否继续检测
                    if ("1".equals(nowMap.get("isEnd")))
                    {
                        flag = true;
                        // 判断过滤类型，如果是小过滤则跳出循环，否则继续循环
                        if (minMatchTYpe == matchType)
                        {
                            break;
                        }
                    }
                }
                else
                {
                    break;
                }
            }
            if (!flag)
            {
                matchFlag = 0;
            }
            return matchFlag;
        }


}
