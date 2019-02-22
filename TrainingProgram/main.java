package TrainingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    System.out.println("номер заявления: ");
    int app_n = in.nextInt();
    System.out.println("ФИО и дату рождения(dd-MM-yyyy): ");
    in.nextLine();
    String surname = in.nextLine(), name = in.nextLine(), patronymic = in.nextLine(), dateOfBirth = in.nextLine();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    try {
      Date birthDate = format.parse(dateOfBirth);
      Student student = new Student(app_n, surname, name, patronymic, birthDate);
      System.out.println("Регистрационный номер программы: ");
      int reg_n = in.nextInt();
      System.out.println("Дата заполнения: ");
      in.nextLine();
      String dateOfCompletion_in = in.nextLine();
      Date dateOfCompletion = format.parse(dateOfCompletion_in);
      Date current_date = new Date();
      Curriculum curr = new Curriculum(student, reg_n, dateOfCompletion, current_date);
      System.out.print("Курсы: \n1.Логика\n2.Теория алгоритмов\n3.Компьютерное обучение\n4.[Spec]Нейронные сети\n" +
          "5.[Spec]Защита аппаратных средств\n6.[Spec]Криптография\n7.Информатика\n8.Математика\n" +
          "9.Разработка технологии искусственного интеллекта\n10.Введение в программирование с MATLAB\n" +
          "11.[Spec]Введение в генетику человеческого поведения\n12.[Spec]Бактериальные и хронические инфекции\n" +
          "13.[Spec]Теория вероятностей\n14.Дискретная математика\n15.[Spec]Основы обработки цифровых видео и изображений\n");
      Course[] courses = new Course[15];

      courses[0] = new Course(1, 30, 32, "Логика", false, false, true, null);
      courses[1] =  new Course(2, 50, 30, "Теория алгоритмов", false, true, true, null);
      courses[2] = new Course(3, 60, 20, "Компьютерное обучение", false, false, false, new int[]{6}); // start with -
      courses[3] = new Course(4, 50, 23, "Нейронные сети", true, true, true, new int[]{6, 7});
      courses[4] = new Course(5, 60, 34, "Защита аппаратных средств", true, true, true, new int[]{7});
      courses[5] = new Course(6, 30, 14, "Криптография", true, false, false, new int[]{7});
      courses[6] = new Course(7, 42, 18, "Информатика", false, true, false, null);
      courses[7] = new Course(8, 50, 28, "Математика", false, true, true, null);
      courses[8] = new Course(9, 35, 34, "Разработка технологии искусственного интеллекта", false, false, false, new int[]{7});
      courses[9] = new Course(10, 67, 23, "Введение в программирование с MATLAB", false, true, true, new int[]{7});
      courses[10] = new Course(11, 34, 36, "Введение в генетику человеческого поведения", true, false, false, null);
      courses[11] = new Course(12, 24, 34, "Бактериальные и хронические инфекции", true, false, false, null);
      courses[12] = new Course(13, 54, 20, "Теория вероятностей", true, false, false, null);
      courses[13] = new Course(14, 23, 10, "Дискретная математика", false, false, false, new int[]{1});
      courses[14] = new Course(15, 12, 5, "Основы обработки цифровых видео и изображений", true, false, false, new int[]{7});

      for (int i = 0; i < 5; i++) {
        reg_n = in.nextInt();
        curr.add(courses[--reg_n], i);
      }
      curr.print();
      System.out.println("Введите код предмета который хотите удалить: ");
      curr.delete(in.nextInt());
      curr.print();
      System.out.println((curr.checkPrerequisites()) ? "Good" : "Bad");
      System.out.println("Выберите квалификационную степень: \n1.Специалист\n2.Бакалавр");
      Degree degree;
      reg_n = in.nextInt();
      switch(reg_n) {
        case 1:
          degree = new Degree(student, curr, reg_n, 15, 1, "Специалист");
          System.out.println((degree.checkCredits(curr)) ? "Degree[credits] : good" : "degree : false");
          System.out.println((degree.checkSpecial(curr)) ? "Degree[special] : good" : "degree : false");
          break;
        case 2:
          degree = new Degree(student, curr, reg_n, 20, 2, "Бакалавр");
          System.out.println((degree.checkCredits(curr)) ? "Degree[credits] : good" : "degree : false");
          System.out.println((degree.checkSpecial(curr)) ? "Degree[special] : good" : "degree : false");
          break;
        default: System.out.println("Error, wrong degree!"); break;
      }
    } catch(ParseException e) {
      e.printStackTrace();
    }
  }
}
