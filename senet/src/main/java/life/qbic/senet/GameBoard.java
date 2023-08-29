package life.qbic.senet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * The board on which senet is played
 */
public class GameBoard {

  static final int NUMBER_OF_FIELDS = 30;
  String[] fields = new String[NUMBER_OF_FIELDS];
  int currentPlayer = 0;

  public void setupFields(String player1, String player2) {
    for (int i = 1; i <= 14; i++) {
      if (i % 2 == 0) {
        fields[i - 1] = player2;
      } else {
        fields[i - 1] = player1;
      }
    }
    for (int i = 14; i < NUMBER_OF_FIELDS; i++) {
      fields[i] = " ";
    }

  }

  public void nextTurn(int player) {
    currentPlayer = player;
  }


  public void show() {
//    for (int i = 0; i < fields.length; i++) {
//      System.out.println("[" + fields[i] + "]" + "\t" + (i + 1));
//    }
    List<String> fieldList = Arrays.stream(fields).toList();
    for (int i = 0; i < 10; i++) {
      System.out.print("[" + fields[i] + "]%-2s ".formatted(i + 1));
    }
    System.out.print("\n");
    for (int i = 19; i >= 10; i--) {
      System.out.print("[" + fields[i] + "]%-2s ".formatted(i + 1));
    }
    System.out.print("\n");
    for (int i = 20; i < 30; i++) {
      System.out.print("[" + fields[i] + "]%-2s ".formatted(i + 1));
    }
    System.out.print("\n");




  }

  public boolean isValidPawn(int chosenPawn, String player) {
    return fields[chosenPawn].equals(player);
  }
}
