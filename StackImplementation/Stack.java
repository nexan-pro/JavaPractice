package StackImplementation;

public class Stack<T> {
  private int maxSize;
  private T[] storage;
  private int top;

  public Stack(int size) {
    maxSize = size;
    storage = (T[])new Object[maxSize];
    top = -1;
  }

  public void push(T value) {
    storage[++top] = value;
  }

  public T pop() {
    return storage[top--];
  }

  public T top() {
    if (storage[top] == null)
      return storage[--top];
    return storage[top];
  }

  public boolean empty() {
    return top == -1;
  }

  public long size() {
      return ++top;
  }

  public void swap(Stack<T> obj) {
    T[] tmp = obj.storage;
    obj.storage = storage;
    storage = tmp;
    int tmp_maxSize = obj.maxSize;
    obj.maxSize = obj.storage.length;
    maxSize = tmp_maxSize;
    int tmp_top = obj.top;
    obj.top = top;
    top = tmp_top;
  }
}
