import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

    System.out.println(pigIt4("Pig !latin is cool ![]"));
  }

  public static String pigIt(String str) {
    String[] originalWords = str.split(" ");
    String[] piggedWords = new String[originalWords.length];

    for (int i = 0; i < originalWords.length; i++) {
      StringBuilder builder = new StringBuilder(originalWords[i]);
      if (!builder.toString().equals(".") && !builder.toString().equals("?") && !builder.toString().equals("!")) {
        int startChar = 0;
        if (builder.charAt(startChar) == '.' || builder.charAt(startChar) == '!' || builder.charAt(startChar) == '?') {
          while (startChar < builder.length() && builder.charAt(startChar) == '.' || builder.charAt(startChar) == '!'
              || builder.charAt(startChar) == '?') {
            startChar++;
          }
        }
        builder.append(builder.charAt(startChar) + "ay");
        builder.deleteCharAt(startChar);
      }
      piggedWords[i] = builder.toString();
    }

    String result = Arrays.stream(piggedWords).map(s -> s + " ").collect(Collectors.joining());
    return result.substring(0, result.length() - 1);
  }

  public static String pigIt2(String str) {
    List<Character> characters = str.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
    int index = 0;
    int nextSpace = 0;
    boolean spaceFound = false;
    boolean reachedEnd = false;
    while (index < characters.size() && !reachedEnd) {
      while (!spaceFound && !reachedEnd) {
        if (nextSpace == characters.size()) {
          reachedEnd = true;
        } else if (characters.get(nextSpace) == ' ') {
          spaceFound = true;
        }
        nextSpace++;
      }
      characters.add(nextSpace - 1, 'y');
      characters.add(nextSpace - 1, 'a');
      characters.add(nextSpace - 1, characters.get(index));
      characters.remove(index);
      index = nextSpace + 2;
      if (!reachedEnd) {
        while (!reachedEnd && index < characters.size() && characters.get(index) == '!' || characters.get(index) == '.' || characters.get(index) == '?') {
          if (index == characters.size() - 1) {
            reachedEnd = true;
          } else {
            index++;
          }
        }
      }
      nextSpace = index;
      spaceFound = false;
    }
    return characters.stream().map(String::valueOf).collect(Collectors.joining());
  }

  public static String pigIt3(String str) {
    return Arrays.stream(str.trim().split(" "))
        .map(v -> v.matches("[a-zA-Z]+") ? v.substring(1).concat(v.substring(0, 1)).concat("ay") : v)
        .collect(Collectors.joining(" "));
  }

  public static String pigIt4(String str) {
    return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
  }

  public static String pigIt5(String str) {
    String[] originalWords = str.split(" ");
    String[] piggedWords = new String[originalWords.length];

    for (int i = 0; i < originalWords.length; i++) {
      StringBuilder builder = new StringBuilder(originalWords[i]);
      if (!builder.toString().equals(".") && !builder.toString().equals("?") && !builder.toString().equals("!")) {
        if (builder.charAt(0) != '.' && builder.charAt(0) != '!' && builder.charAt(0) != '?') {
          builder.append(builder.charAt(0) + "ay");
          builder.deleteCharAt(0);
        }
      }
      piggedWords[i] = builder.toString();
    }

    String result = Arrays.stream(piggedWords).map(s -> s + " ").collect(Collectors.joining());
    return result.substring(0, result.length() - 1);
  }
}
