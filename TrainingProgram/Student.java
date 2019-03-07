package TrainingProgram;

import java.util.Date;

class Student extends Curriculum {
  private int applicationNumber;
  private String surname, name, patronymic;
  private Date birthDate;

  Student(int app_num, String surname_, String name_, String patronymic_, Date birthDate_) {
    this.applicationNumber = app_num;
    this.surname = surname_;
    this.name = name_;
    this.patronymic = patronymic_;
    this.birthDate = birthDate_;
  }

  @Override
  void print() {
    System.out.println("App num: " + applicationNumber + "\r\nFullname: " + surname + " " + name + " " + patronymic + "\r\nbirthDate: " + birthDate);
  }
}

