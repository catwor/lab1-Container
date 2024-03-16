package org.lab1.storage;

public interface List<T> {
  boolean isEmpty();
  Integer size();
  void add(T object);
  void add(Integer index, T object);
  void remove(Integer index);
  void remove(T object);
  T get(Integer index);
  Integer get(T object);
  void clear();
}
