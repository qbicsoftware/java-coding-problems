package life.qbic.leaderboard

import spock.lang.Specification


class PlayerRankSpec extends Specification {

    def "when creating a player rank then the rank must be greater or equal to 1"() {
        when: "creating a player rank"
        new PlayerRank(rank, new Player("tom", 42))
        then: "the rank must be greater or equal to 1"
        noExceptionThrown()

        where:
        rank << [1, 2, 3, 4, 5, 6, 10_000]
    }

    def "when creating a player rank with rank lower than 1,then an IllegalArgumentException is thrown"() {
        when: "creating a player rank"
        new PlayerRank(rank, new Player("tom", 42))
        then: "IllegalArgumentException thrown"
        thrown(IllegalArgumentException)

        where:
        rank << [-10, -1, 0]
    }
}
