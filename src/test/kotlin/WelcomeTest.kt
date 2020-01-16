import io.restassured.RestAssured.get
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WelcomeTest : TestBase() {
    @Test
    fun `alpas works!`() {
        get("/")
        assertViewIs("welcome")
    }
}
