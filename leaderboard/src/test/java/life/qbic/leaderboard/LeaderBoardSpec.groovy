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
        given:
        List<Player> players = [Player.create("Tom", 0),
                                Player.create("Tim", 42),
                                Player.create("Jim", 42),
                                Player.create("Bob", 100)]

    }
}
