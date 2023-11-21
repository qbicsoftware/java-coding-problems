package life.qbic.senet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * The board on which senet is played
 */
public class GameBoard {

  private House toHouse;
  private List<PawnRemovedListener> listeners;

  public static final class House {

    private String pawn = "";

    public static House empty() {
      return new House();
    }

    public static House withPawn(String pawn) {
      House house = new House();
      house.pawn = pawn;
      return house;
    }


    private boolean isOccupied() {
      return !pawn.isBlank();
    }

    private void movePawnTo(House target) {
      if (target.isOccupied()) {
        swap(target);
      } else {
        move(target);
      }
    }

    private void move(House target) {
      target.pawn = this.pawn;
      this.pawn = "";
    }

    private void swap(House target) {
      var temp = target.pawn;
      target.pawn = this.pawn;
      this.pawn = temp;
    }

    public String getPawn() {
      return pawn;
    }

    public String removePawn() {
      String removedPawn = this.pawn;
      this.pawn = "";
      return removedPawn;
    }
  }

  static final int NUMBER_OF_FIELDS = 30;
  House[] houses = new House[NUMBER_OF_FIELDS];

  public void move(int from, int to) {
    House fromHouse = houses[from - 1];
    if (to > houses.length) {
      pawnRemoved(fromHouse.removePawn());
    }
    toHouse = houses[to - 1];
    fromHouse.movePawnTo(toHouse);
  }

  public void setupFields(Player player1, Player player2) {
    int totalNumberOfPawns = player1.getPawnCount() + player2.getPawnCount();
    for (int i = 1; i <= totalNumberOfPawns; i++) {
      if (i % 2 == 0) {
        houses[i - 1] = House.withPawn(player2.getPlayerSymbol());
      } else {
        houses[i - 1] = House.withPawn(player1.getPlayerSymbol());
      }
    }
    for (int i = totalNumberOfPawns; i < NUMBER_OF_FIELDS; i++) {
      houses[i] = House.empty();
    }
  }


  /**
   *
   * @param position 1-based position up to the number of houses included
   * @return the pawn or empty optional
   */
  public Optional<String> getPawnAt(int position) {
    return Optional.ofNullable(houses[position - 1].getPawn());
  }

  /**
   *
   * @param chosenPawn
   * @param player
   * @return true only if the field contains a pawn with the player
   */
  public boolean pawnBelongsToPlayer(int chosenPawn, Player player) {
    return getPawnAt(chosenPawn)
        .map(it -> it.equals(player.getPlayerSymbol()))
        .orElse(false);
  }

  public boolean isValidMove(int fromHouse, int toHouse, Player player) {
    return pawnBelongsToPlayer(fromHouse, player)
        && !pawnBelongsToPlayer(toHouse, player);

  }

  public void addListener(PawnRemovedListener pawnRemovedListener) {
    listeners = new ArrayList<>();
    listeners.add(pawnRemovedListener);
  }

  private void pawnRemoved(String pawn) {
    PawnRemoved event = new PawnRemoved(pawn);
    listeners.forEach(listener -> listener.onPawnRemoved(event));
  }



  public record PawnRemoved(String pawn) {

  }

  @FunctionalInterface
  public static interface PawnRemovedListener {

    public void onPawnRemoved(PawnRemoved pawnRemoved);
  }
}
