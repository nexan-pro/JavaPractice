package Color;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CMY_Test {

  @Test
  void createRGB() {
    RGB rgb = new RGB();
    rgb.createRGB(0.2, 0.3, 0.5);
    CMY cmy = new CMY(rgb);
    cmy.print();
    assertEquals(0, rgb.getBlue() - rgb.getGreen() - rgb.getRed());
  }

  @Test
  void add() {
    RGB first_rgb = new RGB(0.3, 0.1, 0.2);
    RGB second_rgb = new RGB(0.5, 0.2, 0.4);
    RGB add_third_rgb = first_rgb.add(second_rgb);
    add_third_rgb.print();
    assertEquals(0.8, add_third_rgb.getRed());
    assertEquals(0.30000000000000004, add_third_rgb.getGreen());
    assertEquals(0.6000000000000001, add_third_rgb.getBlue());
  }

  @Test
  void sub() {
    RGB first_rgb = new RGB(0.5, 0.3, 0.4);
    RGB second_rgb = new RGB(0.2, 0.2, 0.1);
    RGB sub_third_rgb = first_rgb.sub(second_rgb);
    CMY cmy = new CMY(sub_third_rgb);
    cmy.print();
    assertEquals(0.3, sub_third_rgb.getRed());
    assertEquals(0.1, sub_third_rgb.getGreen());
    assertEquals(0.3, sub_third_rgb.getBlue());
  }

  @Test
  void createCMY() {
    RGB rgb = new RGB(0.2, 0.4, 0.7);
    CMY cmy = new CMY();
    cmy = cmy.createCMY(rgb);
    assertEquals(1.7, cmy.getCyan() + cmy.getMagenta() + cmy.getYellow());
  }
}