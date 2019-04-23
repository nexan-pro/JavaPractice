package Multithreading.task_1Ex;


public class Main {
  public static void main(String[] args) {
    System.out.println("Started   main thread id is:" + Thread.currentThread().getId());
    Observer o = new Demonstrator(5000, 50, 50, 100);
    Calculator obj = new Calculator(5000, o, 10);
  }
}
