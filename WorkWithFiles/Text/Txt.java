package WorkWithFiles.Text;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Txt {
  final static String FILE_NAME = "src/WorkWithFiles/Text/example.txt";
  public static void main(String[] args) throws IOException {
    int[] lengths = getLengths();
    int max = getMax(lengths);
    String longestString = findString(max);
    System.out.println("Content of line: " + longestString + "Length: " + longestString.length());
  }

  private static int getCountOfLines() throws IOException {
    FileInputStream in = new FileInputStream(FILE_NAME);
    BufferedReader buf = new BufferedReader(new InputStreamReader(in));
    int countOfLines = 0;
    while (buf.readLine() != null)
      countOfLines++;
    buf.close();
    in.close();
    return countOfLines;
  }

  private static int[] getLengths() throws  IOException {
    FileInputStream in = new FileInputStream(FILE_NAME);
    BufferedReader buf = new BufferedReader(new InputStreamReader(in));
    int i = 0;
    String tmp = "";
    int[] lengths = new int[getCountOfLines()];
    while ((tmp = buf.readLine()) != null) {
      lengths[i] = tmp.length();
      i++;
    }
    buf.close();
    in.close();
    return lengths;
  }

  private static String findString(int max) throws IOException {
    FileInputStream in = new FileInputStream(FILE_NAME);
    BufferedReader buf = new BufferedReader(new InputStreamReader(in));
    String tmp = "", rez = "";
    while((tmp = buf.readLine()) != null) {
      if (tmp.length() == max)
        rez += tmp + "\n";
    }
    return rez;
  }

  private static int getMax(int[] array) {
    int max = array[0];
    for (int i = 0; i < array.length; i++)
      if (array[i] > max)
        max = array[i];
      return max;
  }
}
