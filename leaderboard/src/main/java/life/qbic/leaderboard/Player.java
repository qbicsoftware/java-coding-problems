package life.qbic.leaderboard;

public class Player implements Comparable<Player> {
    final String name;
    final int score;
    int rank;

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

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public int compareTo(Player o) {
        return this.score - o.score;
    }
}
