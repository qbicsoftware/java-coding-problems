package life.qbic.leaderboard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    assignRanks();
  }

  public static LeaderBoard create(ArrayList<Player> players) {
    return new LeaderBoard(players);
  }

  private void sortPlayersByScore() {
    players.sort(Comparator.comparing(Player::getScore).reversed());
  }

  private void assignRanks() {
    sortPlayersByScore();
    players.get(0).setRank(1);
    int lastAssignedRank = 1;
    for (int rank = 1; rank < players.size(); rank++) {
      Player currPlayer = players.get(rank);
      if (players.get(rank - 1).getScore() == currPlayer.getScore()) {
        currPlayer.setRank(lastAssignedRank);
      } else {
        currPlayer.setRank(rank+1);
        lastAssignedRank = rank+1;
      }
    }
  }

  public List<Player> rankedPlayers() {
    return Collections.unmodifiableList(this.players);
  }


}
