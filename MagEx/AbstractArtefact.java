package MagEx;

import java.util.Timer;

abstract class AbstractArtefact implements IMagic {
  int power;
}

class HealingBottle extends Config implements IMagic {
  public void performMagic(Warlock warlock, Person person, int typeOfBottle) {
    if (typeOfBottle != small && typeOfBottle != medium && typeOfBottle != large) {
      System.out.println("performMagic: error, invalid type of bottle (small, medium, large)");
      return;
    }
    else
      if (warlock.m_health + typeOfBottle > person.getMaxHealth())
        person.m_health = (short)Person.MAX_HEALTH;
      else
        person.m_health += typeOfBottle;
  }
}

class ManaBootle extends Config implements IMagic {
  //warlock - target to spell TODO: backwards
  public void performMagic(Warlock warlock, Person person, int typeOfBottle) {
    if (typeOfBottle != small && typeOfBottle != medium && typeOfBottle != large) {
      System.out.println("performMagic: error, invalid type of bottle (small, medium, large)");
      return;
    }
    else
      if (warlock.m_mana + typeOfBottle > warlock.getMaxMana())
        warlock.m_mana = Warlock.MAX_MANA;
      else
        warlock.m_mana += typeOfBottle;
  }
}

class LightningWand extends AbstractArtefact implements IMagic {
  public void performMagic(Warlock warlock, Person person, int power) {
    Timer t = new Timer();
    //TODO: all class
  }
}