package life.qbic.adventofcode23;

import static java.util.logging.Logger.getLogger;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * <class short description - One Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 *
 */
public class Day3 {

  private static final Logger logger = getLogger(Day3.class.getName());

  public List<String> parseInput(String filePath) {
    return new ArrayList<>();
  }

  public static int sumOfAllValidParts(List<String> input) {
    char[][] schematic = convertListToArray(input);
    List<Position> symbols = findSymbols(schematic);
    logger.log(Level.INFO, () -> "symbols = " + symbols);
    return 0;
  }

  private static List<Position> retrieveValidNumberPosition(Position symbolPosition, char[][] schematic) {
    List<Position> validNumber = new ArrayList<>();
    //TODO
    return validNumber;
  }

  private static List<Position> findSymbols(char[][] schematic) {
    List<Position> symbols = new ArrayList<>();
    for (int row = 0; row < schematic.length; row++) {
      for (int col = 0; col < schematic[row].length; col++) {
        char currentSymbol = schematic[row][col];
        if (Character.isDigit(currentSymbol) || currentSymbol == '.') {
          continue;
        }
        Position position = new Position(row, col);
        symbols.add(position);
      }

    }
    return symbols;
  }

  private static char[][] convertListToArray(List<String> input) {
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
