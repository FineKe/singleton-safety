package com.fine.reflect;

/**
 * 单例
 * volatile 双重校验
 *
 * @author finefine at: 2019-05-02 22:22
 */
public class Singleton {
    private volatile static Singleton INSTANCE;

    private Singleton() {

    }

    public static Singleton getInstance() {

        if (INSTANCE==null){

            //同步代码块
            synchronized (Singleton.class){
                if (INSTANCE == null) {
                    INSTANCE = new Singleton();
                }
            }

        }
        return INSTANCE;
    }

}
