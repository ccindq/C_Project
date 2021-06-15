package com.cc.interview.sign;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * 文件夹 生成签名，校验，
 *                   生成签名命令  需要生成签名的目录         生成的签名
 * 生成签名 java Sign m D:\学习资料\Front-end\练习\书城项目 123.text
 * 校验签名 java Sign c D:\学习资料\Front-end\练习\书城项目 123.text
 * @author changcheng
 * @since 2021-04-15 14:54
 */
public class Sign {

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        if (args != null && args.length >= 3) {
            String mode = args[0];
            String filePath = args[1];
            String resultFile = args[2];
            //生成摘要，m，文件位置，生成摘要的文件
            if (mode.equals("m")) {
                Map<String, String> resultMap = getAllsha256(filePath);
                File file2 = new File(resultFile);
                if (!file2.exists()) {
                    file2.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2));
                for (Map.Entry entry : resultMap.entrySet()) {
                    String key = ((String) entry.getKey()).substring(filePath.length());
                    bufferedWriter.write(key + "\n");
                    bufferedWriter.write(entry.getValue() + "\n");
                }
                bufferedWriter.close();
                System.out.println("生成摘要完毕");
                //检查摘要，c，文件位置，生成摘要的文件
            } else if (mode.equals("c")) {
                String checkResult = "sucess";
                BufferedReader bufferedReader = new BufferedReader(new FileReader(resultFile));
                String str = null;
                int i = 0;
                String tempPath = "";
                String tempStr = "";
                while ((str = bufferedReader.readLine()) != null) {
                    if (i % 2 == 0) {
                        File tempFile = new File(filePath + str);
                        tempStr = sha256(tempFile);
                        tempPath = str;
                    }
                    if (i % 2 == 1) {
                        if (tempStr.equals(str)) {
                            //校验成功
                        } else {
                            checkResult = tempPath + "\n rigth:" + str + "\n calculate:" + tempStr;
                        }
                    }
                    i++;
                }
                System.out.println(checkResult);
                bufferedReader.close();
            }
        }


    }

    /**
     * SHA256算法
     */
    private static String sha256(File file) throws NoSuchAlgorithmException, IOException {
        FileInputStream fis = new FileInputStream(file);
        MessageDigest messageDigest;
        String encodestr = "";
        messageDigest = MessageDigest.getInstance("SHA-256");
//        messageDigest.update(str.getBytes("UTF-8"));
        byte[] buffer = new byte[2048];
        int length = -1;
//        System.out.println("开始生成摘要");
        long s = System.currentTimeMillis();
        while ((length = fis.read(buffer)) != -1) {
            messageDigest.update(buffer, 0, length);
        }
//        System.out.println("摘要生成成功,总用时: " + (System.currentTimeMillis() - s) + "ms");
        encodestr = byte2Hex(messageDigest.digest());
        System.out.println(encodestr);
        return encodestr;
    }

    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                // 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }

    private static Map<String, String> getAllsha256(String filePath) throws IOException, NoSuchAlgorithmException {
        Map<String, String> map = new HashMap<>();
        File file = new File(filePath);
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File tempFile : files) {
                map.putAll(getAllsha256(tempFile.getPath()));
            }
        } else {
            map.put(file.getPath(), sha256(file));
        }
        return map;
    }
}
