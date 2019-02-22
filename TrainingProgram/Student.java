package TrainingProgram;

import java.util.Date;

class Student {
  private int applicationNumber;
  private String surname, name, patronymic;
  private Date birthDate;

  public static final int COURSE_SIZE = 5;

  Student() { }

  Student(int app_num, String surname_, String name_, String patronymic_, Date birthDate_) {
    this.applicationNumber = app_num;
    this.surname = surname_;
    this.name = name_;
    this.patronymic = patronymic_;
    this.birthDate = birthDate_;
  }

  Student(Student student) {
    this.applicationNumber = student.applicationNumber;
    this.surname = student.surname;
    this.name = student.name;
    this.patronymic = student.patronymic;
    this.birthDate = student.birthDate;
  }

  void print() {
    System.out.println("App num: " + applicationNumber + "\r\nFullname: " + surname + " " + name + " " + patronymic + "\r\nbirthDate: " + birthDate);
  }
}

class Curriculum extends Student {
  private int code;
  private Date creationDate, confirmationDate;
  protected Course[] storage = new Course[COURSE_SIZE];

  Curriculum() { }

  Curriculum(Student student, int code_, Date creationDate_, Date confirmationDate_) {
    super(student);
    this.code = code_;
    this.creationDate = creationDate_;
    this.confirmationDate = confirmationDate_;
  }

  Curriculum(Student student, Curriculum curr) {
    super(student);
    this.code = curr.code;
    this.creationDate = curr.creationDate;
    this.confirmationDate = curr.confirmationDate;
  }

  @Override
  void print() {
    System.out.println("code: " + code + " creationDate: " + creationDate + " confirmationDate: " + confirmationDate + "\nCourses:");
    for (int i = 0; i < storage.length; i++)
      System.out.println("Title: " + storage[i].title);
  }

  void add(Course course, int index) {
    storage[index] = course;
  }

  boolean contains(String str) {
    for (int i = 0; i < storage.length; i++)
      if (str.equals(storage[i].title)) return true;
    return false;
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

  void delete(int code) {
    int cnt = 0;
    for (int i = 0; i < storage.length; i++)
      if (storage[i].code == code) cnt++;
    int ecx = 0;
    Course[] tmp = new Course[COURSE_SIZE - cnt];
    for (int i = 0; i < storage.length; i++)
      if (storage[i].code != code) {
        tmp[ecx] = storage[i];
        ecx++;
      }
    this.storage = tmp;
  }
}

class Degree extends Curriculum {
  private int code, creditsRequired, specialCoursesRequired;
  private String title;

  Degree(Student student, Curriculum curr, int code_, int creditsRequired_, int specialCoursesRequired_, String title_) {
    super(student, curr);
    this.code = code_;
    this.creditsRequired = creditsRequired_;
    this.specialCoursesRequired = specialCoursesRequired_;
    this.title = title_;
  }

  boolean checkCredits(Curriculum curr) {
    double curriculumTotalCredits = 0;
    for (int i = 0; i < curr.storage.length; i++) {
      curriculumTotalCredits += (curr.storage[i].lectureHours + 1.25 * curr.storage[i].practiceHours) / 18;
      if (curr.storage[i].hasExam) curriculumTotalCredits++;
      if (curr.storage[i].hasCoursePaper) curriculumTotalCredits += 2;
    }
    System.out.println("curriculumTotalCredits: " + curriculumTotalCredits);
    return (creditsRequired < curriculumTotalCredits) ? true : false;
  }

  boolean checkSpecial(Curriculum curr) {
    int cntSpecial = 0;
    for (int i = 0; i < curr.storage.length; i++)
      if (curr.storage[i].isSpecial)
        cntSpecial++;
    return (specialCoursesRequired > cntSpecial) ? false : true;
  }
}

class Course extends Curriculum  {
  protected int code, lectureHours, practiceHours;
  protected String title;
  protected boolean isSpecial, hasExam, hasCoursePaper;
  protected int[] prerequisities = new int[2];
  protected static final String[] COURSES = { "Логика" , "Теория алгоритмов", "Компьютерное обучение", "Нейронные сети",
      "Защита аппаратных средств", "Криптография", "Информатика", "Математика", "Разработка технологии искусственного интеллекта",
      "Введение в программирование с MATLAB", "Введение в генетику человеческого поведения", "Бактериальные и хронические инфекции",
      "Теория вероятностей", "Дискретная математика", "Основы обработки цифровых видео и изображений"};

  Course() { }

  Course(int code_, int lectureHours_, int practiceHours_, String title_, boolean isSpecial_, boolean hasExam_, boolean hasCoursePaper_, int[] prerequisities_) {
    this.code = code_;
    this.lectureHours = lectureHours_;
    this.practiceHours = practiceHours_;
    this.title = title_;
    this.isSpecial = isSpecial_;
    this.hasExam = hasExam_;
    this.hasCoursePaper = hasCoursePaper_;
    this.prerequisities = prerequisities_;
  }

}