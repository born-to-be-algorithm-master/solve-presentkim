package kim.present.solve.programmers

import kim.present.solve.programmers.level0.Solution181832
import kim.present.solve.programmers.level0.Solution181832kt
import org.junit.jupiter.api.TestFactory

internal class Solution181832Test : TestBase1<Int, Array<IntArray>>() {
    init {
        +Solution181832()::solution
        +Solution181832kt()::solution
    }

    @TestFactory
    fun run() = test {
        { 4 } expected of(
            of(1, 2, 3, 4),
            of(12, 13, 14, 5),
            of(11, 16, 15, 6),
            of(10, 9, 8, 7)
        );

        { 5 } expected of(
            of(1, 2, 3, 4, 5),
            of(16, 17, 18, 19, 6),
            of(15, 24, 25, 20, 7),
            of(14, 23, 22, 21, 8),
            of(13, 12, 11, 10, 9)
        )
    }
}
