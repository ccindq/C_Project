package com.cc.interview.threads.callable;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author changcheng
 * @since 2021-04-29 17:28
 */
public class CallableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService pool= Executors.newFixedThreadPool(5);
        List<Future> list=new ArrayList<>();

        for(int i=0;i<5;i++){
            Callable callable=new CallableEntity();
            System.out.println("--------1-----");
            Future f=pool.submit(callable);
            System.out.println(f.get().toString());
            list.add(f);
            System.out.println("--------2--------");
        }
        System.out.println("--------3--------");
        pool.shutdown();
        for(Future f:list){
            System.out.println(""+f.get().toString());
        }

    }
}
