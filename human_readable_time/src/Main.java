public class Main {

  public static void main(String[] args) {

    System.out.println(makeReadable(359999));
  }

  public static String makeReadable(int seconds) {
    Integer hour = seconds / 3600;
    int minute = (seconds - (hour * 3600)) / 60;
    int second = seconds - hour * 3600 - minute * 60;
    return String.format("%02d", hour) + ":" + String.format("%02d", minute) + ":" + String.format("%02d", second);
  }
}
