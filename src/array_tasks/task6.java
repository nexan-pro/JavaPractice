package array_tasks;
//task 6 from Pavlovskaya C#
public class task6 {
    public static void main(String[] args) {
        int size = 5, cnt = 0, index = 0, rezI = 0, indexRow = 0;
        int[][] matrix = {{0,4,5,7,5}, {1,0,3,3,3}, {5,0,0,5,6}, {6,7,4,2,1}, {5,6,3,2,2,1}};
        System.out.println("Source matrix: ");
        print(matrix, size);
        System.out.print("Count of column with zeros: ");
        System.out.print(countOfColumnWithZeros(matrix, size));
        for (int i = 0; i < matrix.length; ++i){
            index = numOfString(matrix[i]);
            if (index > rezI) {
                rezI = index;
                indexRow = i;
            }
        }
        System.out.println("\r\nLine " + indexRow + " series of " + (rezI + 1) + " identical numbers.");
    }
    static int countOfColumnWithZeros(int[][] matrix, int size){
        int cnt = 0;
        for (int i = 0; i < size; ++i){
            for (int j = 0; j < size; ++j)
                if (matrix[i][j] == 0) {
                    cnt++;
                    break;
                }
        }
        return (cnt);
    }

    static int numOfString(int[] tmp){
        int ecx = 0, t = tmp[0], cnt = 0;
        for (int i = 1; i < tmp.length; ++i) {
            if (tmp[i] == t)
                cnt++;
            else
                cnt = 0;
        t = tmp[i];
        if (cnt > ecx)
            ecx = cnt;
        }
        return (ecx);
    }

    static void print(int[][] matrix, int size){
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < size; ++j)
                System.out.print(" " + matrix[i][j]);
        System.out.println();
        }
    }
}
