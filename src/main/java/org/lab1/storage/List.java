package org.lab1.storage;

import java.util.NoSuchElementException;

public class List<T> implements IList<T> {
  private Node<T> head;
  private int size;

  public List() {
    this.head = null;
    this.size = 0;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public Integer size() {
    return size;
  }

  @Override
  public void add(T object) {
    add(size, object);
  }

  @Override
  public void add(Integer index, T object) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException("ERROR: Index out of bounds");
    }

    Node<T> newNode = new Node<>(object);
    if (isEmpty() || index == 0) {
      newNode.next = head;
      head = newNode;
    } else {
      Node<T> prev = getNodeAtIndex(index - 1);
      newNode.next = prev.next;
      prev.next = newNode;
    }
    size++;
  }

  @Override
  public void remove(Integer index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERROR: Index out of bounds");
    }

    if (index == 0) {
      head = head.next;
    } else {
      Node<T> prev = getNodeAtIndex(index - 1);
      prev.next = prev.next.next;
    }
    size--;
  }

  @Override
  public void remove(T object) {
    Node<T> tmp = head;
    Node<T> prev = null;

    while (tmp != null) {
      if (tmp.data.equals(object)) {
        if (prev == null) {
          head = tmp.next;
        } else {
          prev.next = tmp.next;
        }
        size--;
        return;
      }
      prev = tmp;
      tmp = tmp.next;
    }

    throw new NoSuchElementException("ERROR: Element not found");
  }

  @Override
  public T get(Integer index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException("ERROR: Index out of bounds");
    }
    return getNodeAtIndex(index).data;
  }

  @Override
  public Integer get(T object) {
    Node<T> tmp = head;
    int index = 0;

    while (tmp != null) {
      if (tmp.data.equals(object)) {
        return index;
      }
      tmp = tmp.next;
      index++;
    }

    throw new NoSuchElementException("ERROR: Element not found");
  }

  @Override
  public void clear() {
    head = null;
    size = 0;
  }
  private static class Node<T> {
    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }
  }
  private Node<T> getNodeAtIndex(Integer index) {
    Node<T> tmp = head;
    for (int i = 0; i < index; i++) {
      tmp = tmp.next;
    }
    return tmp;
  }
}
