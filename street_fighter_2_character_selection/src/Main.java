import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    String[][] fighters = new String[][]{
        new String[]{"Ryu", "E.Honda", "Blanka", "Guile", "Balrog", "Vega"},
        new String[]{"Ken", "Chun Li", "Zangief", "Dhalsim", "Sagat", "M.Bison"},
    };
    String[] moves = new String[]{"down", "down", "down", "down"};

    System.out.println(streetFighterSelection(fighters, new int[]{0, 0}, moves));

  }

  public static String[] streetFighterSelection(String[][] fighters, int[] position, String[] moves) {
    List<String> resultList = new ArrayList<>();
    int fightersListWidth = fighters[0].length;
    int fightersListHeight = fighters.length;
    for (String move : moves) {
      getNewPosition(position, move, fightersListWidth, fightersListHeight);
      resultList.add(fighters[position[0]][position[1]]);
    }
    return resultList.toArray(new String[resultList.size()]);
  }

  private static void getNewPosition(int[] position, String move, int fightersListLength, int fightersListHeight) {
    if (move.equals("left")) {
      if (position[1] == 0) {
        position[1] = fightersListLength - 1;
      } else {
        position[1] = position[1] - 1;
      }
    }
    if (move.equals("right")) {
      if (position[1] == fightersListLength - 1) {
        position[1] = 0;
      } else {
        position[1] = position[1] + 1;
      }
    }
    if (move.equals("up") && position[0] != 0) {
      position[0] = position[0] - 1;
    }
    if (move.equals("down") && position[0] != fightersListHeight - 1) {
      position[0] = position[0] + 1;
    }
  }
}
