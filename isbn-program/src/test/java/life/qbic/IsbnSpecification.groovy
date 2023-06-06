package life.qbic

import spock.lang.Specification


class IsbnSpecification extends Specification {
    def "the length of ISBN10 is not 10 throw IllegalArgument Exception"() {
        when:
        Isbn10.parse(input)
        then:
        var e = thrown(IllegalArgumentException)
        println e.message
        where:
        input << ["1234", "000000000011111111118888888888", "abcd12345"]
    }

    def "when the check digit is incorrect throw IllegalArgument Exception"() {
        when:
        Isbn10.parse(input)
        then:
        var e = thrown(IllegalArgumentException)
        println e.message
        where:
        input << ["0471-606-951", "0471-606-95X", "09874857126"]
    }

    def "valid ISBN10 numbers do not lead to an IllegalArgumentException"() {
        when:
        Isbn10.parse("0471-606-952");
        then:
        noExceptionThrown()
    }

    def "valid ISBN10 numbers with checksum X do not lead to an IllegalArgumentException"() {
        when:
        Isbn10.parse("0-8044-2957-X");
        then:
        noExceptionThrown()
    }


}
