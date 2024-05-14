package kim.present.solve.programmers

import org.junit.jupiter.api.TestFactory

internal class Solution258712Test : TestBase2<Array<String>, Array<String>, Int>() {
    init {
        +Solution258712()::solution
        +Solution258712kt()::solution
    }

    @TestFactory
    fun run() = test {
        {
            of("muzi", "ryan", "frodo", "neo") args of(
                "muzi frodo",
                "muzi frodo",
                "ryan muzi",
                "ryan muzi",
                "ryan muzi",
                "frodo muzi",
                "frodo ryan",
                "neo muzi"
            )
        } expected 2

        {
            of("joy", "brad", "alessandro", "conan", "david") args of(
                "alessandro brad",
                "alessandro joy",
                "alessandro conan",
                "david alessandro",
                "alessandro david"
            )
        } expected 4

        {
            of("a", "b", "c") args of(
                "a b",
                "b a",
                "c a",
                "a c",
                "a c",
                "c a"
            )
        } expected 0
    }
}
