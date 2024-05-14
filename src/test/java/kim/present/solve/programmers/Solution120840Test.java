package kim.present.solve.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution120840Test {

    static Solution120840 javaSolution = new Solution120840();
    static Solution120840kt kotlinSolution = new Solution120840kt();

    @Test
    void testcase_1() {
        int balls = 3;
        int share = 2;
        assertEquals(3, javaSolution.solution(balls, share));
        assertEquals(3, kotlinSolution.solution(balls, share));
    }

    @Test
    void testcase_2() {
        int balls = 5;
        int share = 3;
        assertEquals(10, javaSolution.solution(balls, share));
        assertEquals(10, kotlinSolution.solution(balls, share));
    }

    @Test
    void testcase_3() {
        int balls = 30;
        int share = 15;
        assertEquals(155117520, javaSolution.solution(balls, share));
        assertEquals(155117520, kotlinSolution.solution(balls, share));
    }

    @Test
    void testcase_4() {
        int balls = 30;
        int share = 30;
        assertEquals(1, javaSolution.solution(balls, share));
        assertEquals(1, kotlinSolution.solution(balls, share));
    }
}
