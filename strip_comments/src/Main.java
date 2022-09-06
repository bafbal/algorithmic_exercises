import java.util.List;

public class Main {

  public static void main(String[] args) {

    String exampleInput = "apples, pears # and bananas\ngrapes\nbananas !apples";
    String[] commentSybols = new String[]{"#", "!"};

    System.out.println(stripComments(exampleInput, commentSybols));
  }

  public static String stripComments(String text, String[] commentSymbols) {
    StringBuilder builder = new StringBuilder();
    StringBuilder buffer = new StringBuilder();
    List<String> commentSymbolsList = List.of(commentSymbols);
    boolean behindComment = false;

    for (int i = 0; i < text.length(); i++) {
      if (text.substring(i, i + 1).equals("\n")) {
        behindComment = false;
        buffer.setLength(0);
      }
      if (commentSymbolsList.contains(text.substring(i, i + 1))) {
        behindComment = true;
      }
      if (!behindComment && !text.substring(i, i + 1).equals(" ")) {
        builder.append(buffer);
        buffer.setLength(0);
        builder.append(text.charAt(i));
      }
      if (text.substring(i, i + 1).equals(" ")) {
        buffer.append(text.substring(i, i + 1));
      }
    }
    return builder.toString();
  }
}
