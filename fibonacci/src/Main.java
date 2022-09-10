public class Main {

  public static void main(String[] args) {
    System.out.println(fib(1000));
  }

  public static long fib2 (int n){
    return n < 3 ? 1 : fib(n - 1) + fib(n - 2);
  }

  public static long fib (int n) {
    if (n < 3) {
      return 1;
    }
    long f1 = 1;
    long f2 = 1;
    for (long i = 0; i < n - 3 ; i++) {
      f2 = f1 + f2;
      f1 = f2 - f1;
    }
    return f1 + f2;
  }
}
