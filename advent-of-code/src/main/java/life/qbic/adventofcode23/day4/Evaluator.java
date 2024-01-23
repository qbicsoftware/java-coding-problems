package life.qbic.adventofcode23.day4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * <class short description - One Line!>
 *
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 *
 */
public class Evaluator {

  public static int points(Card card) {
    if (card.winningCount() == 0) {
      return 0;
    }
    return (int) Math.pow(2, (card.winningCount() - 1));
  }

  public static int totalScratchCardCount(List<Card> cards) {
    List<List<Card>> cardLists = new ArrayList<>();
    for (Card card : cards) {
      cardLists.add(new ArrayList<>(List.of(card)));
    }
    for (int currentCardIndex = 0; currentCardIndex < cardLists.size(); currentCardIndex++) {
      var currentIndexCards = cardLists.get(currentCardIndex);

      for (int copiedCardIndex = currentCardIndex + 1;
          copiedCardIndex <= currentIndexCards.get(0).winningCount() + currentCardIndex;
          copiedCardIndex++) {
        var copiedCardList = cardLists.get(copiedCardIndex);
        Card cardToCopy = copiedCardList.getFirst();
        for (int i = 0; i < currentIndexCards.size(); i++) {
          copiedCardList.add(cardToCopy);
        }
      }
    }
    return (int) cardLists.stream().mapToLong(Collection::size).sum();
  }
}
