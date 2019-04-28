package Events;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DoubleClick {
  public static void main(String[] args) {
    JTextField textField = new JTextField();
    textField.addMouseListener(new Handle());
    JFrame frame = new JFrame();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(textField);
    frame.setLocationRelativeTo(null);
    frame.setSize(150, 150);
    frame.setVisible(true);

    textField.addMouseListener(new Handle());
  }
}

class Handle extends MouseAdapter {
  public void mouseClicked(MouseEvent e) {
    if (e.getClickCount() == 2)
      System.out.println("Double-click");
  }
}