import java.util.Scanner;

public class zadanie3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double x, y, r = 1;
        System.out.println("Enter x: ");
        x = input.nextDouble();
        System.out.println("Enter y: ");
        y = input.nextDouble();
        if (y*y + x*x <= r*r && y>= -x && y >= x)
            System.out.println("popal");
        else System.out.println("nepopal");
    }
}
