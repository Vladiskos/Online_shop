package com.java.automation.lab.fall.cehanovich.core22.domain.io;

import java.io.*;

public class ObjectIO<T> {

    public void write(T obj, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(path).getAbsoluteFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T read(String path) {
        try {
            FileInputStream fis = new FileInputStream(new File(path).getAbsoluteFile());
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (T) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
