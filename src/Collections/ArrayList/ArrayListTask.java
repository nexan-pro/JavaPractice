package Collections.ArrayList;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

class Checkroom implements Comparable<Checkroom> {
  String[] init = new String[3];
  int cntGoods;
  int totalWeight;
  static int totalBaggageWeight; // our set weight

  void setTotalWeight(int i) {
    totalBaggageWeight = i;
  }

  @Override
  public String toString() {
    return (init[0] + " " + init[1] + " " + init[2] + "\r\ncntGoods: "
      + cntGoods + " totalWeight: " + totalWeight + "\r\n---------------------------\r\n");
  }

  public int compareTo(Checkroom lhs) {
    int compareGoods = lhs.cntGoods;
    return this.cntGoods - compareGoods;
  }
}

public class ArrayListTask {
  public static void main(String[] args) throws IOException {
    FileInputStream in = new FileInputStream("src/Collections/ArrayList/input.txt");
    BufferedReader in_buf = new BufferedReader(new InputStreamReader(in));
    String line;
    ArrayList<Checkroom> obj_arr = new ArrayList<>();
    int size = 4;
    Checkroom[] obj = new Checkroom[size];
    for (int i = 0; i < size; i++)
      obj[i] = new Checkroom(); //initialize all objects
    int ecx = 0;
    while ((line = in_buf.readLine()) != null) {
      String[] words = line.split(" ");
      for (int i = 0; i < 3; ++i)
        obj[ecx].init[i] = words[i];
      obj[ecx].cntGoods = Integer.parseInt(words[3]);
      obj[ecx].totalWeight = Integer.parseInt(words[4]);
      obj_arr.add(ecx, obj[ecx]);
      ecx++;
    }
    obj[0].setTotalWeight(35);
    obj_arr.removeIf(new Predicate<Checkroom>() {
      @Override
      public boolean test(Checkroom checkroom) {
        if (checkroom.totalWeight > Checkroom.totalBaggageWeight)
          return false;
        return true;
      }
    });
    Collections.sort(obj_arr);
    String info = obj_arr.toString();
    writeToFile("src/Collections/ArrayList/output.txt", info);
  }
  public static FileWriter writeToFile(String pathToFile, String content) throws IOException {
    String rez = content.replaceAll("[^A-Za-zA-Яа-я0-9 \\: ] ", "");
    FileWriter outputFile = new FileWriter(pathToFile);
    BufferedWriter outputBuffer = new BufferedWriter(outputFile);
    outputBuffer.write(rez);
    outputBuffer.close();
    outputFile.close();
    return (outputFile);
  }
}
