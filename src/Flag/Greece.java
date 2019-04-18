package Flag;

import javax.swing.*;
import java.awt.*;

public class Greece extends JPanel {

  public Greece() {
    repaint();
  }

  //white line size is 30px, blue line - 30px
  public void paint(Graphics g) {
    g.setColor(new Color(0, 93, 170));
    g.fillRect(0, 0, 50, 50);
    g.fillRect(80, 0, 50, 50);
    g.fillRect(130, 0, 320, 30);
    g.fillRect(0, 80, 50, 50);
    g.fillRect(80, 80, 50, 50);
    g.fillRect(130, 50, 320, 30);
    g.fillRect(130, 100, 320, 30);
    g.fillRect(0, 160, 450, 30);
    g.fillRect(0, 220, 450, 30);
  }
}
