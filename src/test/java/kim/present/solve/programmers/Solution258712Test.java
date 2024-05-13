package kim.present.solve.programmers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Solution258712Test {

    static Solution258712 javaSolution = new Solution258712();
    static Solution258712kt kotlinSolution = new Solution258712kt();

    @Test
    void testcase_1() {
        String[] friends = {"muzi", "ryan", "frodo", "neo"};
        String[] gifts = {"muzi frodo", "muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi"};
        assertEquals(2, javaSolution.solution(friends, gifts));
        assertEquals(2, kotlinSolution.solution(friends, gifts));
    }

    @Test
    void testcase_2() {
        String[] friends = {"joy", "brad", "alessandro", "conan", "david"};
        String[] gifts = {"alessandro brad", "alessandro joy", "alessandro conan", "david alessandro", "alessandro david"};
        assertEquals(4, javaSolution.solution(friends, gifts));
        assertEquals(4, kotlinSolution.solution(friends, gifts));
    }

    @Test
    void testcase_3() {
        String[] friends = {"a", "b", "c"};
        String[] gifts = {"a b", "b a", "c a", "a c", "a c", "c a"};
        assertEquals(0, javaSolution.solution(friends, gifts));
        assertEquals(0, kotlinSolution.solution(friends, gifts));
    }
}
