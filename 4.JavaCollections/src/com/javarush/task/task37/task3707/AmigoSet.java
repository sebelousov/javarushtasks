package com.javarush.task.task37.task3707;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

public class AmigoSet<E> extends AbstractSet implements Serializable, Cloneable, Set {
    private static final Object PRESENT = new Object();
    private transient HashMap<E, Object> map;

    public AmigoSet() {
        this.map = new HashMap<>();
    }

    public AmigoSet(Collection<? extends E> collection) {
        this.map = new HashMap<>((int)Math.max(16, Math.ceil(collection.size()/.75f)));
        for (E e : collection) {
            map.put(e, PRESENT);
        }
    }

    @Override
    public boolean add(Object e) {
        return map.put((E) e, PRESENT) == null;
    }

    @Override
    public Iterator iterator() {
        return map.keySet().iterator();
    }

    @Override
    public int size() {
        return map.size();
    }

    @Override
    public boolean isEmpty() {
        return map.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return map.containsKey(o);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public boolean remove(Object o) {
        return null == map.remove(o);
    }

    @Override
    public Object clone() {
        AmigoSet amigoSet;

        try {
            amigoSet = (AmigoSet) super.clone();
            amigoSet.map = (HashMap) map.clone();
            return amigoSet;
        }
        catch (Exception e){
            throw new InternalError();
        }
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        int capacity = (int) HashMapReflectionHelper.callHiddenMethod(map, "capacity");
        float loadFactor = (float) HashMapReflectionHelper.callHiddenMethod(map, "loadFactor");
        Set<E> set = map.keySet();

        out.defaultWriteObject();
        out.writeInt(capacity);
        out.writeFloat(loadFactor);
        out.writeInt(set.size());

        for (E e : set) {
            out.writeObject(e);
        }

        System.out.println("Запись завершена - " + capacity + " - " + loadFactor);

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();

        int capacity = in.readInt();
        float loadFactor = in.readFloat();
        int size = in.readInt();

        map = new HashMap<>(capacity, loadFactor);

        for (int i = 0; i < size; i++) {
            map.put((E) in.readObject(), PRESENT);
        }
    }
}
