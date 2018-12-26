package Serializable;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.*;
import java.util.*;

public class main {
  @XmlRootElement
  public static class Student implements Serializable {
    @XmlElement
    String surname, name, patronymic;
    @XmlElement
    int numberOfGroup;
    @XmlElement
    int[] progress = new int[5];
    @XmlElement(name = "students")
    private List<Student> students = null;
    void setStudents(List<Student> students) {
      this.students = students;
    }
    List<Student> getStudent() {
      return students;
    }
  }
  public static void main(String[] args) {
    Student students = new Student();
    students.setStudents(new ArrayList<Student>());
    Scanner input = new Scanner(System.in);
    Map bad = new HashMap<String, Integer>();
    int size = 3;
    Student[] obj = new Student[size];
    for (int i = 0; i < size; i++)
      obj[i] = new Student(); //initialize all objects

    for (int i = 0; i < size; ++i) {
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
      students.getStudent().add(obj[i]);
      System.out.println();
      input.nextLine();
    }
    System.out.println("Output array of objects: ");
    System.out.println("~~~~~~~Array without sort: ~~~~~~~~");
    print(obj, size);
    System.out.println("~~~~~~~Modified array: ~~~~~~~");
    sort(obj, size);
    print(obj, size);
    System.out.println("=================================\r\n");
    System.out.println((bad.isEmpty()) ? "Error, students with 2 not found" : bad);
    serializable(obj, size);
    Student[] newStudents = deserializable(size);

    System.out.println("Output from binary file deserialization: ");
    for (Student p : newStudents)
      System.out.printf("Surname: %s \t Name: %s \t Patronymic: %s \n", p.surname, p.name, p.patronymic);

    toXml(students);
    System.out.println("Output from XML file deserialization: ");
    fromXml();
  }

  static boolean fromXml() {
    try {
      System.out.println("XML deserialization start");
      JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

      Student students = (Student)jaxbUnmarshaller.unmarshal(new File("src/Serializable/students.xml"));
      for (Student st : students.getStudent())
        System.out.println("Surname/Name/Patronymic: " + st.surname + " " + st.name + " " + st.patronymic);
      return true;
    } catch (JAXBException e) {
      e.printStackTrace();
      return false;
    }
  }

  static boolean toXml(Student students) {
    try {
      System.out.println("XML serialization start");
      File file = new File("src/Serializable/students.xml");
      JAXBContext jaxbContext = JAXBContext.newInstance(Student.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

      jaxbMarshaller.marshal(students, file);
      System.out.println("Success saved in: " + file.getPath());
      return true;
    } catch (JAXBException e) {
      e.printStackTrace();
      return false;
    }
  }

  static boolean serializable(Student[] students, int size) {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("src/Serializable/students.dat")))
    {
      for (int i = 0; i < size; ++i)
        oos.writeObject(students[i]);
      return true;
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
      return false;
    }
  }

  static Student[] deserializable(int size) {
    Student[] newPeople = new Student[size];
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("src/Serializable/students.dat")))
    {
      for (int i = 0; i < size; ++i)
        newPeople[i] = (Student)ois.readObject();
    }
    catch (Exception ex) {
      System.out.println(ex.getMessage());
    }
    return newPeople;
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
        if (obj[j].surname.compareTo(obj[i].surname) < 0) {
          Student tmp = obj[i];
          obj[i] = obj[j];
          obj[j] = tmp;
        }
      }
    return (obj);
  }
}

