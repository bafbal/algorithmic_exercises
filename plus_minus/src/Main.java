import java.util.List;

public class Main {

  public static void main(String[] args) {

    plusMinus(List.of(1, 1, 0, -1, -1));
  }

  public static void plusMinus(List<Integer> arr) {
    int plus = 0;
    int minus = 0;
    int zero = 0;
    for (Integer number : arr) {
      if (number > 0) {
        plus++;
      } else if (number < 0) {
        minus++;
      } else {
        zero++;
      }
    }
    System.out.println(String.format("%.6f", (double) plus / arr.size()));
    System.out.println(String.format("%.6f", (double) minus / arr.size()));
    System.out.println(String.format("%.6f", (double) zero / arr.size()));
  }

}
