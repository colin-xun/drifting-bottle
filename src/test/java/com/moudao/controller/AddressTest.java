package com.moudao.controller;

import com.moudao.util.AddressUtil;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 测试获取对象的地址
 * author: MrWang
 * date: 2018/4/6 16:55
 */
public class AddressTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        String s1 = new String("abc");
        String s2 = new String("abc");
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println(s1 == s2);

        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
//        Unsafe unsafe = (Unsafe) field.get(String.class);
        Unsafe unsafe = (Unsafe) field.get(null);
        Object[] array = new Object[]{s1};
        long offset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long s1Address;
        switch (addressSize) {
            case 4:
                s1Address = unsafe.getInt(array, offset);
                break;
            case 8:
                s1Address = unsafe.getLong(array, offset);
                break;
            default:
                    s1Address = -1;
        }
        System.out.println(s1Address);

        Field field1 = Unsafe.class.getDeclaredField("theUnsafe");
        field1.setAccessible(true);
        Unsafe unsafe1 = (Unsafe) field1.get(null);
        Object[] array1 = new Object[]{s2};
        long offset1 = unsafe1.arrayBaseOffset(Object[].class);
        int addressSize1 = unsafe1.addressSize();
        long s1Address1;
        switch (addressSize1) {
            case 4:
                s1Address1 = unsafe1.getInt(array1, offset1);
                break;
            case 8:
                s1Address1 = unsafe1.getLong(array1, offset1);
                break;
            default:
                s1Address1 = -1;
        }
        System.out.println(s1Address1);

    }

}
