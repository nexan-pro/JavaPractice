package Pavlovskaya.task8;

public class Main {
  public static void main(String[] args) {
    int degree = 2;
    double[] kMatrix = { 1, 4, 8 }; // x^2 + 4x + c
    Polynomial first = new Polynomial(kMatrix, degree);
    /******************Enter second polynomial*************/
    int degree_sec = 2;
    double[] kMatrix_sec = { 2, 3, 7 };
    Polynomial second = new Polynomial(kMatrix_sec, degree_sec);
    System.out.println("Value of argument: " + first.calculate(kMatrix, 1, degree));
    Polynomial addition = first.add(first, second);
    Polynomial subtraction = second.sub(first, second);
    Polynomial multiplication = first.mul(first, second);

    System.out.print("\r\nAddition: ");
    addition.print(addition);
    System.out.print("\r\nSubtraction: ");
    subtraction.print(subtraction);
    System.out.print("\r\nMultiplication: ");
    multiplication.print(multiplication);
  }
}
