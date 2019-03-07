package NewsDepartment;

public class Main {
  public static void main(String[] args) {
    NewsOperator operator = new NewsOperator(new ServiceSubscriber(NewsOperator.Categories.HUMOR));
    operator.addNews("Hello world!", NewsOperator.Categories.HUMOR);
  }
}
