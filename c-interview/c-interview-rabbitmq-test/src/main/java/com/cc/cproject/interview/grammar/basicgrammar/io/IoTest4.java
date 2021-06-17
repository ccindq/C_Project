package com.cc.cproject.interview.grammar.basicgrammar.io;

import java.io.*;

/**
 * 复制文件
 *
 * @author changcheng
 * @since 2021-04-14 15:12
 */
public class IoTest4 {
    public static void readFile(String fromPath, String toPath) throws IOException {
        File fromfile = new File(fromPath);
        File tofile = new File(toPath);
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        inputStream = new FileInputStream(fromfile);
        outputStream = new FileOutputStream(tofile);
        if (null != inputStream && null != outputStream) {
            bufferedInputStream = new BufferedInputStream(inputStream);
            bufferedOutputStream = new BufferedOutputStream(outputStream);
            byte[] b = new byte[1024];
            try {
                while (-1 != (bufferedInputStream.read(b))) {
                    bufferedOutputStream.write(b);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (null != bufferedInputStream) {
            bufferedInputStream.close();
        }
        if (null != bufferedOutputStream) {
            bufferedOutputStream.close();
        }
        if (null != inputStream) {
            inputStream.close();
        }
        if (null != outputStream) {
            outputStream.close();
        }
    }
    public static void main(String[] args) throws IOException {
        readFile("d:/test.docx", "d:/test2.docx");

    }
}
