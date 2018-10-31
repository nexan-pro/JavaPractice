package RegEx;

import java.util.regex.Pattern;
/*
task 0 = \bth[^o]\w+\b 
task 1 = Составьте шаблон регулярного выражения для проверки корректного ввода номера паспорта. Протестируйте шаблон.
@example MP1234567
 */
public class Task0 {
  public static void main(String[] args) {
    System.out.print("Task 0: ");
    String input = "though thing though them through thus thorough this";
    Pattern pattern = Pattern.compile("\\b(th)[\\^o]\\w+\\b");
    String[] words = pattern.split(input);
    for(String word:words)
        System.out.println(word);
    System.out.print("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\r\n");
    System.out.print("Task1: ");
    input = "MP1234567"; //example number of passport
    boolean rez = input.matches("\\b(HB|KH|MP|MC|KB|PP)\\d{7}\\b");
    System.out.print((rez) ? "It's passport number" : "No passport number");
   }
}
