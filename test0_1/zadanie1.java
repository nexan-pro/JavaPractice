package test0_1;

public class zadanie1 {
    public static void main(String[] args) {
        int x = 10, sum = 0;
        do {
            if (x % 2 != 0) {
                System.out.println("x  = " + x);
                sum += x;
            }
            x++;
        } while(x != 100);
        System.out.println("sum = "+ sum);
    }
}
