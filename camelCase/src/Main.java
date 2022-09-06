public class Main {

  public static void main(String[] args) {

    System.out.println((int) 'A');
    System.out.println((int) 'Z');
  }

  public static int camelcase(String s) {
    return (int) s.chars().filter(c -> c > 64).filter(c -> c < 96).count() + 1;
  }

}
