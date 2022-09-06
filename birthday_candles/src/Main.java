import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

  public static void main(String[] args) {

    System.out.println(birthdayCakeCandles(List.of(3,2,1,3)));
  }

  public static int birthdayCakeCandles(List<Integer> candles) {
    int max = Collections.max(candles);
    return (int) candles.stream().filter(n -> n == max).count();
  }
}
