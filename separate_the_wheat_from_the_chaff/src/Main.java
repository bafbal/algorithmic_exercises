public class Main {

  public static void main(String[] args) {

    wheatFromChaff(new long[]{16, 25, -48, -47, -37, 41, -2});
  }

  public static long[] wheatFromChaff(long[] values) {
    long[] result = values.clone();
    boolean swapDone = false;
    int j = result.length - 1;
    for (int i = 0; i < result.length; i++) {
      if (result[i] > 0) {
        while (!swapDone && j > i) {
          if (result[j] < 0) {
            result[i] = (result[i] + result[j]) - (result[j] = result[i]);
            swapDone = true;
          }
          j--;
        }
      }
      swapDone = false;
    }
    return result;
  }
}
