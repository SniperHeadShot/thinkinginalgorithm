package com.bat.data.structure;

/**
 * 通用测试类
 *
 * @author ZhengYu
 * @version 1.0 2020/6/3 11:38
 **/
public class CommonTestMain {

    public static void add(Byte b)
    {
        b = b++;
    }

    public static void main(String[] args) {
        Byte a = 127;
        Byte b = 127;
        add(++a);
        System.out.print(a + " ");
        add(b);
        System.out.print(b + "");
    }
}
