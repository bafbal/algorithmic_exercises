public class Main {

  public static void main(String[] args) {

    System.out.println(fibRabbits(5,3));
  }

  public static int fibRabbits(int n, int b) {
    int[] rabbits = new int[]{1,0};
    for (int i = 0; i < n; i++) {
      rabbits[1] = rabbits[0] + rabbits[1];
      rabbits[0] = (rabbits[1] - rabbits[0]) * b;
    }
    return rabbits[1];
  }

}
