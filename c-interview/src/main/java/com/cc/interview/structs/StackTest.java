package com.cc.interview.structs;

/**
 * @author changcheng
 * @since 2021-01-25 10:07
 */
public class StackTest<E> {




    E frist;

    E last;

    E next;

    //链表，先进先出
    public E pop(){
       return last;
    }

    public void push(E objcet){
       last=objcet;
    }

}
