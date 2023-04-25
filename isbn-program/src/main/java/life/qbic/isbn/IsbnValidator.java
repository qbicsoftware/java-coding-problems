package life.qbic.isbn;


import java.util.ArrayList;
import java.util.List;

public class IsbnValidator {

  public static boolean validateIsbn10(String input) {

    int checkDigit = getCheckDigit(input);
    if (containsInvalidCharacters(input)) {
      return false;
    }
    Integer[] digits = cleanUp(input);
    if (digits.length != 10) {
      return false;
    }
    return true;
  }

  public static boolean validateIsbn13(String input) {
    return false;
  }

  private static int getCheckDigit(String input) {
    char lastCharacter = input.toCharArray()[input.length() - 1];
    if (lastCharacter == 'X') {
      return 10;
    }
    return Integer.parseInt(String.valueOf(lastCharacter));
  }

  private static boolean isCharacterInvalidIsbn10(char c) {
    return !Character.isDigit(c) && !Character.isWhitespace(c) && c != '-';
  }


  static boolean containsInvalidCharacters(String input) {
    for (char c : input.toCharArray()) {
      if (isCharacterInvalidIsbn10(c)) {
        return true;
      }
    }
    return false;
  }

  static private Integer[] cleanUp(String input) {
    List<Integer> digits = new ArrayList<>();
    for (char c : input.toCharArray()) {
      if (Character.isDigit(c)) {
        int parsedInt = Integer.parseInt(String.valueOf(c));
        digits.add(parsedInt);
      }
    }

    return digits.toArray(new Integer[0]);
  }

  private int checkDigit(String input) {
    return -1;
  }

}
