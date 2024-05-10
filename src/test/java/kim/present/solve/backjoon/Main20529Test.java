package kim.present.solve.backjoon;

import org.junit.jupiter.api.Test;

import static kim.present.solve.backjoon.BackjoonTester.test;

class Main20529Test {

    @Test
    void testcase_1() {
        test(
                """
                        3
                        3
                        ENTJ INTP ESFJ
                        4
                        ESFP ESFP ESFP ESFP
                        5
                        INFP INFP ESTP ESTJ ISTJ""",
                "8\n0\n4",
                Main20529.class
        );
    }

    @Test
    void testcase_2() {
        test(
                """
                        2
                        5
                        INFP INFP INTP INTP ESTJ
                        4
                        ENTP ENTP INFP INTP""",
                "2\n2",
                Main20529.class
        );
    }

    @Test
    void testcase_3() {
        test(
                """
                        1
                        32
                        ISTJ ISFJ INFJ INTJ ISTP ISFP INFP INTP ESTP ESFP ENFP ENTP ESTJ ESFJ ENFJ ENTJ ISTJ ISFJ INFJ INTJ ISTP ISFP INFP INTP ESTP ESFP ENFP ENTP ESTJ ESFJ ENFJ ENTJ""",
                "2",
                Main20529.class
        );
    }
}
