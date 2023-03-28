package life.qbic.leaderboard;

import java.util.Objects;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public record PlayerRank(int rank, Player player) {

  public PlayerRank {
    if (rank < 1) {
      throw new IllegalArgumentException("Highest rank is 1; provided " + rank);
    }
    Objects.requireNonNull(player);
  }
}
