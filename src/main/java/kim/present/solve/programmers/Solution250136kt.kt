package kim.present.solve.programmers

/**
 * [프로그래머스 250136 - [PCCP 기출문제] 2번 / 석유 시추](https://school.programmers.co.kr/learn/courses/30/lessons/250136?language=java) *
 */
class Solution250136kt {
    fun solution(land: Array<IntArray>): Int {
        val n = land.size // n : 땅의 세로길이
        val m = land[0].size // m : 땅의 가로길이

        val oils: MutableList<Int> = ArrayList() // 석유 덩어리의 크기를 저장하는 리스트
        for (x in 0 until m) {
            for (y in 0 until n) {
                if (land[y][x] == 1) oils.add(replaceConnectedOil(land, x, y, -oils.size - 1))
            }
        }

        var max = 0
        for (x in 0 until m) {
            var amount = 0
            val visited = BooleanArray(oils.size)
            land.forEachIndexed { y, line ->
                val value = line[x]
                val oilIndex = -value - 1
                if (value != 0 && !visited[oilIndex]) {
                    amount += oils[oilIndex]
                    visited[oilIndex] = true
                }
            }
            if (amount > max) max = amount // 최대값 갱신
        }

        return max // 최대값 반환
    }

    private fun replaceConnectedOil(land: Array<IntArray>, startX: Int, startY: Int, value: Int): Int {
        var count = 0
        val stack = ArrayDeque<Pair<Int, Int>>().apply { add(startX to startY) }

        while (!stack.isEmpty()) {
            val (x, y) = stack.removeLast()

            if (x < 0 || x >= land[0].size || y < 0 || y >= land.size || land[y][x] != 1) {
                continue
            }

            land[y][x] = value
            count++

            for (i in -1..1 step 2) {
                stack.add(x + i to y)
                stack.add(x to y + i)
            }
        }

        return count
    }
}
