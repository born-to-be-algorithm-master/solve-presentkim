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
                        1
                        5 3 6
                        0 2
                        1 2
                        2 2
                        3 2
                        4 2
                        4 0""",
                "2",
                Main1012.class
        );
    }
}
