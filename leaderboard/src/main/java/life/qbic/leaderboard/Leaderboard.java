package life.qbic.leaderboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Leaderboard {

  private final List<Player> players = new ArrayList<>();


  public void addPlayer(Player player) {
    players.add(player);
  }

  public List<PlayerRank> ranked() {
    if (players.isEmpty()) {
      return List.of();
    }
    List<Player> sortedPlayersByScoreDesc = players.stream().sorted(Comparator.comparing(Player::score).reversed())
        .toList();
    List<PlayerRank> rankedPlayers = new ArrayList<>();
    StateMachine stateMachine = new StateMachine();

    for (Player player : sortedPlayersByScoreDesc) {
      int rank = stateMachine.nextRank(player.score());
      rankedPlayers.add(new PlayerRank(rank, player));
    }
    return rankedPlayers;
  }

  public Optional<Player> find(String name) {
    return players.stream().filter(it -> it.name().equals(name)).findAny();
  }

  private static class StateMachine {
    private int currentRank = 0;
    private int skippedRanks = 0;
    private long previousScore = Long.MAX_VALUE;


    int nextRank(int currentScore) {
      if (currentScore < previousScore) {
        currentRank = currentRank + 1 + skippedRanks;
        skippedRanks = 0;
      } else {
        skippedRanks++;
      }
      previousScore = currentScore;
      return currentRank;
    }
  }


}
