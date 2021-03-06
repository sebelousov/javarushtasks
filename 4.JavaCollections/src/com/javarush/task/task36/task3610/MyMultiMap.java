package com.javarush.task.task36.task3610;

import java.io.Serializable;
import java.util.*;

public class MyMultiMap<K, V> extends HashMap<K, V> implements Cloneable, Serializable {
    static final long serialVersionUID = 123456789L;
    private HashMap<K, List<V>> map;
    private int repeatCount;

    public MyMultiMap(int repeatCount) {
        this.repeatCount = repeatCount;
        map = new HashMap<>();
    }

    @Override
    public int size() {
        //напишите тут ваш код
        return values().size();
    }

    @Override
    public V put(K key, V value) {
        //напишите тут ваш код
        if (map.containsKey(key)) {
            List<V> values = map.get(key);
            int sizeValues = values.size();
            V outValue = values.get(sizeValues - 1);
            if (sizeValues == repeatCount) {
                values.remove(0);
                //size--;
            }
            values.add(value);
            //size++;
            return outValue;
        }
        List<V> values = new ArrayList<>();
        values.add(value);
        map.put(key, values);
        //size++;
        return null;
    }

    @Override
    public V remove(Object key) {
        //напишите тут ваш код
        if (map.containsKey(key)) {
            List<V> values = map.get(key);
            int sizeValues = values.size();
            V valueRemove = values.remove(0);
            //size--;
            if (values.size() == 0) map.remove(key);
            return valueRemove;
        }
        return null;
    }

    @Override
    public Set<K> keySet() {
        //напишите тут ваш код
        return map.keySet();
    }

    @Override
    public Collection<V> values() {
        //напишите тут ваш код
        List<V> values = new ArrayList<>();
        map.values().forEach(values::addAll);
        return values;
    }

    @Override
    public boolean containsKey(Object key) {
        //напишите тут ваш код
        return map.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        //напишите тут ваш код
        List<V> values = new ArrayList<>();
        map.values().forEach(values::addAll);
        return values.contains(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (Map.Entry<K, List<V>> entry : map.entrySet()) {
            sb.append(entry.getKey());
            sb.append("=");
            for (V v : entry.getValue()) {
                sb.append(v);
                sb.append(", ");
            }
        }
        String substring = sb.substring(0, sb.length() - 2);
        return substring + "}";
    }
}