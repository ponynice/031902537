package com;

import com.github.stuxuhai.jpinyin.PinyinException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.*;

public class AddSensitiveWordsTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始！");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束！");
    }

    @Test
    public void addSensitiveWords()throws PinyinException {
        String[] ss={"笨蛋","sMart","小可爱"};
        Set<String>aa =new HashSet<>();
        aa.add("笨蛋");
        aa.add("sMart");
        aa.add("小可爱");
        aa.add("bendan");
        aa.add("xiaokeai");
        aa.add("bd");
        aa.add("xka");
        AddSensitiveWords awords=new AddSensitiveWords();
        assertEquals(aa,awords.addSensitiveWords(ss));
    }
}