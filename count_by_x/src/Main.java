import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    countBy(2,5);
  }

  public static int[] countBy(int x, int n){
    int[] result = new int[n];
    for (int i = 0; i < result.length; i++) {
      result[i] = x * (i + 1);
    }
    return result;
  }
}
