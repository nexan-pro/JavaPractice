//package Pets;
//
//import java.io.FileReader;
//
//import com.google.gson.Gson;
//
//public class main
//{
//  public static void main(String[] args) throws Exception
//  {
//    Gson gson = new Gson();
//    Peat[] myTypes = gson.fromJson(new FileReader("/home/gilgamesh/Projects/java/JavaPractice/src/Pets/sample.json"), Peat[].class);
//    System.out.println(myTypes[1].ownerSurname);
//  }
//}
//
//class Peat {
//  String ownerSurname;
//  String kind;
//  String nickname;
//  int age;
//
////  Peat(String ownerSurname, String kind, String nickname, int age) {
////    this.ownerSurname = ownerSurname;
////    this.kind = kind;
////    this.nickname = nickname;
////    this.age = age;
////  }
//}
