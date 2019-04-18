package Pets;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.*;


class PetDispatcher {

  private Pet[] pets;

  /**
   * @brief initialize main pets storage and process strings
   */
  void init() throws IOException {
    try {
      Gson gson = new Gson();
      String name = gson.fromJson("name", String.class);
      pets = gson.fromJson(new FileReader("/home/gilgamesh/Projects/java/JavaPractice/src/Pets/sample.json"), Pet[].class);
      /* Parse owners info from txt file
      System.out.println("name from json is: " + name);
      FileHelper hFile = new FileHelper();
      String[] contentOfFile = hFile.readFile();
      pets = new Pet[hFile.getCntOfLines()];

      if (contentOfFile.length == 0) throw new NullPointerException("Error, file is empty!");

      for (int i = 0; i < hFile.getCntOfLines(); i++) {
        String[] formatted = contentOfFile[i].split(", ");
        pets[i] = new Pet(formatted[0], formatted[1], formatted[2], Integer.parseInt(formatted[3]));
      }*/

    } catch(NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * @brief count the numbers of diff kind of animals
   * @return size of set
   */
  int countOfDiffKind() {
    try {
      if (pets == null) throw new NullPointerException("Error, need to call init method!");
      Map<Integer, String> allOwners = new HashMap<>();
      int ecx = 0;

      for (int i = 0; i < pets.length; i++) {
        if (!allOwners.containsValue(pets[i].ownerSurname)) {
          allOwners.put(ecx, pets[i].ownerSurname);
          ecx++;
        }
      }

      for (int i = 0; i < ecx; i++) {
        Set<String> set = new HashSet<>();
        for (int j = 0; j < pets.length; j++)
          if (allOwners.get(i).equals(pets[j].ownerSurname))
            set.add(pets[j].kind);

        System.out.println("[" + allOwners.get(i) + "] Count of diff kinds: " + set.size());
        set.clear();
      }

      Set<String> set = new HashSet<>();
      for (int i = 0; i < pets.length; i++)
        set.add(pets[i].kind);
      System.out.println("Count of different kinds: " + set.size());
      return set.size();
    } catch(NullPointerException e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  /**
   * @param kind - kind of animal which we wanna print owners and nicknames
   */
  void printOwners(String kind) {
    try {
      if (pets == null) throw new NullPointerException("Error, need to call init method!");
      Set<String> set = new HashSet<>();
      for (int i = 0; i < pets.length; i++) {
        if (pets[i].kind.equals(kind)) {
          set.add(pets[i].ownerSurname);
          set.add(pets[i].nickname);
        }
      }
      System.out.println("Owners and nicknames: ");
      System.out.println(set);
    } catch(NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }

  /**
   * @brief fetch the number of animals bearing this name
   * @param nick - animal nickname
   * @return size of set
   */
  int checkNickname(String nick) {
    try {
      if (pets == null) throw new NullPointerException("Error, need to call init method!");
      Set<String> set = new HashSet<>();
      for (int i = 0; i < pets.length; i++)
        if (pets[i].nickname.equals(nick))
          set.add(pets[i].kind);
      return set.size();
    } catch(NullPointerException e) {
      System.out.println(e.getMessage());
    }
    return 0;
  }

  /**
   * @brief print info about the age of the oldest and youngest kind of animal
   */
  void printOldestAndYoungest() {
    try {
      if (pets == null) throw new NullPointerException("Error, need to call init method!");
      Map<Integer, String> allKinds = new HashMap<>();
      int cntOfDiffKinds = 0;
      for (int i = 0; i < pets.length; i++)
        if (!allKinds.containsValue(pets[i].kind)) {
          allKinds.put(cntOfDiffKinds, pets[i].kind);
          cntOfDiffKinds++;
        }

      for (int i = 0; i < cntOfDiffKinds; i++) {
        int[] ages = new int[10000];
        int cntOfKindPets = 0;
        for (int j = 0; j < pets.length; j++) {
          if (allKinds.get(i).equals(pets[j].kind)) {
            ages[cntOfKindPets] = pets[j].age;
            cntOfKindPets++;
          }
        }
        ages = bubble_sort(ages, cntOfKindPets);
        System.out.println("Kind: " + allKinds.get(i) + ", Oldest age: " + ages[0] +
            ", Youngest age: " + ages[cntOfKindPets - 1]);
      }
    } catch(NullPointerException e) {
      System.out.println(e.getMessage());
    }
  }


  /**
   * @see https://en.wikipedia.org/wiki/Bubble_sort
   * @param arr - array which we want to sort
   * @param cntOfElm - count of elements in input array
   * @return - modified array
   */
  private int[] bubble_sort(int[] arr, int cntOfElm) {
    for (int i = 0; i < cntOfElm; i++) {
      for (int j = i + 1; j < cntOfElm; j++) {
        if (arr[i] < arr[j]) {
          int tmp = arr[i];
          arr[i] = arr[j];
          arr[j] = tmp;
        }
      }
    }
    return arr;
  }

}

class Pet {
  String ownerSurname;
  String kind;
  String nickname;
  int age;

  Pet(String ownerSurname, String kind, String nickname, int age) {
    this.ownerSurname = ownerSurname;
    this.kind = kind;
    this.nickname = nickname;
    this.age = age;
  }
}