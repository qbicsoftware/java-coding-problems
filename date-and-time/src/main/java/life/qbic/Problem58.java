package life.qbic;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/**
 * Converting a string to date and time: Write a program that exemplifies conversions between a string and date/time.
 */
public class Problem58 {

  public static void main(String[] args) throws ParseException {

    String dateString = readInput();
    Date date = toDate(dateString);
    LocalDateTime localDateTime = toLocalDateTime(dateString);
    System.out.println("date = " + date);
    System.out.println("local date time = " + localDateTime);
  }

  private static String readInput() {
    Scanner scanner = new Scanner(System.in);
    return scanner.nextLine().trim();
  }

  private static Date toDate(String str) throws ParseException {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.GERMANY);
    return simpleDateFormat.parse(str);
  }

  private static LocalDateTime toLocalDateTime(String str) {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.GERMANY);
    return LocalDateTime.parse(str, dateTimeFormatter);
  }







}
