package Color;

public class CMY extends RGB { // cyan, magenta, yellow
  private double cyan, magenta, yellow;

  CMY (RGB rgb) {
    super(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    cyan = 1 - getRed();
    magenta = 1 - getGreen();
    yellow = 1 - getBlue();
  }

  public static CMY createCMY(RGB rgb) {
    return new CMY(rgb);
  }

  void print() {
    System.out.println("cyan: " + cyan + "\r\nmagenta: " + magenta + "\r\nyellow: " + yellow);
  }
}

class RGB  {
  private double red, green, blue;

  RGB(double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  public static RGB createRGB(double red, double green, double blue) {
    return new RGB(red, green, blue);
  }

  public double getRed() {
    return red;
  }

  public double getBlue() {
    return blue;
  }

  public double getGreen() {
    return green;
  }

  public RGB add(RGB rgb) {
    RGB tmp = new RGB(red, green, blue);
    tmp.red += rgb.red;
    tmp.green += rgb.green;
    tmp.blue += rgb.blue;
    return tmp;
  }

  public RGB sub(RGB rgb) {
    RGB tmp = new RGB(red, green, blue);
    tmp.red -= rgb.red;
    tmp.green -= rgb.green;
    tmp.blue -= rgb.blue;
    return tmp;
  }
}