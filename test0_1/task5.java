package test0_1;

import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        double n = input.nextDouble(), y;
        for (double i = 1; i <= n; i++){
            y = i + (n-1) / n;
            System.out.println("y[" + i + "] = " + y);
        }
    }
}
