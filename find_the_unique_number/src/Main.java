public class Main {

  public static void main(String[] args) {

    double[] array = new double[]{0,0,1,0,0,0,0,0,0,0};

    System.out.println(findUniq(array));
  }

  public static double findUniq(double arr[]) {
    double notUniqueValue = arr[0] == arr[1] ? arr[0] : arr[2];
    int i = 0;
    while (true) {
      if (arr[i] != notUniqueValue) {
        return arr[i];
      }
      i++;
    }
  }
}
