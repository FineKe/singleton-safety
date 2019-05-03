package com.fine.serialize;

import java.io.*;

/**
 * @author finefine at: 2019-05-03 21:50
 */
public class DeSerailizeAttackTest {

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("object"));
             ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("object"))) {

            //将对象持久化到磁盘中
            outputStream.writeObject(singleton);
            outputStream.flush();

            //从磁盘中反序列化成对象
            Singleton singleton1 = (Singleton) inputStream.readObject();

            if (singleton == singleton1) {
                System.out.println("是同一个对象");
            } else {
                System.out.println("是两个不同的对象");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
