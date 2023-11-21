package life.qbic.senet;

import java.util.Objects;
import java.util.StringJoiner;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public final class Player {

  private int pawnCount;
  private final String playerSymbol;

  public Player(String playerSymbol, int pawnCount) {
    this.playerSymbol = playerSymbol;
    this.pawnCount = pawnCount;
  }

  public void decreasePawnCount() {
    pawnCount--;
  }

  public int getPawnCount() {
    return pawnCount;
  }

  public String getPlayerSymbol() {
    return playerSymbol;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", Player.class.getSimpleName() + "[", "]")
        .add("pawnCount=" + pawnCount)
        .add("playerSymbol='" + playerSymbol + "'")
        .toString();
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
      return true;
    }
    if (object == null || getClass() != object.getClass()) {
      return false;
    }

    Player player = (Player) object;

    if (pawnCount != player.pawnCount) {
      return false;
    }
    return Objects.equals(playerSymbol, player.playerSymbol);
  }

  @Override
  public int hashCode() {
    int result = pawnCount;
    result = 31 * result + (playerSymbol != null ? playerSymbol.hashCode() : 0);
    return result;
  }
}
