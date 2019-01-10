package CSet;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class CSetTest {

  CSet<Integer> getSet() {
    CSet<Integer> set = new CSet<Integer>();
    set.add(1);
    set.add(3);
    set.add(3);
    set.add(7);
    return set;
  }

  Vector<Integer> getCollection() {
    Vector<Integer> vec = new Vector<>();
    vec.add(3);
    vec.add(4);
    vec.add(7);
    vec.add(2);
    return vec;
  }

  void assertEqualsSet(Integer[] expected, CSet<Integer> lhs) {
    assertEquals(expected.length, lhs.size());
    for (int i = 0; i < expected.length; ++i)
      assertEquals(expected[i], lhs.at(i));
  }

  void assertEqualsCollection(Integer[] expected, Collection<Integer> c) {
    assertEquals(expected.length, c.size());
    for (int i = 0; i < expected.length; ++i) {
      assertEquals(expected[i], c.toArray()[i]);
    }
  }

  @BeforeEach
  void setUp() {
  }

  @AfterEach
  void tearDown() {
  }

  @Test
  void isEmpty() {
    CSet<Integer> actual = getSet();
    actual.clear();
    assertTrue(actual.isEmpty());
  }

  @Test
  void contains() {
    CSet<Integer> actual = getSet();
    assertTrue(actual.contains(3));
  }

  @Test
  void size() {
    CSet<Integer> actual = getSet();
    int expected = 3;
    assertEquals(expected, actual.size());
  }

  @Test
  void add() {
    CSet<Integer> actual = getSet();
    Integer[] expected = { 1, 3, 7 };
    assertEqualsSet(expected, actual);
  }

  @Test
  void remove() {
    CSet<Integer> actual = getSet();
    actual.remove(3);
    Integer[] expected = { 1, 7 };
    assertEqualsSet(expected, actual);
  }

  @Test
  void at() {
    CSet<Integer> actual = getSet();
    Integer expected = 7;
    assertEquals(expected, actual.at(2));
  }

  @Test
  void clear() {
    CSet<Integer> actual = getSet();
    actual.clear();
    assertTrue(actual.isEmpty());
  }

  @Test
  void addAll() {
    Vector<Integer> vec = getCollection();
    CSet<Integer> actual = getSet();
    Integer[] expected = { 1, 3, 7, 4, 2 };
    actual.addAll(vec);
    assertEqualsSet(expected, actual);
  }

  @Test
  void removeAll() {
    Vector<Integer> vec = getCollection();
    CSet<Integer> actual = getSet();
    Integer[] expected = { 1 };
    actual.removeAll(vec);
    assertEqualsSet(expected, actual);
  }

  @Test
  void retainAll() {
    Vector<Integer> vec = getCollection();
    CSet<Integer> actual = getSet();
    Integer[] expected = { 3, 7 };
    actual.retainAll(vec);
    assertEqualsCollection(expected, vec);
  }

  @Test
  void equals() {
    CSet<Integer> actual = getSet();
    CSet<Integer> expected = getSet();
    assertTrue(actual.equals(expected));
  }
}