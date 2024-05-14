package kim.present.solve.programmers

import org.junit.jupiter.api.TestFactory

internal class Solution250136Test : TestBase1<Array<IntArray>, Int>() {
    init {
        +Solution250136()::solution
        +Solution250136kt()::solution
    }

    @TestFactory
    fun run() = test {
        {
            of(
                of(0, 0, 0, 1, 1, 1, 0, 0),
                of(0, 0, 0, 0, 1, 1, 0, 0),
                of(1, 1, 0, 0, 0, 1, 1, 0),
                of(1, 1, 1, 0, 0, 0, 0, 0),
                of(1, 1, 1, 0, 0, 0, 1, 1)
            )
        } expected 9

        {
            of(
                of(1, 0, 1, 0, 1, 1),
                of(1, 0, 1, 0, 0, 0),
                of(1, 0, 1, 0, 0, 1),
                of(1, 0, 0, 1, 0, 0),
                of(1, 0, 0, 1, 0, 1),
                of(1, 0, 0, 0, 0, 0),
                of(1, 1, 1, 1, 1, 1)
            )
        } expected 16

        {
            of(
                of(0, 0, 0, 1, 1, 1, 1, 1),
                of(0, 0, 0, 0, 0, 0, 0, 1),
                of(1, 1, 1, 1, 1, 1, 1, 1),
                of(1, 1, 1, 0, 0, 0, 0, 0),
                of(1, 1, 1, 0, 0, 0, 1, 1)
            )
        } expected 22

        { Array(500) { IntArray(500) { 1 } } } expected 500 * 500
    }
}
