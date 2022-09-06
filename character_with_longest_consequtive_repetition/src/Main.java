public class Main {

  public static void main(String[] args) {

    longestRepetition("");
  }

  public static Object[] longestRepetition(String s) {
    if (s.length() == 0) {
      return new Object[]{"", 0};
    }
    Object[] result = new Object[]{s.substring(0,1), 1};
    int countOfConsuqutiveChars = 1;
    for (int i = 1; i < s.length(); i++) {
      if (s.charAt(i - 1) == s.charAt(i)) {
        countOfConsuqutiveChars++;
      }
      if (s.charAt(i - 1) != s.charAt(i) || i == s.length() - 1) {
        if (countOfConsuqutiveChars > (int) result[1]) {
          result[0] = s.substring(i - 1, i);
          result[1] = countOfConsuqutiveChars;
        }
        countOfConsuqutiveChars = 1;
      }
    }
    return result;
  }

}
