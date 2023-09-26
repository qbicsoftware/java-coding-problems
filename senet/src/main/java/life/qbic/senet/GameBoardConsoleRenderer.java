package life.qbic.senet;

import life.qbic.senet.Game.GameBoardRenderer;

public class GameBoardConsoleRenderer implements GameBoardRenderer {

  @Override
  public void render(GameBoard gameBoard) {
    for (int i = 1; i <= 10; i++) {
      System.out.print("[" + gameBoard.getPawnAt(i).orElse("") + "]%-2s ".formatted(i));
    }
    System.out.print("\n");
    for (int i = 20; i >= 11; i--) {
      System.out.print("[" + gameBoard.getPawnAt(i).orElse("") + "]%-2s ".formatted(i));
    }
    System.out.print("\n");
    for (int i = 21; i <= 30; i++) {
      System.out.print("[" + gameBoard.getPawnAt(i).orElse("") + "]%-2s ".formatted(i));
    }
    System.out.print("\n");
  }
}
