package com.jmzombe.generics;

import java.util.List;

public interface BaseDao<T> {
    public T get(int id);
    public List<T> list();
    public int add(T t);
    public void update(T t);
    public void delete(int id);
}