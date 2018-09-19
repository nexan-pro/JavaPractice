import java.util.Scanner;

public class Taylor_sequence_3_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Xn, Xk, dx, eps: ");
        double x, sum, n, i, Xn, Xk, dx, eps;
        do {
            Xn = input.nextDouble();
            Xk = input.nextDouble();
            System.out.println((Xk < Xn) ? "Error input, Xk < Xn!.\nTry again." : "");
        } while(Xk < Xn);
        System.out.println("enter dx, eps: ");
        dx = input.nextDouble();
        eps = input.nextDouble();
        while (Xn <= Xk){
            x = Xn;
            sum = 1;
            n = 1;
            i = 1;
            while ((Math.abs(Math.pow(-x, i))) / getFactorial(i) > eps) {
                sum += (Math.pow(-x, i)) / getFactorial(i);
                i++;
                n++;
            }
            System.out.println("x: " + Xn + "\t f(x): " + sum + " \t Кол-во членов: " + n + " \t" + Math.exp(-x));
            Xn += dx;
        }
    }

    private static double getFactorial(double N){
        if (N < 0)
            return 0;
        if (N == 0)
            return 1;
        else
            return (N * getFactorial(N - 1));
    }
}

