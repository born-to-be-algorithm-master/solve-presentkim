package kim.present.solve.programmers.level0

/**
 * [프로그래머스 120956 - 옹알이 (1)](https://school.programmers.co.kr/learn/courses/30/lessons/120956) *
 */
class Solution120956kt {
    /**
     * @param babbling 옹알이 문자열 배열
     * @return 발음할 수 있는 단어의 개수
     */
    fun solution(babbling: Array<String>) = babbling.count { w ->
        w.length == arrayOf("aya", "ye", "woo", "ma").sumOf { if (w.contains(it)) it.length else 0 }
    }
}
