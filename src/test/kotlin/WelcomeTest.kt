import io.restassured.module.kotlin.extensions.Given
import io.restassured.module.kotlin.extensions.Then
import io.restassured.module.kotlin.extensions.When
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class WelcomeTest : TestBase() {
    @Test
    fun `it works!`() {
        Given {
            redirects().follow(false)
        } When {
            get("/")
        } Then {
            statusCode(200)
            assertViewIs("welcome")
        }
    }
}
