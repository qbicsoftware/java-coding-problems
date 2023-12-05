package life.qbic.adventofcode23;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

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
    int result = Day3.sumOfAllValidParts(input.lines().toList());
    System.out.println("result = " + result);
    assertEquals(4361, result);
  }


  @Test
  void runDay3() {
    int result = Day3.sumOfAllValidParts(Day3.parseInput("/aoc23/3/input.txt"));
    System.out.println("result = " + result);
    fail("Not implemented.");
  }

}
