import java.util.Scanner;

/*System.out.println("Enter R: ");
       Scanner input = new Scanner(System.in);
       double x = 1, y = -3, r = input.nextDouble();
       if (Math.abs(x) <= r && Math.abs(y) <= r && (Math.pow((x+r), 2)) + Math.pow((y-r), 2) >= Math.pow(r,2) && (Math.pow((x-r), 2)) + Math.pow((y+r), 2) >= Math.pow(r,2)){
           System.out.println("popal");
       } else System.out.println("ne popal");*/
public class main {
    public static void main(String[] args) {
       /* Scanner input = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        double a = input.nextDouble();
        double z1 = (Math.sin(2 * a) + Math.sin(5*a) - Math.sin(3*a)) / (Math.cos(a) + 1 - 2 * Math.pow(Math.sin(2*a),2)), z2 = 2 * Math.sin(a);
        System.out.println(z1);
        System.out.println(z2);
        if (z1 - z2 < 0.0000001)
            System.out.println("Equal");
        else
            System.out.println("!Equal"); */
       /* laba 2.1 */Scanner input = new Scanner(System.in);
       System.out.println("Enter x: ");
       double x = input.nextDouble(), y, R;
       System.out.println("Enter R: ");
       R = input.nextDouble();
        if (x<-5 && x>=-9)
            y = -Math.sqrt(Math.pow(R,2)-Math.pow(x+7,2))+2;
        else if (x <=-4 && x>=-5)
            y = 2;
        else if (x<=0 && x>-4)
            y = -0.5*x;
        else if(x<=Math.PI && x>0)
            y = Math.sin(x);
        else if (x<=5 && x>=Math.PI)
            y = x - Math.PI;
        else y = 0;
        System.out.println("y = " + y);
        /* laba 2.2double x = 1, y = -2;
        System.out.println("Enter R: ");
        Scanner input = new Scanner(System.in);
        double r = input.nextDouble();
        boolean flag = false;
        if (x > -r && x < r && y > -r && y < r){
            //System.out.println("popal v kvadrat");
            flag = true;
            if (Math.pow((-r-x),2) + Math.pow(r-y,2) < Math.pow(r,2)){
                //System.out.println("promah verh");
                flag = false;
            }
            if (Math.pow(r-x, 2) + Math.pow(-r-y,2) < Math.pow(r,2)) {
                //System.out.println("promah nizh");
                flag = false
            }
        } if (flag) System.out.println("popal");*/


    }
}
