package WorkWithFiles.Binary;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Bin {
  final static String FILE_NAME = "src/WorkWithFiles/Binary/example.dat";
  public static void main(String[] args) throws IOException {
    FileOutputStream out = new FileOutputStream(FILE_NAME);
    int n = 11;
    String line = "";
    for (int i = 1; i <= n; i++)
      line += "1/" + i + " ";
    byte[] out_data = line.getBytes();
    out.write(out_data, 0, out_data.length);
    out.flush(); // clear buffered output bytes
    out.close();

    byte[] in_data = Files.readAllBytes(Paths.get(FILE_NAME));
    String inline = new String(in_data);
    String[] formatted = inline.split(" ");
    for (int i = 0; i < formatted.length; ++i)
      if (i % 3 == 0)
        System.out.println(formatted[i]);
  }
}
