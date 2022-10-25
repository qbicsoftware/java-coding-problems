package life.qbic;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 *Write several programs that exemplify different sorting algorithms for arrays. Also, write a program for shuffling arrays.
 */
public class Problem99 {

  public static void main(String[] args) {
    int[] test = new int[7];
    fillWithRandomInts(test);
    System.out.println("test = " + Arrays.toString(test));
    System.out.println("sorted copy = " + Arrays.toString(sortedCopy(test)));
    System.out.println("isSorted(sortedCopy(test)) = " + isSorted(sortedCopy(test)));
  }

  private static void fillWithRandomInts(int[] test) {
    for (int i = 0; i < test.length; i++) {
      test[i] = new Random().nextInt(0, 100);
    }
  }

  private static int[] sortedCopy(int[] array) {
    int[] copyOf = Arrays.copyOf(array, array.length);
    Arrays.sort(copyOf);
    return copyOf;
  }

  private static void bogoSort(int[] test) {
    Set<Integer> newPositions;

  }

  private static boolean isSorted(int[] array) {
    for (int i = 0; i < array.length -1; i++) {
      if (array[i + 1] < array[i]) {
        return false;
      }
    }
    return true;
  }
}
