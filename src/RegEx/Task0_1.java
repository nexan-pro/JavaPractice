package RegEx;

import java.io.*;

/**
 * Некоторые строки текстового файла содержат GUID (строчка, состоящая из 8, 4, 4, 4, 12 шестнадцатеричных цифр, разделенных символом «минус»).
 * Регистр букв не различается. Создать на основе входного файла новый текстовый файл, не включая в него найденные строки.
 * Пример GUID: e02fd0e4-00fd-090A-ca30-0d00a0038ba0
 */
public class Task0_1 {
  public static void main(String[] args) throws IOException {
    FileInputStream inputFile = new FileInputStream("src/RegEx/GUID.txt");
    BufferedReader contentsOfFile = new BufferedReader(new InputStreamReader(inputFile));
    String line, content = "";
    boolean isRegex;
    while (((line = contentsOfFile.readLine()) != null)) {
        isRegex = line.matches("\\b[0-9a-fA-F]{8}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{4}\\-[0-9a-fA-F]{12}\\b");
        if (!isRegex)
            content += line + "\r\n";
    }
    writeToFile("src/RegEx/GUID_out.txt", content);
  }

  public static FileWriter writeToFile(String pathToFile, String content) throws IOException {
    FileWriter outputFile = new FileWriter(pathToFile);
    BufferedWriter outputBuffer = new BufferedWriter(outputFile);
    outputBuffer.write(content);
    outputBuffer.close();
    outputFile.close();
    return (outputFile);
  }

}

