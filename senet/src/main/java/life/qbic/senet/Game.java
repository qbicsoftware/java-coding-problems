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
//  String player1 = "1";//"𓀅";
  String player1 = "𓀅";
//  String player2 = "2";//"𓀀";
  String player2 = "𓀀";
  private final GameBoardRenderer gameBoardRenderer = new GameBoardConsoleRenderer();

  public Game() {
    gameBoard.setupFields(player1, player2);
  }

  public void play() {
    while (true) {
      takeTurn(player1);
      takeTurn(player2);
    }
  }

  public void takeTurn(String player) {
    System.out.println("Player '" + player + "' takes turn:");
    // player throws knuckle bones
    int moves = Knucklebones.throwBones();
    // show moves to player
    System.out.println(
        "You look at the knucklebones in your lap and see that you can move a pawn " + moves
            + " houses.");
    gameBoardRenderer.render(gameBoard);

    int houseOfChosenPawn = choosePawn();
    boolean isValidMove = gameBoard.isValidMove(houseOfChosenPawn,  houseOfChosenPawn + moves, player);
//    System.out.println("isValidMove = " + isValidMove);
    if (isValidMove) {
      //move pawn
      gameBoard.move(houseOfChosenPawn, houseOfChosenPawn + moves);
    }
    // player moves pawn

    // game executes move
    // => no pawns of player left; he wins
  }

  private int choosePawn() {
    System.out.println("Please enter the position of the pawn you want to move");
    Scanner scanner = new Scanner(System.in);
    return Integer.parseInt(scanner.nextLine());
  }

  @FunctionalInterface
  public interface GameBoardRenderer {

    void render(GameBoard gameBoard);
  }
}
