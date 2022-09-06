public class Main {

  public static void main(String[] args) {
    System.out.println(findHighestScoringWord("man i need a taxi up to ubud"));
  }

  public static String findHighestScoringWord(String s) {
    String[] split = s.split(" ");
    int highestScore = Integer.MIN_VALUE;
    int scoreOfWord = 0;
    String result = "";
    for (int i = 0; i < split.length; i++) {
      for (int j = 0; j < split[i].length(); j++) {
        scoreOfWord += (int) split[i].charAt(j) - 96;
      }
      if (scoreOfWord > highestScore) {
        result = split[i];
        highestScore = scoreOfWord;
      }
      scoreOfWord = 0;
    }
    return result;
  }
}
