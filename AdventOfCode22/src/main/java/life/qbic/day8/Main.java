package life.qbic.day8;

import java.util.Arrays;
import java.util.List;

/**
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public class Main {

  public static void main(String[] args) {
    String input = Inputs.EIGHT.content();
    List<String> lines = input.lines().toList();
    int maxCol = lines.get(0).length();
    int maxRow = lines.size();
    int[][] grid = new int[maxRow][maxCol];

    for (int row = 0; row < maxRow; row++) {
      String line = lines.get(row);
      for (int col = 0; col < maxCol; col++) {
        char character = line.toCharArray()[col];
        grid[row][col] = Character.getNumericValue(character);
      }
    }

    System.out.println("input = " + input);
    System.out.println("grid = " + Arrays.deepToString(grid));

    int visibleTrees = 0;
    for (int row = 0; row < maxRow; row++) {
      for (int col = 0; col < maxCol; col++) {
        if (row == 0 || col == 0) {
          visibleTrees++;
          continue;
        } else if (row == maxRow - 1 || col == maxCol - 1) {
          visibleTrees++;
          continue;
        }
        if (isVisibleFromWest(row, col, grid)) {
          visibleTrees++;
          continue;
        }
        if (isVisibleFromEast(row, col, grid)) {
          visibleTrees++;
          continue;
        }
        if (isVisibleFromNorth(row, col, grid)) {
          visibleTrees++;
          continue;
        }
        if (isVisibleFromSouth(row, col, grid)) {
          visibleTrees++;
        }
      }
    }
    System.out.println("visibleTrees = " + visibleTrees);
    // grid i,j
    // 0,0 -> max(i),max(j)

    // i = 0 || max(i) -> visible
    // or
    // j = 0 || max(j) -> visible

    // for each row
    // is the tree the highest from the edge? if so
        // count the tree
    // else
        // break

    // for each column
    // is the tree the highest from the edge? if so
        // count the tree
    // else
        // break
  }

  private static boolean isVisibleFromNorth(int row, int col, int[][] grid) {
    int treeHeight = grid[row][col];
    for (int i = 0; i < row; i++) {
      if (grid[i][col] >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  private static boolean isVisibleFromEast(int row, int col, int[][] grid) {
    int treeHeight = grid[row][col];
    for (int i = col + 1; i < grid[0].length; i++) {
      if (grid[row][i] >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  private static boolean isVisibleFromSouth(int row, int col, int[][] grid) {
    int treeHeight = grid[row][col];
    for (int i = row + 1; i < grid.length; i++) {
      if (grid[i][col] >= treeHeight) {
        return false;
      }
    }
    return true;
  }

  private static boolean isVisibleFromWest(int row, int col, int[][] grid) {
    int treeHeight = grid[row][col];
    for (int i = 0; i < col; i++) {
      if (grid[row][i] >= treeHeight) {
        return false;
      }
    }
    return true;
  }

}
