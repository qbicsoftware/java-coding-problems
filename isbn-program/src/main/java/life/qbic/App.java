package life.qbic;

import life.qbic.isbn.IsbnValidator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String isbn10 = "0321125215";
        boolean isIsbn10Valid = IsbnValidator.validateIsbn10(isbn10);
        String isbn13 = "978-0765387561";
        boolean isIsbn13Valid = IsbnValidator.validateIsbn13(isbn13);
        System.out.println("isIsbn10Valid = " + isIsbn10Valid);
        System.out.println("isIsbn13Valid = " + isIsbn13Valid);
    }
}
