package Flag.Panama;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {
  Panama instance;

  public Frame() {
    super("Panama flag");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450, 280);
    setResizable(false);

    init();
  }

  private void init() {
    setLocationRelativeTo(null);
    setLayout(new GridLayout(1, 1, 0, 0));

    instance = new Panama();
    add(instance);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Frame();
  }
}

