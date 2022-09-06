public class Main {

  public static void main(String[] args) {
    System.out.println(isPrime(31798321));
  }

  public static boolean isPrime(int num) {
    if (num < 2 || num == 4 || num % 2 == 0 && num != 2 || num % 3 == 0 && num != 3) {
      return false;
    }
    int limit = (int) Math.round(Math.sqrt(num));
    if((num + 1) % 6 != 0 && (num - 1) % 6 != 0 && num > 3) {
      return false;
    }
    for (int i = 2; i <= limit; i++) {
      if(num % i == 0) {
        return false;
      }
    }
    return true;
  }
}
