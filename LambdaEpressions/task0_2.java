package LambdaEpressions;

interface ShowOperation {
  void show(int[][] matrix);
}

public class task0_2 {
  public static void main(String[] args) {
    int[][] matrix = {
        { 1, 5, 6, 15, 45 },
        { 3, 2, 3, 53, 23 },
        { 12, 7, 1, 78, 43 },
        { 67, 45, 2, 64, 64 },
        { 23, 1, 6, 7, 44, 21 }
    };
    for (int i = 1; i < matrix.length - 1; ++i) {
      for (int j = 1; j < matrix.length - 1; ++j) {
        if(matrix[i][j] < matrix[i-1][j] && matrix[i][j] < matrix[i-1][j-1] && matrix[i][j] < matrix[i-1][j+1] &&
           matrix[i][j] < matrix[i][j-1] && matrix[i][j] < matrix[i][j+1] && matrix[i][j] < matrix[i+1][j] &&
           matrix[i][j] < matrix[i+1][j-1] && matrix[i][j] < matrix[i+1][j+1]) {
          System.out.println(i + "," + j + " " + matrix[i][j]);
          matrix[i][j] = 0;
        }
      }
    }
    ShowOperation operation = (int[][] lhs) -> {
      for (int i = 0; i < lhs.length; ++i) {
        for (int j = 0; j < lhs.length; ++j)
          System.out.printf("%d\t", lhs[i][j]);
        System.out.println();
      }
    };
    operation.show(matrix);
  }
}
