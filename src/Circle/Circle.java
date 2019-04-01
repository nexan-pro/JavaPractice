package Circle;

public class Circle {
  int r;
  double square;

  Circle() { }

  Circle(int r) {
    try {
      if (r < 0) throw new RuntimeException("Invalid value!");
      this.r = r;
      this.square = Math.PI * Math.pow(r, 2);
    } catch (RuntimeException e) {
      System.out.println(e.getMessage());
    }
  }

  double getSquare() {
    return square;
  }

  double add(double lhs) {
    this.r *= lhs;
    this.square = Math.PI * Math.pow(r, 2);
    return r;
  }

  /**
   * @return Information about our object
   */
  @Override
  public String toString() {
    return ("R: " + this.r + " S: " + this.square);
  }
}
