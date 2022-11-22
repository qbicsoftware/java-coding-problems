package life.qbic;

import java.util.Arrays;
import java.util.Random;

/**
 *Write several programs that exemplify different sorting algorithms for arrays. Also, write a program for shuffling arrays.
 */
public class Problem99 {

  public static void main(String[] args) {
    int[] testIntSorting = new int[7];
    MyCustomObject[] testObjectSorting = new MyCustomObject[11];
    testIntSorting = fill(testIntSorting);
    testObjectSorting = fill(testObjectSorting);
    //TODO sort test array
    System.out.println("testIntSorting = " + Arrays.toString(testIntSorting));
    bubbleSort(testIntSorting);
    System.out.println("testIntSorting (bubble sort)= " + Arrays.toString(testIntSorting));
    testIntSorting = fill(testIntSorting);
    System.out.println("testIntSorting = " + Arrays.toString(testIntSorting));
    Arrays.sort(testIntSorting);
    System.out.println("testIntSorting (Arrays.sort)= " + Arrays.toString(testIntSorting));


    //TODO sort testObjectSorting
    //TODO shuffle test integer array
    //TODO shuffle test object array
  }

  public static void bubbleSort(int[] toBeSorted) {
    for (int outerIndex = 0; outerIndex < toBeSorted.length; outerIndex++) {
      int remainingUnsorted = toBeSorted.length - outerIndex;
      for (int i = 0; i < remainingUnsorted - 1; i++) {
        if (toBeSorted[i + 1] < toBeSorted[i]) {
          int temp = toBeSorted[i + 1];
          toBeSorted[i + 1] = toBeSorted[i];
          toBeSorted[i] = temp;
        }
      }
    }
  }

  private static int[] fill(int[] test) {
    int[] temp = new int[test.length];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = new Random().nextInt(0, 100);
    }
    return temp;
  }

  private static MyCustomObject[] fill(MyCustomObject[] testObjectSorting) {
    MyCustomObject[] temp = new MyCustomObject[testObjectSorting.length];
    for (int i = 0; i < temp.length; i++) {
      temp[i] = new MyCustomObject("John", "Doe");
    }
    return temp;
  }

  private static class MyCustomObject {
    private final String firstName;
    private final String lastName;

    private MyCustomObject(String firstName, String lastName) {
      this.firstName = firstName;
      this.lastName = lastName;
    }

    public String firstName() {
      return firstName;
    }

    public String lastName() {
      return lastName;
    }
  }
}
