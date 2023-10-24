package life.qbic.senet;

import java.util.Optional;

/**
 * The board on which senet is played
 */
public class GameBoard {

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
  }

  static final int NUMBER_OF_FIELDS = 30;
  House[] houses = new House[NUMBER_OF_FIELDS];

  public void move(int from, int to) {
    houses[from - 1].movePawnTo(houses[to - 1]);
  }

  public void setupFields(String player1, String player2) {
    for (int i = 1; i <= 14; i++) {
      if (i % 2 == 0) {
        houses[i - 1] = House.withPawn(player2);
      } else {
        houses[i - 1] = House.withPawn(player1);
      }
    }
    for (int i = 14; i < NUMBER_OF_FIELDS; i++) {
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
  public boolean pawnBelongsToPlayer(int chosenPawn, String player) {
    return getPawnAt(chosenPawn)
        .map(it -> it.equals(player))
        .orElse(false);
  }

  public boolean isValidMove(int fromHouse, int toHouse, String player) {
    return pawnBelongsToPlayer(fromHouse, player)
        && !pawnBelongsToPlayer(toHouse, player);

  }

}
