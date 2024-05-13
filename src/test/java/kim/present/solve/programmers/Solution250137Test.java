package kim.present.solve.programmers;

import org.junit.jupiter.api.Test;

import static kim.present.solve.programmers.ProgrammersTester.copy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution250137Test {

    static Solution250137 javaSolution = new Solution250137();
    static Solution250137kt kotlinSolution = new Solution250137kt();

    @Test
    void testcase_1() {
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] gifts = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        assertEquals(5, javaSolution.solution(copy(bandage), health, copy(gifts)));
        assertEquals(5, kotlinSolution.solution(copy(bandage), health, copy(gifts)));
    }

    @Test
    void testcase_2() {
        int[] bandage = {3, 2, 7};
        int health = 20;
        int[][] gifts = {{1, 15}, {5, 16}, {8, 6}};
        assertEquals(-1, javaSolution.solution(copy(bandage), health, copy(gifts)));
        assertEquals(-1, kotlinSolution.solution(copy(bandage), health, copy(gifts)));
    }

    @Test
    void testcase_3() {
        int[] bandage = {4, 2, 7};
        int health = 20;
        int[][] gifts = {{1, 15}, {5, 16}, {8, 6}};
        assertEquals(-1, javaSolution.solution(copy(bandage), health, copy(gifts)));
        assertEquals(-1, kotlinSolution.solution(copy(bandage), health, copy(gifts)));
    }

    @Test
    void testcase_4() {
        int[] bandage = {1, 1, 1};
        int health = 5;
        int[][] gifts = {{1, 2}, {3, 2}};
        assertEquals(3, javaSolution.solution(copy(bandage), health, copy(gifts)));
        assertEquals(3, kotlinSolution.solution(copy(bandage), health, copy(gifts)));
    }

    @Test
    void testcase_5() {
        int[] bandage = {2, 4, 4};
        int health = 100;
        int[][] gifts = {{1, 96}, {18, 1}};
        assertEquals(99, javaSolution.solution(copy(bandage), health, copy(gifts)));
        assertEquals(99, kotlinSolution.solution(copy(bandage), health, copy(gifts)));
    }
}
