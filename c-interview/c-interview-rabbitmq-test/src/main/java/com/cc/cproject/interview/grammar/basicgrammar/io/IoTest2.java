package com.cc.cproject.interview.grammar.basicgrammar.io;

import java.io.File;

/**
 * 删除指定文件夹下的所有文件（递归删除）
 *
 * @author changcheng
 * @since 2021-04-14 14:35
 */
public class IoTest2 {

    public static void main(String[] args) {
        File file=new File("D:\\学习资料\\开课吧\\开课吧面试知识点\\面试pdf\\safasdfasd");
        deleteFiles(file);
    }

    public static void deleteFiles(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for(File tempFile:files){
                deleteFiles(tempFile);
            }
            if(file.listFiles().length==0){
               file.delete();
            }
        }else{
            file.delete();
        }
    }
}
