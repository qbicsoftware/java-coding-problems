package life.qbic.leaderboard

import spock.lang.Specification

/**
 * <b>short description</b>
 *
 * <p>detailed description</p>
 *
 * @since <version tag>
 */
class LeaderBoardSpec extends Specification {

    def "when the leaderboard is filled then all items are ranked"() {
        given: "some players"
        def tom = Player.create("Tom", 0)
        def tim = Player.create("Tim", 100)
        def jim = Player.create("Jim", 42)
        when: "the leaderboard is filled"
        LeaderBoard leaderBoard = LeaderBoard.create([tom, tim, jim])

        then: "all items are ranked"
        leaderBoard.rankedPlayers() == [tim, jim, tom]
        leaderBoard.rankedPlayers()[0].getRank() == 1
        leaderBoard.rankedPlayers()[1].getRank() == 2
        leaderBoard.rankedPlayers()[2].getRank() == 3
    }

    def "test that two players with the same score are assigned the same rank"() {
        def tom = Player.create("Tom", 0)
        def tim = Player.create("Tim", 42)
        def jim = Player.create("Jim", 42)
        def marry = Player.create("Marry", 42)
        def bob = Player.create("Bob", 100)
        given:
        List<Player> players = [tom, tim, jim, marry, bob]

        when: "the leaderboard is filled"
        LeaderBoard leaderBoard = LeaderBoard.create(players)

        then: "all items are ranked"
        leaderBoard.rankedPlayers() == [bob, tim, jim, marry, tom]
        leaderBoard.rankedPlayers()[0].getRank() == 1
        leaderBoard.rankedPlayers()[1].getRank() == 2
        leaderBoard.rankedPlayers()[2].getRank() == 2
        leaderBoard.rankedPlayers()[3].getRank() == 2
        leaderBoard.rankedPlayers()[4].getRank() == 5
    }
}
