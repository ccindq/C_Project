package com.cc.interview.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author changcheng
 * @since 2021-02-22 11:20
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args){
        List<OOMObject> list=new ArrayList();
        while(true){
            list.add(new OOMObject());
        }
    }
}
