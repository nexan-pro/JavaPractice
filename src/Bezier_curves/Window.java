package Bezier_curves;

import javax.swing.*;

public class Window extends JFrame {
  Window() {
    super("Bezier curve");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(700, 700);


    setResizable(false);
    setLocationRelativeTo(null);
    Curve bCurve = new Curve();
    add(bCurve);
    MouseHandler h_mouse = new MouseHandler();
    addMouseListener(h_mouse);
    setVisible(true);
  }

}
