package com.cc.interview.basicgrammar.io;

import java.io.*;

/**
 * 给定一个文件和一个字符串 判断文件是否包含该字符串 如果包含 请打印出包含该字符串的行号和该行全部内容
 *
 * @author changcheng
 * @since 2021-04-14 14:45
 */
public class IoTest3 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("D:\\学习资料\\开课吧\\开课吧面试知识点\\面试pdf\\adsf.txt");
        File file2 = new File("D:\\学习资料\\开课吧\\开课吧面试知识点\\面试pdf\\fadsfadf.txt");
        int i = 0;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
        BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(file2));
        String str = null;
        while ((str = bufferedReader.readLine()) != null) {
            i++;
            if (str.contains("s")) {
                byte[] bytes = str.getBytes();
                char[] chars = str.toCharArray();
                System.out.println("行号：" + i + ",内容：" + str+",字节数:"+bytes.length+",字符数:"+chars.length);
                bufferedWriter.write(str+"\n");
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
        System.out.println("总行数" + i);
    }
}
