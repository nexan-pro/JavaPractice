/*import  java.util.Scanner;

public class Task0_2 {
    public static void main(String[] args) {
        double x, y;
        System.out.println("Enter R: ");
        Scanner input = new Scanner(System.in);
        double r = input.nextDouble();
        boolean flag = false;
        for (int i = 0; i < 10; ++i) {
            x = getrandomNumber();
            y = getrandomNumber();
            System.out.print("x = " + x + " y = " + y);
            if (x > -r && x < r && y > -r && y < r) {
                //System.out.println("popal v kvadrat");
                flag = true;
                if (Math.pow((-r - x), 2) + Math.pow(r - y, 2) < Math.pow(r, 2)) {
                    //System.out.println("promah verh");
                    flag = false;
                }
                if (Math.pow(r - x, 2) + Math.pow(-r - y, 2) < Math.pow(r, 2)) {
                    //System.out.println("promah nizh");
                    flag = false;
                }
            }
            if (flag) System.out.println(" popal");
        }
    }

    public static double getrandomNumber() {
        return (Math.random() - Math.random());
    }
}
*/