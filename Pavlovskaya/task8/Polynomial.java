package Pavlovskaya.task8;

import java.util.Arrays;

class Polynomial {
  private double[] kMatrix;
  private int degree;
  Polynomial(double[] kMatrix, int degree) {
      this.kMatrix = kMatrix;
      this.degree = degree;
  }

  /**
   * Calculate value of argument
   * @param kMatrix - matrix of K
   * @param x - argument of calculate
   * @param degree - degree polynomial
   * @return double result of argument
   */
  public double calculate(double[] kMatrix, double x, int degree) {
    double rez = 0;
    for (int i = degree; i > 0; i--) {
      for (int j = i; j < degree; j++) x *= x;
      rez += kMatrix[i - 1] * x;
    }
    rez += kMatrix[degree];
    return rez;
  }

  /**
   * Addition between lhs polynomial and rhs polynomial
   * @param lhs - first polynomial to add
   * @param rhs - second polynomial to add
   * @return result polynomial of addition
   */
  public Polynomial add(Polynomial lhs, Polynomial rhs) {
    int degree_rez = lhs.degree;
    double[] kMatrix_rez = Arrays.copyOf(lhs.kMatrix, lhs.kMatrix.length);
    Polynomial rez = new Polynomial(kMatrix_rez, degree_rez);
    for (int i = 0; i < lhs.degree + 1; i++)
      rez.kMatrix[i] = lhs.kMatrix[i] + rhs.kMatrix[i];
    return rez;
  }

  /**
   * Subtraction between two polynomial
   * @param lhs - first polynomial to add
   * @param rhs - second polynomial to add
   * @return result of polynomial of subtraction
   */
  public Polynomial sub(Polynomial lhs, Polynomial rhs) {
    int degree_rez = lhs.degree;
    double[] kMatrix_rez = Arrays.copyOf(lhs.kMatrix, lhs.kMatrix.length);
    Polynomial rez = new Polynomial(kMatrix_rez, degree_rez);
    for (int i = 0; i < lhs.degree + 1; i++)
      rez.kMatrix[i] = lhs.kMatrix[i] - rhs.kMatrix[i];
    return rez;
  }

  /**
   * Multiplication between to polynomial
   * @param lhs - first polynomial to add
   * @param rhs - second polynomial to add
   * @return result of polynomial of multiplication
   */
  public Polynomial mul(Polynomial lhs, Polynomial rhs) {
    int degree_rez = lhs.degree;
    double[] kMatrix_rez = Arrays.copyOf(lhs.kMatrix, lhs.kMatrix.length);
    Polynomial rez = new Polynomial(kMatrix_rez, degree_rez);
    for (int i = 0; i < lhs.degree + 1; i++)
      rez.kMatrix[i] = lhs.kMatrix[i] * rhs.kMatrix[i];
    return rez;
  }

  /**
   * Print polynomial
   * @param obj - polynomial to output
   */
  public void print(Polynomial obj) {
    for (int i = 0; i <= obj.degree; i++)
      System.out.print(obj.kMatrix[i] + "x^" + (obj.degree - i) + " + ");
  }
}
