package Pavlovskaya.task4;
import java.util.Scanner;

public class task_4_3_class {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter coordinate of point a: ");
        float ax = input.nextFloat(), ay = input.nextFloat(), bx = input.nextFloat(), by = input.nextFloat(), cx = input.nextFloat(), cy = input.nextFloat();
        if (ax == bx && ay == by || ax == cx && ay == cy|| bx == cx && by == cy) {
            try {
                throw new NullPointerException("Error, coordinate!");
            }
            catch (NullPointerException e){
                System.out.print("Error, coordinate!!!");
            }
        }

        point a = new point(ax,ay);
        point b = new point(bx,by);
        point c = new point(cx,cy);
        triangle obj = new triangle(a,b,c);
        obj.rotate(20);
        obj.print();
    }
}
