package Collections.StackTask;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackTask {
  public static void main(String[] args) throws IOException {
    FileInputStream in = new FileInputStream("src/Collections/StackTask/t.txt");
    BufferedReader buf_in = new BufferedReader(new InputStreamReader(in));
    Stack stack = new Stack();
    String line;
    while ((line = buf_in.readLine()) != null) {
      char[] bufChars = line.toCharArray();
      for (int i = 0; i < bufChars.length; i++)
        stack.push(bufChars[i]);
      for (int i = 0; i < bufChars.length; i++)
        System.out.print(stack.pop());
      System.out.println();
    }
    stack.clear();
    buf_in.close();
    in.close();
  }
}
