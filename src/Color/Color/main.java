package Color;

public class main {
  public static void main(String[] args) {
    RGB first_rgb = new RGB(0.3, 0.1, 0.2);
    RGB second_rgb = new RGB(0.5, 0.2, 0.4);
    RGB add_third_rgb = first_rgb.add(second_rgb);
    CMY cmy = new CMY(add_third_rgb);
    cmy.print();
  }
}
