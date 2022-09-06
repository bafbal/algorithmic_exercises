import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Integer> list = Arrays.asList(1,2,3,4,5);
    miniMaxSum2(list);
  }

  public static void miniMaxSum(List<Integer> arr) {
    int min = Collections.min(arr);
    int max = Collections.max(arr);
    Long sum = arr.stream().mapToLong(Long::valueOf).sum();
    System.out.println((sum - max) + " " + (sum - min));
  }

  public static void miniMaxSum2(List<Integer> arr) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    Long sum = 0l;
    for (Integer number : arr) {
      sum += number;
      if (number < min) {
       min = number;
      }
      if (number > max) {
        max = number;
      }
    }
    System.out.println((sum - max) + " " + (sum - min));
  }
}
