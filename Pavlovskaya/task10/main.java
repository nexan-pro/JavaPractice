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
        String[] SNP = new String[size];
        rer[] obj = new rer[size];
        for (int i = 0; i < size; i++)
            obj[i] = new rer(); //initialize all objects
        for (int i = 0; i < size; ++i){
             System.out.print("Enter initials (surname, name, patronymic): ");
             obj[i].surname = input.nextLine();
             obj[i].name = input.nextLine();
             obj[i].patronymic = input.nextLine();
             SNP[i] = obj[i].surname + " " + obj[i].name + " " + obj[i].patronymic;
             System.out.println("Enter num of your group: ");
             obj[i].numberOfGroup = input.nextInt();
             System.out.print("Enter your perfomance (size of array = 5): ");
             for (int j = 0; j < 5; j++)
                 obj[i].perfomance[j] = input.nextInt();
             System.out.println();
             input.nextLine();
        }
        System.out.println("Modified List: ");
        print(obj, size);
        System.out.print("Sort surname of alphabet: \r\n");
        sort(SNP);
    }
    static void print(rer[] obj, int size){
        for (int i = 0; i < size; ++i) {
            System.out.print("Surname/Name/Patronymic: " + obj[i].surname + " " + obj[i].name + " " + obj[i].patronymic + "\r\n");
            System.out.print("Number of group: " + obj[i].numberOfGroup + "\r\n");
            System.out.print("Perfomance: ");
            for (int j = 0; j < 5; ++j)
                System.out.print(" " + obj[i].perfomance[j]);
            System.out.println();
        }
    }
    static String[] sort(String[] src){
        for (int i = 0; i < src.length; i++)
            for (int j = i + 1; j < src.length; j++){
                if (src[j].compareTo(src[i]) < 0){
                    String tmp = src[i];
                    src[i] = src[j];
                    src[j] = tmp;
                }
            }
        return (src);
    }
}

