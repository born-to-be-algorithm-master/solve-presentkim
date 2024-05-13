package kim.present.solve.backjoon;

import org.junit.jupiter.api.Test;

import static kim.present.solve.backjoon.BackjoonTester.test;

class Main20529Test {

    @Test
    void testcase_1() {
        String input = """
                3
                3
                ENTJ INTP ESFJ
                4
                ESFP ESFP ESFP ESFP
                5
                INFP INFP ESTP ESTJ ISTJ""",
                expected = "8\n0\n4";

        test(input, expected, Main20529.class);
        test(input, expected, Main20529kt.class);
    }

    @Test
    void testcase_2() {
        String input = """
                2
                5
                INFP INFP INTP INTP ESTJ
                4
                ENTP ENTP INFP INTP""",
                expected = "2\n2";

        test(input, expected, Main20529.class);
        test(input, expected, Main20529kt.class);
    }

    @Test
    void testcase_3() {
        String input = """
                1
                32
                ISTJ ISFJ INFJ INTJ ISTP ISFP INFP INTP ESTP ESFP ENFP ENTP ESTJ ESFJ ENFJ ENTJ ISTJ ISFJ INFJ INTJ ISTP ISFP INFP INTP ESTP ESFP ENFP ENTP ESTJ ESFJ ENFJ ENTJ""",
                expected = "2";

        test(input, expected, Main20529.class);
        test(input, expected, Main20529kt.class);
    }
}
