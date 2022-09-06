import java.util.regex.Pattern;

public class Main {

  public static void main(String[] args) {

    minimumNumber(6, "AUzs-nV");
  }

  public static int minimumNumber(int n, String password) {
    Pattern lowercaseCharacters= Pattern.compile("[a-z]");
    Pattern uppercaseCharacters= Pattern.compile("[A-Z]");
    Pattern numbers= Pattern.compile("[0-9]");
    Pattern specialCharacters= Pattern.compile("[-!@#$%^&*()+ ]");

    int numberOfCharactersToBeAdded = 4;
    boolean lowercaseFound = false;
    boolean uppercaseFound = false;
    boolean numberFound = false;
    boolean specialFound = false;
    int index = 0;

    while (numberOfCharactersToBeAdded > 0 && index < password.length()) {
      if (lowercaseCharacters.matcher(String.valueOf(password.charAt(index))).find() && !lowercaseFound) {
        numberOfCharactersToBeAdded--;
        lowercaseFound = true;
      }
      if (uppercaseCharacters.matcher(String.valueOf(password.charAt(index))).find() && !uppercaseFound) {
        numberOfCharactersToBeAdded--;
        uppercaseFound = true;
      }
      if (numbers.matcher(String.valueOf(password.charAt(index))).find() && !numberFound) {
        numberOfCharactersToBeAdded--;
        numberFound = true;
      }
      if (specialCharacters.matcher(String.valueOf(password.charAt(index))).find() && !specialFound) {
        numberOfCharactersToBeAdded--;
        specialFound = true;
      }
      index++;
    }

    return numberOfCharactersToBeAdded > (6 - password.length()) ? numberOfCharactersToBeAdded : (6 - password.length());
  }
}
