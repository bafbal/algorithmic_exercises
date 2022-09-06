public class WithoutRecursion {

  public static void main(String[] args) {

    String a = ".W.\n" +
        ".W.\n" +
        "...";
    String b = ".W.\n" +
        ".W.\n" +
        "W..";
    String c = ".W.";
    System.out.println(pathFinder(c));
  }

  static boolean pathFinder(String maze) {
    int[][] mazeRepresentation = representMazeAsArray(maze);
    mazeRepresentation[0][0] = 1;
    turnAllReachableSquaresToOne(mazeRepresentation);
    return mazeRepresentation[mazeRepresentation.length - 1][mazeRepresentation[0].length - 1] == 1;
  }

  private static int[][] representMazeAsArray(String maze) {
    int numberOfLines = getNumberOfLines(maze);
    int numberOfColums = getNumberOfColumns(maze);
    int[][] representation = new int[numberOfLines + 1][numberOfColums];
    int position = 0;
    for (int i = 0; i < representation.length; i++) {
      for (int j = 0; j < numberOfColums; j++) {
        if (maze.charAt(position) == '.') {
          representation[i][j] = 0;
        }
        if (maze.charAt(position) == 'W') {
          representation[i][j] = 2;
        }
        position++;
      }
      position++;
    }
    return representation;
  }

  private static int getNumberOfLines(String maze) {
    int count = 0;
    for (int i = 0; i < maze.length(); i++) {
      if (maze.charAt(i) == '\n') {
        count++;
      }
    }
    return count;
  }

  private static int getNumberOfColumns(String maze) {
    return maze.indexOf('\n') == -1 ? maze.length() : maze.indexOf('\n');
  }

  private static void turnAllReachableSquaresToOne(int[][] mazeRepresentation) {
    boolean atLeastOneSquareTurned = true;
    int countOfOnes = 0;
    while (atLeastOneSquareTurned) {
      atLeastOneSquareTurned = false;
      countOfOnes = countNumberInMatrix(mazeRepresentation, 1);
      for (int i = 0; i < mazeRepresentation.length; i++) {
        for (int j = 0; j < mazeRepresentation[i].length; j++) {
          if (mazeRepresentation[i][j] == 1) {
            setNeigbouringDotsToOne(mazeRepresentation, i, j);
          }
        }
      }
      if (countOfOnes != countNumberInMatrix(mazeRepresentation, 1)) {
        atLeastOneSquareTurned = true;
      }
    }
  }

  private static int countNumberInMatrix(int[][] matrix, int searchedNumber) {
    int count = 0;
    for (int j = 0; j < matrix.length; j++) {
      for (int k = 0; k < matrix[0].length; k++) {
        if (matrix[j][k] == searchedNumber) {
          count++;
        }
      }
    }
    return count;
  }

  private static void setNeigbouringDotsToOne(int[][] mazeRepresentation, int i, int j) {
    if (i > 0 && mazeRepresentation[i - 1][j] == 0) {
      mazeRepresentation[i - 1][j] = 1;
    }
    if (j > 0 && mazeRepresentation[i][j - 1] == 0) {
      mazeRepresentation[i][j - 1] = 1;
    }
    if (i < mazeRepresentation.length - 1 && mazeRepresentation[i + 1][j] == 0) {
      mazeRepresentation[i + 1][j] = 1;
    }
    if (j < mazeRepresentation[i].length - 1 && mazeRepresentation[i][j + 1] == 0) {
      mazeRepresentation[i][j + 1] = 1;
    }
  }
}
