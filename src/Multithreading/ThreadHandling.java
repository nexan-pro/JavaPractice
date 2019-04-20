package Multithreading;

import java.util.Random;

class ThreadHandling extends Thread {

  private Thread[] t;
  int[] sequence;
  private int[] offcuts;
  private int it; // current offcut iteration
  Integer num = 7; // the value by which we will multiply the array
  Integer k = 20; // complication

  @Override
  public void run() {
    System.out.print("thread start: " + currentThread().getName());
    int start = (it == 0) ? 0 : offcuts[it - 1];
    int end = offcuts[it];

    System.out.printf(" (start index: %d, end index: %d)\n", start, end);

    for (; start < end; start++)
      sequence[start] *= num;

    for (; start < end; start++)
      for (int i = 0; i < k; i++)
        sequence[start] += Math.pow(sequence[start], 1.789);

    it++;
  }

  public void test_report() {
    long[] elapsed_times = new long[5];
    long start_time = System.currentTimeMillis();
    this.mul(10, 2);
    long end_time = System.currentTimeMillis();
    elapsed_times[0] = end_time - start_time;

    start_time = System.currentTimeMillis();
    this.mul(100, 3);
    end_time = System.currentTimeMillis();
    elapsed_times[1] = end_time - start_time;

    start_time = System.currentTimeMillis();
    this.mul(1000, 4);
    end_time = System.currentTimeMillis();
    elapsed_times[2] = end_time - start_time;

    start_time = System.currentTimeMillis();
    this.mul(10000, 5);
    end_time = System.currentTimeMillis();
    elapsed_times[3] = end_time - start_time;

    start_time = System.currentTimeMillis();
    this.mul(100000, 10);
    end_time = System.currentTimeMillis();
    elapsed_times[4] = end_time - start_time;

    System.out.println("Total summary: ");
    System.out.println("--------------------------------------");
    System.out.println("|\tN\t|\tM\t|  Elapsed time (ms) |");
    System.out.println("--------------------------------------");
    System.out.printf("|%-7d|%-7d|%-20d|\n", 10, 2, elapsed_times[0]);
    System.out.printf("|%-7d|%-7d|%-20d|\n", 100, 3, elapsed_times[1]);
    System.out.printf("|%-7d|%-7d|%-20d|\n", 1000, 4, elapsed_times[2]);
    System.out.printf("|%-7d|%-7d|%-20d|\n", 10000, 5, elapsed_times[3]);
    System.out.printf("|%-7d|%-7d|%-20d|\n", 100000, 10, elapsed_times[4]);
    System.out.println("--------------------------------------");
  }

  private void generateArray(int[] array) {
    int rand_n;
    Random rand = new Random();
    for (int i = 0; i < array.length; i++) {
      rand_n = rand.nextInt(500);
      ++rand_n;
      array[i] = rand_n;
    }
  }

  int[] divide(int n, int m) {
    int remainder = n % m;
    int mid = n / m;
    int[] separator = new int[m];
    int step = 0;
    if (remainder > 0) {
      for (int i = 0; i < m - 1; i++) {
        step += mid;
        separator[i] = step;
      }

      separator[m - 1] = step + mid + remainder;
    } else {
      for (int i = 0; i < m; i++) {
        step += mid;
        separator[i] += step;
      }
    }

    return separator;
  }
  
  int mul(int n, int m) {
    t = new Thread[m];
    sequence = new int[n];

    generateArray(sequence);

    System.out.print("generated array is: ");
    for (int i = 0; i < sequence.length; i++)
      System.out.print(sequence[i] + " ");
    System.out.println();

    if (sequence.length / 2 < m) System.out.println("Error, array length < num of parts");

    offcuts = divide(sequence.length, m);

    System.out.print("generated offcuts is: ");
    for (int i = 0; i < offcuts.length; i++)
      System.out.print(offcuts[i]  + " ");
    System.out.println();


    for (int i = 0; i < m; i++) {
      t[i] = new Thread(this);
      t[i].start();
      try {
        t[i].join();
      } catch (Exception ex) {
        System.out.println("Exception has been caught: " + ex);
      }
    }
    it = 0;
    return n;
  }
}
