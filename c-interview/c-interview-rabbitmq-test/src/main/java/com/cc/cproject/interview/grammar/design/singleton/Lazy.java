package com.cc.cproject.interview.grammar.design.singleton;

/**
 * @author changcheng
 * @since 2021-05-07 10:29
 */
public class Lazy {

    private static Lazy lazy;

    private Lazy() {
    }

    public static Lazy getInstance(){
        if(lazy==null){
            lazy=new Lazy();
        }
        return lazy;
    }
}
