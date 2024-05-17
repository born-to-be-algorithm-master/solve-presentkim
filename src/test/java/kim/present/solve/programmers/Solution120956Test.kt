package kim.present.solve.programmers

import kim.present.solve.programmers.level0.Solution120956
import kim.present.solve.programmers.level0.Solution120956kt
import org.junit.jupiter.api.TestFactory

internal class Solution120956Test : TestBase1<Array<String>, Int>() {
    init {
        +Solution120956()::solution
        +Solution120956kt()::solution
    }

    @Suppress("SpellCheckingInspection")
    @TestFactory
    fun run() = test {
        {
            of("aya", "yee", "u", "maa", "wyeoo")
        } expected 1

        {
            of("ayaye", "uuuma", "ye", "yemawoo", "ayaa")
        } expected 3

        {
            of("ayaya", "maaya", "myea", "ymyeae", "ymae", "ayaaya", "yeaya", "yayae", "wooyeoo")
        } expected 2

        {
            of("ayayewooma", "yeayawoo", "wooayaye")
        } expected 3

        {
            of("ayaye")
        } expected 1

        {
            of("asdf")
        } expected 0
    }
}
