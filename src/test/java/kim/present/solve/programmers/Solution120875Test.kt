package kim.present.solve.programmers

import kim.present.solve.programmers.level0.Solution120875
import kim.present.solve.programmers.level0.Solution120875kt
import org.junit.jupiter.api.TestFactory

internal class Solution120875Test : TestBase1<Array<IntArray>, Int>() {
    init {
        +Solution120875()::solution
        +Solution120875kt()::solution
    }

    @TestFactory
    fun run() = test {
        // [[1, 4], [9, 2], [3, 8], [11, 6]] expected 1
        { of(of(1, 4), of(9, 2), of(3, 8), of(11, 6)) } expected 1

        // [[3, 5], [4, 1], [2, 4], [5, 10]] expected 0
        { of(of(3, 5), of(4, 1), of(2, 4), of(5, 10)) } expected 0

        // [[1, 1], [4, 2], [5, 5], [7, 7]] expected 0
        { of(of(1, 1), of(4, 2), of(5, 5), of(7, 7)) } expected 0

        // [[1, 1], [10, 8], [7, 7], [8, 6]] expected 0
        { of(of(1, 1), of(10, 8), of(7, 7), of(8, 6)) } expected 1

        // [[1, 4],[3, 8],[5, 12], [11, 6]] expected 0
        { of(of(1, 4), of(3, 8), of(5, 12), of(11, 6)) } expected 0

        // [[1, 1], [2, 2], [3, 3], [4, 0]] expected 0
        { of(of(1, 1), of(2, 2), of(3, 3), of(4, 0)) } expected 0
    }
}
