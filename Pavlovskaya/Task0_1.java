package Pavlovskaya;

import java.util.Scanner;

public class Task0_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double R, xdst = 5, dx = 0.5;
        System.out.println("Enter R: ");
        R = input.nextDouble();
        System.out.println("------------------------------------------------------------------------------------------");
        System.out.println("======================Y==================================X================================");
        System.out.println("------------------------------------------------------------------------------------------");
        for (double x = -9; x <= xdst; x += dx)
            System.out.println("\t\t\t\t\t" + func(x, R) + "\t\t\t\t\t" + x);
    }
    public static double func(double x, double R){
        if (x<-5 && x>=-9)
            return (-Math.sqrt(Math.pow(R,2)-Math.pow(x+7,2))+2);
        else if (x <=-4 && x>=-5)
            return (2);
        else if (x<=0 && x>-4)
            return (-0.5*x);
        else if(x<=Math.PI && x>0)
            return (Math.sin(x));
        else if (x<=5 && x>=Math.PI)
            return (x - Math.PI);
        else return -1; //error
    }
}
