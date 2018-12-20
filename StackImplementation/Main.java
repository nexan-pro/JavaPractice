package StackImplementation;

public class Main {
  public static void main(String[] args) {
    Stack<String> myStack = new Stack(10);
    myStack.push("10");
    myStack.push("22");
    myStack.push("32");

    Stack<String> myStack2 = new Stack(10);
    myStack2.push("44");
    myStack2.push("55");
    myStack2.push("66");
    myStack2.swap(myStack);
    System.out.println("size of first stack = " + myStack.size());
    System.out.println("top first stack = " + myStack.top());

    System.out.println("element of second stack = " + myStack2.pop());

    System.out.println("Is empty: " + myStack2.empty());
  }
}
