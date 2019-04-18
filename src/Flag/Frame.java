package Flag;

import java.awt.*;

import javax.swing.*;

public class Frame extends JFrame {
  Greece instance;

  public Frame() {
    super("Greece flag");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(450, 280);
    setResizable(false);

    init();


  }

  private void init() {
    setLocationRelativeTo(null);
    setLayout(new GridLayout(1, 1, 0, 0));

    instance = new Greece();
    add(instance);
    setVisible(true);
  }

  public static void main(String[] args) {
    new Frame();
  }
}

