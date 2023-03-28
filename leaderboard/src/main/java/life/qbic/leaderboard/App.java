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
        leaderBoard.addPlayer(new Player("Sven", 9000));
        leaderBoard.addPlayer(new Player("Tobi", 5000));
        leaderBoard.addPlayer(new Player("Steffen", Integer.MAX_VALUE));
        leaderBoard.addPlayer(new Player("IntelliJ IDE", Integer.MAX_VALUE));

        String header = """
            This is an AWESOME leaderboard. Only the best players in the world can make it here.
            o.O WOOOOOOW!
            
            #rank\t#player\t#score
            """;
        System.out.println(header);
        leaderBoard.ranked().forEach(it ->
            System.out.println(it.rank() + ":\t" + it.player().name() + "\t" + it.player().score()));
    }

}
