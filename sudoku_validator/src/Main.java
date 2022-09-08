import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    System.out.println(check(new int[][]{
        {5, 3, 4, 6, 7, 8, 9, 1, 2},
        {6, 7, 2, 1, 9, 5, 3, 4, 8},
        {1, 9, 8, 3, 4, 2, 5, 6, 7},
        {8, 5, 9, 7, 6, 1, 4, 2, 3},
        {4, 2, 6, 8, 5, 3, 7, 9, 1},
        {7, 1, 3, 9, 2, 4, 8, 5, 6},
        {9, 6, 1, 5, 3, 7, 2, 8, 4},
        {2, 8, 7, 4, 1, 9, 6, 3, 5},
        {3, 4, 5, 2, 8, 6, 1, 7, 9}
    }));
  }

  public static boolean check(int[][] sudoku) {
    if (Arrays.stream(sudoku).flatMapToInt(x -> Arrays.stream(x)).filter(n -> n == 0).count() > 0) {
      return false;
    }
    if(Arrays.stream(sudoku).filter(x -> checkForALlDigits(x)).count() != 9) {
      return false;
    }
    int[] holder = new int[9];
    int index = 0;
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        holder[index] = sudoku[j][i];
        index++;
      }
      if (checkForALlDigits(holder)) {
        index = 0;
      } else {
        return false;
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          for (int l = 0; l < 3; l++) {
            holder[index] = sudoku[i * 3 + k][j * 3 + l];
            index++;
          }
        }
        if (checkForALlDigits(holder)) {
          index = 0;
        } else {
          return false;
        }
      }
    }
    return true;
  }

  private static boolean checkForALlDigits(int[] array) {
        return Arrays.stream(array).sum() == 45 && Arrays.stream(array).filter(n -> n > 0 && n < 10).distinct().count() == 9;
  }
}
