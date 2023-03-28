package life.qbic.leaderboard;

import java.util.StringJoiner;

public class Player {

  private final String name;
  private final int score;

  public Player(String name, int score) {
    this.name = name;
    this.score = score;
  }

  public String name() {
    return name;
  }

  public int score() {
    return score;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
        .add("name='" + name + "'")
        .add("score=" + score)
        .toString();
  }
}
