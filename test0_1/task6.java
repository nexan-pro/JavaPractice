package test0_1;

import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n: ");
        double n = input.nextDouble(), rez = 0;
        for(double i = 10; i < n; i++) {
            rez += (10*0.1) / 100;
        }
        System.out.println(rez);
    }
}
