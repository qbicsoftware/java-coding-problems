package life.qbic.leaderboard

import spock.lang.Specification

class LeaderboardSpec extends Specification {

    def "when a player is added to a leaderboard then the leaderboard contains the added player"() {
        given:
        Leaderboard leaderBoard = new Leaderboard()
        def player = new Player("tom", 42)

        when: "a player is added to a leaderboard"
        leaderBoard.addPlayer(player)

        then: "the leaderboard contains the added player"
        leaderBoard.find(player.name()).isPresent()
        leaderBoard.find(player.name()).get() == player
    }

    def "when no player with the given name is present, then return empty"() {
        when:
        Leaderboard leaderBoard = new Leaderboard()

        then:
        leaderBoard.find("nobody").isEmpty()
    }

    def "when no player is present then ranked() returns an an empty list"() {
        when: "no player is present"
        Leaderboard leaderboard = new Leaderboard()

        then: "ranked() returns an an empty list"
        leaderboard.ranked().isEmpty()
    }

    def "when one single player is added then the leaderboard assigns it rank 1"() {
        when: "one single player is added"
        Leaderboard leaderboard = new Leaderboard()
        def player = new Player("tim", 42)
        leaderboard.addPlayer(player)

        then: "the leaderboard assigns it rank 1"
        leaderboard.ranked().size() == 1
        leaderboard.ranked().get(0) == new PlayerRank(1, player)
    }

    def "when multiple players are added then the player with the highest score is assigned rank 1 and all following with higher ranks"() {
        when:
        Leaderboard leaderboard = new Leaderboard()
        def tim = new Player("tim", 10)
        def bob = new Player("bob", 20)
        def udo = new Player("udo", 30)
        leaderboard.addPlayer(bob)
        leaderboard.addPlayer(tim)
        leaderboard.addPlayer(udo)

        then:
        leaderboard.ranked().size() == 3 // yes
        leaderboard.ranked().get(0).rank() == 1
        leaderboard.ranked().get(1).rank() == 2
        leaderboard.ranked().get(2).rank() == 3
    }

    def "when multiple players with the same score are added then they are assigned the same rank"() {
        when:
        Leaderboard leaderboard = new Leaderboard()
        def tim = new Player("tim", Integer.MAX_VALUE)
        def bob = new Player("bob", Integer.MAX_VALUE)
        def lea = new Player("lea", 20)

        leaderboard.addPlayer(bob)
        leaderboard.addPlayer(tim)
        leaderboard.addPlayer(lea)

        then:
        leaderboard.ranked().size() == 3
        leaderboard.ranked().get(0).rank() == 1
        leaderboard.ranked().get(1).rank() == 1
    }

    def "when 2 players with the same score are added then the next player has the rank + 2"() {
        when:
        Leaderboard leaderboard = new Leaderboard()
        def tim = new Player("tim", Integer.MAX_VALUE)
        def bob = new Player("bob", Integer.MAX_VALUE)
        def lea = new Player("lea", 20)

        leaderboard.addPlayer(bob)
        leaderboard.addPlayer(tim)
        leaderboard.addPlayer(lea)

        then:
        leaderboard.ranked().size() == 3
        leaderboard.ranked().get(0).rank() == 1
        leaderboard.ranked().get(1).rank() == 1
        leaderboard.ranked().get(2).rank() == 3

    }

}
