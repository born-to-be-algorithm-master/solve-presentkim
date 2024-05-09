package kim.present.solve.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution258712Test {

    static Solution258712 solution = new Solution258712();

    @Test
    void testcase_1() {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        assertEquals(2, solution.solution(friends, gifts));
    }

    @Test
    void testcase_2() {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        assertEquals(4, solution.solution(friends, gifts));
    }

    @Test
    void testcase_3() {
        String[] friends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        assertEquals(0, solution.solution(friends, gifts));
    }
}
