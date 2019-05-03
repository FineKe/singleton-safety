package com.fine.serialize;

import java.io.Serializable;

/**
 * 单例
 * volatile 双重校验
 *
 * @author finefine at: 2019-05-03 21:43
 */
public class Singleton implements Serializable {

    private static final long serialVersionUID = 1L;


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

    private Object readResolve() {
        return INSTANCE;
    }
}
