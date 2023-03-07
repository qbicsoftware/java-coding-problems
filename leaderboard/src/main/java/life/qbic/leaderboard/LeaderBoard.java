package life.qbic.leaderboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <class short description - One Line!>
 * <p>
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 */
public class LeaderBoard {

  private final List<Player> players;

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
    int rank = 1;
    players.get(0).setRank(rank);
    for (int i = 1; i < players.size(); i++) {
      Player currPlayer = players.get(i);
      if (players.get(i - 1).getScore() == currPlayer.getScore()) {
        currPlayer.setRank(rank);
      } else {
        rank++;
        currPlayer.setRank(rank);
      }
    }
  }

  public List<Player> rankedPlayers() {
    return Collections.unmodifiableList(this.players);
  }


}
