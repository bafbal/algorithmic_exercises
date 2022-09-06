import java.util.List;

public class Main {

  public static void main(String[] args) {

  }

  public static boolean alphanumeric(String s) {
    List<String> listOfPossibleCharacters = List.of("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".split(""));
    if (s.equals("")) {
      return false;
    }
    boolean alphanumeric = true;
    for (int i = 0; i < s.length(); i++) {
      if (!listOfPossibleCharacters.contains(s.substring(i, i + 1))) {
        alphanumeric = false;
      }
    }
    return alphanumeric;
  }
}
