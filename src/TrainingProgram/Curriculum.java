package TrainingProgram;

import java.util.Date;

class Curriculum {
  protected int code;
  protected Date creationDate, confirmationDate;
  protected static final int COURSE_SIZE = 5;
  protected static Course[] storage = new Course[COURSE_SIZE];

  Curriculum() { }

  Curriculum(Student student_, int code_, Date creationDate_, Date confirmationDate_) {
    this.code = code_;
    this.creationDate = creationDate_;
    this.confirmationDate = confirmationDate_;
  }

  void print() {
    System.out.println("code: " + code + " creationDate: " + creationDate + " confirmationDate: " + confirmationDate + "\nCourses:");
    for (int i = 0; i < storage.length; i++)
      System.out.println("Title: " + storage[i].title);
  }

  void add(Course course, int index) {
    storage[index] = course;
    System.out.println("Курс: " + storage[index].title + " успешно добавлен в Вашу учебную программу, кол-во кредитных единиц курса: "
    + (storage[index].lectureHours + 1.25 * storage[index].practiceHours) / 18);
  }

  boolean contains(String str) {
    for (int i = 0; i < storage.length; i++)
      if (str.equals(storage[i].title)) return true;
    return false;
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
    storage = tmp;
  }
}
