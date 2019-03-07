package array_tasks;

public class transparent_matrix {
    public static void main(String[] args) {
        int size = 3;
        int[][] src_matrix = new int[size][size];
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++)
                src_matrix[i][j] = (int)(0 + (Math.random() * 10));
        System.out.println("Source matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%4d", src_matrix[i][j]);
            System.out.println();
        }
        for (int i = 0; i < size; i++) {
            for (int j = i+1; j < size; j++) {
                int tmp = src_matrix[i][j];
                src_matrix[i][j] = src_matrix[j][i];
                src_matrix[j][i] = tmp;
            }
        }
        System.out.println("Transparent matrix: ");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                System.out.printf("%4d", src_matrix[i][j]);
            System.out.println();
        }
    }
}
