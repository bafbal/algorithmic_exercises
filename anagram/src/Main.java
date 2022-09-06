import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    System.out.println(checkForAnagrams("dog", "god"));
    System.out.println(checkForAnagrams("dog", "godd"));
  }

  public static boolean checkForAnagrams(String str1, String str2) {
    int[] arr1 = str1.chars().sorted().toArray();
    int[] arr2 = str2.chars().sorted().toArray();
    return Arrays.equals(arr1, arr2);
  }
}
