import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

  public static void main(String[] args) {

    System.out.println(validParentheses(""));

  }

  public static boolean validParentheses(String parens) {
    AtomicInteger sum = new AtomicInteger();
    AtomicBoolean result = new AtomicBoolean(true);
    parens.chars()
        .forEachOrdered(c -> {
          switch (c) {
            case '(': sum.getAndIncrement(); break;
            case ')': sum.getAndDecrement();
          }
          if (sum.get() < 0) {
            result.set(false);
          }
        });
    return result.get() && sum.get() == 0;
  }

}
