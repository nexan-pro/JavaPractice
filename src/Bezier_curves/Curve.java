package Bezier_curves;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Curve extends JPanel {
  private ArrayList<Point> points;
  private static final int WIDTH = 15;
  private static final int HEIGHT = 15;
  private Point start;
  private Point control;
  private Point end;
  static Point[] g_points;

  Curve() {
    points = new ArrayList<>();
    g_points = new Point[3];
    start = new Point(150, 150);
    control = new Point(300, 30);
    end = new Point(600, 150);
  }

  public void setControl(int x, int y) {
    control.setX(x);
    control.setY(y);
  }

  void drawCurve(Graphics g) {
    setBackground(Color.darkGray);
    Graphics2D g2d = (Graphics2D) g;
    double x, y;

    g_points[0] = start;
    g_points[1] = control;
    g_points[2] = end;

    g2d.setColor(Color.GREEN);
    g2d.fillOval(start.getX(), start.getY(), WIDTH, HEIGHT);
    g2d.fillOval(control.getX(), control.getY(), WIDTH, HEIGHT);
    g2d.fillOval(end.getX(), end.getY(), WIDTH, HEIGHT);

    for (double t = 0; t < 1; t += 0.1) {
      x = Math.pow(1 - t, 2) * start.getX() + 2 * (1 - t) * t * control.getX() + Math.pow(t, 2) * end.getX();
      y = Math.pow(1 - t, 2) * start.getY() + 2 * (1 - t) * t * control.getY() + Math.pow(t, 2) * end.getY();
      points.add(new Point((int)x, (int)y));
    }
    g2d.setColor(Color.MAGENTA);
    for (Point p : points)
      g2d.fillOval(p.getX(), p.getY(), 5, 5);

    g2d.setColor(Color.RED);
    System.out.println("size of points: " + points.size() + "\nPoints coordinates: ");
    for (int i = 0; i < points.size() - 1; i ++) {
      System.out.println("x = " + points.get(i).getX() + "y = " + points.get(i).getY());
      g2d.drawLine(points.get(i).getX(), points.get(i).getY(), points.get(i + 1).getX(), points.get(i + 1).getY());
    }

    repaint(); // TODO: start repaint only if user clicks on point
    points.clear();
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawCurve(g);
  }
}

class Point {
  private int x;
  private int y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int setX(int x) {
    this.x = x;
    return x;
  }

  public int setY(int y) {
    this.y = y;
    return x;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}