package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/*
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    public int size;
    Entry<String> root;
    private List<Entry<String>> nodes = new LinkedList<>();

    public CustomTree() {
        this.root = new Entry<>("root");
        nodes.add(root);
        size = 0;
    }

    static class Entry<T> implements  Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;

        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        @Override
        public String toString() {
            return elementName + " - " + parent.elementName;
        }
    }

    @Override
    public boolean remove(Object o) {
        try {
            List<Entry<String>> list = new ArrayList<>();
            String arg = (String) o;
            for (Entry<String> e : nodes) {
                if (e.elementName.equals(arg)) {
                    if (e == e.parent.leftChild) {
                        e.parent.leftChild = null;
                        e.parent.availableToAddLeftChildren = true;
                        e.elementName = null;
                        list.add(e);
                    }
                    if (e == e.parent.rightChild){
                        e.parent.rightChild = null;
                        e.parent.availableToAddRightChildren = true;
                        e.elementName = null;
                        list.add(e);
                    }
                }
            }

            for (Entry<String> e : nodes) {
                if (e != root && e.parent.elementName == null) {
                    list.add(e);
                    e.elementName = null;
                }
            }

            size = size - list.size();
            nodes.removeAll(list);
            return true;
        }
        catch (Exception e) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean add(String s) {
        Entry<String> temp = new Entry<>(s);
        size++;

        for (Entry<String> e : nodes) {
            if (e.isAvailableToAddChildren()) {
                if (e.availableToAddLeftChildren) {
                    e.availableToAddLeftChildren = false;
                    e.leftChild = temp;
                }
                else {
                    e.availableToAddRightChildren = false;
                    e.rightChild = temp;
                }
                temp.parent = e;
                nodes.add(temp);
                return true;
            }
        }


        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    public String getParent(String s) {

        for (Entry<String> e : nodes) {
            if (e.parent != null && e.elementName.equals(s)) return e.parent.elementName;
        }

        return null;
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }


}
