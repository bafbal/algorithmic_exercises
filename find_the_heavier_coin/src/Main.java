import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

  // write a program that receives an array of n coins and returns the one that is heavier than the others
  // n-1 coins have equal weight, one is heavier
  // n > 1, weights are positive integers

  public static void main(String[] args) {

    Coin[] coins = new Coin[100];
    for (int i = 0; i < coins.length; i++) {
      coins[i] = new Coin(1);
    }

    Random random = new Random();
    int indexOfHeavierCoin = random.nextInt(coins.length);
    coins[indexOfHeavierCoin].setWeight(2);
    System.out.println(findTheHeaviest3(coins).getWeight());
  }

  public static Coin findTheHeaviest(Coin[] coins) {
    int heaviestCoinWeight = coins[0].getWeight();
    if (coins[1].getWeight() < coins[0].getWeight()) {
      return coins[0];
    }
    for (int i = 1; i < coins.length; i++) {
      if (coins[i].getWeight() > heaviestCoinWeight) {
        return coins[i];
      }
    }
    return null;
  }

  public static Coin findTheHeaviest2(Coin[] coins) {
    int heaviestCoinWeight = coins[0].getWeight();
    if (coins[1].getWeight() < coins[0].getWeight()) {
      return coins[0];
    }
    return Arrays.stream(coins).filter(n -> n.getWeight() > heaviestCoinWeight).collect(Collectors.toList()).get(0);
  }

  public static Coin findTheHeaviest3(Coin[] coins) {
    if (coins.length == 1) {
      return coins[0];
    }
    int sumFirst = IntStream.range(0, coins.length / 2).mapToObj(i -> coins[i].getWeight()).mapToInt(Integer::intValue).sum();
    int sumSecond = IntStream.range(coins.length / 2, coins.length / 2 * 2).mapToObj(i -> coins[i].getWeight()).mapToInt(Integer::intValue).sum();
    if (sumFirst > sumSecond) {
      return findTheHeaviest3(IntStream.range(0, coins.length / 2).mapToObj(i -> coins[i]).toArray(Coin[]::new));
    } else if (sumFirst < sumSecond) {
      return findTheHeaviest3(IntStream.range(coins.length / 2, coins.length).mapToObj(i -> coins[i]).toArray(Coin[]::new));
    }
    return coins[coins.length - 1];
  }
}
