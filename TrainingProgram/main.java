package TrainingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class main {

  private static Course[] initListOfCourses() {
    Course[] tmp = new Course[15];
    tmp[0] = new Course(1, 30, 32, "Логика", false, false, true, null);
    tmp[1] =  new Course(2, 50, 30, "Теория алгоритмов", false, true, true, null);
    tmp[2] = new Course(3, 60, 20, "Компьютерное обучение", false, false, false, new int[]{6}); // input prerequisites id start with zeros in arr
    tmp[3] = new Course(4, 50, 23, "Нейронные сети", true, true, true, new int[]{6, 7});
    tmp[4] = new Course(5, 60, 34, "Защита аппаратных средств", true, true, true, new int[]{7});
    tmp[5] = new Course(6, 30, 14, "Криптография", true, false, false, new int[]{7});
    tmp[6] = new Course(7, 42, 18, "Информатика", false, true, false, null);
    tmp[7] = new Course(8, 50, 28, "Математика", false, true, true, null);
    tmp[8] = new Course(9, 35, 34, "Разработка технологии искусственного интеллекта", false, false, false, new int[]{7});
    tmp[9] = new Course(10, 67, 23, "Введение в программирование с MATLAB", false, true, true, new int[]{7});
    tmp[10] = new Course(11, 34, 36, "Введение в генетику человеческого поведения", true, false, false, null);
    tmp[11] = new Course(12, 24, 34, "Бактериальные и хронические инфекции", true, false, false, null);
    tmp[12] = new Course(13, 54, 20, "Теория вероятностей", true, false, false, null);
    tmp[13] = new Course(14, 23, 10, "Дискретная математика", false, false, false, new int[]{1});
    tmp[14] = new Course(15, 12, 5, "Основы обработки цифровых видео и изображений", true, false, false, new int[]{7});
    return tmp;
  }

  private static Degree[] initListOfDegree(Student student_, int code_, Date creationDate_, Date confirmationDate_) {
    Degree[] list = new Degree[15];
    for (int i = 0; i < list.length; i++)
      list[i] = new Degree(student_, code_, creationDate_, confirmationDate_);

    list[0].set(20, 3, "Техник-программист");
    list[1].set(15, 0, "Экономист");
    list[2].set(13, 0, "Бухгалтер");
    list[3].set(20, 3, "Инженер-проектировщик");
    list[4].set(16, 3, "Робототехник");
    list[5].set(16, 3, "Робототехник");
    list[6].set(13, 2, "Биолог");
    list[7].set(25, 3, "Физик-математик");
    list[8].set(26, 3, "Специалист по защите информации");
    list[9].set(14, 3, "Инженер по радиодэлектронике");
    list[10].set(23, 3, "Магистр радиобиологии");
    list[11].set(22, 3, "Магистр технических наук");
    list[12].set(21, 3, "Магистр квантовой радиофизики и лазерные технологии");
    list[13].set(21, 3, "Магистр физики");
    list[14].set(28, 3, "Программист-математик");
    return list;
  }

  public static void main(String[] args) {
    Random rand = new Random();
    SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
    try {
      Date birthDate = format.parse("20-02-2001"); // set student birthDate
      Student student = new Student(rand.nextInt(1000), "Prokopchenko", "Petr", "Vladimirovich", birthDate);
      Date dateOfPreparation = format.parse("24-05-2020"); // set date of completion to curriculum program
      Date current_date = new Date();
      Calendar cal = Calendar.getInstance();
      cal.setTime(birthDate);
      int birthYear = cal.get(Calendar.YEAR);
      cal.setTime(current_date);

      try {
        if (birthYear > cal.get(Calendar.YEAR))
          throw new DateTimeException("Ошибка, дата рождения студента не может быть больше текущей даты!");
      } catch (DateTimeException e) {
        System.out.println(e.getMessage());
        return;
      }

      Degree degree = new Degree(student, rand.nextInt(1000), dateOfPreparation, current_date);
      Degree[] list = initListOfDegree(student, rand.nextInt(1000), dateOfPreparation, current_date);

      Degree.printDegreeList();
      int degreeChoice = 4;
      degree.set(list[degreeChoice - 1]);

      Degree.printDegreeRules();
      int rule = 1; // set rule for our program

      Course.print();
      Course[] courses = initListOfCourses();

      int[] coursesChoice = { 1, 2, 10, 7, 8 }; // choice of courses that student will attend !(input choice always start with 1)
      for (int i = 0; i < 5; i++)
        degree.add(courses[--coursesChoice[i]], i);

      if (degree.setRule(rule, current_date)) {
        int deleteChoice = 1; // set course to be deleted
        System.out.println("Выбран курс на удаление: " + Course.COURSES[deleteChoice - 1]);
        degree.delete(deleteChoice);
        degree.print();
        System.out.println((degree.checkPrerequisites()) ? "Данная программа является допустимой"
            : "Ошибка, курс не содержит необходимых подкурсов");
      } else  System.out.println("Error, bad training program!");
    } catch(ParseException e) {
      e.printStackTrace();
    }
  }
}
