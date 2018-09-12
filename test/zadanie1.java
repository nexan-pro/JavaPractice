import java.util.Scanner;

public class zadanie1 { //deusnvitel'noe
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x, y, c = 0;
        System.out.println("Enter x: ");
        x = input.nextDouble();
        System.out.println("Enter y: ");
        y = input.nextDouble();
        if (x - y == 0)
            c = Math.pow(x,2) + Math.pow(y,2) + Math.sin(x);
        if (x - y > 0)
            c = Math.pow((x-y), 2) + Math.cos(x);
        if (x - y < 0)
            c = Math.pow((y-x),2) + Math.tan(x);
        System.out.println("C = " + c);
    }
}
