package com;
import java.io.*;
public class OutputFile {
    public static void rwFile(String file,String filepath) {
        FileWriter fw = null;
        try {
            fw = new FileWriter(filepath, true);//路径一定要用"\\"
            fw.write(file);//这里向文件中输入结果
            fw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fw != null) {
                try {
                    fw.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}
