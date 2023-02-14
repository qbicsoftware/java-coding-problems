package life.qbic.leaderboard;

import java.util.ArrayList;

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

  }

  public static LeaderBoard create(ArrayList<Player> players) {
    sortPlayersByScore();
    return new LeaderBoard(players);
  }

  private static void sortPlayersByScore() {

  }

  public void assignRanks() {
  }


}
