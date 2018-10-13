package test;

import java.util.Scanner;

public class zadanie5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double a, b, c, D, koren1, koren2;//-b+-sqrt(D)/2a
        System.out.println("Enter a: ");
        a = input.nextInt();
        System.out.println("Enter b: ");
        b = input.nextInt();
        System.out.println("Enter c: ");
        c = input.nextInt();
        D = (b*b) - 4 * a * c;
        koren1 = (-b - Math.sqrt(D)) / 2 * a;
        koren2 = (-b + Math.sqrt(D)) / 2 * a;
        System.out.println("koren1 =  " + koren1 + "koren2 = " + koren2);
    }
}
