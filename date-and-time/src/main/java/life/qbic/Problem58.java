package life.qbic;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Problem58 {

  public static void main(String[] args) throws ParseException {

    //String dateString = readInput();
    String dateString = " 23-04-1999 ";
    Date date = toDate(dateString);
    System.out.println("date = " + date);
  }

  private static String readInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().trim();
  }

  private static Date toDate(String str) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.GERMANY);
    return simpleDateFormat.parse(str);
  }

}
