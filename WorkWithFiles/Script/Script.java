package WorkWithFiles.Script;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Script {
  static final String NAME_OF_FIRST_FILE = "src/WorkWithFiles/Script/K1/t1.txt";
  static final String NAME_OF_SECOND_FILE = "src/WorkWithFiles/Script/K1/t2.txt";
  static final String NAME_OF_THIRD_FILE = "src/WorkWithFiles/Script/K1/t3.txt";

  public static void main(String[] args) throws IOException {
    File K1 = new File("src/WorkWithFiles/Script/K1");
    File K2 = new File("src/WorkWithFiles/Script/K2");
    if (!K1.exists() && !K2.exists()) {
      if (K1.mkdir() && K2.mkdir())
        System.out.println("Directory is created!");
      else
        System.out.println("Failed to create directory!");

      FileOutputStream t1 = new FileOutputStream(NAME_OF_FIRST_FILE);
      byte[] contentOfT1 = "Иванов Иван Иванович, 1965 года рождения, место жительства г. Саратов".getBytes();
      t1.write(contentOfT1);
      checkFile(NAME_OF_FIRST_FILE);
//      t1.close();

      FileOutputStream t2 = new FileOutputStream(NAME_OF_SECOND_FILE);
      byte[] contentOfT2 = "Петров Сергей Федорович, 1966 года рождения, место жительства г.Энгельс".getBytes();
      t2.write(contentOfT2);
      checkFile(NAME_OF_SECOND_FILE);
//      t2.close();

      FileOutputStream t3 = new FileOutputStream(NAME_OF_THIRD_FILE);
      byte[] readDataFromT1 = Files.readAllBytes(Paths.get(NAME_OF_FIRST_FILE));
      t3.write(readDataFromT1);
      byte[] readDataFromT3 = Files.readAllBytes(Paths.get(NAME_OF_THIRD_FILE));
      byte[] readDataFromT2 = Files.readAllBytes(Paths.get(NAME_OF_SECOND_FILE));
      byte[] contentOfT3 = new byte[readDataFromT3.length + readDataFromT2.length];
      System.arraycopy(readDataFromT3, 0, contentOfT3, 0, readDataFromT3.length);
      System.arraycopy(readDataFromT2, 0, contentOfT3, readDataFromT3.length, readDataFromT2.length);
      t3.write(contentOfT3);
      t1.close();
      t2.close();
      t3.close();
      Files.move(Paths.get(NAME_OF_SECOND_FILE), Paths.get("src/WorkWithFiles/Script/K2/t2.txt"), StandardCopyOption.REPLACE_EXISTING);
      Files.copy(Paths.get(NAME_OF_FIRST_FILE), Paths.get("src/WorkWithFiles/Script/K2/t1.txt"), StandardCopyOption.COPY_ATTRIBUTES);

      final String newName = "ALL";
      File newDir = new File(K2.getParent() + "/" + newName);
      K2.renameTo(newDir);
      deleteDirectory(K1);
      System.out.println("Folder ALL contain: ");
      showFiles(newDir);
    }
  }

  private static void checkFile(final String filename) {
    final File file = new File(filename);
    if (file.exists())
      System.out.println(filename + " was created.");
    else
      System.out.println(filename + " not exist.");
  }

  private static void showFiles(File directory) {
    File[] files = directory.listFiles();
    for (int i = 0; i < files.length; i++)
      System.out.println(files[i]);
  }

  private static boolean deleteDirectory(File directory) {
    if(directory.exists()) {
      File[] files = directory.listFiles();
      if(files != null) {
        for(int i = 0; i < files.length; i++) {
          if(files[i].isDirectory())
            deleteDirectory(files[i]);
          else
            files[i].delete();
        }
      }
    }
    return directory.delete();
  }
}
