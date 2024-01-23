package life.qbic.adventofcode23.day4;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public record Card(String cardName, Set<Integer> winningNumbers, Set<Integer> cardNumbers) {
  public int points() {
    HashSet<Integer> intersection = new HashSet<>(winningNumbers);
    intersection.retainAll(cardNumbers);
    if (intersection.isEmpty()) {
      return 0;
    }
    return (int) Math.pow(2, (intersection.size() - 1));
  }

  public static Card parse(String s) {
    String[] split = s.split(":");
    var name = split[0];
    String[] numbers = split[1].split("\\|");
    var left = numbers[0];
    var right = numbers[1];
    Set<Integer> winningNumbers = Arrays.stream(left.split("\\W+"))
        .filter(s1 -> !s1.isEmpty())
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
    Set<Integer> cardNumbers = Arrays.stream(right.split("\\W+"))
        .filter(s1 -> !s1.isEmpty())
        .map(Integer::parseInt)
        .collect(Collectors.toSet());
    return new Card(name, winningNumbers, cardNumbers);
  }

}
