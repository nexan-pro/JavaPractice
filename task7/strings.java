package task7;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class strings {
    public static void main(String[] args) {
        try {
            FileInputStream fstream = new FileInputStream("/home/gilgamesh/IdeaProjects/Main/src/example.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strline;
            while (((strline = br.readLine()) != null)){
                int state = 0;
                for (int i = 0; i < strline.length(); i++){
                    boolean isDigit = (isDigit(strline.charAt(i)));
                    if ((state == 0 || state == 1) && isDigit)
                        state++;
                    else if (state == 2 && !isDigit){
                        System.out.println(strline);
                        break;
                    }
                    else
                        state = 0;
                }
            }
        } catch (IOException e){
            System.out.println("Error");
        }
    }
    private static boolean isDigit(char c){
        return (c>= 48 && c<=57);
    }
}
