package MagEx;

public class main {
  public static void main(String[] args) {

    Person unit = new Person("test", Person.Race.ELF, Person.Sex.MAN);
    Person unit1 = new Person("test1", Person.Race.GNOME, Person.Sex.WOMAN);
    System.out.print(unit1.getSex());
    unit.print(unit);
    Warlock warlock = new Warlock("magiUnit", Person.Race.GNOME, Person.Sex.MAN);
    System.out.println("be4: \r\nhealth: " + warlock.getHealth() + "\r\nmana: " + warlock.getMana());
    warlock.healing(warlock, 40);
    System.out.println("after: \r\nhealth: " + warlock.getHealth() + "\r\nmana: " + warlock.getMana());

  }
}
