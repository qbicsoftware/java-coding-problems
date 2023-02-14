package life.qbic.leaderboard;

import java.util.ArrayList;
import java.util.Collections;

/**
 * <class short description - One Line!>
 * <p>
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 */
public class LeaderBoard {

  private final ArrayList<Player> players;

  private LeaderBoard(ArrayList<Player> players) {
    this.players = players;
    sortPlayersByScore();
  }

  public static LeaderBoard create(ArrayList<Player> players) {
    return new LeaderBoard(players);
  }

  private void sortPlayersByScore() {
    Collections.sort(players);
  }

  public void assignRanks() {
  }


}
