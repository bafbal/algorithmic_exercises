import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

  }

  public static boolean comp(int[] a, int[] b) {
    return (a == null || b == null) ? false : Arrays.equals(Arrays.stream(a).map(n -> n * n).sorted().toArray(),Arrays.stream(b).sorted().toArray());
  }
}
