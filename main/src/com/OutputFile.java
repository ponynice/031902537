package com;
import java.io.*;
import java.nio.charset.StandardCharsets;

//输出文件到指定的文件路径中
public class OutputFile {
    public static void rwFile(String file,String filepath) {
        FileOutputStream fw= null;
        try {
            /*fw = new FileWriter(filepath, true);//路径一定要用"\\"
            fw.write(file);//这里向文件中输入结果
            fw.flush();*/
            fw = new FileOutputStream(filepath);
            BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(fw, StandardCharsets.UTF_8));
            writer.write(file);
            writer.close();
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
