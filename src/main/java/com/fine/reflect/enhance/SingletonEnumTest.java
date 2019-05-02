package com.fine.reflect.enhance;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author finefine at: 2019-05-03 00:50
 */
public class SingletonEnumTest {

    public static void main(String[] args) {
        SingletonEnum singletonEnum = SingletonEnum.INSTANCE;

        Class clazz = singletonEnum.getClass();
        try {
            Constructor<Singleton> constructor = clazz.getDeclaredConstructors()[0];

            //设置允许访问私有的构造器
            constructor.setAccessible(true);
            Singleton singleton1 = constructor.newInstance();

            if (singleton1 != null && singleton1.getClass().equals(singletonEnum.getClass())) {
                System.out.println("通过反射构造除了对象");
            } else {
                return;
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }
}
