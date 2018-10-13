package Pavlovskaya.task10;

import java.util.Scanner;

public class main {
    static class rer {
        String surname, name, patronymic;
        int numberOfGroup;
        int[] perfomance = new int[5];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = 2;
        rer[] obj = new rer[size];
        for (int i = 0; i < size; i++)
            obj[i] = new rer(); //initialize all objects
        for (int i = 0; i < size; ++i){
             System.out.print("Enter initials (surname, name, patronymic): ");
             obj[i].surname = input.nextLine();
             obj[i].name = input.nextLine();
             obj[i].patronymic = input.nextLine();
             System.out.println("Enter num of your group: ");
             obj[i].numberOfGroup = input.nextInt();
             System.out.print("Enter your perfomance (size of array = 5): ");
             for (int j = 0; j < 5; j++)
                 obj[i].perfomance[j] = input.nextInt();
             input.nextLine();
        }
        System.out.println("Modified List: ");
        for (int i = 0; i < size; ++i) {
            System.out.print("Surname: " + obj[i].surname + "\r\n");
            System.out.print("Name: " + obj[i].name + "\r\n");
            System.out.print("Patronymic: " + obj[i].patronymic + "\r\n");
            System.out.print("Number of group: " + obj[i].numberOfGroup + "\r\n");
            System.out.print("Perfomance: ");
            for (int j = 0; j < 5; ++j)
                System.out.print(" " + obj[i].perfomance[j]);
        }
         System.out.print("\r\n" + "Sort surname of alphabet: ");
    }
    static rer[] sort(rer[] src){
        for (int i = 0; i < src.length; ++i){
            for (int j = i+1; j < src.length; ++j){
                if (src.co)
            }
        }
        return (src);
    }
}

