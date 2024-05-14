package kim.present.solve.programmers

import org.junit.jupiter.api.TestFactory

internal class Solution250137Test : TestBase3<IntArray, Int, Array<IntArray>, Int>() {
    init {
        +Solution250137()::solution
        +Solution250137kt()::solution
    }

    @TestFactory
    fun run() = test {
        {
            +of(5, 1, 5) / 30 / of(of(2, 10), of(9, 15), of(10, 5), of(11, 5))
        } expected 5

        {
            +of(3, 2, 7) / 20 / of(of(1, 15), of(5, 16), of(8, 6))
        } expected -1

        {
            +of(4, 2, 7) / 20 / of(of(1, 15), of(5, 16), of(8, 6))
        } expected -1

        {
            +of(1, 1, 1) / 5 / of(of(1, 2), of(3, 2))
        } expected 3

        {
            +of(2, 4, 4) / 100 / of(of(1, 96), of(18, 1))
        } expected 99
    }
}
