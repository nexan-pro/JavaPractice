package test0_1;

import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        System.out.println("Enter a, b, h: ");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble(), b = input.nextDouble(), h = input.nextDouble(), y;
        for (double i = a; i < b; i+=h) {
            y = Math.pow(Math.E, i) + 1 / Math.pow(Math.E, i);
            System.out.println("y = " + y);
        }
    }
}
