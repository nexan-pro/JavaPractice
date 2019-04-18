package Pets;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PetDispatcherTest {

  @Test
  void countOfDiffKind() throws IOException {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    assertEquals(handle.countOfDiffKind(), 4);
  }

  @Test
  void init() throws IOException {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
  }

  @Test
  void printOwners() throws IOException {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    handle.printOwners("dog");
  }

  @Test
  void checkNickname() throws IOException {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    assertEquals(handle.checkNickname("muhtar"), 2);
  }

  @Test
  void printOldestAndYoungest() throws IOException {
    PetDispatcher handle = new PetDispatcher();
    handle.init();
    handle.printOldestAndYoungest();
  }
}