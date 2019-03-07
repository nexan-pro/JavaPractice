package array_tasks;
// block 'Б' № 3 liner

public class task0_2_var_3 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int M = 11, rez = 1, cnt = 0;
        for (int i = 0; i < 10; i++)
            array[i] =  (int)(0 + (Math.random() * 10));
        System.out.print("Source array: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(array[i] + " ");
            if (array[i] > M) {
                rez *= array[i];
                cnt++;
            }
        }
        System.out.print((cnt != 0) ? "\r\nrez = " + rez : "\r\nNothing found.");
    }
}
