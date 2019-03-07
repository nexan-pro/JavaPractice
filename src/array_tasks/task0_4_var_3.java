package array_tasks;

import java.util.Scanner;

//block 'Б' liner №2
public class task0_4_var_3 {
    public static void main(String[] args) {
        System.out.println("Enter n, c, d: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double c = input.nextDouble(), d = input.nextDouble();
        if (c > d)
         System.out.println("Error input.");
        double[] array = new double[n + 1];
        for (int i = 0; i <= n; ++i)
            array[i] = i;
        System.out.print("Source array: ");
        for (int i = 0; i <= n; ++i)
            System.out.print(array[i] + " ");
        System.out.print("\nmodified array: ");
        for (double i = c; i <= d; ++i)
            System.out.print(array[(int)i] + " ");
    }
}
