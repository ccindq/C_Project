package com.cc.cproject.interview.grammar.design.singleton;

/**
 * @author changcheng
 * @since 2021-05-07 10:30
 */
public class DuobleCheck {

    private volatile static DuobleCheck duobleCheck;

    private DuobleCheck() {
    }
    //双重检测模式的懒汉式单例 ，即DCL懒汉式
    //不是一个原子性操作
    /**
     * 1.分配对象内存空间
     * 2.执行构造方法，初始化对象
     * 3.把这个对象指向这个刚分配的空间
     * 但是在2、3部之间可能会被重排序，造成创建对象顺序变为1-3-2。
     *
     * 123 A
     * 132 B
     * 此时lazyMan还没有完成构造
     **/
    //对于JVM而言，它执行的是一个个Java指令。在Java指令中创建对象和赋值操作是分开进行的，
    //也就是说instance = new Singleton();语句是分两步执行的。
    //但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，
    //然后直接赋值给instance成员，然后再去初始化这个Singleton实例。(即先赋值指向了内存地址，再初始化)这样就使出错成为了可能，我们仍然以A、B两个线程为例：
    //
    //A、B线程同时进入了第一个if判断
    //A首先进入synchronized块，由于instance为null，所以它执行instance = new Singleton();
    //由于JVM内部的优化机制，JVM先画出了一些分配给Singleton实例的空白内存，并赋值给instance成员（注意此时JVM没有开始初始化这个实例），然后A离开了synchronized块。
    //B进入synchronized块，由于instance此时不是null，因此它马上离开了synchronized块并将结果返回给调用该方法的程序。
    //此时B线程打算使用Singleton实例，却发现它没有被初始化，于是错误发生了。
    public static DuobleCheck getInstance() {
        if (duobleCheck == null) {
            synchronized (DuobleCheck.class) {
                if (duobleCheck == null) {
                    duobleCheck = new DuobleCheck();
                }
            }
        }
        return duobleCheck;
    }

}
