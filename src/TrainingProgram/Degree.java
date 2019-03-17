package TrainingProgram;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Hashtable;

class Degree extends Curriculum {
  protected int code, creditsRequired, specialCoursesRequired;
  private String title;
  private static final Hashtable<String, int[]> list = new Hashtable<String, int[]>() {
    {
      put("Техник-программист", new int[]{ 6, 7, 13 });
      put("Экономист", new int[]{ });
      put("Бухгалтер", new int[]{ });
      put("Инженер-проектировщик", new int[]{ 0, 1, 9 });
      put("Робототехник", new int[]{ 4, 5, 6 });
      put("Биолог", new int[]{ 10, 11 });
      put("Физик-математик", new int[]{ 0, 1, 7 });
      put("Специалист по защите информации", new int[]{ 4, 6, 7 });
      put("Инженер по радиодэлектронике", new int[]{ 4, 6, 7 });
      put("Инженер-системотехник", new int[]{ 4, 6, 7 });
      put("Инженер по эклектронным системам", new int[]{ 4, 6, 7  });
      put("Магистр радиобиологии", new int[]{ 11, 10, 6 });
      put("Магистр технических наук", new int[]{ 4, 6, 7  });
      put("Магистр квантовой радиофизики и лазерные технологии", new int[]{ 4, 6, 7 });
      put("Магистр физики", new int[]{ 0, 1, 7 });
      put("Программист-математик", new int[]{ 0, 1, 13 });
    }
  };

  Degree(Student student_, int code_, Date creationDate_, Date confirmationDate_) {
    super(student_, code_, creationDate_, confirmationDate_);
  }

  void set(Degree lhs) {
    this.code = lhs.code;
    this.creditsRequired = lhs.creditsRequired;
    this.specialCoursesRequired = lhs.specialCoursesRequired;
    this.title = lhs.title;
  }

  void set(int creditsRequired_, int specialCoursesRequired_, String title_) {
    this.code = super.code;
    this.creditsRequired = creditsRequired_;
    this.specialCoursesRequired = specialCoursesRequired_;
    this.title = title_;
  }

  boolean checkPrerequisites() {
    for (int i = 0; i < storage.length; i++)
      if (storage[i].prerequisities != null) {
        for (int j = 0; j < storage[i].prerequisities.length; j++) {
          int index = storage[i].prerequisities[j];
          if (contains(Course.COURSES[index]))
            continue;
          else {
            System.out.println("[checkPrerequisites] error, not contain " + Course.COURSES[index]);
            return false;
          }
        }
      }
    return true;
  }

  boolean checkCredits() {
    int curriculumTotalCredits = 0;
    for (int i = 0; i < storage.length; i++) {
      curriculumTotalCredits += (int)((storage[i].lectureHours + 1.25 * storage[i].practiceHours) / 18);
      if (storage[i].hasExam) curriculumTotalCredits++;
      if (storage[i].hasCoursePaper) curriculumTotalCredits += 2;
    }
    System.out.println("curriculumTotalCredits: " + curriculumTotalCredits);
    if (creditsRequired < curriculumTotalCredits) {
      System.out.println("[checkCredits] : good");
      return true;
    }
    System.out.println("[checkCredits] : false");
    return false;
  }

  boolean checkSpecial() {
    int cntSpecial = 0;
    for (int i = 0; i < storage.length; i++)
      if (storage[i].isSpecial)
        cntSpecial++;
    if (cntSpecial >= specialCoursesRequired) {
      System.out.println("[checkSpecial] : good");
      return true;
    }
    System.out.println("[checkSpecial] : false");
    return false;
  }

  boolean checkSpecialCompulsorySubjects() {
    for (int i = 0; i < list.get(title).length; i++)
       if (!contains(Course.COURSES[list.get(title)[i]])) {
         System.out.println("[checkSpecialCompulsorySubjects] : Doesn't contains: " + Course.COURSES[list.get(title)[i]]);
         return false;
       }
    System.out.println("Degree[checkSpecialCompulsorySubjects]  : good");
    return true;
  }

  boolean checkCurrentDate(Date date) {
    Calendar tmp = Calendar.getInstance();
    tmp.setTime(date);
    int currentYear = tmp.get(Calendar.YEAR);
    tmp.setTime(creationDate);
    int yearOfConfirmation = tmp.get(Calendar.YEAR);

    if (yearOfConfirmation <= currentYear && checkCredits()) {
      System.out.println("[CheckCurrentDate] : good");
      return true;
    }
    System.out.println("[CheckCurrentDate] : false");
    return false;
  }

  boolean checkFeatureDate(Date date) {
    Calendar tmp = Calendar.getInstance();
    tmp.setTime(date);
    int featureYear = tmp.get(Calendar.YEAR);
    tmp.setTime(creationDate);
    int yearOfConfirmation = tmp.get(Calendar.YEAR);

    if (yearOfConfirmation <= featureYear) {
      System.out.println("[CheckFeatureDate] : good");
      if (checkSpecial())
        return true;
      else return false;
    }
    System.out.println("[CheckFeatureDate] : false");
    return false;
  }

  boolean checkExams() {
    for (int i = 0; i < COURSE_SIZE; i++)
      if (!storage[i].hasExam) {
        System.out.println("[checkExams] Error : Title: " + storage[i].title + " hasExam = false!");
        return false;
      }
    return checkCredits();
  }

  boolean setRule(int code, Date current_date) {
    switch(code) {
      case 1:
        return checkSpecialCompulsorySubjects();
      case 2:
        return checkCurrentDate(current_date);
      case 3:
        return checkExams();
      case 4:
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
          Calendar calendar = Calendar.getInstance();
          calendar.setTime(current_date);
          String newDate_str = String.valueOf(calendar.get(Calendar.DATE)) + "-" + String.valueOf(calendar.get(Calendar.MONTH)) + "-" + String.valueOf(calendar.get(Calendar.YEAR) + 1);
          Date newDate = format.parse(newDate_str);
          System.out.println("newDate is: " + newDate + ", newDate_str is: " + newDate_str);
          return checkFeatureDate(newDate);
        } catch(ParseException e) {
          e.printStackTrace();
        }
      default: {
        System.out.println("Ошибка, неккоректно выбрано правило!");
        return false;
      }
    }
  }

  static void printDegreeList() {
    System.out.println("----------------------------------------------------------------------------------------------\n" +
        "|*************Квалификация**********|*******Кредитные единицы*******|***Специальные курсы****|" +
        "\n----------------------------------------------------------------------------------------------");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "1.Техник-программист", "20", "6, 7, 13");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "2.Экономист", "15", "");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "3.Бухгалтер", "13", "");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "4.Инженер-проектировщик", "20", "0, 1, 9");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "5.Робототехник", "16", "4, 5, 6");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "6.Биолог", "13", "10, 11");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "7.Физик-математик", "25", "0, 1, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "8.Специалист по защите информации", "26", "4, 6, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "9.Инженер по радиодэлектронике", "14", "4, 6, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "10.Инженер-системотехник", "17", "4, 6, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "11.Инженер по эклектронным системам", "26", "4, 6, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "12.Магистр радиобиологии", "23", "11, 10, 6");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "13.Магистр технических наук", "22", "4, 6, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "14.Магистр квантовой радиофизики", "21", "4, 6, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "15.Магистр физики", "21", "0, 1, 7");
    System.out.printf("|%35.35s|\t\t\t%6s\t\t\t\t|%24.9s|\n", "16.Программист-математик", "28", "0, 1, 13");
    System.out.println("----------------------------------------------------------------------------------------------");
  }

  static void printDegreeRules() {
    System.out.println("1.Обязательные спецкурсы\n2.учебная программа должна быть составлена в 2019 году или ранее; за все\n" +
        "время обучения студент должен набрать в сумме некоторое количество кредитных единиц\n3.Кредитные единицы, все прослушанные" +
        " курсы должны завершаться экзаменом\n4.Должна быть составлена в 2020 году или ранее; Кол-во спецкурсов\n");
  }

  @Override
  void print() {
    System.out.println("code: " + code + " creditsRequired: " + creditsRequired + " specialCoursesRequired: " + specialCoursesRequired + " title: " +
        title);
  }
}
