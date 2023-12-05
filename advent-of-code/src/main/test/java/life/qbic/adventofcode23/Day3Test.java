package life.qbic.adventofcode23;

import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * <class short description - One Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 *
 */
class Day3Test {

  private static final String input = """
      467..114..
      ...*......
      ..35..633.
      ......#...
      617*......
      .....+.58.
      ..592.....
      ......755.
      ...$.*....
      .664.598..
      """;

  @Test
  void TestDay3() {
    Day3 day3 = new Day3();
    List<String> awesomeInput = input.lines().toList();
    day3.sumOfAllValidParts(awesomeInput);
  }

}
