import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    int[] array1 = new int[]{1,3,3,6,7,7,7,9};
    int[] array2 = new int[]{1,1,3,5,7,7,7,10,12};
    int[] result = getCommonElements(array1, array2);
    System.out.println(Arrays.toString(result));
  }

//  return common elements in a new array without repetition
//
//  Traps:
//    - array length is predefined
//    - printing an array prints it memory adress by default
//
//  Solutions:
//    - need to create a list and fill it
//    - Arrays.toString(array)
  private static int[] getCommonElements(int[] array1, int[] array2) {
    List<Integer> resultList = new ArrayList<>();
    for (int i = 0; i < array1.length; i++) {
      for (int j = 0; j < array2.length; j++) {
        if (array1[i] == array2[j] && !resultList.contains(array1[i])) {
          resultList.add(array1[i]);
        }
      }
    }
    int[] result = new int[resultList.size()];
    for (int i = 0; i < result.length; i++) {
      result[i] = resultList.get(i);
    }
    return result;
  }

}
