package life.qbic.adventofcode23;

import java.util.ArrayList;
import java.util.List;

/**
 * <class short description - One Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 *
 */
public class Day3 {

  public List<String> parseInput(String filePath) {
    return new ArrayList<String>();
  }

  public int sumOfAllValidParts(List<String> input) {
    char[][] schematic = convertListToArray(input);
    List<Position> symbols = findSymbols(schematic);
    System.out.println("symbols = " + symbols);
    return 0;
  }

  private List<Position> retrieveValidNumberPosition(Position symbolPosition, char[][] schematic) {
    List<Position> validNumber = new ArrayList<>();
    return validNumber;
  }

  private List<Position> findSymbols(char[][] schematic) {
    List<Position> symbols = new ArrayList<>();
    for (int row = 0; row < schematic.length; row++) {
      for (int col = 0; col < schematic[row].length; col++) {
        char currentSymbol = schematic[row][col];
        if (Character.isDigit(currentSymbol)) {
          continue;
        }
        if (currentSymbol == '.') {
          continue;
        }
        Position position = new Position(row, col);
        symbols.add(position);
      }

    }
    return symbols;
  }

  private char[][] convertListToArray(List<String> input) {
    int rowCount = input.size();
    int columnCount = input.getFirst().length();
    char[][] schematic = new char[rowCount][columnCount];
    for (int i = 0; i < rowCount; i++) {
      schematic[i] = input.get(i).toCharArray();
    }
    return schematic;
  }

  public record Position(int row, int column) {

    public Position left() {
      return new Position(row, column - 1);
    }

    public Position right() {
      return new Position(row, column + 1);
    }

    public Position up() {
      return new Position(row - 1, column);
    }

    public Position down() {
      return new Position(row + 1, column);
    }

    public Position diagonalUpLeft() {
      return this.left().up();
    }

    public Position diagonalDownLeft() {
      return this.left().down();
    }

    public Position diagonalUpRight() {
      return this.right().up();
    }

    public Position diagonalDownRight() {
      return this.right().down();
    }

  }


}
