public class Main {

  public static void main(String[] args) {

    System.out.println(shiftedDiff("hoop", "pooh"));
    System.out.println(shiftedDiff("coffee", "eecoff"));
    System.out.println(shiftedDiff("eecoff", "coffee"));
  }

  static int shiftedDiff(String first, String second) {
    int counter = 0;
    if (first.equals(second)) {
      return counter;
    }
    for (int i = 0; i < first.length(); i++) {
      first = rotateString(first);
      counter++;
      if (first.equals(second)) {
        return counter;
      }
    }
    return -1;
  }

  private static String rotateString(String first) {
    StringBuilder builder = new StringBuilder(first);
    char last = builder.charAt(builder.length() - 1);
    for (int i = builder.length() - 1; i > 0; i--) {
      builder.setCharAt(i, builder.charAt(i - 1));
    }
    builder.setCharAt(0, last);
    return builder.toString();
  }
}
