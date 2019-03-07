package Collections.Queue;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class QueueTask {
  public static void main(String[] args) throws IOException {
    Queue<String> vowelWords = new LinkedList<>();
    Queue<String> consonantWords = new LinkedList<>();
    FileInputStream in = new FileInputStream("src/Collections/Queue/input.txt");
    BufferedReader buf_in = new BufferedReader(new InputStreamReader(in));
    String line;
    while ((line = buf_in.readLine()) != null) {
      String[] words = line.split(" ");
      for (int i = 0; i < words.length; ++i) {
        if (words[i].charAt(words[i].length() - 1) == ',' || words[i].charAt(words[i].length() - 1) == '.') {
          StringBuilder sb = new StringBuilder(words[i]);
          words[i] = sb.deleteCharAt(words[i].length() - 1).toString();
        }
        if (isVowel(words[i]) && words[i].length() > 1)
          vowelWords.add(words[i]);
        if (!isVowel(words[i]) && words[i].length() > 1)
          consonantWords.add(words[i]);
      }
    }
    System.out.println("vowelWords: " + vowelWords);
    System.out.println("consonantWords: " + consonantWords);
  }
  public static boolean isVowel(String word) {
    String tmp = word.toLowerCase();
    switch (tmp.charAt(0)) {
      case 'а': return true;
      case 'е': return true;
      case 'ё': return true;
      case 'и': return true;
      case 'о': return true;
      case 'у': return true;
      case 'ы': return true;
      case 'э': return true;
      case 'ю': return true;
      case 'я': return true;
      default: return false;
    }
  }
}
