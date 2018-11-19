package MagEx;

import java.util.Comparator;

class Person extends config implements Comparator<Person> {
  Person(String name, Race race, Sex sex) {
    m_id++;
    this.m_name = name;
    this.m_race = race;
    this.m_sex = sex;
    id = m_id;
  }

  enum Race  { HUMAN, GNOME, ELF, ORC, GOBLIN }
  enum Sex   { MAN, WOMAN }
  enum State { NORMAL, WEAKENED, IS_SICK, POISONED, PARALYZED, IS_DEAD }

  /************************Private fields*******************************/
  private static short m_id = 0;
  protected short m_age, m_health = 50, m_experience, id; //!< * health - unsigned variable, need to make exception construction because java don't have unsigned variables
  private String m_name;
  State m_state = State.NORMAL;
  private boolean m_isTalk, m_isMove; //!< m_sex - 1(true) => man, and alternative
  private Race m_race;
  private Sex m_sex;
  /********************************************************************/

  /************************Public get methods*******************************/
  // Get current unique id (total count of persons)
  public int getId()         { return (id);             }

  // Get current object age
  public int getAge()        { return (m_age);            }

  // Get current object health
  public int getHealth()     { return (m_health);         }

  // Get max access health
  public int getMaxHealth()  { return (super.MAX_HEALTH); }

  // Get current person experience
  public int getExperience() { return (m_experience);     }

  // Get person name
  public String getName()    { return (m_name);           }

  // Get the value of the m_sex
  public String getSex()     { return (m_sex.name());     }

  /**
   * Get current person state
   * State may be - normal, weakened, is sick, poisoned, paralyzed, is dead
   * @return person state
   */
  public String getState()   { return (m_state.name());          }

  /**
   * Get race of person
   * Race may be - human, gnome, elf, orc, goblin
   * @return person race
   */
  public String getRace()    { return (m_race.name());    }

  // Get the value of the m_isTalk
  public boolean getIsTalk() { return (m_isTalk);         }

  // Get the value of the m_isMove boolean variable
  public boolean getIsMove() { return (m_isMove);         }
  /**********************************************************************/

  /************************Public set methods*****************************/
  public State setState(Person person, State state) { return person.m_state = state; }
  /**********************************************************************/

  /************************Public methods*******************************/
  /**
   * Implementation of the compare(...) method in the interface Comparator <...>, which
   * compares 2 objects of person type by experience
   * @param lhs - left-hand side operand type of person
   * @param rhs - right-hand side operand type of person
   * @return result of compare (1 - lhs > rhs; -1 lhs < rhs; 0 - lhs == rhs)
   */
  public int compare(Person lhs, Person rhs) {
    if (lhs.getExperience() > rhs.getExperience())
      return 1;
    else if (lhs.getExperience() < rhs.getExperience())
      return -1;
    else
      return 0;
  }

  @Override
  public String toString() {
    return (Integer.toString(id) + " " + m_name + " " + m_state + " " + m_race + " "
      + m_sex + " " + m_age + " " + m_health + " " + m_experience + "\r\n");
  }

  /**
   * Update the state, which depends on the current health of the person
   * @return updated state
   */
  public String updateState() {
    int precentHealth = m_health / getMaxHealth();
    if (precentHealth < 10)
      m_state = State.WEAKENED;
    else if (precentHealth >= 10)
      m_state = State.NORMAL;
    else
      m_state = State.IS_DEAD;

    return (m_state.name());
  }

  public String print(Person person) { return (person.toString()); }
}

class Warlock extends Person {
  Warlock(String name, Race race, Sex sex) {
    super(name, race, sex);
    if (name == null || race == null || sex == null) throw new NullPointerException();
  }

  private int m_mana = super.MAX_MANA; //!< current mana

  /************************Public get methods*******************************/
  public int getMana()      { return (m_mana);          }
  public int getMaxMana()   { return (super.MAX_MANA);  }
  /************************************************************************/

  /***************************** Logic ************************************/
  protected boolean isManaHandle(Warlock warlock, int mana) {
    if (warlock.m_mana < mana)
      return false;
    return true;
  }
  /************************************************************************/

  /**************************** Spells ***********************************/
  /**
   * Healing person
   * @param warlock - warlock which want to heal person
   * @param person - person you want to heal
   * @param amount - amount of unit to heal
   */
  public void healing(Warlock warlock, Person person, int amount) {
    if (!isManaHandle(warlock, amount * 2)) {
      System.out.println("Missing mana");
      return;
    }
    else if (getHealth() >= getMaxHealth() || warlock.m_health + amount > getMaxHealth()) {
      System.out.println("You have maximum health or amount too large");
      return;
    }
    else if (getHealth() <= 0) {
      System.out.println("You died");
      return;
    }
    else {
      person.m_health += amount;
      warlock.m_mana -= amount * 2;
    }
  }
  /**********************************************************************/
}