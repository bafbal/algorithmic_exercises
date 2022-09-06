public class Main {

  public static void main(String[] args) {

  }

  public static String bumps(final String road) {
    int count = 0;
    for (int i = 0; i < road.length(); i++) {
      if (road.charAt(i) == 'n') {
        count++;
      }
    }
    return count > 15 ? "Car Dead" : "Woohoo!";
  }

  public static String bumps2(final String road) {
    return road.chars().filter(x -> x == 'n').count() > 15 ? "Car Dead" : "Woohoo!";
  }
}
