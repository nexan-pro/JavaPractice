package Bezier_curves;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseHandler extends MouseAdapter {

  private int pr_x;
  private int pr_y;
  private int r_x;
  private int r_y;
  private boolean isPoint;

  @Override
  public void mouseReleased(MouseEvent e) {
    System.out.println("Mouse released on(" + e.getX() + ", " + e.getY() + ")");
    if (isPoint) {
      this.r_x = e.getX();
      this.r_y = e.getY();
      Curve.g_points[1].setX(e.getX());
      Curve.g_points[1].setY(e.getY());
    }
  }

  @Override
  public void mousePressed(MouseEvent e) {
    if (Curve.g_points[1].getX() <= e.getX() && e.getX() <= Curve.g_points[1].getX() + 15
        && e.getY() >= Curve.g_points[1].getY() + 25 && e.getY() <= Curve.g_points[1].getY() + 40) {
      isPoint = true;
      System.out.println("action");
    }
    System.out.println("Mouse pressed on(" + e.getX() + ", " + e.getY() + ")");
    this.pr_x = e.getX();
    this.pr_y = e.getY();
  }

  public int getPr_y() {
    return pr_y;
  }

  public int getPr_x() {
    return pr_x;
  }

  public int getR_x() {
    return r_x;
  }

  public int getR_y() {
    return r_y;
  }
}
