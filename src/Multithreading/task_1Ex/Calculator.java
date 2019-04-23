package Multithreading.task_1Ex;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Calculator extends Thread implements Observable {
  private Thread t;
  private Observer o;
  private long s;
  private int n;
  private int k;
  private int relax;
  private int cnt;
  static boolean status;
  private final AtomicBoolean running = new AtomicBoolean(false);

  Calculator(int relax, Observer o, int cnt) {
    this.cnt = cnt;
    this.relax = relax;
    this.o = o;
    t = new Thread(this);
    t.start();
  }

  @Override
  public void run() {
    running.set(true);
    System.out.println("\nRunning new calc-thread: " + currentThread().getId());
    start(cnt);
  }

  static void stop_calc() {
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
        System.out.println("Leave from calc main loop");
        running.set(false);
        break;
      }
      n = rand.nextInt(10) + 1;
      k = rand.nextInt(2) + 1;

      s = getStirlingNum(n, k);
      notifyObserver();

      try {
        Thread.sleep(relax);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread was interrupted: " + e.getMessage());
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
