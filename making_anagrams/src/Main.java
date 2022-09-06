import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    /*
     * Complete the 'makeAnagram' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING a
     *  2. STRING b
     */
    String a = "cdf";
    String b = "def";
    System.out.println(makeAnagram(a,b));
  }

  public static int makeAnagram(String a, String b) {
    int matchCount = 0;
    boolean match = false;
    StringBuilder aBuilder = new StringBuilder(a);
    StringBuilder bBuilder = new StringBuilder(b);
    int i = 0;
    int j = 0;
    while (i < aBuilder.length()) {
      while (j < bBuilder.length() && match == false) {
        if (aBuilder.charAt(i) == bBuilder.charAt(j)) {
          match = true;
          matchCount++;
          aBuilder.deleteCharAt(i);
          bBuilder.deleteCharAt(j);
          i--;
        }
        j++;
      }
      j = 0;
      i++;
      match = false;
    }
    return (a.length() + b.length() - 2 * matchCount);
  }
}
