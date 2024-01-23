package life.qbic.adventofcode23;

import java.util.List;
import java.util.stream.Stream;
import life.qbic.adventofcode23.day4.Card;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public class Day4 {

  public int parseInput(String input) {
    List<Card> cards = input.lines().map(Card::parse).toList();
    return cards.stream()
        .map(Card::points)
        .reduce(0, Integer::sum);
  }

}
