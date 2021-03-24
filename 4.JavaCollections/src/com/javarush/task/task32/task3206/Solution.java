package com.javarush.task.task32.task3206;

import java.lang.reflect.Proxy;
import java.util.*;

/*
Дженерики для создания прокси-объекта
*/
public class Solution<T> {

    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Solution solution = new Solution();
        test(solution.getProxy(Item.class));                        //true false false
        test(solution.getProxy(Item.class, Small.class));           //true false true
        test(solution.getProxy(Item.class, Big.class, Small.class));//true true true
        test(solution.getProxy(Big.class, Small.class));            //true true true т.к. Big наследуется от Item
        test(solution.getProxy(Big.class));                         //true true false т.к. Big наследуется от Item
    }

    public <T extends Item> T getProxy(Class<T> itemClass, Class<?>... args) throws IllegalAccessException, InstantiationException {
        Class<?>[] interfaces = new Class[args.length + 1];
        System.arraycopy(args, 0, interfaces, 0, args.length);
        interfaces[interfaces.length - 1] = itemClass;
        return (T) Proxy.newProxyInstance(itemClass.getClassLoader(), interfaces, new ItemInvocationHandler());
    }


    private static void test(Object proxy) {
        boolean isItem = proxy instanceof Item;
        boolean isBig = proxy instanceof Big;
        boolean isSmall = proxy instanceof Small;

        System.out.format("%b %b %b\n", isItem, isBig, isSmall);
    }
}