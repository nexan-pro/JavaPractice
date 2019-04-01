package Circle;

public class main {
  public static void main(String[] args) {
    Circle sample = new Circle(5);
    System.out.println(sample.toString());
    Ring sampleRing = new Ring(5, 3);
    System.out.println(sampleRing.toString());
    sample.add(1.5);
    sampleRing.add(1.5);
    System.out.println("after add: ");
    System.out.println(sample.toString());
    System.out.println(sampleRing.toString());
  }
}
