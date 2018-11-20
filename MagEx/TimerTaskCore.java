package MagEx;

import java.util.Date;
import java.util.TimerTask;

public class TimerTaskCore extends TimerTask {
  private boolean isAlive = false;
  Warlock warlock;
  Person person;
  int strength; // unit of time - ms

  TimerTaskCore(Warlock warlock, Person person, int strength) {
    this.warlock = warlock;
    this.person = person;
    this.strength = strength;
  }

  public void run() {
    this.isAlive = true;
    long startTime = System.currentTimeMillis();
    long elapsedTime = 0L;
    Person.State tmpState = person.getState();

    while (elapsedTime < strength) {

      person.setState(person, Person.State.GOD);
      elapsedTime = (new Date()).getTime() - startTime;
//      System.out.println("elapsed time = " + elapsedTime);
//      try {
//        Thread.sleep(100);
//      } catch (InterruptedException e) {
//        System.out.println(Thread.currentThread().getName() + " was interrupted");
//      }
    }
    person.setState(person, tmpState);
    this.isAlive = false;
  }

  public boolean isAlive() {
    return this.isAlive;
  }
}
