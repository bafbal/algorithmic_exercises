import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    int[] array = new int[]{1,2,2,3,3,3,4,3,3,3,2,2,1};
    findIt(array);
  }

  public static int findIt(int[] a) {
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < a.length; i++) {
      if (list.contains(a[i])) {
        list.remove((Integer) a[i]);
      } else {
        list.add(a[i]);
      }
    }
    return list.get(0);
  }

}
