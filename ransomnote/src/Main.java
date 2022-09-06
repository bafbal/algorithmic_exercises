import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<String> magazine = new ArrayList<>();
    magazine.add("one");
    magazine.add("two");
    magazine.add("three");
    List<String> note = new ArrayList<>();
    note.add("three");
    note.add("two");
    note.add("one");
    checkMagazine(magazine, note);
  }

  public static void checkMagazine(List<String> magazine, List<String> note) {
    boolean atLeastOneWordNotFound = false;
    boolean wordFoundInIteration = false;
    String[] magazineArray = magazine.toArray(new String[magazine.size()]);
    String[] noteArray = note.toArray(new String[note.size()]);
    int i = 0;
    int j = 0;
    while (!atLeastOneWordNotFound && i < noteArray.length) {
      while (!wordFoundInIteration && j < magazineArray.length) {
        if (noteArray[i].equals(magazineArray[j])) {
          magazineArray[j] = "";
          wordFoundInIteration = true;
        }
        j++;
        if (j == magazineArray.length && !wordFoundInIteration) {
          atLeastOneWordNotFound = true;
        }
      }
      i++;
      j = 0;
      wordFoundInIteration = false;
    }
    if (atLeastOneWordNotFound) {
      System.out.println("No");
    } else {
      System.out.println("Yes");
    }
  }
}
