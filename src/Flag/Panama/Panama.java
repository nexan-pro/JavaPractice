package Flag.Panama;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.GeneralPath;

public class Panama extends JPanel {

  int blue_star_x = 70;
  int blue_star_y = 0;
  int red_star_x = 300;
  int red_star_y = 120;

  public Panama() {
    repaint();
  }

  @Override
  public void paint(Graphics g) {
    g.setColor(new Color(0, 0, 255));
    g.fillRect(0, 140, 225, 140);
    int xPoints[] = { 42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42 };
    int yPoints[] = { 38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38 };
    Graphics g2d = (Graphics2D)g;
    GeneralPath blue_star = new GeneralPath();
    blue_star.moveTo(xPoints[0] + blue_star_x, yPoints[0] + blue_star_y);
    for (int i = 1; i < xPoints.length; i++)
      blue_star.lineTo(xPoints[i] + blue_star_x, yPoints[i] + blue_star_y);
    blue_star.closePath();
    g2d.setColor(Color.BLUE);
    ((Graphics2D) g2d).fill(blue_star);

    g.setColor(new Color(255, 0, 0));
    g.fillRect(225, 0, 225, 140);

    int zxPoints[] = { 42, 52, 72, 52, 60, 40, 15, 28, 9, 32, 42 };
    int zyPoints[] = { 38, 62, 68, 80, 105, 85, 102, 75, 58, 60, 38 };
    GeneralPath red_star = new GeneralPath();
    red_star.moveTo(zxPoints[0] + red_star_x, zyPoints[0] + red_star_y);
    for (int i = 1; i < zxPoints.length; i++)
      red_star.lineTo(zxPoints[i] + red_star_x, zyPoints[i] + red_star_y);
    red_star.closePath();
    g2d.setColor(Color.RED);
    ((Graphics2D) g2d).fill(red_star);
  }
}
