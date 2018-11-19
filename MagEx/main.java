package MagEx;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class main {
  public void givenUsingTimer_whenSchedulingTaskOnce_thenCorrect() {
    TimerTask task = new TimerTask() {
      public void run() {
        System.out.println("Task performed on: " + new Date() + "n" +
          "Thread's name: " + Thread.currentThread().getName());
      }
    };
    Timer timer = new Timer("Timer");

    long delay = 10001L;
    timer.schedule(task, delay);
  }

  public static void main(String[] args) {
    main obj = new main();
    obj.givenUsingTimer_whenSchedulingTaskOnce_thenCorrect();
//    Person firstPerson = new Person("nameOfFirstPerson", Person.Race.ELF, Person.Sex.MAN);
//    Person secondPerson = new Person("nameOfSecondPerson", Person.Race.GNOME, Person.Sex.WOMAN);
//    System.out.print("Info about first person: " + firstPerson.print(firstPerson));
//    System.out.print("Info about second person: " + secondPerson.print(secondPerson));
//    Warlock warlock = new Warlock("nameOfWarlock", Person.Race.GNOME, Person.Sex.MAN);
//    System.out.println("be4: health: " + firstPerson.getHealth() + " warlock mana: " + warlock.getMana());
//    PerformMagic obj = new PerformMagic();
//    obj.magicEx(new AddHealth(), warlock, firstPerson, 40);
//    System.out.println("after: health: " + firstPerson.getHealth() + " warlock mana: " + warlock.getMana());
  }
}
