package LambdaEpressions;

interface ShrinkOperation {
  double[] shrink(double[] arr);
}

public class task0_1 {
  public static void main(String[] args) {
    double[] array = { 0, 2, 0, -3, 0, 0, 0, 4, 0, 5, 0, 0 };
    double[] rez = resize(array);
    for (int i = 0; i < rez.length; i++)
      System.out.print(rez[i] + " ");
  }

  private static double[] resize(double[] lhs) {
    ShrinkOperation shrinkOperation = (double[] arr) -> {
      int ecx = 0;
      for (int i = 0; i < arr.length; ++i)
        if (arr[i] != 0)
          ecx++;

      double[] tmp = new double[ecx];
      ecx = 0;
      for (int i = 0; i < arr.length; ++i)
        if (arr[i] != 0) {
          tmp[ecx] = arr[i];
          ecx++;
        }
      return tmp;
    };
    return shrinkOperation.shrink(lhs);
  }
}
