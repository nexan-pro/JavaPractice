package test0_1;

import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        System.out.println("Enter a, x, n: ");
        Scanner input = new Scanner(System.in);
        double a = input.nextDouble(), x = input.nextDouble(), n = input.nextDouble(), y, sum = 0;
        for (double i = 0; i <= n; ++i){
            y = (Math.pow(x * Math.log(a), i)) / getFactorial(i);
            sum += y;
            System.out.println("y[" + i + "] = " + y);
        }
        System.out.println("sum = " + sum);
    }
    private static int getFactorial(double n){
        int fact = 1;
        while (n != 0){
            fact *= n;
            n--;
        }
        return fact;
    }
}

/* Output

y[0.0] = 1.0
y[1.0] = 1.3862943611198906
y[2.0] = 0.9609060278364028
sum = 3.347200388956294
 */