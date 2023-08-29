package life.qbic.senet;

import java.util.Scanner;

/**
 * TODO!
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
public class Game {

  private final GameBoard gameBoard = new GameBoard();
  String player1 = "1";//"𓀅";
  String player2 = "2";//"𓀀";

  public Game() {
    gameBoard.setupFields(player1, player2);
  }

  public void play() {
    takeTurn(player1);
    takeTurn(player2);
  }

  public void takeTurn(String player) {
    System.out.println("Player '" + player + "' takes turn:");
    // player throws knuckle bones
    int moves = Knucklebones.throwBones();
    // player inputs pawn on field
    gameBoard.show();
    int chosenPawn = choosePawn();
    gameBoard.isValidPawn(chosenPawn, player);
    System.out.println(gameBoard.isValidPawn(chosenPawn, player));
    // player moves pawn

    // game executes move
    // => no pawns of player left; he wins
  }

  private int choosePawn() {
    Scanner scanner = new Scanner(System.in);
    return Integer.parseInt(scanner.nextLine()) - 1;
  }
}
