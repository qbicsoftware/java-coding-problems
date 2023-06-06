package life.qbic;


public class Isbn10 {

    public static Isbn10 parse(String s) {
        String cleanedString = removeNotAllowedCharacters(s.trim());
        validateLength(cleanedString);
        String firstPart = cleanedString.substring(0, 9);
        String checkDigitInput = cleanedString.substring(9);
        validateCheckDigit(checkDigitInput, computeCheckDigit(firstPart));
        return new Isbn10();
    }

    private static void validateCheckDigit(String checkDigitInput, int expectedCheckDigit) {
        int providedCheckDigit = checkDigitInput.equals("X") ? 10 : Integer.parseInt(checkDigitInput);
        if (expectedCheckDigit != providedCheckDigit) {
            throw new IllegalArgumentException("Provided check digit " + providedCheckDigit + " does not match expected " + expectedCheckDigit);
        }
    }

    private static void validateLength(String cleanedString) {
        if (cleanedString.length() != 10) {
            throw new IllegalArgumentException("Provided input does not contain 10 digits.");
        }
    }

    private static String removeNotAllowedCharacters(String s) {
        return s.replaceAll("[^[\\d|X]]", "");
    }

    private static int computeCheckDigit(String firstPart) {
        int sum = 0;
        for (int i = 0; i < 9; i++) {
            char currentChar = firstPart.charAt(i);
            int currentDigit = currentChar - 48;
            sum += currentDigit * (i+1);
        }
        return sum % 11;
    }

}
