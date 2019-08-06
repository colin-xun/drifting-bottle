package com.moudao.util;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 获取对象的地址值
 * author: MrWang
 * date: 2018/4/6 17:10
 */
public class AddressUtil {
    private static Unsafe unsafe;

    static{
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Long getAddress(Object o) {
        Object[] objects = new Object[]{0};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long address;
        switch (addressSize) {
            case 4:
                address = unsafe.getInt(objects, baseOffset);
                break;
            case 8:
                address = unsafe.getLong(objects, baseOffset);
                break;
            default:
                address = -1;
        }
        return address;
    }
}
