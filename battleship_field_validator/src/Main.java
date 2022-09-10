import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) {

//    fieldValidator(null);
    fieldValidator(new int[][]{{0, 0, 0, 1}, {1, 0, 0, 1}, {1, 0, 0, 0}, {1, 0, 0, 1}});
  }

  public static boolean fieldValidator(int[][] field) {
    int[][] fieldsOccupiedByShip = new int[field.length][field.length];
    int[][] shipBeingDiscovered = new int[field.length][field.length];
    List<Integer> shipsizes = new ArrayList<>();
    for (int i = 0; i < field.length; i++) {
      for (int j = 0; j < field.length; j++) {
        if (fieldsOccupiedByShip[i][j] == 0 && field[i][j] == 1) {
          for (int[] row : shipBeingDiscovered) {
            Arrays.fill(row, 0);
          }
          discoverShip(field, shipBeingDiscovered, i, j);
          if (validateShip(shipBeingDiscovered)) {
            shipsizes.add(getShipsize(shipBeingDiscovered));
          } else {
            return false;
          }
          for (int k = 0; k < shipBeingDiscovered.length; k++) {
            for (int l = 0; l < shipBeingDiscovered.length; l++) {
              if (shipBeingDiscovered[k][l] == 1) {
                fieldsOccupiedByShip[k][l] = 1;
              }
            }
          }
        }
      }
    }
    Collections.sort(shipsizes);
    return shipsizes.equals(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 3, 3, 4));
  }

  private static Integer getShipsize(int[][] shipBeingDiscovered) {
    return Arrays.stream(shipBeingDiscovered).flatMapToInt(x -> Arrays.stream(x)).sum();
  }

  private static boolean validateShip(int[][] shipBeingDiscovered) {
    if (Arrays.stream(shipBeingDiscovered).flatMapToInt(x -> Arrays.stream(x)).sum() > shipBeingDiscovered.length) {
      return false;
    }
    int row = 0;
    int column = 0;
    boolean firstShipFieldFound = false;
    while (!firstShipFieldFound && row < shipBeingDiscovered.length) {
      while (!firstShipFieldFound && column < shipBeingDiscovered.length) {
        if (shipBeingDiscovered[row][column] == 1) {
          firstShipFieldFound = true;
        } else {
          column++;
        }
      }
      if (!firstShipFieldFound) {
        column = 0;
        row++;
      }
    }
    for (int i = 0; i < shipBeingDiscovered.length; i++) {
      for (int j = 0; j < shipBeingDiscovered.length; j++) {
        if (shipBeingDiscovered[i][j] == 1 && i != row && j != column) {
          return false;
        }
      }
    }
    return true;
  }

  private static void discoverShip(int[][] field, int[][] shipBeingDiscovered, int i, int j) {
    shipBeingDiscovered[i][j] = 1;
    if (i > 0 && field[i - 1][j] == 1 && shipBeingDiscovered[i - 1][j] == 0) {
      discoverShip(field, shipBeingDiscovered, i - 1, j);
    }
    if (i > 0 && j > 0 && field[i - 1][j - 1] == 1 && shipBeingDiscovered[i - 1][j - 1] == 0) {
      discoverShip(field, shipBeingDiscovered, i - 1, j - 1);
    }
    if (i > 0 && j < field.length - 1 && field[i - 1][j + 1] == 1 && shipBeingDiscovered[i - 1][j + 1] == 0) {
      discoverShip(field, shipBeingDiscovered, i - 1, j + 1);
    }
    if (i < field.length - 1 && field[i + 1][j] == 1 && shipBeingDiscovered[i + 1][j] == 0) {
      discoverShip(field, shipBeingDiscovered, i + 1, j);
    }
    if (i < field.length - 1 && j > 0 && field[i + 1][j - 1] == 1 && shipBeingDiscovered[i + 1][j - 1] == 0) {
      discoverShip(field, shipBeingDiscovered, i + 1, j - 1);
    }
    if (i < field.length - 1 && j < field.length - 1 && field[i + 1][j + 1] == 1 && shipBeingDiscovered[i + 1][j + 1] == 0) {
      discoverShip(field, shipBeingDiscovered, i + 1, j + 1);
    }
    if (j < field.length - 1 && field[i][j + 1] == 1 && shipBeingDiscovered[i][j + 1] == 0) {
      discoverShip(field, shipBeingDiscovered, i, j + 1);
    }
    if (j > 0 && field[i][j - 1] == 1 && shipBeingDiscovered[i][j - 1] == 0) {
      discoverShip(field, shipBeingDiscovered, i, j - 1);
    }
  }
}
