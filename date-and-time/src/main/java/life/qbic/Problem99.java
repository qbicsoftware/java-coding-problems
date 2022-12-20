package life.qbic;

import java.util.Arrays;
import java.util.List;
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
    //sort test array
    System.out.println("testIntSorting = " + Arrays.toString(testIntSorting));
    bubbleSort(testIntSorting);
    System.out.println("testIntSorting (bubble sort)= " + Arrays.toString(testIntSorting));
    testIntSorting = fill(testIntSorting);
    System.out.println("testIntSorting = " + Arrays.toString(testIntSorting));
    Arrays.sort(testIntSorting);
    System.out.println("testIntSorting (Arrays.sort)= " + Arrays.toString(testIntSorting));
    //sort testObjectSorting
    System.out.println("testObjectSorting (Arrays.sort)= " + Arrays.toString(testObjectSorting));
    Arrays.sort(testObjectSorting);
    System.out.println("testObjectSorting (Arrays.sort)= " + Arrays.toString(testObjectSorting));
    //shuffle test integer array
    System.out.println("previous state " + Arrays.toString((testIntSorting)));
    int [] shuffled = arrayShuffle(testIntSorting);
    System.out.println("shuffel int array " + Arrays.toString(shuffled));
    //shuffle test object array

    int[] testBogoSorting = new int[7];
    testBogoSorting = fill(testBogoSorting);
    System.out.println("testBogoSorting = " + Arrays.toString(testBogoSorting));
    bogoSort(testBogoSorting);
    System.out.println("testBogoSorting = " + Arrays.toString(testBogoSorting));
  }

  public static int[] arrayShuffle(int[] toShuffle){
    int[] shuffled = new int [toShuffle.length];
    List<Integer> shuffleOrder = new Random().ints(0, toShuffle.length).distinct().limit(toShuffle.length).boxed().toList();

    for(int i = 0; i < toShuffle.length; i++){
      shuffled[shuffleOrder.get(i)] = toShuffle[i];
    }

    return shuffled;
  }
  public static void bogoSort(int[] toBeSorted) {
    int[] indicator = toBeSorted.clone();
    int tries = 0;
    Arrays.sort(indicator);
    while(!Arrays.equals(indicator, toBeSorted)) {
      tries++;
      toBeSorted = arrayShuffle(toBeSorted);
    }
    System.out.println("took "+tries+ " shuffles");
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
