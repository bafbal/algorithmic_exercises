import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    int[] arr = new int[]{1, 2, 0, 3, 4, 0, 5, 6, 7, 0, 8, 9};
    getNumbersNotBetweenZeros(arr);
  }

  public static List<Integer> getNumbersNotBetweenZeros(int[] input) {
    List<Integer> result = new ArrayList<>();
    fillResultList(input, result, false, 0);
    return result;
  }

  private static void fillResultList(int[] input, List<Integer> result, boolean betweenZeros, int index) {
    if (index == input.length) {
      return;
    }
    if (input[index] == 0) {
      betweenZeros = !betweenZeros;
    } else if (!betweenZeros) {
      result.add(input[index]);
    }
    fillResultList(input, result, betweenZeros, index + 1);
  }
}
