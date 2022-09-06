public class WithRecursion {

  public static void main(String[] args) {

    String a = ".W.\n" +
        ".W.\n" +
        "...";
    String b = ".W.\n" +
        ".W.\n" +
        "W..";
    String c = "...";
    System.out.println(pathFinder(b));
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
    turnOneReachableSquareToOne(mazeRepresentation, 0, 0);
  }

  private static void turnOneReachableSquareToOne(int[][] mazeRepresentation, int row, int column) {
    if (row > 0 && mazeRepresentation[row - 1][column] == 0) {
      mazeRepresentation[row - 1][column] = 1;
      turnOneReachableSquareToOne(mazeRepresentation, row - 1, column);
    }
    if (column > 0 && mazeRepresentation[row][column - 1] == 0) {
      mazeRepresentation[row][column - 1] = 1;
      turnOneReachableSquareToOne(mazeRepresentation, row, column - 1);
    }
    if (row < mazeRepresentation.length - 1 && mazeRepresentation[row + 1][column] == 0) {
      mazeRepresentation[row + 1][column] = 1;
      turnOneReachableSquareToOne(mazeRepresentation,row + 1, column);
    }
    if (column < mazeRepresentation[row].length - 1 && mazeRepresentation[row][column + 1] == 0) {
      mazeRepresentation[row][column + 1] = 1;
      turnOneReachableSquareToOne(mazeRepresentation,row, column + 1);
    }
  }
}
