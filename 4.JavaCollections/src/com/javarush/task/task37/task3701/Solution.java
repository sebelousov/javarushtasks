package com.javarush.task.task37.task3701;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/* 
Круговой итератор
*/
public class Solution<T> extends ArrayList<T> {
    public static void main(String[] args) {
        Solution<Integer> list = new Solution<>();
        list.add(1);
        list.add(2);
        list.add(3);

        int count = 0;
        for (Integer i : list) {
            //1 2 3 1 2 3 1 2 3 1
            System.out.print(i + " ");
            count++;
            if (count == 10) {
                break;
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new RoundIterator();
    }

    public class RoundIterator<E> implements Iterator<E> {
        Iterator<T> iterator = Solution.super.iterator();
        int cursor;

        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }

        @Override
        public E next() {
            E out = (E) iterator.next();

            try {
                Field fieldCursor = iterator.getClass().getDeclaredField("cursor");
                fieldCursor.setAccessible(true);
                if (fieldCursor.getInt(iterator) == Solution.super.size()) {
                    fieldCursor.set(iterator, 0);
                }
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

            return out;
        }

        @Override
        public void remove() {
            iterator.remove();
        }

        @Override
        public void forEachRemaining(Consumer<? super E> action) {
            iterator.forEachRemaining((Consumer<? super T>) action);
        }
    }
}
