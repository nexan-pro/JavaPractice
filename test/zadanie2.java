package test;

import java.util.Scanner;

public class zadanie2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int x, y, t = 0;
        System.out.println("Enter x: ");
        x = input.nextInt();
        System.out.println("Enter y: ");
        y = input.nextInt();
        t = max(min(x,5), max(y,0));
        System.out.println("t = " + t);
    }
    private static int min(int l, int r){
        if (l < r)
            return  l;
        if (r < l)
            return r;
        return l;
    }

    private static int max(int l, int r){
        if (l > r)
            return  l;
        if (r > l)
            return r;
        return r;
    }
}
