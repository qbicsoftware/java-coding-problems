package life.qbic.senet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

/**
 * The board on which senet is played
 */
public class GameBoard {

  public static final class Field {

    private String pawn = "";

    public static Field empty() {
      return new Field();
    }

    public static Field withPawn(String pawn) {
      Field field = new Field();
      field.pawn = pawn;
      return field;
    }


    private boolean isOccupied() {
      return pawn.isBlank();
    }

    private void movePawnTo(Field target) {
      if (target.isOccupied()) {
        swap(target);
      } else {
        move(target);
      }
    }

    private void move(Field target) {
      target.pawn = this.pawn;
      this.pawn = "";
    }

    private void swap(Field target) {
      var temp = target.pawn;
      target.pawn = this.pawn;
      this.pawn = temp;
    }

    public String getPawn() {
      return pawn;
    }
  }

  static final int NUMBER_OF_FIELDS = 30;
  Field[] fields = new Field[NUMBER_OF_FIELDS];

  public void setupFields(String player1, String player2) {
    for (int i = 1; i <= 14; i++) {
      if (i % 2 == 0) {
        fields[i - 1] = Field.withPawn(player2);
      } else {
        fields[i - 1] = Field.withPawn(player1);
      }
    }
    for (int i = 14; i < NUMBER_OF_FIELDS; i++) {
      fields[i] = Field.empty();
    }

  }

  /**
   *
   * @param position 1-based position up to the number of fields included
   * @return the pawn or empty optional
   */
  public Optional<String> getPawnAt(int position) {
    return Optional.ofNullable(fields[position - 1].getPawn());
  }

  public boolean isValidPawn(int chosenPawn, String player) {
    return fields[chosenPawn].getPawn().equals(player);
  }
}
