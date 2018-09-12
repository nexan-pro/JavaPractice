import java.util.Scanner;

public class zadanie6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int r;
        double f;
        System.out.println("Enter r: ");
        r = input.nextInt();
        if (1 <= r && r <= 5){
            f = 2*r +6;
        }
        else if (6 <= r && r <= 10){
            f = Math.pow(r,2) + 5;
        } else f = 1;
    }
}
