package Events.task_1;

import java.util.Random;

public class Calculator implements Observable {
  private Observer o = new Demonstrator();
  private long s;
  private int n;
  private int k;
  private int relax;
  private static boolean status;

  Calculator(int relax) {
    this.relax = relax;
  }

  static void stop() {
    status = false;
    System.out.println("Current thread: " + Thread.currentThread());
    Thread.currentThread().stop();
  }

  @Override
  public void notifyObserver() {
    o.update(s, n, k);
  }

  void start(int cnt) {
    status = true;
    Random rand = new Random();
    for (int i = 0; i < cnt; i++) {
      if (!status)  {
        System.out.println("Leave from main loop");
        break;
      }
      n = rand.nextInt(10) + 1;
      k = rand.nextInt(2) + 1;

      s = getStirlingNum(n, k);
      notifyObserver();

      try {
        Thread.sleep(relax);
      } catch(InterruptedException e) {
        System.out.println(e.getMessage());
      }
    }
  }

  private long getStirlingNum(int n, int k) {
    if (n == 0 && k == 0) return 1;
    if (n > 0 && k == 0) return 0;
    if (n == 0 && k > 0) return 0;
    if (0 < k && k < n)
      return (n - 1) * getStirlingNum(n - 1, k) + getStirlingNum(n - 1, k - 1);
    return 1;
  }
}
