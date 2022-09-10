public class Main {

  public static void main(String[] args) {
    System.out.println(fib(1));
    System.out.println(fib(2));
    System.out.println(fib(3));
    System.out.println(fib(4));
    System.out.println(fib(5));
    System.out.println(fib(6));
    System.out.println(fib(7));
  }

  public static long fib (int n){
    return n < 3 ? 1 : fib(n - 1) + fib(n - 2);
  }
}
