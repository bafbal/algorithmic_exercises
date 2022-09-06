import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {

  }

  public static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
    int aPoints = 0;
    int bPoints = 0;
    for (int i = 0; i < 3; i++) {
      if (a.get(i) > b.get(i)) {
        aPoints++;
      } else if (a.get(i) < b.get(i)) {
        bPoints++;
      }
    }
    return Arrays.asList(aPoints, bPoints);
  }

}
