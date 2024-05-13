package kim.present.solve.programmers;

import org.junit.jupiter.api.Test;

import static kim.present.solve.programmers.ProgrammersTester.copy;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution250136Test {

    static Solution250136 javaSolution = new Solution250136();
    static Solution250136kt kotlinSolution = new Solution250136kt();

    @Test
    void testcase_1() {
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 1, 0},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        assertEquals(9, javaSolution.solution(ProgrammersTester.copy(land)));
        assertEquals(9, kotlinSolution.solution(ProgrammersTester.copy(land)));
    }

    @Test
    void testcase_2() {
        int[][] land = {
                {1, 0, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 0},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        };
        assertEquals(16, javaSolution.solution(ProgrammersTester.copy(land)));
        assertEquals(16, kotlinSolution.solution(ProgrammersTester.copy(land)));
    }

    @Test
    void testcase_3() {
        int[][] land = {
                {0, 0, 0, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0, 0, 0, 0},
                {1, 1, 1, 0, 0, 0, 1, 1}
        };
        assertEquals(22, javaSolution.solution(ProgrammersTester.copy(land)));
        assertEquals(22, kotlinSolution.solution(ProgrammersTester.copy(land)));
    }

    @Test
    void testcase_4() {
        int[][] land = new int[500][500];
        for (int y = 0; y < 500; y++) {
            for (int x = 0; x < 500; x++) {
                land[y][x] = 1;
            }
        }
        assertEquals(500 * 500, javaSolution.solution(ProgrammersTester.copy(land)));
        assertEquals(500 * 500, kotlinSolution.solution(ProgrammersTester.copy(land)));
    }
}
