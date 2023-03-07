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

    def "test that ranks are assigned corretly"() {
        def tom = Player.create("Tom", 0)
        def tim = Player.create("Tim", 100)
        def jim = Player.create("Jim", 42)
        given:
        List<Player> players = [tom, tim, jim]
        LeaderBoard leaderBoard = LeaderBoard.create(players)

        when:
        leaderBoard.assignRanks()

        then:
        leaderBoard.rankedPlayers() == [tom, jim, tim]

    }

    def "test that two players with the same score are assigned the same rank"() {
        given:
        List<Player> players = [Player.create("Tom", 0),
                                Player.create("Tim", 42),
                                Player.create("Jim", 42),
                                Player.create("Bob", 100)]

    }
}
