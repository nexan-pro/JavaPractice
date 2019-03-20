package Pets;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

class FileHelper {
  private int cntOfLines = 0;
  private String[] contentOfFile = new String[10000];
  String[] readFile() {
    try {
      FileInputStream fstream = new FileInputStream("src/Pets/input.txt");
      BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
      String line;
      while ((line = br.readLine()) != null) {
        contentOfFile[cntOfLines] = "";
        contentOfFile[cntOfLines++] += line;
      }
    } catch(IOException e) {
      System.out.println(e.getMessage());
    }
    return contentOfFile;
  }

  int getCntOfLines() { return cntOfLines; }
}
