package com.cc.interview.basicgrammar.volatiledemo;

/**
 * @author changcheng
 * @since 2021-02-23 15:24
 */
public class VolatileUseCase {

    volatile boolean shutdownRequested;

    public void shundown(){
        shutdownRequested=true;
    }

    public void doWork(){
        while(!shutdownRequested){
            //do stuff
        }
    }
}
