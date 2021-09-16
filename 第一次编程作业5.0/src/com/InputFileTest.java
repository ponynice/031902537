package com;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;

import java.io.IOException;

import static org.junit.Assert.*;

public class InputFileTest {

    InputFile input=new InputFile();
    @Before
    public void setUp() throws Exception {
        System.out.println("测试开始");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("测试结束");
    }

    @org.junit.Test
    public void inputfile() throws IOException {
        assertEquals("我盡力了哈哈哈法輪功害人不淺太過分了要少熬夜dsqbdquidq@#!#!&*#!hhhh1hw1uhw1\n",input.inputfile("C:\\Users\\24427\\Desktop\\test.txt"));
    }


}