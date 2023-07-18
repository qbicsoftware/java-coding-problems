import org.spockframework.util.Assert
import spock.lang.Specification


class AppTest extends Specification {
    def "always passes"() {
        expect:
        Assert.notNull("something")
    }
}
