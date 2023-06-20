package life.qbic;

import javax.security.auth.login.AccountLockedException;

public class Isbn13 {
    private final int[] digits;
    private final int checkDigit;

    private Isbn13(int[] digits, int checkDigit) {
        this.digits = digits;
        this.checkDigit = checkDigit;

    }

    static Isbn13 parse(String input) {
        String cleanedInput = cleanInput(input);
        if (!cleanedInput.matches("^[0-9]+$")) {
            throw new IllegalArgumentException("non digit character observed.");
        }
        if (cleanedInput.length() != 13) {
            throw new IllegalArgumentException("length does not equal 13");
        }
        return new Isbn13(new int[0], 0);
    }

    static String cleanInput(String input) {
        String workingCopy = input.trim();
        workingCopy = workingCopy.replaceAll("\\s", "").replaceAll("-", "");
        return workingCopy;
    }
}
