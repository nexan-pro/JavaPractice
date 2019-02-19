package Color;

class CMY extends RGB { // cyan, magenta, yellow
  private double cyan, magenta, yellow;

  CMY() { }

  CMY (RGB rgb) {
    super(rgb.getRed(), rgb.getGreen(), rgb.getBlue());
    cyan = 1 - getRed();
    magenta = 1 - getGreen();
    yellow = 1 - getBlue();
  }

  static CMY createCMY(RGB rgb) {
    return new CMY(rgb);
  }

  double getCyan() {
    return cyan;
  }

  double getMagenta() {
    return magenta;
  }

  double getYellow() {
    return yellow;
  }

  void print() {
    System.out.println("cyan: " + cyan + "\r\nmagenta: " + magenta + "\r\nyellow: " + yellow);
  }
}

class RGB  {
  private double red, green, blue;

  RGB() { }

  RGB(double red, double green, double blue) {
    this.red = red;
    this.green = green;
    this.blue = blue;
  }

  static RGB createRGB(double red, double green, double blue) {
    return new RGB(red, green, blue);
  }

  double getRed() {
    return red;
  }

  double getBlue() {
    return blue;
  }

  double getGreen() {
    return green;
  }

  public RGB add(RGB rgb) {
    RGB tmp = new RGB(red, green, blue);
    tmp.red += rgb.red;
    tmp.green += rgb.green;
    tmp.blue += rgb.blue;
    return tmp;
  }

  RGB sub(RGB rgb) {
    RGB tmp = new RGB(red, green, blue);
    tmp.red -= rgb.red;
    tmp.green -= rgb.green;
    tmp.blue -= rgb.blue;
    return tmp;
  }

  void print() {
    System.out.printf("Red: %f%n\r\nGreen: %f%n\r\nBlue: %f%n\r\n", red, green, blue);
  }
}