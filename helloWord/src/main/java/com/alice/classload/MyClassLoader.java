package com.alice.classload;

import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            //1.获取文件名称
            String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
            //2.读取文件名称
            InputStream resourceAsStream = this.getClass().getResourceAsStream(fileName);
            //3.读取字节
            byte[] bytes = new byte[resourceAsStream.available()];
            resourceAsStream.read(bytes);
            return defineClass(name, bytes, 0, bytes.length);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
