package com.cc.interview.design.singleton;

/**
 * @author changcheng
 * @since 2021-05-07 10:40
 * JVM内部的机制能够保证当一个类被加载的时候，这个类的加载过程是线程互斥的。
 * 这样当我们第一次调用getInstance的时候，JVM能够帮我们保证instance只被创建一次，
 * 并且会保证把赋值给instance的内存初始化完毕，这样我们就不用担心双重检查锁定中的问题。
 * 此外该方法也只会在第一次调用的时候使用互斥机制，这样就解决了使用Class锁机制中的低效问题。
 *
 * 最后instance是在第一次加载SingletonContainer类时被创建的，而SingletonContainer类则在调用getInstance方法的时候才会被加载，因此也实现了惰性加载。
 */
public class InnerClass {
    private InnerClass() {
    }

    public static InnerClass getInstance() {
        return SingletonClass.INNER_CLASS;
    }

    public static class SingletonClass {
        private static final InnerClass INNER_CLASS = new InnerClass();
    }
}
