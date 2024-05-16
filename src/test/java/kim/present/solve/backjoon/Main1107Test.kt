package kim.present.solve.backjoon

import org.junit.jupiter.api.TestFactory

internal class Main1107Test : TestBase() {
    init {
        +Main1107::class.java
        +Main1107kt.javaClass
    }

    @TestFactory
    fun run() = test {

        !"""
            5457
            3
            6 7 8
        """ expected !"""
            6
        """

        !"""
            100
            5
            0 1 2 3 4
        """ expected !"""
            0
        """

        !"""
            500000
            8
            0 2 3 4 6 7 8 9
        """ expected !"""
            11117
        """

        !"""
            100
            3
            1 0 5
        """ expected !"""
            0
        """

        !"""
            14124
            0
        """ expected !"""
            5
        """

        !"""
            1
            9
            1 2 3 4 5 6 7 8 9
        """ expected !"""
            2
        """

        !"""
            80000
            2
            8 9
        """ expected !"""
            2228
        """

        !"""
            500000
            6
            0 1 2 3 4 5
        """ expected !"""
            166672
        """

        !"""
            0
            2
            0 1
        """ expected !"""
            3
        """

        !"""
            9999
            8
            0 1 2 3 4 5 6 7
        """ expected !"""
            4
        """

        !"""
            99933
            2
            3 9
        """ expected !"""
            73
        """

        !"""
            383399
            6
            1 2 3 4 5 7
        """ expected !"""
            216607
        """

        !"""
            889
            9
            0 2 3 4 5 6 7 8 9
        """ expected !"""
            226
        """

        !"""
            889
            9
            0 2 3 4 5 6 7 8 9
        """ expected !"""
            226
        """

        !"""
            1
            10
            0 1 2 3 4 5 6 7 8 9
        """ expected !"""
            99
        """
    }
}
