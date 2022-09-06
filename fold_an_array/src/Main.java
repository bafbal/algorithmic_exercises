import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    int[] array = foldArray(new int[]{1,2,3,4,5}, 2);
    System.out.println();
  }

  public static int[] foldArray(int[] array, int runs) {
    List<Integer> list = Arrays.stream(array).boxed().collect(Collectors.toList());
    foldList(list,runs);
    return list.stream().mapToInt(n -> n).toArray();
  }

  public static void foldList(List<Integer> list, int runs) {
    if (runs == 0) {
      return;
    }
    for (int i = 0; i < list.size() / 2; i++) {
      list.set(i, list.get(i) + list.get(list.size() - 1 - i));
    }
    list.subList(list.size() - list.size() / 2, list.size()).clear();
    foldList(list, runs - 1);
  }

  public static int[] foldArray2(int[] array, int runs) {
    final int[] result = Arrays.copyOfRange(array, 0, Math.round(array.length / 2.0f));

    IntStream.range(0, array.length / 2)
        .forEach(i -> result[i] = array[i] + array[array.length - 1 - i]);

    return runs > 1 ? foldArray(result, --runs) : result;
  }

  public static int[] foldArray3(int[] a, int r) {
    int[] f = java.util.Arrays.copyOfRange(a,0,(int)Math.ceil(a.length/2.));
    for (int i=0; i<a.length/2; i++) f[i] += a[a.length-1-i];
    return f.length==1|r==1 ? f : foldArray(f,--r);
  }
}
