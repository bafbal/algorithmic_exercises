public class Main {

  public static void main(String[] args) {

    String s1 = "dogg";
    String s2 = "god";
    System.out.println(scramble(s1,s2));
  }

  public static boolean scramble(String str1, String str2) {
    int[] poolOfChars = str1.chars().sorted().toArray();
    int[] searchedWord = str2.chars().sorted().toArray();
    int poolOfCharsIndex = -1;
    boolean allCharactersFound = true;
    boolean charFoundInPool = false;

    for (int i = 0; i < searchedWord.length; i++) {
      charFoundInPool = false;
      while (!charFoundInPool && allCharactersFound) {
        poolOfCharsIndex++;
        if (poolOfCharsIndex == poolOfChars.length) {
          allCharactersFound = false;
        } else if (searchedWord[i] == poolOfChars[poolOfCharsIndex]) {
          charFoundInPool = true;
        }
      }
    }
    return allCharactersFound;
  }
}
