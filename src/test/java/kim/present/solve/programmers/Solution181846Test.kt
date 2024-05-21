package kim.present.solve.programmers

import kim.present.solve.programmers.level0.Solution181846
import kim.present.solve.programmers.level0.Solution181846kt
import org.junit.jupiter.api.TestFactory

internal class Solution181846Test : TestBase2<String, String, Any>() {
    init {
        +Solution181846()::solution
        +Solution181846kt()::solution
    }

    @TestFactory
    fun run() = test {
        { "582" args "734" } expected "1316"
        { "18446744073709551615" args "287346502836570928366" } expected "305793246910280479981"
        { "0" args "0" } expected "0"
        { "123456789" args "1234" } expected "123458023"
        { "111111111111111111111111" args "2222" } expected "111111111111111111113333"
    }
}
