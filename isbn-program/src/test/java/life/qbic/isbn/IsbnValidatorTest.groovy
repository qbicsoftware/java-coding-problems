package life.qbic.isbn

import spock.lang.Specification

class IsbnValidatorTest extends Specification {
    def "cleanup method returns an Integer array"() {
        expect:
        [1,2,3,4,6,7,8].toArray() == IsbnValidator.cleanUp("1234678")
        [1,2,3,4,6,7,8].toArray() == IsbnValidator.cleanUp("1 234 6 78")
        [1,2,3,4,6,7,8].toArray() == IsbnValidator.cleanUp("1-234-6-78")
        [1,2,3,4,6,7,8].toArray() == IsbnValidator.cleanUp("1 234-6-78")
    }

    def "contains invalid characters works"() {
        expect:
        IsbnValidator.containsInvalidCharacters(input) == result
        where:
        input | result
        "1234678" | false
        "12346-78" | false
        "123 4678" | false
        "1234678X" | false
        "1234.678" | true
        "1234A678" | true
        "12346!78" | true
        "123467#8" | true
    }

    def "validate Isbn 10 fails for inputs != length of 10"() {
        expect:
        IsbnValidator.validateIsbn10("1234567890") == true
        IsbnValidator.validateIsbn10("123456789") == false
        IsbnValidator.validateIsbn10("1234 567 890") == true
        IsbnValidator.validateIsbn10("1234 567 89X") == true

        IsbnValidator.validateIsbn10("0321125215")
        IsbnValidator.validateIsbn10("0321125214") == false
    }
}
