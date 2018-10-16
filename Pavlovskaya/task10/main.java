package Pavlovskaya.task10;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class main {
    static class Student {
        String surname, name, patronymic;
        int numberOfGroup;
        int[] progress = new int[5];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Map bad = new HashMap<String, Integer>();
        int size = 3;
        Student[] obj = new Student[size];
        for (int i = 0; i < size; i++)
            obj[i] = new Student(); //initialize all objects
        for (int i = 0; i < size; ++i){
             System.out.print("Enter initials (surname, name, patronymic): ");
             obj[i].surname = input.nextLine();
             obj[i].name = input.nextLine();
             obj[i].patronymic = input.nextLine();
             System.out.println("Enter num of your group: ");
             obj[i].numberOfGroup = input.nextInt();
             System.out.print("Enter your progress (size of array = 5): ");
             for (int j = 0; j < 5; j++) {
                 obj[i].progress[j] = input.nextInt();
                 if (obj[i].progress[j] == 2)
                     bad.put(obj[i].surname, obj[i].numberOfGroup);
             }
             System.out.println();
             input.nextLine();
        }
        System.out.println("~~~~~~~Array without sort: ~~~~~~~~");
        print(obj, size);
        System.out.println("~~~~~~~Modified array: ~~~~~~~");
        sort(obj, size);
        print(obj, size);
        System.out.println("=================================\r\n");
        System.out.println((bad.isEmpty()) ? "Error, students with 2 not found" : bad);
    }

    static void print(Student[] obj, int size){
        System.out.println("\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        for (int i = 0; i < size; ++i) {
            System.out.print("Surname/Name/Patronymic: " + obj[i].surname + " " + obj[i].name + " " + obj[i].patronymic + "\r\n");
            System.out.print("Number of group: " + obj[i].numberOfGroup + "\r\n");
            System.out.print("progress: ");
            for (int j = 0; j < 5; ++j)
                System.out.print(" " + obj[i].progress[j]);
            System.out.println("\r\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        }
    }
    //case-sensitive bubble sort
    static Student[] sort(Student[] obj, int size){
        for (int i = 0; i < size; i++)
            for (int j = i + 1; j < size; j++){
                if (obj[j].surname.compareTo(obj[i].surname) < 0){
                    Student tmp = obj[i];
                    obj[i] = obj[j];
                    obj[j] = tmp;
                }
            }
        return (obj);
    }
    //static void printBad(HashMap<String, Integer> src){

    //}
}

