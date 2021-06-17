package com.cc.cproject.interview.grammar.basicgrammar.volatiledemo;

/**
 * @author changcheng
 * @since 2021-02-23 15:18
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    private static final String USER_NAME_REGEX = "^[a-zA-Z][a-zA-Z0-9_]{4,15}$";

    public static void main(String[] args) {
        if ("?".matches(USER_NAME_REGEX)) {
            System.out.println("帐号不合法(字母开头，允许5-16字节，允许字母数字下划线)");
        }
//        Thread[] threads=new Thread[THREADS_COUNT];
//
//        for(int i= 0; i<THREADS_COUNT;i++){
//            threads[i]=new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    for(int i=0;i<10000;i++){
//                        increase();
//                    }
//                }
//            });
//           threads[i].start();
//        }
//        //等待所有累加线程都结束
//        while (Thread.activeCount()>1){
//            Thread.yield();
//        }
//
//        System.out.println(race);
    }
}
