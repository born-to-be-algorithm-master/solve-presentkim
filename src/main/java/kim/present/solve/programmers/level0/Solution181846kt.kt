package kim.present.solve.programmers.level0

/**
 * [프로그래머스 181846 - 두 수의 합](https://school.programmers.co.kr/learn/courses/30/lessons/181846)
 */
class Solution181846kt {
    fun solution(a: String, b: String) = (maxOf(a.length, b.length))
        // 아래 두줄과 동일한 결과 .let { a.padStart(it, '0').zip(b.padStart(it, '0')) { a, b -> (a - '0') + (b - '0') } }
        .let { arrayOf(a, b).map { v -> (it downTo 0).map { i -> v.elementAtOrElse(v.length - i - 1) { '0' } } } }
        .let { (a, b) -> a.zip(b) { a2, b2 -> (a2 - '0') + (b2 - '0') } }
        .toMutableList()
        .let { (it.size - 1 downTo 1).map { i -> it[i - 1] += it[i] / 10; it[i] %= 10; }; it }
        .joinToString("")
        .removePrefix("0")
}
