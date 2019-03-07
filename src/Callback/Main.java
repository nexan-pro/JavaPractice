package Callback;

public class Main {
  public static void main(String[] args) {
    Functions obj = new Functions();
    IPerform m_perform = new Perform();
    obj.setCallback(m_perform);
    obj.performFunc();
  }
}
