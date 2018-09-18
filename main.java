import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Xn, Xk, dx, eps: ");
        double x, sum, n, i, Xn, Xk, dx, eps, rez;
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
            System.out.println("x: " + Xn + "\t f(x): " + sum + " \t Кол-во членов" + n);
            Xn += dx;
        }
       // System.out.println("-----------------------------------------------------------");
        //System.out.println("|         value          |   ...     |   ....    |   .... |");
        //System.out.println("-----------------------------------------------------------");

    }

    private static double getFactorial(double N){
        if (N < 0)
            return 0;
        if (N == 0)
            return 1;
        else
            return N * getFactorial(N - 1);
    }


    public static double func(double x, double eps) {
        double s = 1;
        double el = 1;
        double n = 0;
        while (Math.abs(el) > eps) {
            n++;
        }
        return n;
    }
}

