import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    int[][] data = {{2, 3, 4, 9},
        {4, 22},
        {2, 8, 8, 55, 3, 6}};
    int index = 2;
    double d = averageJaggedArrayAboveIndex(data, index);
    int[][] subarrays = getSubarraysAboveIndex(data, index);
    System.out.println();
  }

  // extract average of numbers above a certain index
  //
  // Traps:
  //  integer division
  //
  // Solution:
  //  at least one of the two numbers must be double
  //
  // Tricks:
  //  ternary operator
  public static double averageJaggedArrayAboveIndex(int[][] array, int index) {
    int sum = 0;
    int count = 0;
    for (int i = 0; i < array.length; i++) {
      for (int j = index + 1; j < array[i].length; j++) {
        sum += array[i][j];
        count++;
      }
    }
    return count > 0 ? (sum / (double) count) : 0;
  }

  // extract average of numbers above a certain index
  //
  // Traps:
  //  initialize and fill jagged array with algorithm
  //
  // Solution:
  //  create the mirror of the desired arrays as lists
  //  conversion to array: see below
  public static int[][] getSubarraysAboveIndex(int[][] array, int index) {
    List<List<Integer>> subarrayList = new ArrayList<>();
    for (int i = 0; i < array.length; i++) {
      List<Integer> subarray = new ArrayList<>();
      for (int j = index + 1; j < array[i].length; j++) {
        subarray.add(array[i][j]);
      }
      if (subarray.size() > 0) {
        subarrayList.add(subarray);
      }
    }
    int[][] result = new int[subarrayList.size()][];
    for (int i = 0; i < subarrayList.size(); i++) {
      result[i] = new int[subarrayList.get(i).size()];
    }
    for (int i = 0; i < subarrayList.size(); i++) {
      for (int j = 0; j < subarrayList.get(i).size(); j++) {
        result[i][j] = subarrayList.get(i).get(j);
      }
    }
    return result;
  }
}