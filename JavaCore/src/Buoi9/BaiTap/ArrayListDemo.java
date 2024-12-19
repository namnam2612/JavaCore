package Buoi9.BaiTap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayListDemo<T> implements ListDemo<T> {

    private List<T> array;

    public ArrayListDemo() {
        array = new ArrayList<>();
    }

    @Override
    public boolean add(T t) {
        return array.add(t);
    }

    @Override
    public boolean remove(T t) {
        return array.remove(t);
    }

    @Override
    public boolean contains(T t) {
        return array.contains(t);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T get(int index) {
        return array.get(index);
    }
}
