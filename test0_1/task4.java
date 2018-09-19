package test0_1;

import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter q: ");
        double q = input.nextDouble(), i = 3, sum = 0, proizv = 1; // i = shag
        if (q >= 0) {
            for (int x = 3; x <= 30; x += i) {
                sum += Math.sqrt(x);
                System.out.println("sum [" + x + "] = " + sum);
            }
            System.out.println("Result: sum(t) = " + sum);
        }
        if (q < 0) {
            for (int x = 3; x <= 30; x += i) {
                proizv *= Math.sqrt(x);
                System.out.println("proiz [" + x + "] = " + proizv);
            }
            System.out.println("Result: proizv(t) = " + proizv);
        }
    }
}
/* Output:
Enter q:
2
sum [3] = 1.7320508075688772
sum [6] = 4.1815405503520555
sum [9] = 7.1815405503520555
sum [12] = 10.64564216548981
sum [15] = 14.518625511697227
sum [18] = 18.76126619881651
sum [21] = 23.34384189377235
sum [24] = 28.242821379338707
sum [27] = 33.43897380204534
sum [30] = 38.916199377097
Result: sum(t) = 38.916199377097
 */