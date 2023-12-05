package life.qbic.adventofcode23;

import static java.util.logging.Logger.getLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

/**
 * --- Day 3: Gear Ratios ---
 * <p>
 * <a href="https://adventofcode.com/2023/day/3">Advent of Code - Day 3</a>
 * <p>
 * You and the Elf eventually reach a gondola lift station; he says the
 * gondola lift will take you up to the water source, but this is as far as he can bring you. You go
 * inside.
 * <p>
 * It doesn't take long to find the gondolas, but there seems to be a problem: they're not moving.
 * <p>
 * "Aaah!"
 * <p>
 * You turn around to see a slightly-greasy Elf with a wrench and a look of surprise. "Sorry, I
 * wasn't expecting anyone! The gondola lift isn't working right now; it'll still be a while before
 * I can fix it." You offer to help.
 * <p>
 * The engineer explains that an engine part seems to be missing from the engine, but nobody can
 * figure out which one. If you can add up all the part numbers in the engine schematic, it should
 * be easy to work out which part is missing.
 * <p>
 * The engine schematic (your puzzle input) consists of a visual representation of the engine. There
 * are lots of numbers and symbols you don't really understand, but apparently any number adjacent
 * to a symbol, even diagonally, is a "part number" and should be included in your sum. (Periods (.)
 * do not count as a symbol.)
 * <p>
 * Here is an example engine schematic:
 * <pre>
 467..114..
 ...*......
 ..35..633.
 ......#...
 617*......
 .....+.58.
 ..592.....
 ......755.
 ...$.*....
 .664.598..</pre>
 In this schematic, two numbers are not part numbers because they are not
 * adjacent to a symbol: 114 (top right) and 58 (middle right). Every other number is adjacent to a
 * symbol and so is a part number; their sum is 4361.
 * <p>
 * Of course, the actual engine schematic is much larger. What is the sum of all of the part numbers
 * in the engine schematic?
 */
public class Day3 {

  private static final Logger logger = getLogger(Day3.class.getName());

  public static List<String> parseInput(String filePath) {
      Stream<String> lines = new BufferedReader(new InputStreamReader(
          Objects.requireNonNull(Day3.class.getResourceAsStream(filePath),
              "File does not exist."))).lines();
    return lines.toList();
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
