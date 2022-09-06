import java.util.List;

public class Main {

  public static void main(String[] args) {

  }

  public static int diagonalDifference(List<List<Integer>> arr) {
    int[][] array = new int[arr.size()][];
    for (int i = 0; i < array.length; i++) {
      array[i] = arr.get(i).stream().mapToInt(n -> n).toArray();
    }
    int sumTopLeftBottomRight = 0;
    int sumBottomLeftTopRight = 0;
    for (int i = 0; i < array.length ; i++) {
      sumBottomLeftTopRight += array[i][array.length - 1 - i];
      sumTopLeftBottomRight += array[i][i];
    }
    return Math.abs(sumBottomLeftTopRight - sumTopLeftBottomRight);
  }

}
