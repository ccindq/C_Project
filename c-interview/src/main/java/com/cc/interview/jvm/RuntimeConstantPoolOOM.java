package com.cc.interview.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changcheng
 * @since 2021-02-22 17:24
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args){
        List<String> list=new ArrayList<String>();
        int i = 0;
        while(true){
            list.add(String.valueOf(i++).intern());
        }
    }
}
