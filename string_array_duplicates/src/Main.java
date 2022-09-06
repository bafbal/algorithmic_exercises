public class Main {

  public static void main(String[] args) {

    String[] input = new String[]{"ccooddddddewwwaaaaarrrrsssss","piccaninny","hubbubbubboo"};
    String[] output = dup(input);
    for (int i = 0; i < output.length; i++) {
      System.out.println(output[i]);
    }
  }

  public static String[] dup(String[] arr) {
    for (int i = 0; i < arr.length; i++) {
      StringBuilder builder = new StringBuilder(arr[i]);
      for (int j = 1; j < builder.length(); j++) {
        if(builder.charAt(j) == builder.charAt(j - 1)) {
          builder.deleteCharAt(j);
          j--;
        }
      }
      arr[i] = builder.toString();
    }
    return arr;
  }
}
