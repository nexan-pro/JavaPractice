package LambdaEpressions;

interface Operation {
  String recent();
}

public class task0 {
  public static void main(String[] args) {
    double[] sequence = { 1.0, -1.0, 3, 4, 5, -1, -4 };

    Operation operation = () -> {
        int cnt_pos = 0, cnt_neg = 0;
        for (int i = 0; i < sequence.length; ++i) {
          if (sequence[i] > 0) cnt_pos++;
          if (sequence[i] < 0) cnt_neg++;
        }
        if (cnt_pos > cnt_neg) return "positive";
        else if (cnt_pos < cnt_neg) return "negative";
        else return "count of positive and negative is equal";
    };
    String rez = operation.recent();
    System.out.print(rez);
  }
}
