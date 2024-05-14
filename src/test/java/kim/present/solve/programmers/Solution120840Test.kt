package kim.present.solve.programmers

import org.junit.jupiter.api.TestFactory

internal class Solution120840Test : TestBase2<Int, Int, Int>() {
    init {
        +Solution120840()::solution
        +Solution120840kt()::solution
    }

    @TestFactory
    fun run() = test {
        { 3 args 2 } expected 3
        { 5 args 3 } expected 10
        { 30 args 15 } expected 155117520
        { 30 args 29 } expected 30
        { 30 args 30 } expected 1
    }
}
