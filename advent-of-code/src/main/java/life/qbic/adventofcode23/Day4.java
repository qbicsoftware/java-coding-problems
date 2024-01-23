package life.qbic.adventofcode23;

import java.util.List;
import life.qbic.adventofcode23.day4.Card;
import life.qbic.adventofcode23.day4.Evaluator;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public class Day4 {

  public int parseInputToPoints(String input) {
    List<Card> cards = input.lines().map(Card::parse).toList();
    return cards.stream()
        .map(Evaluator::points)
        .reduce(0, Integer::sum);
  }

  public int parseInputToScratchCards(String input) {
    List<Card> cards = input.lines().map(Card::parse).toList();
    return Evaluator.totalScratchCardCount(cards);
  }

}
