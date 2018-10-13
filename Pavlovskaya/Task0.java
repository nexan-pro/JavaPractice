package Pavlovskaya;

import java.util.Scanner;

public class Task0 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        double a = input.nextDouble();
        double z1 = (Math.sin(2 * a) + Math.sin(5 * a) - Math.sin(3 * a)) / (Math.cos(a) + 1 - 2 * Math.pow(Math.sin(2 * a), 2)), z2 = 2 * Math.sin(a);
        System.out.println(z1);
        System.out.println(z2);
        if (z1 - z2 < 0.0000001)
            System.out.println("Equal");
        else
            System.out.println("!Equal");
    }
}
