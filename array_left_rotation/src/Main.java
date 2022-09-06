import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    /*
     * Complete the 'rotLeft' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY a
     *  2. INTEGER d
     */
    List<Integer> integerList = List.of(0,1,2,3,4,5);
    rotLeft(integerList,3);
  }

  public static List<Integer> rotLeft(List<Integer> a, int d) {
    List<Integer> positions = new ArrayList<>();
    for (int i = 0; i < a.size(); i++) {
      positions.add(i - d);
    }
    for (int i = 0; i < positions.size(); i++) {
      if (positions.get(i) < 0) {
        positions.set(i, positions.size() + positions.get(i));
      }
    }
    List<Integer> result = new ArrayList<>();
    for (int i = positions.indexOf(0); i < positions.size(); i++) {
      result.add(a.get(i));
    }
    for (int i = 0; i < positions.indexOf(0); i++) {
      result.add(a.get(i));
    }
    return result;
  }
}
