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

    def "when an ISBN10 number is generated then its length is 10"() {
      when: "an ISBN10 number is generated"
      def isbn10 = Isbn10.generate()
      then: "its length is 10"
      isbn10.value().size() == 10
      print(isbn10.value())
    }

    def "when an ISBN10 number is generated then the generated Isbn is valid"() {
        expect:
        Isbn10.parse(Isbn10.generate().value())
        where:
        i << (0..100)
    }

    def "valid ISBN13 numbers have a length of 13"() {
        when:
        Isbn13.parse(input)
        then:
        noExceptionThrown()
        where:
        input << ["978-4-6301-5556-9", "978-0-2394-1321-5", "978-2-2942-1261-1", "978-3-5059-6475-6", "978-5-7288-4124-1", "978-8-7069-6602-8", "978-0-7120-1615-5", "978-5-1068-6156-4", "978-8-9560-4031-8", "978-9-5743-5978-3", "978-5-7345-8329-6", "978-9-4851-4836-0", "978-3-5156-0406-2", "978-7-6588-8295-0", "978-3-4447-6217-8", "978-1-8412-8708-9", "978-7-5820-8218-1", "978-4-0898-2765-9", "978-4-7956-6647-4", "978-0-0920-5712-0", "978-2-7073-8069-2", "978-8-4174-2595-1", "978-0-7396-0397-0", "978-2-7381-1190-6", "978-5-6081-5192-7", "978-3-3074-4974-1", "978-9-1175-1877-6", "978-8-3837-1102-7", "978-4-8691-5927-7", "978-0-8317-0462-9", "978-6-2993-9716-8", "978-1-7616-0081-4", "978-8-0462-4018-5", "978-6-9256-1243-6", "978-0-5725-8210-4", "978-6-9807-1174-7", "978-8-6310-0842-8", "978-8-8101-6533-1", "978-4-7813-5167-4", "978-6-9978-7108-3", "978-4-2437-4743-4", "978-3-7173-3886-4", "978-4-9596-9038-3", "978-2-8914-8312-4", "978-2-7524-7537-4", "978-5-4815-5101-2", "978-6-0430-1421-1", "978-7-4551-5174-7", "978-9-1059-4722-9", "978-6-0163-4062-0", "978-4-1114-8194-1", "978-5-0197-6950-6", "978-2-7900-1308-8", "978-2-7391-0407-5", "978-2-2813-0144-1", "978-2-5692-0987-2", "978-7-7409-6685-8", "978-7-4472-4563-8", "978-4-1788-2908-3", "978-9-1110-6276-3"]
    }

    def "valid ISBN13 numbers may not contain characters that are neither digit nor dash nor whitespace"() {
        when:
        Isbn13.parse(input)
        then:
        thrown(IllegalArgumentException)
        where:
        input << ["978-A-6301-5556-9", "978-0-2394+1321-5"]
    }
    def "valid ISBN13 numbers may contain digits, dashes or whitespace"() {
        when:
        Isbn13.parse(input)
        then:
        noExceptionThrown()
        where:
        input << ["978-4-6301-5556-9", "978 0 2394 1321 5", "9780239413215"]
    }
}
