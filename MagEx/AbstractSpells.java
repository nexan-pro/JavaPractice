package MagEx;

abstract class AbstractSpells implements IMagic {
  int[] min_mana;
  boolean verbal_component, motor_component;
}

class AddHealth implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
      warlock.healing(warlock, person, strength);
  }
}

class Cure implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
    if ((person.getState() == Person.State.IS_SICK.name()) && (warlock.getMana() >= 20))
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
    if ((person.getState() == Person.State.POISONED.name()) && (warlock.getMana() >= 30))
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
    if ((person.getState() == Person.State.IS_DEAD.name()) && (warlock.getMana() >= 150)) {
      if (warlock.getMana() % 2 == 0)
        person.setState(person, Person.State.NORMAL);
      else
        person.setState(person, Person.State.WEAKENED);
      person.m_health = 1;
    } else
      System.out.println("performMagic: person state is not IS_DEAD or missing mana"); //TODO: exceptions
  }
}

class Armour implements IMagic {
  /**
   *
   * @param warlock -
   * @param person -
   * @param strength - period (mins) to god mode, 1 min = 50 units of mana
   */
  public void performMagic(Warlock warlock, Person person, int strength) {
    if (warlock.getMana() >= 50) {

    //TODO:
  }
}

class BreakDown implements IMagic {
  public void performMagic(Warlock warlock, Person person, int strength) {
    if ((person.getState() == Person.State.PARALYZED.name()) && (warlock.getMana() >= 85)) {
      if (warlock.getMana() % 2 == 0)
        person.setState(person, Person.State.NORMAL);
      else
        person.setState(person, Person.State.WEAKENED);
      person.m_health = 1;
    } else
      System.out.println("performMagic: person state is not PARALYZED or missing mana"); //TODO: exceptions
  }
  }
}

class PerformMagic {
  void magicEx(IMagic test, Warlock warlock, Person person, int strength) {
    test.performMagic(warlock, person, strength);
  }
}