package com.cc.cproject.interview.grammar.threads.callable;

import java.util.concurrent.Callable;

/**
 * @author changcheng
 * @since 2021-04-29 17:26
 */
public class CallableEntity implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {
        Thread.sleep(5000);
        return 5;
    }

}
