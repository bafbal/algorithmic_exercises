import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    String a[] = new String[]{"arp", "strong", "live"};
    String b[] = new String[]{"lively", "alive", "harp", "sharp", "armstrong"};
    String[] result =  inArray(a,b);
  }


  public static String[] inArray(String[] array1, String[] array2) {
    return Arrays.stream(array1)
        .filter(f -> Arrays.stream(array2)
            .anyMatch(s -> s.indexOf(f) != -1))
        .distinct()
        .sorted()
        .toArray(String[]::new);
  }
}
