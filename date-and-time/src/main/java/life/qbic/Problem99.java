package life.qbic;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

/**
 * Write several programs that exemplify different sorting algorithms for arrays. Also, write a
 * program for shuffling arrays.
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
    System.out.println("testObjectSorting (Arrays.sort)= " + Arrays.toString(testObjectSorting));
    Arrays.sort(testObjectSorting);
    System.out.println("testObjectSorting (Arrays.sort)= " + Arrays.toString(testObjectSorting));
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
      int randomInt = new Random().nextInt(0,10);
      int randomInt2 = new Random().nextInt(10,20);
      temp[i] = new MyCustomObject("John" + randomInt, "Doe" + randomInt2);
    }
    return temp;
  }

  private static class MyCustomObject implements Comparable<MyCustomObject> {

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

    @Override
    public int compareTo(MyCustomObject o) {
      if (this.firstName.compareTo(o.firstName) != 0) {
        return this.firstName.compareTo(o.firstName);
      }
      return this.lastName.compareTo(o.lastName);
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      MyCustomObject that = (MyCustomObject) o;
      return Objects.equals(firstName, that.firstName) && Objects.equals(lastName,
          that.lastName);
    }

    @Override
    public int hashCode() {
      return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
      return "MyCustomObject{" +
          "firstName='" + firstName + '\'' +
          ", lastName='" + lastName + '\'' +
          '}';
    }
  }
}
