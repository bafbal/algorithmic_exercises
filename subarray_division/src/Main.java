import java.util.List;

public class Main {

  public static void main(String[] args) {

    List<Integer> list = List.of(4);
    int sum = 4;
    int lenght = 1;
    System.out.println(divideIntoSubarrays(list,sum,lenght));
  }

  public static int divideIntoSubarrays(List<Integer> s, int d, int m) {
    int result = 0;
    int sumOfSubarray = 0;
    for (int i = 0; i < s.size() - m + 1; i++) {
      for (int j = 0; j < m; j++) {
        sumOfSubarray += s.get(i + j);
      }
      if (sumOfSubarray == d) {
        result++;
      }
      sumOfSubarray = 0;
    }
    return result;
  }
}