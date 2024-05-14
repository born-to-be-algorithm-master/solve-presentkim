package kim.present.solve.programmers

import kotlin.math.min

/**
 * [프로그래머스 120840 - 구슬을 나누는 경우의 수](https://school.programmers.co.kr/learn/courses/30/lessons/120840)
 */
class Solution120840kt {
    fun solution(n: Int, r: Int): Int =
        (0 until min(r, n - r)).fold(1L) { acc, i -> acc * (n - i) / (i + 1) }.toInt()
}
