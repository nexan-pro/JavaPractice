package Pets;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PetDispatcherTest {

  @Test
  void countOfDiffKind() {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    assertEquals(handle.countOfDiffKind(), 4);
  }

  @Test
  void init() {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
  }

  @Test
  void printOwners() {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    handle.printOwners("dog");
  }

  @Test
  void checkNickname() {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    assertEquals(handle.checkNickname("muhtar"), 2);
  }

  @Test
  void printOldestAndYoungest() {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    handle.printOldestAndYoungest();
  }
}