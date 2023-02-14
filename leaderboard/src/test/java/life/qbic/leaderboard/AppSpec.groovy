package life.qbic.leaderboard

import spock.lang.Ignore
import spock.lang.Specification

class AppSpec extends Specification {

    def "always pass"() {
        expect:
        1 == 1
    }

    @Ignore
    def "always fail"() {
        when:
        def a = 5
        then:
        a == 6
    }
}
