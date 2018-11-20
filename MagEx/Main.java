package MagEx;

public class Main {
  public static void main(String[] args) {
    Person firstPerson = new Person("nameOfFirstPerson", Person.Race.ELF, Person.Sex.MAN);
    Person secondPerson = new Person("nameOfSecondPerson", Person.Race.GNOME, Person.Sex.WOMAN);
    System.out.print("Info about first person: " + firstPerson.print(firstPerson));
    System.out.print("Info about second person: " + secondPerson.print(secondPerson));
    Warlock warlock = new Warlock("nameOfWarlock", Person.Race.GNOME, Person.Sex.MAN);
    System.out.println("be4: health: " + firstPerson.getHealth() + " warlock mana: " + warlock.getMana());
    PerformMagic obj = new PerformMagic();
    obj.magicEx(new Armour(), warlock, firstPerson, 15000);

    obj.magicEx(new AddHealth(), warlock, firstPerson, 40);

    System.out.println("after: health: " + firstPerson.getHealth() + " warlock mana: " + warlock.getMana());

    try {
      Thread.sleep(20000);
    } catch(InterruptedException e) {
      System.out.println(Thread.currentThread().getName() + " was interrupted");
    }
    obj.magicEx(new AddHealth(), warlock, firstPerson, 40);
    System.out.println("after: health: " + firstPerson.getHealth() + " warlock mana: " + warlock.getMana());
  }
}