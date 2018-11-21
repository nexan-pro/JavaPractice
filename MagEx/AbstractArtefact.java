package MagEx;

import java.util.Timer;
import java.util.TimerTask;

abstract class AbstractArtefact extends Config implements IMagic {
  protected int power = MAX_POWER;
}

class HealingBottle extends Config implements IMagic {
  public void performMagic(Warlock warlock, Person person, int typeOfBottle) {
    if (typeOfBottle != SMALL && typeOfBottle != MEDIUM && typeOfBottle != LARGE)
      System.out.println("performMagic: error, invalid type of bottle (SMALL, MEDIUM, LARGE)");
    else
      if (warlock.m_health + typeOfBottle > person.getMaxHealth()) {
        person.m_health = (short) Person.MAX_HEALTH;
        person.updateState(person);
      }
      else {
        person.m_health += typeOfBottle;
        person.updateState(person);
      }
  }
}

class ManaBootle extends Config implements IMagic {
  //warlock - target to spell TODO: backwards
  public void performMagic(Warlock warlock, Person person, int typeOfBottle) {
    if (typeOfBottle != SMALL && typeOfBottle != MEDIUM && typeOfBottle != LARGE)
      System.out.println("performMagic: error, invalid type of bottle (SMALL, MEDIUM, LARGE)");
    else
      if (warlock.m_mana + typeOfBottle > warlock.getMaxMana())
        warlock.m_mana = Warlock.MAX_MANA;
      else
        warlock.m_mana += typeOfBottle;
  }
}

class LightningStaff extends AbstractArtefact implements IMagic {
  private int lightning_power = this.power;
  public void performMagic(Warlock warlock, Person person, int power) {
    if (power > MAX_POWER) {
      System.out.println("LightningStaff.performMagic: not enough power, maximum power is " + MAX_POWER);
      return;
    }
    lightning_power -= power;
    person.m_health -= power;
    person.updateState(person);
    Timer t = new Timer();
    t.scheduleAtFixedRate(new TimerTask() {
      @Override
      public void run() {
        if (lightning_power < MAX_POWER)
            System.out.println("Lightning power now is  " + lightning_power++);
        else
          t.cancel();
      }
    }, 0, 1000);
  }
}

class PotionOfFrogLegs implements IMagic {
  public void performMagic(Warlock warlock, Person person, int typeOfBottle) {
    if (person.getState() == Person.State.POISONED) {
      if (person.m_health % 3 == 0)
        person.m_state = Person.State.NORMAL;
      else
        person.m_state = Person.State.WEAKENED;
    }
    else
      System.out.println("PotionOfFrogLegs: spell is not used because person state is not poisoned");
  }
}

class PoisonTeeth extends AbstractArtefact implements IMagic {
  private int teeth_power = this.power;
  public void performMagic(Warlock warlock, Person person, int power) {
    if (power > MAX_POWER) {
      System.out.println("PoisonTeeth.performMagic: not enough power, maximum power is " + MAX_POWER);
      return;
    }
    if (person.getState() == Person.State.NORMAL || person.getState() == Person.State.WEAKENED) {
      person.setState(person, Person.State.POISONED);
      person.m_health -= power;
      person.updateState(person);
      teeth_power -= power;
      Timer t = new Timer();
      t.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
          if (teeth_power < MAX_POWER)
            System.out.println("Teeth power now is  " + teeth_power++);
          else
            t.cancel();
        }
      }, 0, 1000);
    }
  }
}

class EyeOfBasilisk implements IMagic {
  public void performMagic(Warlock warlock, Person person, int power) {
    if (person.getState() != Person.State.IS_DEAD)
      person.setState(person, Person.State.PARALYZED);
    else
      System.out.println("EyeOfBasilisk: person is dead");
  }
}