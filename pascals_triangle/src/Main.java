import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    generate(1);
  }

  public static long[] generate(int level) {
    List<List<Long>> triangleList = new ArrayList<>();
    triangleList.add(List.of(1L));
    int totalnumbers = 1;
    for (int i = 1; i < level; i++) {
      List<Long> newLine = new ArrayList<>();
      newLine.add(triangleList.get(i - 1).get(0));
      for (int j = 1; j < i; j++) {
        newLine.add(triangleList.get(i - 1).get(j - 1) + triangleList.get(i - 1).get(j));
      }
      newLine.add(triangleList.get(i - 1).get(i - 1));
      triangleList.add(newLine);
      totalnumbers += newLine.size();
    }
    long[] result = new long[totalnumbers];
    int resultPosition = 0;
    for (int i = 0; i < triangleList.size(); i++) {
      for (int j = 0; j < triangleList.get(i).size(); j++) {
        result[resultPosition] = triangleList.get(i).get(j);
        resultPosition++;
      }
    }
    return result;
  }
}
