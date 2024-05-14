package kim.present.solve.backjoon

import org.junit.jupiter.api.TestFactory

internal class Main20529Test : TestBase() {
    init {
        +Main20529::class.java
        +Main20529kt.javaClass
    }

    @TestFactory
    fun run() = test {
        !"""
            3
            3
            ENTJ INTP ESFJ
            4
            ESFP ESFP ESFP ESFP
            5
            INFP INFP ESTP ESTJ ISTJ
        """ expected !"""
            8
            0
            4
        """

        !"""
            2
            5
            INFP INFP INTP INTP ESTJ
            4
            ENTP ENTP INFP INTP
        """ expected !"""
            2
            2
        """

        !"""
            1
            32
            ISTJ ISFJ INFJ INTJ ISTP ISFP INFP INTP ESTP ESFP ENFP ENTP ESTJ ESFJ ENFJ ENTJ ISTJ ISFJ INFJ INTJ ISTP ISFP INFP INTP ESTP ESFP ENFP ENTP ESTJ ESFJ ENFJ ENTJ
        """ expected !"""
            2
        """
    }
}
