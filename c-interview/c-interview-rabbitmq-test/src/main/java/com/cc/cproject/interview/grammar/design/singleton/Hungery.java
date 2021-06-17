package com.cc.cproject.interview.grammar.design.singleton;

/**
 * @author changcheng
 * @since 2021-05-07 10:29
 */
public class Hungery {

    private static Hungery hungery=new Hungery();

    private Hungery() {
    }

    public static Hungery getSingleton(){
        return  hungery;
    }
}
