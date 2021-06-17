package com.cc.cproject.interview.grammar.basicgrammar.io;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取文件下一层目录的所有xls结尾文件同时大小小于200K并统计数量 list()获取
 *
 * @author changcheng
 * @since 2021-04-14 14:11
 */
public class IoTest1 {

    public static void main(String[] args) {
        File file = new File("D:\\学习资料\\开课吧\\开课吧面试知识点\\面试pdf");
        File[] files = null;
        List<File> result = new ArrayList<>();
        if (file.isDirectory()) {
            files = file.listFiles();
            for (File tempFile : files) {
                if (tempFile.isFile() && tempFile.getName().endsWith(".xls") && tempFile.length() > 200 * 1024) {
                    result.add(tempFile);
                }
            }
        }
        System.out.println(result.size());
    }


}
