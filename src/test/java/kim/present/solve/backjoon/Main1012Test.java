package kim.present.solve.backjoon;

import org.junit.jupiter.api.Test;

import static kim.present.solve.backjoon.BackjoonTester.test;

class Main1012Test {

    @Test
    void testcase_1() {
        test(
                """
                        2
                        10 8 17
                        0 0
                        1 0
                        1 1
                        4 2
                        4 3
                        4 5
                        2 4
                        3 4
                        7 4
                        8 4
                        9 4
                        7 5
                        8 5
                        9 5
                        7 6
                        8 6
                        9 6
                        10 10 1
                        5 5""",
                "5\n1",
                Main1012.class
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