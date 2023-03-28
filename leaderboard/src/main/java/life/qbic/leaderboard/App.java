package life.qbic.leaderboard;

/**
 * Hello world!
 */
public class App {
    /**
     * TODO: display a leaderboard with player name and score sorted by rank.
     */
    public static void main(String[] args) {
        Leaderboard leaderBoard = new Leaderboard();
        leaderBoard.addPlayer(new Player("Sven", 42));
        leaderBoard.addPlayer(new Player("Tobi", 42));
        leaderBoard.addPlayer(new Player("Olena", 42));
        leaderBoard.addPlayer(new Player("Jenni", 42));
        leaderBoard.addPlayer(new Player("Andreas", 42));
        leaderBoard.addPlayer(new Player("Aline", 42));
        leaderBoard.addPlayer(new Player("Steffen", 42));
        leaderBoard.addPlayer(new Player("IntelliJ", Integer.MAX_VALUE));
        leaderBoard.addPlayer(new Player("Bug Mc Buggy", 0));

        String header = """
            #########################################################
            This is an AWESOME leaderboard. 
                Only the best players in the world can make it here.
            #########################################################\
            """;
        System.out.println(header);
        System.out.printf("#%-14s#%-14s#%-14s%n", "rank", "name", "score");
        leaderBoard.ranked().forEach(it ->
            System.out.printf("%-15s%-15s%-15s%n", it.rank(), it.player().name(),
                it.player().score()));
    }

}
