package Circle;

public class Ring extends Circle {
  int rin;
  double inSquare;
  Ring(int r, int rin) {
    super(r);
    this.rin = rin;
  }

  @Override
  double getSquare() {
    this.inSquare = this.square - inSquare;
    return this.inSquare;
  }

  @Override
  double add(double lhs) {
    this.rin *= lhs;
    this.r *= lhs;
    return rin;
  }
}
