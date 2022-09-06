import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    String a = "heeeeeeeee";
    String b = "world";
    System.out.println(twoStrings2(a,b));
  }



  public static String twoStrings(String s1, String s2) {
    char[] charsOfS1 = new char[s1.length()];
    char[] charsOfS2 = new char[s2.length()];
    for (int i = 0; i < charsOfS1.length; i++) {
      charsOfS1[i] = s1.charAt(i);
    }
    for (int i = 0; i < charsOfS2.length; i++) {
      charsOfS2[i] = s2.charAt(i);
    }
    boolean commonCharacterFound = false;
    int i = 0;
    int j = 0;
    while (!commonCharacterFound && i < charsOfS1.length) {
      while (!commonCharacterFound && j < charsOfS2.length) {
        if (charsOfS1[i] == charsOfS2[j]) {
          commonCharacterFound = true;
        }
        j++;
      }
      i++;
      j = 0;
    }
    return commonCharacterFound ? "YES" : "NO";
  }

  public static String twoStrings2(String s1, String s2) {
    s1 = s1.chars().distinct().mapToObj(i -> (char) i).map(c -> c.toString()).collect(Collectors.joining());
    s2 = s2.chars().distinct().mapToObj(i -> (char) i).map(c -> c.toString()).collect(Collectors.joining());
    char[] charsOfS1 = s1.toCharArray();
    boolean commonCharacterFound = false;
    int i = 0;
    while (!commonCharacterFound && i < charsOfS1.length) {
      if (s2.indexOf(charsOfS1[i]) != -1) {
        commonCharacterFound = true;
      }
      i++;
    }
    return commonCharacterFound ? "YES" : "NO";
  }

  public static String twoStrings3(String s1, String s2) {
    String shorter = s1.length() > s2.length() ? s2 : s1;
    String longer = s1.equals(shorter) ? s2 : s1;
    char[] charsOfShorter = shorter.toCharArray();
    boolean commonCharacterFound = false;
    int i = 0;
    while (!commonCharacterFound && i < charsOfShorter.length) {
      if (longer.indexOf(charsOfShorter[i]) != -1) {
        commonCharacterFound = true;
      }
      i++;
    }
    return commonCharacterFound ? "YES" : "NO";
  }
}
