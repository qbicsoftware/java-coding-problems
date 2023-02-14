package life.qbic.leaderboard;

public class Player {
    final String name;
    final int score;

    public static Player create(String name, int score) {
        if (!name.isBlank()) {
            throw new IllegalArgumentException("a players name must not be empty");
        }
        return new Player(name, score);
    }
    private Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
