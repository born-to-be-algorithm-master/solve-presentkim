package kim.present.solve.programmers

import kotlin.math.min

/**
 * [프로그래머스 250137 - [PCCP 기출문제] 1번 / 붕대 감기](https://school.programmers.co.kr/learn/courses/30/lessons/250137) *
 */
class Solution250137kt {
    fun solution(bandage: IntArray, health: Int, attacks: Array<IntArray>): Int {
        val (t, x, y) = bandage
        var answer = health
        var time = 0
        attacks.forEach { (attackTime, damage) ->
            val diff = attackTime - time
            answer = min((answer + diff * x + diff / t * y), health) - damage

            if (answer > 0) time += diff + 1
            else return -1
        }
        return answer
    }
}
