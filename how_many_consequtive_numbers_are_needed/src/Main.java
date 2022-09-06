import java.util.Arrays;

public class Main {

  public static void main(String[] args) {
    consecutive(new int[]{4,8,6});
  }

  public static int consecutive(final int[] arr) {
    Arrays.sort(arr);
    int count = 0;
    for (int i = 1; i < arr.length - 1; i++) {
      count += (arr[i] - arr[i - 1] - 1);
    }
    return count;
  }
}
