package MagEx;

import java.util.Timer;

abstract class AbstractSpells implements IMagic {
  private static int[] min_mana = {
    20, // for Cure
    30, // for Antidote
    150, // for Revive
    50, // for Armour
    85, // for BreakDown
  };
  boolean isVerbal_component, isMotor_component; //TODO:

  public static int getMinMana(int index) { return (min_mana[index]); }
}

class AddHealth implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
      warlock.healing(warlock, person, strength);
  }
}

class Cure implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
    if ((person.getState() == Person.State.IS_SICK) && (warlock.isManaHandle(warlock, AbstractSpells.getMinMana(0))))
      if (warlock.getMana() % 3 == 0)
        person.setState(person, Person.State.NORMAL);
      else
        person.setState(person, Person.State.WEAKENED);
    else
      System.out.println("performMagic: person state is not IS_SICK or missing mana"); //TODO: exceptions
  }
}

class Antidote implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
    if ((person.getState() == Person.State.POISONED) && (warlock.isManaHandle(warlock, AbstractSpells.getMinMana(1))))
      if (warlock.getMana() % 2 == 0)
        person.setState(person, Person.State.NORMAL);
      else
        person.setState(person, Person.State.WEAKENED);
    else
      System.out.println("performMagic: person state is not POISONED or missing mana"); //TODO: exceptions
  }
}

class Revive implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
    if ((person.getState() == Person.State.IS_DEAD) && (warlock.isManaHandle(warlock, AbstractSpells.getMinMana(2)))) {
      if (warlock.getMana() % 2 == 0)
        person.setState(person, Person.State.NORMAL);
      else {
        person.setState(person, Person.State.WEAKENED);
        person.m_health = 1;
        person.updateState(person);
      }
    } else
      System.out.println("performMagic: person state is not IS_DEAD or missing mana"); //TODO: exceptions
  }
}

class Armour implements IMagic {
  /**
   *
   * @param warlock -
   * @param person -
   * @param strength - period (mins) to god mode, 15s = 50 units of mana, if MAX_MANA = 150 e.g. max seconds ~ 45s
   */
  public void performMagic(Warlock warlock, Person person, int strength) {
    int manaForSpell =  (strength <= 45000 && strength >= 15000) ? strength / 15000 *
                        AbstractSpells.getMinMana(3) : -1; // minimum of strength is 15s(15000ms)

    if (warlock.isManaHandle(warlock, AbstractSpells.getMinMana(3)) &&
        manaForSpell != -1) {
      warlock.m_mana -= manaForSpell;
      Timer t = new Timer();
      TimerTaskCore at = new TimerTaskCore(warlock, person, strength);
      t.schedule(at,0);
      /************** Test main thread sleep in order to see the difference between threads ***************/
      try {
        Thread.sleep(1);
      } catch(InterruptedException e) {
        System.out.println(Thread.currentThread().getName() + " was interrupted");
      }
      /**************************************************************************************************/
      t.cancel();
  } else
    System.out.println("performMagic: Armour; This error could occur due to:\r\n\t no mana; " +
                       "\r\n\t strength less than 15000(ms) ~ 15s");
}

class BreakDown implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
    if ((person.getState() == Person.State.PARALYZED) && (warlock.getMana() >= AbstractSpells.getMinMana(4))) {
      if (warlock.getMana() % 2 == 0)
        person.setState(person, Person.State.NORMAL);
      else {
        person.setState(person, Person.State.WEAKENED);
        person.m_health = 1;
        person.updateState(person);
      }
    } else
      System.out.println("performMagic: person state is not PARALYZED or missing mana"); //TODO: exceptions
    }
  }
}

class PerformMagic {
  void magicEx(IMagic IVar, Warlock warlock, Person person, int strength) {
    if (warlock.isGodMode(person)) {
      System.out.println("Spell is not used because person have armour");
      return;
    }
    IVar.performMagic(warlock, person, strength);
  }
}