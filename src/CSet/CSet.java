package CSet;


import java.util.Collection;

public class CSet<T> {
  /*********************** FIELDS ***************************/
  private T[] storage;
  int max_size = 0;

  /********************* MEMBERS ***************************/

  /**
   * reallocate memory method
   * @param flag - INC or DEC size of storage
   * @return reallocated storage
   */
  private T[] realloc(boolean flag) {
    T[] tmp = (T[])new Object[max_size];
    if (storage == null) return tmp;
    if (flag) {
      for (int i = 0; i < max_size - 1; ++i)
        if (storage[i] != null)
          tmp[i] = storage[i];
    }
    if (!flag) {
      int ecx = 0;
      for (int i = 0; i <= max_size; ++i)
        if (storage[i] != null) {
          tmp[ecx] = storage[i];
          ecx++;
        }
    }
    return tmp;
  }

  /**
   * check set for emptiness
   * @return boolean value @if empty - true
   */
  public boolean isEmpty() {
    if (max_size == 0)
      return true;
    else
      return false;
  }

  /**
   * whether the set contains a given value
   * @param lhs - value to check
   * @return boolean value @if contain - true
   */
  public boolean contains(T lhs) {
    for (int i = 0; i < max_size; ++i)
      if (storage[i] == lhs)
        return true;
    return false;
  }

  /**
   * get size of set
   * @return count of value in set
   */
  public int size() {
    return max_size;
  }

  /**
   * adds element to set
   * @param lhs - element to add
   * @return boolean value @if success added - true
   */
  public boolean add(T lhs) {
    if (!contains(lhs)) {
      max_size++;
      storage = realloc(true);
      storage[max_size - 1] = lhs;
      return true;
    }
    return false;
  }

  /**
   * remove element from set
   * @param lhs - element to remove
   * @return boolean value @if success removed - true
   */
  public boolean remove(T lhs) {
    if (contains(lhs)) {
      for (int i = 0; i < max_size; ++i)
        if (storage[i] == lhs) {
          max_size--;
          storage[i] = null;
          storage = realloc(false);
        }
        return true;
    }
    return false;
  }

  /**
   * access to the elements of the set by index
   * @param index - index
   * @return set element
   */
  public T at(int index) {
    return storage[index];
  }

  /**
   * delete set
   */
  public void clear() {
    max_size = 0;
    storage = null;
  }

  /**
   * adds Collection values of sets
   * @param c - Collection set
   * @return boolean value @if success added all Collection elements - true
   */
  public boolean addAll(Collection<T> c) {
    if (c.isEmpty())
      return false;
    for (T obj : c)
      add(obj);
    return true;
  }

  /**
   * removes Collection values of sets
   * @param c - Collection set
   * @return boolean value @if success removed all Collection elements - true
   */
  public boolean removeAll(Collection<T> c) {
    if (c.isEmpty())
      return false;
    for (T obj : c)
      remove(obj);
    return true;
  }

  /**
   * intersection of two sets
   * @param c - Collection set
   * @return boolean value @if Collection success modified - true
   */
  public boolean retainAll(Collection<T> c) {
    if (c.isEmpty())
      return false;
    T[] tmp = (T[])new Object[c.size()];
    for (int i = 0; i < c.size(); ++i)
      tmp[i] = (T)c.toArray()[i];
    c.clear();
    for (int i = 0; i < tmp.length; ++i)
      if (contains(tmp[i]))
        c.add(tmp[i]);
    return true;
  }

  /**
   * equality check
   * @param lhs - set for check
   * @return boolean value @if first set is equal to the second
   */
  public boolean equals(CSet<T> lhs) {
    if (lhs.size() != max_size) return false;
    for (int i = 0; i < lhs.size(); ++i)
      if (lhs.at(i) != storage[i]) return false;
    return true;
  }
}
