public class Main {

  public static void main(String[] args) {

    System.out.println((int) 'a');
  }

  public static boolean bishop(String positionStart, String positionEnd, int n){
    if (!checkIfFieldsAreOfSameColor(positionStart, positionEnd)) {
      return false;
    }
    if (n == 0) {
      return positionStart.equals(positionEnd);
    }
    if (n == 1) {
      return checkIfFieldsAreOnSameDiagonal(positionStart,positionEnd);
    }
    return true;
  }

  private static boolean checkIfFieldsAreOnSameDiagonal(String positionStart, String positionEnd) {
    return ((convertFieldToArray(positionStart)[0] - convertFieldToArray(positionStart)[1])
        == (convertFieldToArray(positionEnd)[0] - convertFieldToArray(positionEnd)[1]))
        || ((convertFieldToArray(positionStart)[0] + convertFieldToArray(positionStart)[1])
        == (convertFieldToArray(positionEnd)[0] + convertFieldToArray(positionEnd)[1]));
  }

  private static boolean checkIfFieldsAreOfSameColor(String positionStart, String positionEnd) {
    return (convertFieldToArray(positionStart)[0] + convertFieldToArray(positionStart)[1]) % 2
        == (convertFieldToArray(positionEnd)[0] + convertFieldToArray(positionEnd)[1]) % 2;
  }

  private static int[] convertFieldToArray(String field) {
    return new int[]{(int) field.charAt(0) - 96, (int) field.charAt(1)};
  }
}
