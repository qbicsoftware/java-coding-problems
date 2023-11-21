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
  Player player1 = new Player("𓀅", 7);
  //  String player2 = "2";//"𓀀";
  Player player2 = new Player("𓀀", 7);
  private final GameBoardRenderer gameBoardRenderer = new GameBoardConsoleRenderer();
  private boolean noOneHasWon;

  public Game() {
    gameBoard.setupFields(player1, player2);
    gameBoard.addListener(pawnRemoved -> {
      if (player1.getPlayerSymbol().equals(pawnRemoved.pawn())) {
        player1.decreasePawnCount();
      }
      if (player2.getPlayerSymbol().equals(pawnRemoved.pawn())) {
        player2.decreasePawnCount();
      }
    });
  }

  public void play() {
    noOneHasWon = true;
    while (noOneHasWon) {
      nextTurn();
      takeTurn(player1); //TODO replace
      takeTurn(player2);
    }
  }

  private void nextTurn() {
    //TODO take turn for current player and set current player as field.
  }

  public void takeTurn(Player player) {
    System.out.println("Player '" + player.getPlayerSymbol() + "' takes turn:");
    // player throws knuckle bones
    int moves = Knucklebones.throwBones();
    // show moves to player
    System.out.println(
        "You look at the knucklebones in your lap and see that you can move a pawn " + moves
            + " houses.");
    gameBoardRenderer.render(gameBoard);

    boolean isValidMove;
    do {
      int houseOfChosenPawn = choosePawn();
      isValidMove = gameBoard.isValidMove(houseOfChosenPawn, houseOfChosenPawn + moves,
          player);
//    System.out.println("isValidMove = " + isValidMove);
      if (isValidMove) {
        //move pawn
        gameBoard.move(houseOfChosenPawn, houseOfChosenPawn + moves);
      } else {
        System.out.println("You cannot move this pawn " + moves + " houses. Please choose a different pawn to move.");
      }
    } while (!isValidMove);
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
