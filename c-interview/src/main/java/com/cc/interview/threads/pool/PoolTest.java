package com.cc.interview.threads.pool;


import com.cc.interview.threads.callable.CallableEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author changcheng
 * @since 2021-05-03 19:49
 */
public class PoolTest {

    public static final Integer THREAD_NUM = 2;
    private static ThreadPoolExecutor pool = new ThreadPoolExecutor(THREAD_NUM, THREAD_NUM * 2, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(100));

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        List<Future<Integer>> result=new ArrayList<>();

        for(int i=0;i<THREAD_NUM;i++){
          Future<Integer> future=  pool.submit(new CallableEntity());
          result.add(future);
        }

        for(Future<Integer> f:result){
            System.out.println(f.get().toString());
        }

    }


}
