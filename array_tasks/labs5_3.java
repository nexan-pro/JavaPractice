package array_tasks;

import java.util.Scanner;

public class labs5_3 {
    public static void main(String[] args) {
        //System.out.println("Enter size of array: ");
        //Scanner input = new Scanner(System.in);
        int size = 6, mul = 1, sum = 0;
        int state = 0, state1 = 0;
        int[] array = new int[size];
        array[0] = 2;
        array[1] = 0;
        array[2] = -3;
        array[3] = -4;
        array[4] = 5;
        array[5] = 0;
        //for (int i = 0; i < size; i++)
        //       array[i] = (int)(0 + (Math.random() * 10));
        System.out.println("Source array: ");
        for (int i = 0; i < size; i++)
            System.out.print(array[i] + " ");
        for (int i = 0; i < size; i++)
            if (i % 2 == 0)
                mul *= array[i];
        for (int i = 0; i < size; i++) {
            if (array[i] == 0 && state != 0) {
                state1 = i;
                System.out.println(" state1 = " + state1);
            }
            if (array[i] == 0 && state == 0) {
                state = i;
                sum += array[i];
                System.out.println(" state = " + state);
            }
        }
        if (state == 0 || state1 == 0) System.out.println("\r\ntwo zeros nothing found");
        else {
            for (int i = state; i < state1; ++i)
                sum += array[i];
            System.out.println("\r\nmul = " + mul + " sum = " + sum);
            System.out.println("modified array: ");
            //TODO: make correctly sort array
            for (int i = 0; i < size; i++)
                System.out.print(array[i] + " ");
        }
    }
}
