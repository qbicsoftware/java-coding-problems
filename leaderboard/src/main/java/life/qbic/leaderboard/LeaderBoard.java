package life.qbic.leaderboard;

import java.util.*;

/**
 * <class short description - One Line!>
 * <p>
 * <More detailed description - When to use, what it solves, etc.>
 *
 * @since <version tag>
 */
public class LeaderBoard {

  private final List<Player> players;
  private final Map<Player, Integer> playerRanks;

  private LeaderBoard(ArrayList<Player> players) {
    this.players = players;
    playerRanks = new HashMap<>();
    sortPlayersByScore();
    determineRanking();
  }

  public static LeaderBoard create(ArrayList<Player> players) {
    return new LeaderBoard(players);
  }

  private void sortPlayersByScore() {
    Collections.sort(players);
  }

  private void determineRanking(){
    int rank = 1;
    Player previousPlayer;

    for (Player player: players) {
      if(previousPlayer == null){
        continue;
      }

      if(previousPlayer.getScore() != player.getScore()) {
        rank++;
      }

      playerRanks.put(player, rank);

      previousPlayer = player;
    }
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
