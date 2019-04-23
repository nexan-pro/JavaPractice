package Multithreading.task_1Ex;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import static java.lang.Thread.currentThread;

public class Demonstrator extends JFrame implements Observer, Runnable {

  private JTextPane calc_editor;
  private JScrollPane calc_editorScrollPane;
  private JTextPane demo_editor;
  private JScrollPane demo_editorScrollPane;
  private int duration;
  private int R;
  private int maxCoord;
  private int cntOfShoots;
  private boolean status;
  private Thread t;
  private final AtomicBoolean running = new AtomicBoolean(false);

  Demonstrator(int duration, int R, int maxCoord, int cntOfShoots) {
    super("Events");

    this.duration = duration;
    this.R = R;
    this.maxCoord = maxCoord;
    this.cntOfShoots = cntOfShoots;
    t = new Thread(this);
    t.start();

    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.getContentPane().setBackground(Color.darkGray);
    createGUI();
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void createGUI() {
    /******************************* Calc GUI components **************************************************/
    JPanel jCalc_pnl = new JPanel();
    try {
      calc_editor = new JTextPane();
      demo_editor = new JTextPane();
    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, ex.getMessage());
    }
    setLayout(new FlowLayout());
    calc_editor.setContentType("text");
    calc_editor.setBackground(Color.BLACK);
    calc_editor.setForeground(Color.green);
    calc_editor.setPreferredSize(new Dimension(150, 250));
    calc_editor.setEditable(false);
    calc_editorScrollPane = new JScrollPane(calc_editor, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    jCalc_pnl.add(calc_editorScrollPane);

    JButton jCalc_btn = new JButton();
    jCalc_btn.setText("Stop calc");
    jCalc_btn.setSize(new Dimension(75, 45));
    jCalc_btn.setVisible(true);
    jCalc_btn.setBackground(Color.BLACK);
    jCalc_btn.setForeground(Color.cyan);
    jCalc_btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("caught calc event");
        Calculator.stop_calc();
      }
    });
    jCalc_pnl.setBackground(Color.GRAY);
    jCalc_pnl.add(jCalc_btn);
    jCalc_pnl.setBorder(BorderFactory.createTitledBorder("Calculator"));
    add(jCalc_pnl);
    /***************************************************************************************************************/

    /******************************* Demonstrator GUI components **************************************************/
    JPanel jDemo_pnl = new JPanel();
    demo_editor.setContentType("text");
    demo_editor.setBackground(Color.BLACK);
    demo_editor.setForeground(Color.green);
    demo_editor.setPreferredSize(new Dimension(150, 250));
    demo_editor.setEditable(false);
    demo_editorScrollPane = new JScrollPane(demo_editor, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
        JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    jDemo_pnl.add(demo_editorScrollPane);

    JButton jDemo_btn = new JButton();
    jDemo_btn.setText("Stop shooting");
    jDemo_btn.setSize(new Dimension(75, 45));
    jDemo_btn.setVisible(true);
    jDemo_btn.setBackground(Color.BLACK);
    jDemo_btn.setForeground(Color.cyan);
    jDemo_btn.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.out.println("caught demo event");
        if (Calculator.status) Calculator.status = false;
        status = false;
      }
    });
    jDemo_pnl.setBackground(Color.GRAY);
    jDemo_pnl.add(jDemo_btn);
    jDemo_pnl.setBorder(BorderFactory.createTitledBorder("Demonstrator"));
    add(jDemo_pnl);

    /***************************************************************************************************************/
  }

  @Override
  public void run() {
    running.set(true);
    System.out.println("Running new demo-thread: " + currentThread().getId());
    shooting(cntOfShoots);
  }

  void shooting(int cntOfShoots) {
    status = true;
    double x, y;
    boolean flag = false;
    Random rand = new Random();
    String line;
    for (int i = 0; i < cntOfShoots; ++i) {
      try {
        Thread.sleep(duration);
      } catch(InterruptedException e) {
        Thread.currentThread().interrupt();
        System.out.println("Thread was interrupted: " + e.getMessage());
      }

      if (!status) {
        System.out.println("Leave from demo main loop!");
        running.set(false);
        break;
      }
      x = rand.nextInt(maxCoord);
      y = rand.nextInt(maxCoord);
      System.out.print("x = " + x + " y = " + y);
      if (x > -R && x < R && y > -R && y < R) {
        //System.out.println("popal v kvadrat");
        flag = true;
        if (Math.pow((-R - x), 2) + Math.pow(R - y, 2) < Math.pow(R, 2)) {
          //System.out.println("promah verh");
          flag = false;
        }
        if (Math.pow(R - x, 2) + Math.pow(-R - y, 2) < Math.pow(R, 2)) {
          //System.out.println("promah nizh");
          flag = false;
        }
      }
      if (flag) {
        line = "(" + x + ", "  + y + ") = hit\n";
        append(line, demo_editor);
      }
    }
  }


  private void append(String s, JTextPane instance) {
    try {
      Document doc = instance.getDocument();
      doc.insertString(doc.getLength(), s, null);
    } catch(BadLocationException e) {
      System.out.println(e.getMessage());
    }
  }

  @Override
  public void update(long s, int n, int k) {
    String sStirlingLine = "s(" + n + ", " + k + ") = " + s + "\n";
    append(sStirlingLine, calc_editor);
  }

}
