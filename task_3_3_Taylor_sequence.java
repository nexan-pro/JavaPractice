import java.util.Scanner;

public class task_3_3_Taylor_sequence {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Xn, Xk, dx, eps: ");
        double x, sum, n, Xn, Xk, dx, eps;
        do {
            Xn = input.nextDouble();
            Xk = input.nextDouble();
            System.out.print((Xk < Xn) ? "Error input, Xk < Xn!.\r\nTry again.\r\n" : "");
        } while(Xk < Xn);
        dx = input.nextDouble();
        eps = input.nextDouble();
        while (Xn <= Xk){
            x = Xn;
            sum = 1;
            n = 1;
            while ((Math.abs(Math.pow(x, n))) / getFactorial(n) > eps) {
                sum += (Math.pow(x, n)) / getFactorial(n);
                n++;
            }
            System.out.println("x: " + Xn + "\t f(x): " + sum + " \t Кол-во членов: " + n + " \t" + Math.exp(x));
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

